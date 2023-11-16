package com.cgpm.api.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cgpm.api.model.entities.Projeto;

/**
 * @author michel.pech
 */

public interface ProjetoJPA extends JpaRepository<Projeto, Long> {

}
