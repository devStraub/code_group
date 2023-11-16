package com.cgpm.api.model.dto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.cgpm.api.base.BaseDTO;
import com.cgpm.api.model.entities.MembroProjeto;

/**
 * @author michel.pech
 */

public class MembroProjetoDTO extends BaseDTO<Long> {
	
	private ProjetoDTO projeto;
	private PessoaDTO pessoa;
	
	@Autowired
	private ModelMapper modelMapper;

	public MembroProjetoDTO() {
	}		
	
	public MembroProjetoDTO(MembroProjeto entity) {
		modelMapper.map(entity, this);
	}

	public ProjetoDTO getProjeto() {
		return projeto;
	}

	public void setProjeto(ProjetoDTO projeto) {
		this.projeto = projeto;
	}

	public PessoaDTO getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaDTO pessoa) {
		this.pessoa = pessoa;
	}	
		
}
