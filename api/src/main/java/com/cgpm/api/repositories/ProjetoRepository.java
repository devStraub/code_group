package com.cgpm.api.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cgpm.api.base.BaseRepository;
import com.cgpm.api.model.entities.Projeto;
import com.cgpm.api.repositories.jpa.ProjetoJPA;

/**
 * @author michel.pech
 */

@Repository
public class ProjetoRepository extends BaseRepository<Projeto, Long> {
	
	@Autowired
	private ProjetoJPA jpa;

	public ProjetoJPA getJpa() {
		return jpa;
	}
			
}
