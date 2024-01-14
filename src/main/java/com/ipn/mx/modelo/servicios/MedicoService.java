package com.ipn.mx.modelo.servicios;

import java.util.List;

import com.ipn.mx.modelo.entidades.Medico;

public interface MedicoService {
	public List<Medico> findAll();
	public Medico findById(Integer id);
	
	public Medico save(Medico medico);
	public void delete(Integer id);

}
