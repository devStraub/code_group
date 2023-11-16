package com.cgpm.api.model.entities;

import java.io.Serializable;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.cgpm.api.base.BaseEntity;
import com.cgpm.api.model.dto.CargoDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * @author michel.pech
 */

@Entity
@Table(name = "cargo")
public class Cargo extends BaseEntity<Long> implements Serializable {

	private static final long serialVersionUID = 196827107793581323L;
	
	private String nome;
	
	@Autowired
	private ModelMapper modelMapper;	

	public Cargo() {
	}
	
	public Cargo(Long id) {
		this.setId(id);
	}	
	
	public Cargo(CargoDTO dto) {
		modelMapper.map(dto, this);
	}
	
	@Column(name = "nome")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}			

}
