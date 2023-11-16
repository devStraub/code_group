package com.cgpm.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgpm.api.base.BaseService;
import com.cgpm.api.model.entities.Cargo;
import com.cgpm.api.repositories.CargoRepository;

/**
 * @author michel.pech
 */

@Service
public class CargoService extends BaseService<Cargo, Long> {
	
	@Autowired
	@SuppressWarnings("unused")
	private CargoRepository repository;
	
}
