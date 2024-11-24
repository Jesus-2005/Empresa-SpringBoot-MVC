package com.example.empresa.repository;

import com.example.empresa.entity.Empleado;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, String> {

	@Query("SELECT e FROM Empleado e WHERE e.nombre LIKE %?1% OR e.dni LIKE %?1% OR e.sexo LIKE %?1%OR CAST(e.categoria AS string) LIKE %?1%OR CAST(e.anyos AS string) LIKE %?1%")
	List<Empleado> buscarPorCriterios(String valor);

	@Query("SELECT e FROM Empleado e WHERE e.dni = ?1")
	Empleado findEmpleadoByDni(String dni);
	
}
