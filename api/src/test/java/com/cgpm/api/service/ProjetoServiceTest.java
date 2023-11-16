package com.cgpm.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cgpm.api.model.entities.Projeto;
import com.cgpm.api.repositories.ProjetoRepository;
import com.cgpm.api.repositories.jpa.ProjetoJPA;
import com.cgpm.api.services.ProjetoService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProjetoServiceTest {

	@InjectMocks
	private ProjetoService service;

	@Mock
	private ProjetoRepository repository;

	@Mock
	private ProjetoJPA projetoJpa;

	@Mock
	private JpaRepository<Projeto, Long> jpaRepository;

	@Test
	void validaExclusao() throws Exception {
		// ARRANGE
		Projeto projeto = new Projeto();

		projeto.setStatus("INICIADO");

		// ACT & ASSERT
		RuntimeException exception = assertThrows(RuntimeException.class, () -> {
			service.validaExclusao(projeto);
		});
		
		assertEquals("Status do projeto, INICIADO, não permite exclusão.", exception.getMessage());
	}
}
