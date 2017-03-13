package com.demo.multitenancy.model.repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.demo.multitenancy.model.Persona;

import java.util.List;

/** Repository manager for Persona. */
public interface RepositorioPersona extends PagingAndSortingRepository<Persona, Long> {

  /** Get collections of Persona by apellido. */
  List<Persona> findByApellido(@Param("apellido") String name);

}