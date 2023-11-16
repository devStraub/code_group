package com.cgpm.api.model.dto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.cgpm.api.base.BaseDTO;
import com.cgpm.api.model.entities.Cargo;
import com.cgpm.api.model.entities.CargoPessoa;
import com.cgpm.api.model.entities.Pessoa;

/**
 * @author michel.pech
 */

public class CargoPessoaDTO extends BaseDTO<Long> {

	private Cargo cargo;
	private Pessoa pessoa;
	
	@Autowired
	private ModelMapper modelMapper;

	public CargoPessoaDTO() {
	}	
	
	public CargoPessoaDTO(CargoPessoa entity) {
		modelMapper.map(entity, this);
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}	
		
}
