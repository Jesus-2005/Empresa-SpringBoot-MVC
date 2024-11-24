package com.example.empresa.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "empleado")
public class Empleado {
	
   

    @Column(nullable = false, length = 100)
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;
    
    @Id
    @Column(nullable = false, unique = true, length = 9)
    @NotBlank(message = "El DNI no puede estar vacío")
    @Size(min = 9, max = 9, message = "El DNI debe tener 9 caracteres")
    private String dni;

    @Column(nullable = false)
    private char sexo;

    @Column(nullable = false)
    @Min(value = 1, message = "La categoría debe ser mayor o igual a 1")
    @Max(value = 10, message = "La categoría debe ser menor o igual a 10")
    private int categoria;

    @Column(nullable = false)
    @Min(value = 0, message = "Los años deben ser positivos")
    private int anyos;

    // Constructores
    public Empleado() {
    }

    public Empleado(String nombre, String dni, char sexo, int categoria, int anyos) {
        this.nombre = nombre;
        this.dni = dni;
        this.sexo = sexo;
        this.categoria = categoria;
        this.anyos = anyos;
    }

    // Getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getAnyos() {
        return anyos;
    }

    public void setAnyos(int anyos) {
        this.anyos = anyos;
    }


    public void imprime() {
		System.out.println("Nombre: " + nombre + "  DNI: " + dni + "Sexo" +sexo+"  Categoria: " + categoria + "  Años: " + anyos);

	}
}
