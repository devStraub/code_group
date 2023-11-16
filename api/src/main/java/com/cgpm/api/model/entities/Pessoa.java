package com.cgpm.api.model.entities;

import java.io.Serializable;
import java.util.Calendar;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.cgpm.api.base.BaseEntity;
import com.cgpm.api.model.dto.PessoaDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * @author michel.pech
 */

@Entity
@Table(name = "pessoa")
public class Pessoa extends BaseEntity<Long> implements Serializable {

	private static final long serialVersionUID = 7222067702611957729L;
	
	private String nome;
	private Calendar dataNascimento;
	private String cpf;
	private Boolean funcionario;
	
	@Autowired
	private ModelMapper modelMapper;	
	
	public Pessoa() {
	}
	
	public Pessoa(Long id) {
		this.setId(id);
	}
	
	public Pessoa(PessoaDTO dto) {
		modelMapper.map(dto, this);
	}		
	
	@Column(name = "nome")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(name = "datanascimento")
	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	@Column(name = "cpf")
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Column(name = "funcionario")
	public Boolean getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Boolean funcionario) {
		this.funcionario = funcionario;
	}	
		
}
