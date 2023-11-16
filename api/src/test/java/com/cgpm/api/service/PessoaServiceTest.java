package com.cgpm.api.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cgpm.api.repositories.PessoaRepository;
import com.cgpm.api.services.PessoaService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PessoaServiceTest {

	@InjectMocks
	private PessoaService service;
	
	@Mock
	private PessoaRepository repository;	
}
