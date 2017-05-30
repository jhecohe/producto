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
	public Iterable<Producto> listaProducto() {
		
		return productoRepository.findAll();
	}

}
