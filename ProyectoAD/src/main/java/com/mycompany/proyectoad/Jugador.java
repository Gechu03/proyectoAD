/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoad;

import java.util.ArrayList;

/**
 *
 * @author Vespertino
 */
public class Jugador {
    public String nombre;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    
    
    @Override
    public String toString() {
        String resultado = nombre ;
        return resultado;
    }
    
    public ArrayList<Jugador> listaJugadores(){
        ArrayList<Jugador> temp = new ArrayList<>();
        
        temp.add(new Jugador("Messi", "Delantero", 600, 30, 0));
        temp.add(new Jugador("Cristiano", "Delantero", 700, 32, 1));
        temp.add(new Jugador("Benzema", "Delantero", 300, 31, 2));
        temp.add(new Jugador("Modric", "Centrocampista", 50, 34, 3));
        temp.add(new Jugador("Gavi", "Centrocampista", 30, 21, 4));
        return temp;
    }
        
   
}
