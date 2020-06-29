package com.ecodeup.model;

public class Serie {
	private int id;
	private String nombre;
	private double cantidad;
	private double precio;
	/*
	 * private Date fechaCrear; private Date fechaActualizar;
	 */

	public Serie(int id, String nombre, double cantidad, double precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		/*
		 * this.fechaCrear = fechaCrear; this.fechaActualizar = fechaActualizar;
		 */
	}

	public Serie() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/*
	 * public Date getFechaCrear() { return fechaCrear; }
	 * 
	 * public void setFechaCrear(Date fechaCrear) { this.fechaCrear = fechaCrear; }
	 * 
	 * public Date getFechaActualizar() { return fechaActualizar; }
	 * 
	 * public void setFechaActualizar(Date fechaActualizar) { this.fechaActualizar = fechaActualizar; }
	 */

	@Override
	public String toString() {
		return "Serie [id=" + id + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precio=" + precio + "]";
	}

}
