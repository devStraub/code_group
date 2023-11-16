package com.cgpm.api.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cgpm.api.repositories.CargoPessoaRepository;
import com.cgpm.api.services.CargoPessoaService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CargoPessoaServiceTest {

	@InjectMocks
	private CargoPessoaService service;
	
	@Mock
	private CargoPessoaRepository repository;
	
}
