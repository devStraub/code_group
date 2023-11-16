package com.cgpm.api.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
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

import com.cgpm.api.model.entities.Projeto;
import com.cgpm.api.services.ProjetoService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author michel.pech
 */

@SpringBootTest
@AutoConfigureMockMvc
public class ProjetoControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private ProjetoService projetoService;

	@Test
	void projetoFindAll() throws Exception {
		// ARRANGE

		// ACT
		var response = mvc.perform(get("/api/projeto")).andReturn().getResponse();

		// ASSERT
		Assertions.assertEquals(200, response.getStatus());
	}
	
	@Test
	void projetoFindById() throws Exception {
		// ARRANGE
		String id = "999";

		// ACT
		var response = mvc.perform(get("/api/projeto/{id}", id)).andReturn().getResponse();

		// ASSERT
		Assertions.assertEquals(404, response.getStatus());
	}
	
	@Test
	void projetoInsert() throws Exception {
		// ARRANGE
		Projeto projeto = new Projeto();

		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(projeto);
		
		when(projetoService.insert(any(Projeto.class))).thenReturn(projeto);
		
		// ACT
		var response = mvc.perform(post("/api/projeto/")
						  .content(json)
						  .contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();				

		// ASSERT
		Assertions.assertEquals(404, response.getStatus());
	}
	
	@Test
	void projetoUpdate() throws Exception {
		// ARRANGE
		Projeto projeto = new Projeto();
		projeto.setId(Long.valueOf(999));

		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(projeto);
		
		when(projetoService.update(any(Projeto.class))).thenReturn(projeto);

		// ACT
		var response = mvc.perform(put("/api/projeto/")
			  	   		  .content(json)
			  	   		  .contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();			
		// ASSERT
		Assertions.assertEquals(404, response.getStatus());
	}
	
	@Test
	void projetoDeleteById() throws Exception {
		// ARRANGE
		String id = "999";

		// ACT
		var response = mvc.perform(delete("/api/projeto/{id}", id)).andReturn().getResponse();

		// ASSERT
		Assertions.assertEquals(200, response.getStatus());
	}
}
