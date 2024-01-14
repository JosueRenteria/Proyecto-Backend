package com.ipn.mx.modelo.servicios;

import java.util.List;

import com.ipn.mx.modelo.entidades.HistorialClinico;

public interface HistorialClinicoService {
	public List<HistorialClinico> findAll();
	public HistorialClinico findById(Integer id);
	
	public HistorialClinico save(HistorialClinico historialclinico);
	public void delete(Integer id);

}
