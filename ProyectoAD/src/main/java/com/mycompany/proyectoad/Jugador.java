/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoad;

/**
 *
 * @author Vespertino
 */
public class Jugador {
    private String nombre;
    private String posicion;
    private int goles;
    private int edad;
    private int id;

    public Jugador(String nombre, String posicion, int goles, int edad, int id) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.goles = goles;
        this.edad = edad;
        this.id = id;
    }

    public Jugador() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    @Override
    public String toString() {
        String resultado = "El jugador: " + this.nombre +" ha marcado " + goles + " esta temporada, juega de " + posicion + " a sus " + edad ;
        return resultado;
    }
   
}
