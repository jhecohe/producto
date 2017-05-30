package org.jhecohe.controller;

import org.jhecohe.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@RequestMapping(value="/producto", method = RequestMethod.GET)
	public String listado(Model model){
		model.addAttribute("producto", productoService.listaProducto());
		return "producto";
	}
}
