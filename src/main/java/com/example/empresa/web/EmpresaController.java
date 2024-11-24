package com.example.empresa.web;

import com.example.empresa.entity.Empleado;
import com.example.empresa.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/empresa")
public class EmpresaController {

	@Autowired
	private EmpresaService empresaService;

	@GetMapping("/listar")
	public String listarEmpleados(Model model) {
		List<Empleado> empleados = empresaService.listarEmpleados();

		System.out.println("Empleados: " + empleados);
		model.addAttribute("empleados", empleados);
		return "listar";
	}

	@GetMapping("/buscarDni")
	public String buscarSueldo() {
		return "buscarDni";
	}

	@PostMapping("/listarSueldo")
	public String buscarSueldo(@RequestParam("dni") String dni, Model model) {
		String sueldo = empresaService.obtenerSueldo(dni);
		if (sueldo != null) {
			model.addAttribute("dni", dni);
			model.addAttribute("sueldo", sueldo);
			return "listarSueldo";
		} else {
			return "error";
		}
	}

	@GetMapping("/buscarEmpleados")
	public String buscarEmpleados() {
		return "buscarEmpleados";
	}

	@PostMapping("/modificarEmpleados")
	public String buscarEmpleados(@RequestParam("valor") String valor, Model model) {
		List<Empleado> empleados = empresaService.buscarPorCriterios(valor);
		if (empleados.isEmpty()) {
			return "error";
		} else {

			for (Empleado empleado : empleados) {
				empleado.imprime();
			}
			model.addAttribute("empleados", empleados);
			return "modificarEmpleados";
		}
	}

	@GetMapping("/editarEmpleado&dni={dni}")
	public String editarEmpleado(@PathVariable String dni, Model model) {
		Empleado empleado = empresaService.obtenerEmpleadoPorDni(dni);
		model.addAttribute("empleado", empleado);
		return "editarEmpleado";
	}
    
	@PostMapping("/editado")
	public String editarEmpleado(@RequestParam("dniOriginal") String dniOriginal, @ModelAttribute Empleado empleado) {
		System.out.println("DNI Original: " + dniOriginal);
	    empleado.imprime();
	    boolean actualizado = empresaService.editar(empleado, dniOriginal);
	    System.out.println(actualizado);
	    if (actualizado) {
	        return "index";  
	    } else {
	        return "error";  
	    }
	}
	

	@GetMapping("/volver")
	public String volver() {
		return "index";
	}
}