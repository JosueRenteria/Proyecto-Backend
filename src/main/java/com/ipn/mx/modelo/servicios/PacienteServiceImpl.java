package com.ipn.mx.modelo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipn.mx.modelo.dao.PacienteDAO;
import com.ipn.mx.modelo.entidades.Paciente;

@Service
public class PacienteServiceImpl implements PacienteService{
	
	@Autowired
	PacienteDAO dao;
	
	@Override
	@Transactional (readOnly = false)
	public List<Paciente> findAll() {
		return (List<Paciente>) dao.findAll();
	}

	@Override
	@Transactional (readOnly = false)
	public Paciente findById(Integer id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Paciente save(Paciente paciente) {
		return dao.save(paciente);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
	}

}
