package com.cgpm.api.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cgpm.api.repositories.CargoRepository;
import com.cgpm.api.services.CargoService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CargoServiceTest {

	@InjectMocks
	private CargoService service;
	
	@Mock
	private CargoRepository repository;	
	
}
