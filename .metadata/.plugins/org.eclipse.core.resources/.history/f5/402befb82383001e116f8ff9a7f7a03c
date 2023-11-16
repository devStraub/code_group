package com.cgpm.api.model.dto;

import java.util.Calendar;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.cgpm.api.base.BaseDTO;
import com.cgpm.api.model.entities.Pessoa;

/**
 * @author michel.pech
 */

public class PessoaDTO extends BaseDTO<Long> {
	
	private String nome;
	private Calendar dataNascimento;
	private String cpf;
	private Boolean funcionario;
	
	@Autowired
	private ModelMapper modelMapper;	
	
	public PessoaDTO() {
	}	

	public PessoaDTO(Pessoa entity) {
		modelMapper.map(entity, this);
	}	
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Boolean getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Boolean funcionario) {
		this.funcionario = funcionario;
	}	
		
}
