package com.ipn.mx.modelo.servicios;

import java.util.List;

import com.ipn.mx.modelo.entidades.Paciente;

public interface PacienteService {
	public List<Paciente> findAll();
	public Paciente findById(Integer id);
	
	public Paciente save(Paciente paciente);
	public void delete(Integer id);
}
