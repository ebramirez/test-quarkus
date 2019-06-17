package org.acme.quickstart;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Entidad {
	@Id
	private
	String nombre;
	
	private long cantidad;

	public long getCantidad() {
		return cantidad;
	}

	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
