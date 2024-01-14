package com.ipn.mx.modelo.entidades;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

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
@Table(name = "HistorialClinico")
public class HistorialClinico implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idHistorialClinico;
	
	@Column(name = "fecha", nullable = false)
	private Timestamp fecha;
	
	@Column(name = "peso", nullable = true, scale = 4)
	private float peso;
	
	@Column(name = "altura", nullable = true)
	private int altura;
	
	@Column(name = "alergiasMedicamentos", nullable = true, columnDefinition = "TEXT")
	private String alergiasMedicamentos;
	
	@Column(name = "medicamentosActuales", nullable = true, columnDefinition = "TEXT")
	private String medicamentosActuales;
	
	@Column(name = "fuma", nullable = true, length = 3)
	private String fuma;
	
	@Column(name = "alcohol", nullable = true, length = 3)
	private String alcohol;
	
	@Column(name = "vacunaNeumonia", nullable = true, length = 3)
	private String vacunaNeumonia;
	
	@Column(name = "fechaUltimaDosis", nullable = true)
	private Date fechaUltimaDosis;
	
	@Column(name = "sintomasPrincipales", nullable = true, columnDefinition = "TEXT")
	private String sintomasPrincipales;
	
	@Column(name = "tiempoSintomas", nullable = true, columnDefinition = "TEXT")
	private String tiempoSintomas;
	
	@Column(name = "contactoInfeccionRespiratoria", nullable = true, length = 3)
	private String contactoInfeccionRespiratoria;
	
	@Column(name = "viajeAreasBrotes", nullable = true, length = 3)
	private String viajeAreasBrotes;
	
	@Column(name = "antecedentesRespiratorios", nullable = true, length = 3)
	private String antecedentesRespiratorios;
	
	@Column(name = "problemasSalud", nullable = true, length = 3)
	private String problemasSalud;
	
	@Column(name = "sudoracionNocturna", nullable = true, length = 3)
	private String sudoracionNocturna;
	
	@Column(name = "perdidaApetito", nullable = true, length = 3)
	private String perdidaApetito;
	
	@Column(name = "infeccionRespiratoriaReciente", nullable = true, length = 3)
	private String infeccionRespiratoriaReciente;
	
	@Column(name = "medicamentosActualidad", nullable = true, length = 3)
	private String medicamentosActualidad;
	
	@Column(name = "preguntasAdicionales", nullable = true, columnDefinition = "TEXT")
	private String preguntasAdicionales;
	
	@OneToOne
	@JoinColumn(name = "idPaciente", referencedColumnName = "idPaciente")
	private Paciente paciente;

}
