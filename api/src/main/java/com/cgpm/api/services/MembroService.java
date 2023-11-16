package com.cgpm.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.cgpm.api.base.BaseService;
import com.cgpm.api.model.entities.Membro;
import com.cgpm.api.model.entities.Pessoa;
import com.cgpm.api.model.entities.Projeto;
import com.cgpm.api.repositories.MembroRepository;

/**
 * @author michel.pech
 */

@Service
public class MembroService extends BaseService<Membro, Long> {
	
	@Autowired
	@SuppressWarnings("unused")
	private MembroRepository repository;
	
	@Override
	public Membro insert(Membro entity) {		
		validaFuncionario(entity.getPessoa());
		
		return repository.getJpa().save(entity);
	}
	
	private void validaFuncionario(Pessoa pessoa) {
		if (!ObjectUtils.isEmpty(pessoa) && !pessoa.getFuncionario()) {
			throw new RuntimeException(pessoa.getNome() + " não pode ser associada pois não é funcionário(a).");
		}
	}
	
	public List<Membro> findByProjeto(Projeto projeto){
		Membro entity = new Membro();
		entity.setId(projeto.getId());
		
		return repository.find(entity);
	}	
}
