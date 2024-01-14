package com.ipn.mx.modelo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipn.mx.modelo.dao.HistorialClinicoDAO;
import com.ipn.mx.modelo.entidades.HistorialClinico;

@Service
public class HistorialClinicoServiceImpl implements HistorialClinicoService{
	@Autowired
	HistorialClinicoDAO dao;

	@Override
	@Transactional (readOnly = false)
	public List<HistorialClinico> findAll() {
		return (List<HistorialClinico>) dao.findAll();
	}

	@Override
	@Transactional (readOnly = false)
	public HistorialClinico findById(Integer id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public HistorialClinico save(HistorialClinico historialClinico) {
        try {
            // Verificar si el paciente ya está asociado a otro historial clínico
            Integer pacienteId = historialClinico.getPaciente().getIdPaciente();
            HistorialClinico existingHistorialClinico = dao.findByPaciente_IdPaciente(pacienteId);

            if (existingHistorialClinico != null && !Integer.valueOf(existingHistorialClinico.getIdHistorialClinico()).equals(historialClinico.getIdHistorialClinico())) {
                // El paciente ya está asociado a otro historial clínico
                // Puedes manejar esto lanzando una excepción, enviando un mensaje de error, etc.
                throw new RuntimeException("El paciente ya está asociado a otro historial clínico.");
            }

            return dao.save(historialClinico);
        } catch (RuntimeException e) {
            // Captura la excepción y lanza una nueva excepción con el mensaje personalizado
            throw new RuntimeException("El paciente ya está asociado a otro historial clínico.", e);
        }
    }

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
	}

}
