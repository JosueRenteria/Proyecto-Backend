package com.ipn.mx.modelo.entidades;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	
	@Column(name = "correo", nullable = false, length = 50)
	private String correo;
	
	@Column(name = "contrasena", nullable = false, length = 20)
	private String contrasena;
	
	@Column(name = "esAdmin", nullable = true)
	private boolean esAdmin;

}
