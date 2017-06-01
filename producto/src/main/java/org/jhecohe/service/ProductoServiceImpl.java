package org.jhecohe.service;

import org.jhecohe.Repository.ProductoRepository;
import org.jhecohe.domain.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	public Producto productoById(Integer id) {
		return productoRepository.findOne(id);
	}
	
	@Override
	public Producto guardarProducto(Producto producto) {
		return productoRepository.save(producto);
	}

	@Override
	public Producto productoById(int id) {
		
		return productoRepository.findOne(id);
	}

	@Override
	public void borrarProducto(int id) {
		productoRepository.delete(id);
	}

	@Override
	public Iterable<Producto> listaProducto() {
		
		return productoRepository.findAll();
	}

}
