package com.example.empresa.service;

import com.example.empresa.entity.Empleado;
import com.example.empresa.entity.Nomina;
import com.example.empresa.repository.EmpleadoRepository;
import com.example.empresa.repository.NominaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EmpresaService {
	@Autowired
	private EmpleadoRepository empleadoRepository;
	@Autowired
	private NominaRepository nominaRepository;
	@Autowired
	private NominaService nominaService;

	public List<Empleado> listarEmpleados() {
		return empleadoRepository.findAll();
	}

	public Empleado obtenerEmpleadoPorDni(String dni) {
		return empleadoRepository.findEmpleadoByDni(dni);
	}

	public String obtenerSueldo(String dni) {
		return nominaRepository.findSueldoByDni(dni);
	}

	public List<Empleado> buscarPorCriterios(String valor) {
		return empleadoRepository.buscarPorCriterios(valor);
	};

	public boolean editar(Empleado empleado, String dniOriginal) {

		Empleado empleadoExistente = empleadoRepository.findEmpleadoByDni(dniOriginal);

		if (empleadoExistente == null) {
			return false;
		}
		System.out.println("-------------------------------------------------------------");
		empleadoExistente.imprime();
		if (dniOriginal == empleado.getDni()) {
			empleadoExistente.setNombre(empleado.getNombre());
			empleadoExistente.setDni(empleado.getDni());
			empleadoExistente.setSexo(empleado.getSexo());
			empleadoExistente.setCategoria(empleado.getCategoria());
			empleadoExistente.setAnyos(empleado.getAnyos());
			empleadoRepository.save(empleadoExistente);
		} else {
			Empleado nuevoEmpleado = new Empleado();
			nuevoEmpleado.setDni(empleado.getDni());
			nuevoEmpleado.setNombre(empleado.getNombre());
			nuevoEmpleado.setSexo(empleado.getSexo());
			nuevoEmpleado.setCategoria(empleado.getCategoria());
			nuevoEmpleado.setAnyos(empleado.getAnyos());
			empleadoRepository.delete(empleadoExistente);
			empleadoRepository.save(nuevoEmpleado);

			
		}

		empleadoExistente.imprime();
		System.out.println("-------------------------------------------------------------");
		Nomina nominaExistente = nominaRepository.findByDni(dniOriginal);
		if (nominaExistente != null) {
			if (dniOriginal == empleado.getDni()) {
				nominaExistente.setDni(empleado.getDni());
				nominaExistente.setSueldo(nominaService.calcularSueldo(empleado));
				nominaRepository.save(nominaExistente);
			} else {
				Nomina nominaNueva = new Nomina();
				nominaNueva.setDni(empleado.getDni());
				nominaNueva.setSueldo(nominaService.calcularSueldo(empleado));
				nominaRepository.delete(nominaExistente);
				nominaRepository.save(nominaNueva);
			}
		}

		return true;
	}
}