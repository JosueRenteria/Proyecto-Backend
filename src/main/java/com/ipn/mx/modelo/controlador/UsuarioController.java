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

import com.ipn.mx.modelo.entidades.Usuario;
import com.ipn.mx.modelo.servicios.UsuarioService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/apiUsuario")
public class UsuarioController {
	@Autowired
	private UsuarioService service;
	
	@GetMapping("/usuario")
	public List<Usuario> readAll(){
		return service.findAll();
	}
	
	//Regresar un Usuario no una Lista.
	@GetMapping("/usuario/{id}")
	public Usuario read(@PathVariable Integer id) {
		return service.findById(id);
	}
	
	@DeleteMapping("/usuario/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
	@PostMapping("/usuario")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario save(@RequestBody Usuario usuario) {
		return service.save(usuario);
	}
	
	@PutMapping("/usuario/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Usuario update(@RequestBody Usuario usuario, @PathVariable Integer id) {
		Usuario u = service.findById(id);
		u.setCorreo(usuario.getCorreo());
		u.setContrasena(usuario.getContrasena());
		u.setEsAdmin(usuario.isEsAdmin());
		
		return service.save(u);
	}
	
}
