package com.tunombre.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tunombre.modelos.Canciones;

@Repository
public interface RepositorioCanciones extends CrudRepository<Canciones, Long>{

}
