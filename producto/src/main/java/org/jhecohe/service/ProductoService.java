package org.jhecohe.service;

import org.jhecohe.domain.Producto;

public interface ProductoService {

	public Iterable<Producto> listaProducto();
	public Producto productoById(Integer id);
	public Producto guardarProducto(Producto producto);
	public Producto productoById(int id);
	public void borrarProducto(int id);
}
