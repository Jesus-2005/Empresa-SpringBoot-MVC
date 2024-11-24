package com.example.empresa.service;
import org.springframework.stereotype.Service;

import com.example.empresa.entity.Empleado;


@Service
public class NominaService {
	private static final int[] SUELDO_BASE = {5000, 7000, 9000, 11000, 13000, 15000, 17000, 19000, 21000, 23000};

    /**
     * Calcula el sueldo de un empleado.
     *
     * @param empleado El empleado para calcular el sueldo.
     * @return El sueldo total del empleado.
     */
    public int calcularSueldo(Empleado empleado) {
        if (empleado.getCategoria() < 1 || empleado.getCategoria() > SUELDO_BASE.length) {
            throw new IllegalArgumentException("Categoría inválida");
        }
        return SUELDO_BASE[empleado.getCategoria() - 1] + 5000 * empleado.getAnyos();
    }
}
