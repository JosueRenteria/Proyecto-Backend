package com.ipn.mx.modelo.servicios;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipn.mx.modelo.dao.MedicoDAO;
import com.ipn.mx.modelo.entidades.Medico;

@Service
public class MedicoServiceImpl implements MedicoService{
	
	@Autowired
	MedicoDAO dao;

	@Override
	@Transactional (readOnly = false)
	public List<Medico> findAll() {
		return (List<Medico>) dao.findAll();
	}

	@Override
	@Transactional (readOnly = false)
	public Medico findById(Integer id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	// Aqui se modifica porque es una relacion OneToOne.
	public Medico save(Medico medico) {
	    try {
	        Integer userId = medico.getUsuario().getIdUsuario();
	        Medico existingMedico = dao.findByUsuario_IdUsuario(userId);

	        if (existingMedico != null && !Integer.valueOf(existingMedico.getIdMedico()).equals(medico.getIdMedico())) {
	        	// Este no es necesario, pero, se dejaba por era solo para el metodo post.
	            throw new RuntimeException("El usuario ya está asociado a otro médico.");
	        }
	        return dao.save(medico);
	    } catch (RuntimeException e) {
	    	// Para todas las exepciones, auque, no es tan recomendable.
	        // Captura la excepción y lanza una nueva excepción con el mensaje personalizado
	        throw new RuntimeException("El usuario ya está asociado a otro médico.");
	    }
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
	}
}
