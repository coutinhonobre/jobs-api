package com.github.coutinhonobre.jobs.repository;

import com.github.coutinhonobre.jobs.entities.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {
}