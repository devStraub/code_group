package com.cgpm.api.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.cgpm.api.model.entities.CargoPessoa;
import com.cgpm.api.services.CargoPessoaService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author michel.pech
 */

@SpringBootTest
@AutoConfigureMockMvc
public class CargoPessoaControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private CargoPessoaService service;

	@Test
	void cargoPessoaFindAll() throws Exception {
		// ARRANGE

		// ACT
		var response = mvc.perform(get("/api/cargo_pessoa")).andReturn().getResponse();

		// ASSERT
		Assertions.assertEquals(200, response.getStatus());
	}
	
	@Test
	void cargoPessoaFindById() throws Exception {
		// ARRANGE		
		String id = "";

		// ACT
		var response = mvc.perform(get("/api/cargo_pessoa/{id}", id)).andReturn().getResponse();

		// ASSERT
		Assertions.assertEquals(404, response.getStatus());
	}
	
	@Test
	void cargoPessoaInsert() throws Exception {
		// ARRANGE
		CargoPessoa cargoPessoa = new CargoPessoa();

		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(cargoPessoa);		
		
		// ACT
		var response = mvc.perform(post("/api/cargo_pessoa/")
						  .content(json)
						  .contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();				

		// ASSERT
		Assertions.assertEquals(404, response.getStatus());
	}
	
	@Test
	void cargoPessoaUpdate() throws Exception {
		// ARRANGE
		CargoPessoa cargoPessoa = new CargoPessoa();

		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(cargoPessoa);		

		// ACT
		var response = mvc.perform(put("/api/cargo_pessoa/")
			  	   		  .content(json)
			  	   		  .contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();			
		// ASSERT
		Assertions.assertEquals(404, response.getStatus());
	}
	
	@Test
	void cargoPessoaDeleteById() throws Exception {
		// ARRANGE
		String id = "999";

		// ACT
		var response = mvc.perform(delete("/api/cargo_pessoa/{id}", id)).andReturn().getResponse();

		// ASSERT
		Assertions.assertEquals(200, response.getStatus());
	}		
}
