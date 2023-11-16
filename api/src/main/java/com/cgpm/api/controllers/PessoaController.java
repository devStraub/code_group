package com.cgpm.api.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgpm.api.base.BaseController;
import com.cgpm.api.model.dto.PessoaDTO;
import com.cgpm.api.model.entities.Pessoa;
import com.cgpm.api.services.PessoaService;

/**
 * @author michel.pech
 */

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController extends BaseController<Pessoa, Long, PessoaDTO> {
	
	@Autowired
	@SuppressWarnings("unused")
	private PessoaService service;
	
	@Autowired
	private ModelMapper modelMapper;	
			
	@GetMapping("/funcionario")
	public ResponseEntity<List<PessoaDTO>> findFuncionarios() {
		List<Pessoa> entities = service.findAll();
		List<PessoaDTO> dtos = entities.stream().map(entity -> modelMapper.map(entity, PessoaDTO.class))
										        .collect(Collectors.toList());
		
		return ResponseEntity.ok().body(dtos);
	}	
}
