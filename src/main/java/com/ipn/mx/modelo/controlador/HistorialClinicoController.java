package com.ipn.mx.modelo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

import com.ipn.mx.modelo.entidades.HistorialClinico;
import com.ipn.mx.modelo.servicios.HistorialClinicoService;
import com.ipn.mx.modelo.servicios.PdfService;

import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/apiHistorialClinico")
public class HistorialClinicoController {
	@Autowired
	private HistorialClinicoService service;
	
	@Autowired
	private PdfService pdfService;
	
	@GetMapping("/clinico")
	public List<HistorialClinico> readAll(){
		return service.findAll();
	}
	
	@GetMapping("/clinico/{id}")
	public HistorialClinico read(@PathVariable Integer id) {
		return service.findById(id);
	}
	
	@DeleteMapping("/clinico/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
	@PostMapping("/clinico")
	@ResponseStatus(HttpStatus.CREATED)
	public HistorialClinico save(@RequestBody HistorialClinico historialclinico) {
		return service.save(historialclinico);
	}
	
	@PutMapping("/clinico/{id}")
	@ResponseStatus(HttpStatus.OK)
	public HistorialClinico update(@RequestBody HistorialClinico historialclinico, @PathVariable Integer id) {
		HistorialClinico h = service.findById(id);
		h.setFecha(historialclinico.getFecha());
		h.setPeso(historialclinico.getPeso());
		h.setAltura(historialclinico.getAltura());
		h.setAlergiasMedicamentos(historialclinico.getAlergiasMedicamentos());
		h.setMedicamentosActuales(historialclinico.getMedicamentosActuales());
		h.setFuma(historialclinico.getFuma());
		h.setAlcohol(historialclinico.getAlcohol());
		h.setVacunaNeumonia(historialclinico.getVacunaNeumonia());
		h.setFechaUltimaDosis(historialclinico.getFechaUltimaDosis());
		h.setSintomasPrincipales(historialclinico.getSintomasPrincipales());
		h.setTiempoSintomas(historialclinico.getTiempoSintomas());
		h.setContactoInfeccionRespiratoria(historialclinico.getContactoInfeccionRespiratoria());
		h.setViajeAreasBrotes(historialclinico.getViajeAreasBrotes());
		h.setAntecedentesRespiratorios(historialclinico.getAntecedentesRespiratorios());
		h.setProblemasSalud(historialclinico.getProblemasSalud());
		h.setSudoracionNocturna(historialclinico.getSudoracionNocturna());
		h.setPerdidaApetito(historialclinico.getPerdidaApetito());
		h.setInfeccionRespiratoriaReciente(historialclinico.getInfeccionRespiratoriaReciente());
		h.setMedicamentosActualidad(historialclinico.getMedicamentosActualidad());
		h.setPreguntasAdicionales(historialclinico.getPreguntasAdicionales());
		h.setPaciente(historialclinico.getPaciente());
		return service.save(h);
	}
	
	@GetMapping("/clinico/pdf/{id}")
	public ResponseEntity<byte[]> generatePdfReport(@PathVariable Integer id, HttpServletResponse response) throws Exception {
	    byte[] pdfBytes = pdfService.generatePdfReport(id);

	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_PDF);
	    headers.setContentDispositionFormData("inline", "reporte.pdf");

	    return ResponseEntity.ok().headers(headers).body(pdfBytes);
	}

	
}
