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

import com.ipn.mx.modelo.entidades.Medico;
import com.ipn.mx.modelo.servicios.CorreoRequest;
import com.ipn.mx.modelo.servicios.EmailServices;
import com.ipn.mx.modelo.servicios.MedicoService;

import jakarta.mail.MessagingException;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/apiMedico")
public class MedicoController {
	@Autowired
	private MedicoService service;
	
	@GetMapping("/medico")
	public List<Medico> readAll(){
		return service.findAll();
	}
	
	@GetMapping("/medico/{id}")
	public Medico read(@PathVariable Integer id) {
		return service.findById(id);
	}
	
	@DeleteMapping("/medico/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
	@PostMapping("/medico")
	@ResponseStatus(HttpStatus.CREATED)
	public Medico save(@RequestBody Medico medico) {
		return service.save(medico);
	}
	
	@PutMapping("/medico/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Medico update(@RequestBody Medico medico, @PathVariable Integer id) {
		Medico m = service.findById(id);
		m.setNombre(medico.getNombre());
		m.setApellidoPaterno(medico.getApellidoPaterno());
		m.setApellidoMaterno(medico.getApellidoMaterno());
		m.setFechaNacimiento(medico.getFechaNacimiento());
		m.setUsuario(medico.getUsuario());
		return service.save(m);
	}
	
	@Autowired
    private EmailServices emailService;

    @PostMapping("/enviar-correo")
    public String enviarCorreo(@RequestBody CorreoRequest request) {
        try {
            emailService.enviarCorreo(request.getDestinatario(), request.getAsunto(), request.getCuerpo());
            return "Correo enviado con éxito";
        } catch (MessagingException e) {
            return "Error al enviar el correo: " + e.getMessage();
        }
    }

}
