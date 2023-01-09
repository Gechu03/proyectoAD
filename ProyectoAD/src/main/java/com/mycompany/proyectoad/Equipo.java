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
public class Equipo {
    private String nombre;
    private String estadio;
    private ArrayList<Jugador> jugadores;
    private Entrenador entrenador;
    private int id;

    public Equipo() {
    }

    public Equipo(String nombre, String estadio, ArrayList<Jugador> jugadores, Entrenador entrenador,int id) {
        this.nombre = nombre;
        this.estadio = estadio;
        this.jugadores = jugadores;
        this.entrenador = entrenador;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }
    
    @Override
    public String toString() {
        String resultado = "El equipo: " + nombre + " con id: "+ id +"  tiene los jugadores:" ;
        for(Jugador temp : jugadores){
            resultado = resultado + " " + temp;
        }
        resultado = resultado + " el entrenador es: " + entrenador;
        return resultado;
    }
    
    
    
}
