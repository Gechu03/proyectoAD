/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.proyectoad;

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
        Jugador j1= new Jugador("Andres", "Banquillo Drecha", 0, 21, 1);
        Jugador j2= new Jugador("Miguel", "Delantero", 16, 10,2);
        odb.store(j1);
        odb.store(j2);
    
        Objects<Jugador> objects = odb.getObjects(Jugador.class);
        for(Jugador temp: objects){
            System.out.println(temp.toString());
        }
        
        System.out.println("---------------");
        Objects<Jugador> jugadoresFiltrados = buscarJugadorWhere("nombre", "Andres");
        
        for(Jugador temp: jugadoresFiltrados){
            System.out.println(temp.toString());
        }
        
        borrarDatos();
        odb.close();
    }
    
    public static Objects<Jugador> buscarJugadorWhere(String campo, String match){
        IQuery query = new CriteriaQuery(Jugador.class, Where.equal(campo,match));
        query.orderByDesc("nombre,edad");
        Objects<Jugador> objects = odb.getObjects(query);
        return objects;
    }
    
    
    public static void borrarDatos(){
       Objects<Jugador> listaJugadores = odb.getObjects(Jugador.class);
       
       for(Jugador temp : listaJugadores){
           odb.delete(temp);
       }
        
    }
}
