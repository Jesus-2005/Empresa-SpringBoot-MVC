package com.example.empresa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "nomina")
public class Nomina {

    @Id
    @Column(nullable = false, unique = true, length = 9)
    private String dni;

    @Column(nullable = false)
    private double sueldo;

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public Nomina() {
		super();
	}


    
    
}