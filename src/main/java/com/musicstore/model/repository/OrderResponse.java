package com.musicstore.model.repository;

import java.util.List;

public class OrderResponse {
	private Integer referencia;
	
	private User user;
	
	private List<Product> productos;

	public Integer getReferencia() {
		return referencia;
	}

	public void setReferencia(Integer referencia) {
		this.referencia = referencia;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Product> getProductos() {
		return productos;
	}

	public void setProductos(List<Product> productos) {
		this.productos = productos;
	}

}
