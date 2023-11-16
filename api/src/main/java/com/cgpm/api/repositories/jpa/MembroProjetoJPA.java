package com.cgpm.api.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cgpm.api.model.entities.MembroProjeto;

/**
 * @author michel.pech
 */

public interface MembroProjetoJPA extends JpaRepository<MembroProjeto, Long> {

}
