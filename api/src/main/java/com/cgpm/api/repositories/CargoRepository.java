package com.cgpm.api.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cgpm.api.base.BaseRepository;
import com.cgpm.api.model.entities.Cargo;
import com.cgpm.api.repositories.jpa.CargoJPA;

/**
 * @author michel.pech
 */

@Repository
public class CargoRepository extends BaseRepository<Cargo, Long> {
	
	@Autowired
	private CargoJPA jpa;

	public CargoJPA getJpa() {
		return jpa;
	}
		
}
