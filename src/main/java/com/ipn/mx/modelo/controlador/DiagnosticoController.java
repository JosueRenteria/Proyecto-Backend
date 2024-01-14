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

import com.ipn.mx.modelo.entidades.Diagnostico;
import com.ipn.mx.modelo.servicios.DiagnosticoService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/apiDiagnostico")
public class DiagnosticoController {
	@Autowired
	private DiagnosticoService service;
	
	@GetMapping("/diagnostico")
	public List<Diagnostico> readAll(){
		return service.findAll();
	}
	
	@GetMapping("/diagnostico/{id}")
	public Diagnostico read(@PathVariable Integer id) {
		return service.findById(id);
	}
	
	@DeleteMapping("/diagnostico/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
	@PostMapping("diagnostico")
	@ResponseStatus(HttpStatus.CREATED)
	public Diagnostico save(@RequestBody Diagnostico diagnostico) {
		return service.save(diagnostico);
	}
	
	@PutMapping("/diagnostico/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Diagnostico update(@RequestBody Diagnostico diagnostico, @PathVariable Integer id) {
		Diagnostico d = service.findById(id);
		d.setFecha(diagnostico.getFecha());
		d.setNameImagenOriginal(diagnostico.getNameImagenOriginal());
		d.setNameImagenZonas(diagnostico.getNameImagenZonas());
		d.setPorcentaje(diagnostico.getPorcentaje());
		d.setDeteccion(diagnostico.getDeteccion());
		d.setHistorialClinico(diagnostico.getHistorialClinico());
		
		return service.save(d);
	}

}
