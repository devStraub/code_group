package com.cgpm.api.model.entities;

import java.io.Serializable;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.cgpm.api.base.BaseEntity;
import com.cgpm.api.model.dto.CargoPessoaDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * @author michel.pech
 */

@Entity
@Table(name = "cargo_pessoa")
public class CargoPessoa extends BaseEntity<Long> implements Serializable {

	private static final long serialVersionUID = 1336186013257219602L;

	private Cargo cargo;
	private Pessoa pessoa;
	
	@Autowired
	private ModelMapper modelMapper;

	public CargoPessoa() {
	}
	
	public CargoPessoa(Long id) {
		this.setId(id);
	}	
	
	public CargoPessoa(CargoPessoaDTO dto) {
		modelMapper.map(dto, this);
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cargo")	
	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
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
