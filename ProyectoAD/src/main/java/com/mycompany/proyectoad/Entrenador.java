/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoad;

import java.util.ArrayList;

/**
 *
 * @author edugi
 */
public class Entrenador {
    private String nombre;
    private int edad;
    private int aniosExperiencia;
    private int nTitulos;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Entrenador(String nombre, int edad, int aniosExperiencia, int nTitulos, int id) {
        this.nombre = nombre;
        this.edad = edad;
        this.aniosExperiencia = aniosExperiencia;
        this.nTitulos = nTitulos;
        this.id = id;
    }

    public Entrenador() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    public int getnTitulos() {
        return nTitulos;
    }

    public void setnTitulos(int nTitulos) {
        this.nTitulos = nTitulos;
    }
    
    
    public ArrayList<Entrenador> listaEntrenadores(){
        ArrayList devuelve = new ArrayList<>();
        devuelve.add(new Entrenador("Anceloti", 60, 20, 20,1));
        devuelve.add(new Entrenador("Xavi", 40, 5, 2,2));
        devuelve.add(new Entrenador("Escaloni", 20, 2, 3,3));
        devuelve.add(new Entrenador("Zidane", 30, 5, 4,5));
        return devuelve;
    }
    
    @Override
    public String toString() {
        String resultado = nombre;
        return resultado;
    }
    
}
