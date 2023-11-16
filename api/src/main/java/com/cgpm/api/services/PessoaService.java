package com.cgpm.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgpm.api.base.BaseService;
import com.cgpm.api.model.entities.Pessoa;
import com.cgpm.api.repositories.PessoaRepository;

/**
 * @author michel.pech
 */

@Service
public class PessoaService extends BaseService<Pessoa, Long> {
	
	@Autowired
	@SuppressWarnings("unused")
	private PessoaRepository repository;
	
	public List<Pessoa> findFuncionarios(){
		Pessoa pessoa = new Pessoa();
		pessoa.setFuncionario(true);
		
		return repository.find(pessoa);
	}
}
