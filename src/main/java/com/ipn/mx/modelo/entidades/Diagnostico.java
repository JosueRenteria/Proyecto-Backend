package com.ipn.mx.modelo.entidades;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

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
@Table(name = "Diagnostico")
public class Diagnostico implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDeteccion;
	
	@Column(name = "fecha", nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
	private Timestamp fecha;
	
	@Column(name = "nameImagenOriginal", nullable = false, length = 100)
	private String nameImagenOriginal;
	
	@Column(name = "nameImagenZonas", nullable = false, length = 100)
	private String nameImagenZonas;
		
	@Column(name = "porcentaje", nullable = true)
	private int porcentaje;
	
	@Column(name = "deteccion", nullable = false)
	private String deteccion;
	
	@ManyToOne
	@JoinColumn(name = "idHistorialClinico", referencedColumnName = "idHistorialClinico")
	private HistorialClinico historialClinico;
}
