package com.ipn.mx.modelo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ipn.mx.modelo.entidades.Paciente;
import com.ipn.mx.modelo.servicios.PacienteService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/apiPaciente")
public class PacienteController {
	@Autowired
	private PacienteService service;
	
	@GetMapping("/paciente")
	public List<Paciente> readAll(){
		return service.findAll();
	}
	
	@GetMapping("/paciente/{id}")
	public Paciente read(@PathVariable Integer id) {
		return service.findById(id);
	}
	
	@DeleteMapping("/paciente/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
	@PostMapping("/paciente")
	@ResponseStatus(HttpStatus.CREATED)
	public Paciente save(@RequestBody Paciente paciente) {
		return service.save(paciente);
	}
	
	@PutMapping("/paciente/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Paciente update(@RequestBody Paciente paciente, @PathVariable Integer id) {
		Paciente p = service.findById(id);
		p.setNombre(paciente.getNombre());
		p.setApellidoPaterno(paciente.getApellidoPaterno());
		p.setApellidoMaterno(paciente.getApellidoMaterno());
		p.setFechaNacimiento(paciente.getFechaNacimiento());
		p.setGenero(paciente.getGenero());
		p.setDireccion(paciente.getDireccion());
		p.setTelefono(paciente.getTelefono());
		p.setCorreo(paciente.getCorreo());
		p.setMedico(paciente.getMedico());
		
		return service.save(p);
	}
}
