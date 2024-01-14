package com.ipn.mx.modelo.entidades;

import java.io.Serializable;
import java.sql.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Medico")
public class Medico implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMedico;
	
	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;
	
	@Column(name = "apellidoPaterno", nullable = false, length = 50)
	private String apellidoPaterno;
	
	@Column(name = "apellidoMaterno", nullable = false, length = 50)
	private String apellidoMaterno;
	
	@Column(name = "fechaNacimiento", nullable = true)
	private Date fechaNacimiento;
	
	@OneToOne
	@JoinColumn(name = "usuario_id", referencedColumnName = "idUsuario")
	private Usuario usuario;
	
}
