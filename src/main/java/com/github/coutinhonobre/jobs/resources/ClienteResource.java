package com.github.coutinhonobre.jobs.resources;

import com.github.coutinhonobre.jobs.entities.Cliente;
import com.github.coutinhonobre.jobs.entities.Login;
import com.github.coutinhonobre.jobs.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService service;

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Integer id) {
        Cliente Cliente = service.findById(id);
        return ResponseEntity.ok().body(Cliente);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Cliente> insert(@RequestBody Cliente a) {
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
    public ResponseEntity<Cliente> update(@PathVariable Integer id, @RequestBody Cliente a) {
        a = service.update(id, a);
        return ResponseEntity.ok().body(a);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Cliente> login(@RequestBody Login login) {
        Cliente cliente = null;
        for (Cliente c: service.findAll()) {
            if (c.getEmail().equals(login.getEmail()) && c.getSenha().equals(login.getSenha())) {
                cliente = c;
            }
        }
        return ResponseEntity.ok().body(cliente);
    }


}
