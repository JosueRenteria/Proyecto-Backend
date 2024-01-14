package com.ipn.mx.modelo.servicios;

import java.util.List;

import com.ipn.mx.modelo.entidades.Usuario;

public interface UsuarioService {
	public List<Usuario> findAll();
	public Usuario findById(Integer id);
	
	//Estatus del objeto que esta insertando o actualizando.
	public Usuario save(Usuario usuario);
	
	//Aun no hace nada.
	public void delete(Integer id);

}
