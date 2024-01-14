package com.ipn.mx.modelo.servicios;

import java.util.List;

import com.ipn.mx.modelo.entidades.Diagnostico;

public interface DiagnosticoService {
	public List<Diagnostico> findAll();
	public Diagnostico findById(Integer id);
	
	public Diagnostico save(Diagnostico diagnostico);
	public void delete(Integer id);
}
