package com.uabc.edu.appswbd.examen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_EMPLOYEES")
public class 	EmployeeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="tipo")
	private String tipo;

	@Column(name="raza")
	private String raza;

	@Column(name="color")
	private String color;

	@Column(name="pelaje", nullable=false, length=200)
	private String pelaje;

	@Column(name="fecha_nacimiento")
	private String fecha_nacimiento;

	@Column(name="vacunas")
	private String vacunas;

	@Column(name="estado")
	private String estado = "0";

	@Column(name="adoptivo")
	private String adoptivo;




	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getAdoptivo() {
		return adoptivo;
	}

	public void setAdoptivo(String adoptivo) {
		this.adoptivo = adoptivo;
	}

	public String getVacunas() {
		return vacunas;
	}

	public void setVacunas(String vacunas) {
		this.vacunas = vacunas;
	}
	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPelaje() {
		return pelaje;
	}

	public void setPelaje(String pelaje) {
		this.pelaje = pelaje;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}





    @Override
    public String toString() {
        return "EmployeeEntity [id=" + id + ", tipo=" + tipo +
                ", color=" + color + ", email=" + pelaje +  "]";
    }
}