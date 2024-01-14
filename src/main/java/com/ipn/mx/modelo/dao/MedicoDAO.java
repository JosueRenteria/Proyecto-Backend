package com.ipn.mx.modelo.dao;

import org.springframework.data.repository.CrudRepository;

import com.ipn.mx.modelo.entidades.Medico;

public interface MedicoDAO extends CrudRepository<Medico, Integer>{
	
	// Se agrega para la parte de verificar si es unico la llave foranea.
	Medico findByUsuario_IdUsuario(Integer idUsuario);

}
