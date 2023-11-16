package com.cgpm.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.cgpm.api.base.BaseService;
import com.cgpm.api.model.entities.Projeto;
import com.cgpm.api.repositories.ProjetoRepository;

import io.micrometer.common.util.StringUtils;

/**
 * @author michel.pech
 */

@Service
public class ProjetoService extends BaseService<Projeto, Long> {
	
	@Autowired
	private ProjetoRepository repository;	
	
	@Override
	public void deleteById(Long id) {		
		Projeto entity = repository.getJpa().findById(id).orElse(null);
		if (ObjectUtils.isEmpty(entity)) {
			throw new RuntimeException("Projeto " + id + " não encontrado no banco de dados");
		}
		
		if (StringUtils.isBlank(entity.getStatus())) {
			validaExclusao(entity);
		}		
		
		repository.getJpa().deleteById(entity.getId());
	}
	
	public boolean validaExclusao(Projeto entity) {
		List<String> statusList = new ArrayList<>();
		
		statusList.add("INICIADO");
		statusList.add("ANDAMENTO");
		statusList.add("ENCERRADO");
		
		String statusProjeto = statusList.stream().filter(s -> s.equals(entity.getStatus())).findFirst().orElse(null);
		if (!ObjectUtils.isEmpty(statusProjeto)) {
			throw new RuntimeException("Status do projeto, " + statusProjeto + ", não permite exclusão." );
		}
		
		return true;
	}
	
}
