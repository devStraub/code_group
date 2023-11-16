package com.cgpm.api.model.dto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.cgpm.api.base.BaseDTO;
import com.cgpm.api.model.entities.Cargo;

/**
 * @author michel.pech
 */

public class CargoDTO extends BaseDTO<Long> {
	
	private String nome;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public CargoDTO() {
	}
	
	public CargoDTO(Cargo entity) {
		modelMapper.map(entity, this);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	
		
}
