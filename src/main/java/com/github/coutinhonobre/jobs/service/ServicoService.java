package com.github.coutinhonobre.jobs.service;

import com.github.coutinhonobre.jobs.entities.Servico;
import com.github.coutinhonobre.jobs.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ServicoService {
    @Autowired
    private ServicoRepository repository;

    public List<Servico> findAll() {
        return repository.findAll();
    }

    public Servico findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Servico insert(Servico a) {
        return repository.save(a);
    }

    public void delete(Integer id) {
        repository.findById(id).map(Servico -> {
            repository.delete(Servico);
            return Void.TYPE;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Servico update(Integer id, Servico obj) {
        return repository.findById(id).map(Servico -> {
            return repository.save(obj);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
