package com.test.babel.siniestro.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Poliza")
public class Poliza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPoliza;

	@JoinColumn(name = "idPersona")
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Persona idPersona;

	private String producto;

	private String numeroPoliza;

	private BigDecimal montoDanoMaterial;

	private BigDecimal montoRoboTotal;

	private BigDecimal montoResponsabilidadCivil;

	private Date fechaInicioProteccion;

	private Date fechaTermnoProteccion;

	public Long getIdPoliza() {
		return idPoliza;
	}

	public void setIdPoliza(Long idPoliza) {
		this.idPoliza = idPoliza;
	}

	public Persona getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Persona idPersona) {
		this.idPersona = idPersona;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getNumeroPoliza() {
		return numeroPoliza;
	}

	public void setNumeroPoliza(String numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}

	public BigDecimal getMontoDanoMaterial() {
		return montoDanoMaterial;
	}

	public void setMontoDanoMaterial(BigDecimal montoDanoMaterial) {
		this.montoDanoMaterial = montoDanoMaterial;
	}

	public BigDecimal getMontoRoboTotal() {
		return montoRoboTotal;
	}

	public void setMontoRoboTotal(BigDecimal montoRoboTotal) {
		this.montoRoboTotal = montoRoboTotal;
	}

	public BigDecimal getMontoResponsabilidadCivil() {
		return montoResponsabilidadCivil;
	}

	public void setMontoResponsabilidadCivil(BigDecimal montoResponsabilidadCivil) {
		this.montoResponsabilidadCivil = montoResponsabilidadCivil;
	}

	public Date getFechaInicioProteccion() {
		return fechaInicioProteccion;
	}

	public void setFechaInicioProteccion(Date fechaInicioProteccion) {
		this.fechaInicioProteccion = fechaInicioProteccion;
	}

	public Date getFechaTermnoProteccion() {
		return fechaTermnoProteccion;
	}

	public void setFechaTermnoProteccion(Date fechaTermnoProteccion) {
		this.fechaTermnoProteccion = fechaTermnoProteccion;
	}

	@Override
	public String toString() {
		return "Poliza [idPersona=" + idPersona.getNombre() + ", producto=" + producto + ", numeroPoliza="
				+ numeroPoliza + ", montoDanoMaterial=" + montoDanoMaterial + ", montoRoboTotal=" + montoRoboTotal
				+ ", montoResponsabilidadCivil=" + montoResponsabilidadCivil + ", fechaInicioProteccion="
				+ fechaInicioProteccion + ", fechaTermnoProteccion=" + fechaTermnoProteccion + "]";
	}

}
