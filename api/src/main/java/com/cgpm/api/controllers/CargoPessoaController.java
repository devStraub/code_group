package com.cgpm.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgpm.api.base.BaseController;
import com.cgpm.api.model.dto.CargoPessoaDTO;
import com.cgpm.api.model.entities.CargoPessoa;
import com.cgpm.api.services.CargoPessoaService;

/**
 * @author michel.pech
 */

@RestController
@RequestMapping("/api/cargo_pessoa")
public class CargoPessoaController extends BaseController<CargoPessoa, Long, CargoPessoaDTO> {
	
	@Autowired
	@SuppressWarnings("unused")
	private CargoPessoaService service;
	
}
