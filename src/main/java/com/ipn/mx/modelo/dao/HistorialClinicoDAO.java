package com.ipn.mx.modelo.dao;

import org.springframework.data.repository.CrudRepository;

import com.ipn.mx.modelo.entidades.HistorialClinico;

public interface HistorialClinicoDAO extends CrudRepository<HistorialClinico, Integer>{
	HistorialClinico findByPaciente_IdPaciente(Integer idPaciente);
}
