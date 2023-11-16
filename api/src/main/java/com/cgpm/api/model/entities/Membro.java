package com.cgpm.api.model.entities;

import java.io.Serializable;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.cgpm.api.base.PersistenceInterface;
import com.cgpm.api.model.dto.MembroDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * @author michel.pech
 */

@Entity
@Table(name = "membros")
public class Membro implements Serializable, PersistenceInterface<Long> {

	private static final long serialVersionUID = 3948287077221686045L;
	
	private Long id;
	private Pessoa pessoa;
	
	@Autowired
	private ModelMapper modelMapper; 	
	
	public Membro() {
	}
	
	public Membro(Long id) {
		this.setId(id);
	}	
	
	public Membro(MembroDTO dto) {
		modelMapper.map(dto, this);
	}		
	
	@Id	
	@Column(name = "idprojeto")	
	public Long getId() {
		return id;
	}
	
	@Override
	public void setId(Long id) {
		this.id = (Long) id;
	}		

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idpessoa")		
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}				
	
}
