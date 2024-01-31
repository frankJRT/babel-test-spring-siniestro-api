package com.test.babel.siniestro.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Siniestro")
public class Siniestro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSiniestro;

	@JoinColumn(name = "idPoliza")
	@OneToOne(fetch = FetchType.LAZY)
	private Poliza idPoliza;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaHoraSiniestro;

	private String direccion;

	private String marca;

	private String modelo;

	private String placa;

	private String conductor;

	private Boolean asistenciaMedica;

	private Boolean asistenciaVial;

	public Long getIdSiniestro() {
		return idSiniestro;
	}

	public void setIdSiniestro(Long idSiniestro) {
		this.idSiniestro = idSiniestro;
	}

	public Poliza getIdPoliza() {
		return idPoliza;
	}

	public void setIdPoliza(Poliza idPoliza) {
		this.idPoliza = idPoliza;
	}

	public Date getFechaHoraSiniestro() {
		return fechaHoraSiniestro;
	}

	public void setFechaHoraSiniestro(Date fechaHoraSiniestro) {
		this.fechaHoraSiniestro = fechaHoraSiniestro;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getConductor() {
		return conductor;
	}

	public void setConductor(String conductor) {
		this.conductor = conductor;
	}

	public Boolean getAsistenciaMedica() {
		return asistenciaMedica;
	}

	public void setAsistenciaMedica(Boolean asistenciaMedica) {
		this.asistenciaMedica = asistenciaMedica;
	}

	public Boolean getAsistenciaVial() {
		return asistenciaVial;
	}

	public void setAsistenciaVial(Boolean asistenciaVial) {
		this.asistenciaVial = asistenciaVial;
	}

	@Override
	public String toString() {
		return "Siniestro [idPoliza=" + idPoliza.getNumeroPoliza() + ", fechaHoraSiniestro=" + fechaHoraSiniestro
				+ ", direccion=" + direccion + ", marca=" + marca + ", modelo=" + modelo + ", placa=" + placa
				+ ", conductor=" + conductor + ", asistenciaMedica=" + asistenciaMedica + ", asistenciaVial="
				+ asistenciaVial + "]";
	}

}
