package com.ipn.mx.modelo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipn.mx.modelo.dao.DiagnosticoDAO;
import com.ipn.mx.modelo.entidades.Diagnostico;

@Service
public class DiagnosticoServiceImpl implements DiagnosticoService{
	@Autowired
	DiagnosticoDAO dao;

	@Override
	@Transactional (readOnly = false)
	public List<Diagnostico> findAll() {
		return (List<Diagnostico>) dao.findAll();
	}

	@Override
	@Transactional (readOnly = false)
	public Diagnostico findById(Integer id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Diagnostico save(Diagnostico diagnostico) {
		return dao.save(diagnostico);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
	}

}
