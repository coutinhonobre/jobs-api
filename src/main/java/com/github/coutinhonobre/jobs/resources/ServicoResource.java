package com.github.coutinhonobre.jobs.resources;

import com.github.coutinhonobre.jobs.entities.Servico;
import com.github.coutinhonobre.jobs.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/servicos")
public class ServicoResource {

    @Autowired
    private ServicoService service;

    @GetMapping
    public ResponseEntity<List<Servico>> findAll() {

        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "idCliente/{id}")
    public ResponseEntity<List<Servico>> findIdClienteAll(@PathVariable Integer id) {
        List<Servico> servicos = new ArrayList<>();
        for (Servico s: service.findAll()) {
            if (s.getCliente().getId() == id) {
                servicos.add(s);
            }
        }
        return ResponseEntity.ok().body(servicos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Servico> findById(@PathVariable Integer id) {
        Servico Servico = service.findById(id);
        return ResponseEntity.ok().body(Servico);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Servico> insert(@RequestBody Servico a) {
        a = service.insert(a);
        return ResponseEntity.ok().body(a);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Servico> update(@PathVariable Integer id, @RequestBody Servico a) {
        a = service.update(id, a);
        return ResponseEntity.ok().body(a);
    }

}
