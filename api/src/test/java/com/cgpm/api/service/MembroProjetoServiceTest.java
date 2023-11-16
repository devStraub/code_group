package com.cgpm.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Calendar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cgpm.api.model.entities.MembroProjeto;
import com.cgpm.api.model.entities.Pessoa;
import com.cgpm.api.model.entities.Projeto;
import com.cgpm.api.repositories.MembroProjetoRepository;
import com.cgpm.api.repositories.jpa.MembroProjetoJPA;
import com.cgpm.api.services.MembroProjetoService;

/**
 * @author michel.pech
 */

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class MembroProjetoServiceTest {

	@InjectMocks
	private MembroProjetoService service;
	
	@Mock
	private MembroProjetoRepository repository;	
	
	@Mock
	private MembroProjetoJPA jpa;

	@Mock
	private JpaRepository<Projeto, Long> jpaRepository;	
	
	@Test
	void membroInsertTest() throws Exception {			
		// ARRANGE		
		Pessoa pessoa = new Pessoa();
		pessoa.setId(Long.valueOf(1));
		pessoa.setNome("Pessoa");
		pessoa.setDataNascimento(Calendar.getInstance());
		pessoa.setFuncionario(false);
		pessoa.setCpf("cpf");
		
		MembroProjeto membroProjeto = new MembroProjeto();
		
		membroProjeto.setProjeto(new Projeto());
		membroProjeto.setPessoa(pessoa);				
		
		// ACT & ASSERT
		RuntimeException exception = assertThrows(RuntimeException.class, () -> {
			service.insert(membroProjeto);
		});
		
		assertEquals("Pessoa não pode ser associada pois não é funcionário(a).", exception.getMessage());		
	}	
}
