package com.example.empresa.repository;


import com.example.empresa.entity.Nomina;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

@Repository
public interface NominaRepository extends JpaRepository<Nomina, String> {
	@Query("SELECT n.sueldo FROM Nomina n WHERE n.dni = ?1")
	String findSueldoByDni(String dni);
	
	
	Nomina findByDni(String dni);

}