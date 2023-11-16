package com.cgpm.api.model.entities;

import java.io.Serializable;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.cgpm.api.base.BaseEntity;
import com.cgpm.api.model.dto.MembroProjetoDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * @author michel.pech
 */

@Entity
@Table(name = "membro_projeto")
public class MembroProjeto extends BaseEntity<Long> implements Serializable {

	private static final long serialVersionUID = 1413365870742243411L;

	private Projeto projeto;
	private Pessoa pessoa;
	
	@Autowired
	private ModelMapper modelMapper;	
	
	public MembroProjeto() {
	}
	
	public MembroProjeto(Long id) {
		this.setId(id);
	}	
	
	public MembroProjeto(MembroProjetoDTO dto) {
		modelMapper.map(dto, this);
	}		
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "projeto")		
	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pessoa")	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	
}
