package com.cgpm.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.cgpm.api.base.BaseService;
import com.cgpm.api.model.entities.MembroProjeto;
import com.cgpm.api.model.entities.Pessoa;
import com.cgpm.api.model.entities.Projeto;
import com.cgpm.api.repositories.MembroProjetoRepository;

/**
 * @author michel.pech
 */

@Service
public class MembroProjetoService extends BaseService<MembroProjeto, Long> {
		
	@Autowired
	@SuppressWarnings("unused")
	private MembroProjetoRepository repository;
	
	@Override
	public MembroProjeto insert(MembroProjeto entity) {		
		validaFuncionario(entity.getPessoa());
		
		return repository.getJpa().save(entity);
	}
	
	private void validaFuncionario(Pessoa pessoa) {
		if (!ObjectUtils.isEmpty(pessoa) && !pessoa.getFuncionario()) {
			throw new RuntimeException(pessoa.getNome() + " não pode ser associada pois não é funcionário(a).");
		}
	}	
	
	public List<MembroProjeto> findByProjeto(Projeto projeto){
		MembroProjeto entity = new MembroProjeto();
		entity.setProjeto(projeto);
		
		return repository.find(entity);
	}
}
