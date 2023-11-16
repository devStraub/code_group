package com.cgpm.api.model.dto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.cgpm.api.base.BaseDTO;
import com.cgpm.api.model.entities.Membro;

/**
 * @author michel.pech
 */

public class MembroDTO extends BaseDTO<Long> {
	
	private PessoaDTO pessoa;
	
	@Autowired
	private ModelMapper modelMapper;	
	
	public MembroDTO() {
	}
	
	public MembroDTO(Membro entity) {
		modelMapper.map(entity, this);
	}	

	public PessoaDTO getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaDTO pessoa) {
		this.pessoa = pessoa;
	}
		
}
