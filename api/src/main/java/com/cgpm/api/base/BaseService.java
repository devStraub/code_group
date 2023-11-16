package com.cgpm.api.base;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

/**
 * @author michel.pech
 */

@Service
public abstract class BaseService<T extends PersistenceInterface<ID>, ID> {

	@Autowired
	private BaseRepository<T, ID> repository;			

	@Transactional
	public List<T> findAll() {
		return repository.getJpa().findAll();
	}

	@Transactional
	public Optional<T> findById(ID id) {
		return repository.getJpa().findById(id);
	}

	@Transactional
	public T insert(T entity) {
        return repository.getJpa().saveAndFlush(entity);		
	}

	@Transactional
	public T update(T entity) {
		return repository.getJpa().saveAndFlush(entity);
	}

	@Transactional
	public void deleteById(ID id) {
		repository.getJpa().deleteById(id);
	}	

}
