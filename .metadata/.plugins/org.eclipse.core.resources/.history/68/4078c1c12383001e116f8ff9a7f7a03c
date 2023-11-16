package com.cgpm.api.model.dto;

import java.math.BigDecimal;
import java.util.Calendar;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.cgpm.api.base.BaseDTO;
import com.cgpm.api.model.entities.Projeto;

/**
 * @author michel.pech
 */

public class ProjetoDTO extends BaseDTO<Long> {
	
	private String nome;
	private Calendar dataInicio;
	private Calendar dataPrevisaoFim;
	private Calendar dataFim;
	private String descricao;
	private String status;
	private BigDecimal orcamento;
	private String risco;
	private PessoaDTO gerente;
	
	@Autowired
	private ModelMapper modelMapper;	
	
	public ProjetoDTO() {
	}	
	
	public ProjetoDTO(Projeto entity) {
		modelMapper.map(entity, this);
	}	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Calendar getDataPrevisaoFim() {
		return dataPrevisaoFim;
	}

	public void setDataPrevisaoFim(Calendar dataPrevisaoFim) {
		this.dataPrevisaoFim = dataPrevisaoFim;
	}

	public Calendar getDataFim() {
		return dataFim;
	}

	public void setDataFim(Calendar dataFim) {
		this.dataFim = dataFim;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(BigDecimal orcamento) {
		this.orcamento = orcamento;
	}

	public String getRisco() {
		return risco;
	}

	public void setRisco(String risco) {
		this.risco = risco;
	}

	public PessoaDTO getGerente() {
		return gerente;
	}

	public void setGerente(PessoaDTO gerente) {
		this.gerente = gerente;
	}	
			
}
