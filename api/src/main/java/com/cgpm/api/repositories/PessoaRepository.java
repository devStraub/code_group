package com.cgpm.api.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cgpm.api.base.BaseRepository;
import com.cgpm.api.model.entities.Pessoa;
import com.cgpm.api.repositories.jpa.PessoaJPA;

/**
 * @author michel.pech
 */

@Repository
public class PessoaRepository extends BaseRepository<Pessoa, Long> {
	
	@Autowired
	private PessoaJPA jpa;

	public PessoaJPA getJpa() {
		return jpa;
	}
		
}
