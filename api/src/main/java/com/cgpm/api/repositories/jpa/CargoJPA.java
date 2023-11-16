package com.cgpm.api.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cgpm.api.model.entities.Cargo;

public interface CargoJPA extends JpaRepository<Cargo, Long> {

}
