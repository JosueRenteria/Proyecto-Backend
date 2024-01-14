package com.ipn.mx.modelo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipn.mx.modelo.dao.UsuarioDAO;
import com.ipn.mx.modelo.entidades.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	UsuarioDAO dao;

	@Override
	@Transactional (readOnly = false)
	public List<Usuario> findAll() {
		//Buscar que hace el findAll();
		return (List<Usuario>) dao.findAll();
	}

	@Override
	@Transactional (readOnly = false)
	public Usuario findById(Integer id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Usuario save(Usuario usuario) {
		return dao.save(usuario);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		dao.deleteById(id);
	}
}
