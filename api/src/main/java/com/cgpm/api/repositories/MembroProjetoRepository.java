package com.cgpm.api.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cgpm.api.base.BaseRepository;
import com.cgpm.api.model.entities.MembroProjeto;
import com.cgpm.api.repositories.jpa.MembroProjetoJPA;

/**
 * @author michel.pech
 */

@Repository
public class MembroProjetoRepository extends BaseRepository<MembroProjeto, Long> {
	
	@Autowired
	private MembroProjetoJPA jpa;

	public MembroProjetoJPA getJpa() {
		return jpa;
	}
		
}
