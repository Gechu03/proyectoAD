/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoad;

import java.util.ArrayList;
import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

/**
 *
 * @author edugi
 */
public class DAOJugador implements IDAO<Jugador>{

    ODB odb;
    
    public DAOJugador(ODB odb) {
        this.odb =odb;
    }
    
    
    

    @Override
    public ArrayList<Jugador> verTodos() {
         ArrayList<Jugador> devuelve = new ArrayList<>();

        Objects<Jugador> objects = odb.getObjects(Jugador.class);
        for (Jugador temp : objects) {
            devuelve.add(temp);
        }
        return devuelve;
    }

    @Override
    public boolean insertar(Jugador jug) {
         Jugador temp = consultar(jug.getId());
        if (jug != null && temp == null) {
            odb.store(jug);
            return true;
        }

        return false;
    }
    
    public boolean insertarMultiples(ArrayList<Jugador> entre) {
        try {
            for (Jugador temp : entre) {
                insertar(temp);
            }
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean borrar(int id) {
        Jugador eliminado = consultar(id);
        if(eliminado != null){
          odb.delete(eliminado);
          return true;
        }
        return false;
    }

    @Override
    public boolean modificar(int id, Jugador nuevo) {
         Jugador modificado = consultar(id);
        if(modificado != null){
            borrar(id);
            odb.store(nuevo);
            return true;
        }
        return false;
    }

    @Override
    public Jugador consultar(int id) {
        
        IQuery query = new CriteriaQuery(Jugador.class, Where.equal("id",id));
        query.orderByDesc("id");
        Objects<Jugador> objects = odb.getObjects(query);
        if(objects.isEmpty()){
            return null;
        }
        return objects.getFirst();
    }
    
    public ArrayList<Jugador> consultar(String nombre) {
        ArrayList<Jugador> devuelve = new ArrayList<>();
        IQuery query = new CriteriaQuery(Jugador.class, Where.equal("nombre",nombre));
        query.orderByDesc("id,edad");
        Objects<Jugador> objects = odb.getObjects(query);
        for(Jugador temp : objects){
            devuelve.add(temp);
        }
        return devuelve;
    }

    public int ultimoId() {
        IQuery query = new CriteriaQuery(Jugador.class);

        query.orderByDesc("id");
        org.neodatis.odb.Objects<Jugador> objects = odb.getObjects(query);

        while (objects.hasNext()) {
            Jugador artista = objects.next();
            return artista.getId(); // Devuelve el ultimo id
        }
        return 0;
    }
}
