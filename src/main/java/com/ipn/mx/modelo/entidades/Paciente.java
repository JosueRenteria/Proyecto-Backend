package com.ipn.mx.modelo.entidades;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Paciente")
public class Paciente implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPaciente;

	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;
	
	@Column(name = "apellidoPaterno", nullable = false, length = 50)
	private String apellidoPaterno;
	
	@Column(name = "apellidoMaterno", nullable = false, length = 50)
	private String apellidoMaterno;
	
	@Column(name = "fechaNacimiento", nullable = true)
	private Date fechaNacimiento;
	
	@Column(name = "genero", nullable = true, length = 10)
	private String genero;
	
	@Column(name = "direccion", nullable = true, length = 255)
	private String direccion;
	
	@Column(name = "telefono", nullable = true, length = 20)
	private String telefono;
	
	@Column(name = "correo", nullable = true, length = 50)
	private String correo;
	
	@ManyToOne
	@JoinColumn(name = "idMedico", referencedColumnName = "idMedico")
	private Medico medico;
}
