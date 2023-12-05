package com.ipartek.modelo.dto;

public class V_Producto {
	
	private int id;
	private String nombre;
	private double precio;
	private int fk_categoria;
	private String categoria;
	
	
	public V_Producto(int id, String nombre, double precio, int fk_categoria, String categoria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.fk_categoria = fk_categoria;
		this.categoria = categoria;
	}



	public V_Producto() {
		this.id = 0;
		this.nombre = "";
		this.precio = 0.0;
		this.fk_categoria = 0;
		this.categoria="";
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


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public int getFk_categoria() {
		return fk_categoria;
	}


	public void setFk_categoria(int fk_categoria) {
		this.fk_categoria = fk_categoria;
	}



	public String getCategoria() {
		return categoria;
	}



	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}



	@Override
	public String toString() {
		return "V_Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", fk_categoria=" + fk_categoria
				+ ", categoria=" + categoria + "]";
	}
	
	
	
	
	
	
}
