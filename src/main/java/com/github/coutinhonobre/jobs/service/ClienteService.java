package com.github.coutinhonobre.jobs.service;

import com.github.coutinhonobre.jobs.entities.Cliente;
import com.github.coutinhonobre.jobs.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Cliente findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Cliente insert(Cliente a) {
        return repository.save(a);
    }

    public void delete(Integer id) {
        repository.findById(id).map(Cliente -> {
            repository.delete(Cliente);
            return Void.TYPE;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Cliente update(Integer id, Cliente obj) {
        return repository.findById(id).map(Cliente -> {
            Cliente.setNome(obj.getNome());
            return repository.save(Cliente);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
