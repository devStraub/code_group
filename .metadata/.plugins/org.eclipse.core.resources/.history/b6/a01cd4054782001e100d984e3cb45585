package com.cgpm.api.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.repository.JpaRepository;

public class BaseRepository<T extends PersistenceInterface<ID>, ID> {
	
	@Autowired
	private JpaRepository<T, ID> jpa;
	
	public JpaRepository<T, ID> getJpa() {
		return jpa;
	}

	public List<T> find(T entity) {
	    Example<T> example = Example.of(entity, ExampleMatcher.matching().withIgnoreNullValues());
	    return jpa.findAll(example);
	}	
}
