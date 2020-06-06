package com.uabc.edu.appswbd.examen.web;

import java.util.List;
import java.util.Optional;

import com.uabc.edu.appswbd.examen.exception.RecordNotFoundException;
import com.uabc.edu.appswbd.examen.model.AnimalesEntity;
import com.uabc.edu.appswbd.examen.model.Productos;
import com.uabc.edu.appswbd.examen.model.Usuario;
import com.uabc.edu.appswbd.examen.service.EmployeeService;
import com.uabc.edu.appswbd.examen.service.articuloService;
import com.uabc.edu.appswbd.examen.service.usuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("/")
public class EmployeeMvcController 
{
	@Autowired
	EmployeeService service;

	@Autowired
	articuloService service2;

	@Autowired
	usuarioService service3;

	@RequestMapping
	public String getAllEmployees(Model model) 
	{
		List<AnimalesEntity> list = service.getAllEmployees();

		model.addAttribute("employees", list);
		return "list-employees";
	}

	@RequestMapping(path = {"/edit", "/edit/{id}"})
	public String editEmployeeById(Model model, @PathVariable("id") Optional<Long> id) 
							throws RecordNotFoundException 
	{
		if (id.isPresent()) {
			AnimalesEntity entity = service.getEmployeeById(id.get());
			model.addAttribute("employee", entity);
		} else {
			model.addAttribute("employee", new AnimalesEntity());
		}
		return "add-edit-employee";
	}
	
	@RequestMapping(path = "/delete/{id}")
	public String deleteEmployeeById(Model model, @PathVariable("id") Long id)
							throws RecordNotFoundException
	{
		service.deleteEmployeeById(id);
		return "redirect:/";
	}

	@RequestMapping(path = "/createEmployee", method = RequestMethod.POST)
	public String createOrUpdateEmployee(AnimalesEntity employee)
	{
		service.createOrUpdateEmployee(employee);
		return "redirect:/";
	}


	//peticiones de Articulos

	@RequestMapping(path = "/ari")
	public String getArticulos(Model model){

		List<Productos> list = service2.getArticulos();
		model.addAttribute("arti", list);
		return "Articulos";

	}

	@RequestMapping(path = {"/create","/editArticulo/{id}"})
	public String editarArticulo(Model model, @PathVariable("id") Optional<Long> id)
			throws RecordNotFoundException
	{

		if (id.isPresent())
		{
			Productos entityProducto = service2.getProductoById(id.get());
			model.addAttribute("arti", entityProducto);
		} else {
			model.addAttribute("arti", new Productos());
		}

		return "FormArticulos";
	}

	@RequestMapping(path = "/deleteArticulo/{id}")
	public String deleteArticulo(Model model, @PathVariable("id") Long id)
			throws RecordNotFoundException
	{
		service2.deleteArticulo(id);
		return "redirect:/ari";
	}

	@RequestMapping(path = "/createArticulo", method = RequestMethod.POST)
	public String createArticuloORupdate(Productos arti)
	{
		service2.createOrUpdateProducto(arti);
		return "redirect:/ari";
	}

	//usuario controller

	@RequestMapping(path = "/USUARIOSnew")
	public String getUsuarios(Model model)
	{

		List<Usuario> list = service3.getUsuarios();
		model.addAttribute("US", list);
		return "Usuarios";

	}

	@RequestMapping(path = {"createUsuarios","/EDICIONusuarios/{id}"})
	public String editarUSUARIO(Model model, @PathVariable("id") Optional<Long> id)
			throws RecordNotFoundException
	{

		if (id.isPresent())
		{
			Usuario usuarioxxx = service3.getUsuarioById(id.get());
			model.addAttribute("US", usuarioxxx);
		} else {
			model.addAttribute("US", new Usuario());
		}

		return "FormUsuarios.html";
	}

	@RequestMapping(path = "/createUsuarioFinal", method = RequestMethod.POST)
	public String createUsuarioORupdate(Usuario US)
	{
		service3.createOrUpdateUsuario(US);
		return "redirect:/USUARIOSnew";
	}

	@RequestMapping(path = "/deleteUs/{id}")
	public String deleteUs(Model model, @PathVariable("id") Long id)
			throws RecordNotFoundException
	{
		service2.deleteArticulo(id);
		return "redirect:/ari";
	}


}
