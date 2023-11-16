package com.cgpm.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgpm.api.base.BaseService;
import com.cgpm.api.model.entities.CargoPessoa;
import com.cgpm.api.repositories.CargoPessoaRepository;

/**
 * @author michel.pech
 */

@Service
public class CargoPessoaService extends BaseService<CargoPessoa, Long> {
	
	@Autowired
	@SuppressWarnings("unused")
	private CargoPessoaRepository repository;
	
}
