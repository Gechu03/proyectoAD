/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.proyectoad;

import java.util.ArrayList;
import javax.management.Query;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;

import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

/**
 *
 * @author Vespertino
 */
public class ProyectoAD {
    static ODB odb;
   
    public static void main(String[] args) {
        odb = ODBFactory.open("equipo.db");
        DAOEquipo dEquipo = new DAOEquipo(odb);
        guardarDatos();
        
        System.out.println("------ Mostrar todos los jugadores ---------");
        Objects<Jugador> objects = odb.getObjects(Jugador.class);
        for(Jugador temp: objects){
            System.out.println(temp.toString());
        }
        
        System.out.println("------ Mostrar Jugadores por where ---------");
        Objects<Jugador> jugadoresFiltrados = buscarJugadorWhere("nombre", "Andres");
        
        for(Jugador temp: jugadoresFiltrados){
            System.out.println(temp.toString());
        }
        
        System.out.println("------ Mostrar Jugadores por between ---------");
        ArrayList<Jugador> listaBetween = buscarJugadorBetweenEdad(objects,1, 11);
        
        
        for(Jugador temp: listaBetween){
            System.out.println(temp.toString());
        }
        
        System.out.println("--------- Mostrar Jugador por where y operadores logicos ---------");
        ArrayList<Jugador> listaJugadores = buscarJugadorWhereYAnd("nombre", "Andres", 22, 26);
        for(Jugador jug : listaJugadores){
            System.out.println(jug.toString());
        }  
                
        System.out.println("--------- Mostrar Equipo 1 - N Jugadores ---------");
        ArrayList<Equipo> listaEquipos = dEquipo.devulveTodos();
        
        for(Equipo temp : listaEquipos){
            System.out.println(temp.getNombre() + " tiene los jugadores :");
            for(Jugador jug : temp.getJugadores()){
                System.out.print("\t" + jug.toString());
            }
        }
        System.out.println("");
        System.out.println("--------- Mostrar Equipo 1 - 1 Entrenador ---------");
        for(Equipo temp : listaEquipos){
            System.out.println(temp.getNombre() + " tiene el entrenador :" + temp.getEntrenador().toString());
           
        }
        borrarDatos();
        odb.close();
    }
    public static ArrayList<Jugador> buscarJugadorWhereYAnd(String campo, String match, int inicio, int fina){
        Objects<Jugador> listaWhere = buscarJugadorWhere(campo, match);
        ArrayList<Jugador> listaWhereAndBetween = buscarJugadorBetweenEdad(listaWhere, inicio, fina);
        return listaWhereAndBetween;
    }
    
    
    
    
    public static Objects<Jugador> buscarJugadorWhere(String campo, String match){
        IQuery query = new CriteriaQuery(Jugador.class, Where.equal(campo,match));
        query.orderByDesc("id,edad");
        Objects<Jugador> objects = odb.getObjects(query);
        return objects;
    }
    
    public static ArrayList<Jugador> buscarJugadorBetweenEdad(Objects<Jugador> objects, int inicio, int fina){
        ArrayList<Jugador> devulve = new ArrayList<Jugador>();
        for(Jugador temp : objects){
            if(temp.getEdad() > inicio){
                if(temp.getEdad() < fina){
                    devulve.add(temp);
                }
            }
        }
        return devulve;
    } 
    
    
    public static void borrarDatos(){
       Objects<Jugador> listaJugadores = odb.getObjects(Jugador.class);
       
       for(Jugador temp : listaJugadores){
           odb.delete(temp);
       }
       
       Objects<Entrenador> listaEntrenadores = odb.getObjects(Entrenador.class);
       
       for(Entrenador temp : listaEntrenadores){
           odb.delete(temp);
       }
       
       Objects<Equipo> listaEquipos = odb.getObjects(Equipo.class);
       
       for(Equipo temp : listaEquipos){
           odb.delete(temp);
       }
       
        
    }
    
    private static void guardarDatos(){
        ArrayList<Jugador> listajug = new ArrayList<>();
        Entrenador en1 = new Entrenador("Carlo", 50, 30, 20, 1);
        Jugador j1= new Jugador("Andres", "Banquillo Drecha", 0, 21, 1);
        Jugador j3= new Jugador("Andres", "Banquillo Drecha", 0, 25, 3);
        Jugador j2= new Jugador("Miguel", "Delantero", 16, 10,2);
        listajug.add(j1);
        listajug.add(j2);
        listajug.add(j3);
        Equipo e1 = new Equipo("Equipo 1", "Estadio 1", listajug, en1, 1);
        
        odb.store(j1);
        odb.store(j2);
        odb.store(j3);
        odb.store(en1);
        odb.store(e1);
        
    }
}
