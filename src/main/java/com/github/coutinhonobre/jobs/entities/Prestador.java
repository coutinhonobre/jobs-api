package com.github.coutinhonobre.jobs.entities;

import javax.persistence.Entity;

@Entity(name = "prestadores")
public class Prestador extends Pessoa {

    private CategoriaServico categoriaServico;

}
