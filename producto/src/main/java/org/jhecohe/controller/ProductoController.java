package org.jhecohe.controller;

import javax.validation.Valid;

import org.jhecohe.domain.Producto;
import org.jhecohe.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@RequestMapping(value="/producto", method = RequestMethod.GET)
	public String listado(Model model){
		model.addAttribute("producto", productoService.listaProducto());
		return "producto";
	}
	
	@RequestMapping(value="/productoById", method=RequestMethod.GET)
	public String productoById(@PathVariable Integer id, Model model){
		model.addAttribute("producto", productoService.productoById(id));
		return "productoShow";
	}
	
	@RequestMapping(value="/create")
	public String create(Model model){
		model.addAttribute("producto", new Producto());
		return "productoForm";
	}
	
	@RequestMapping(value="/agregar", method=RequestMethod.POST)
	public String crearProducto(@Valid Producto producto, BindingResult bindingResult, Model model){
		Producto productoGuardar = productoService.guardarProducto(producto);
		return "redirect:producto";
	}
	
	@RequestMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model){
		model.addAttribute("producto", productoService.productoById(id));
		return "productoForm";
	}
	
	@RequestMapping(value="/borrar/{id}")
	public String borrar(@PathVariable int id, RedirectAttributes redirectAt){
		productoService.borrarProducto(id);
		redirectAt.addFlashAttribute("mensaje", "El producto fue borrado de la base de datos");
		return "redirect:/producto";
	}
}
