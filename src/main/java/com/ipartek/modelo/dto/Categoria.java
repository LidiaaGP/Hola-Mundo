package com.ipartek.modelo.dto;

public class Categoria {
	
	//Atributos
	private int id;
	private String categoria;
	
	public double CantidadDinero;
	
	//constructores
	public Categoria(int id,String categoria) {
		this.id=id;
		this.categoria=categoria;
		
	}
	
	public Categoria() {
		this.id=0;
		this.categoria="";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", categoria=" + categoria + ", CantidadDinero=" + CantidadDinero + "]";
	}
	
	
	
	
}
