package com.cgpm.api.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cgpm.api.base.BaseRepository;
import com.cgpm.api.model.entities.Membro;
import com.cgpm.api.repositories.jpa.MembroJPA;

/**
 * @author michel.pech
 */

@Repository
public class MembroRepository extends BaseRepository<Membro, Long> {
	
	@Autowired
	private MembroJPA jpa;

	public MembroJPA getJpa() {
		return jpa;
	}
		
}
