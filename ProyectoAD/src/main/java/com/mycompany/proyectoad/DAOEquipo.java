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
public class DAOEquipo implements IDAO<Equipo> {

    ODB odb;
    

    public DAOEquipo(ODB odb) {
        this.odb = odb;
       
    }

    @Override
    public ArrayList<Equipo> verTodos() {
        ArrayList<Equipo> devuelve = new ArrayList<>();

        Objects<Equipo> objects = odb.getObjects(Equipo.class);
        for (Equipo temp : objects) {
            devuelve.add(temp);
        }
        return devuelve;
    }

    @Override
    public boolean insertar(Equipo equi) {
       Equipo temp = consultar(equi.getId());
       if(temp != null && equi != null){
           equi.setId(ultimoId()+1);
       }
        if (equi != null) {
            odb.store(equi);
            return true;
        }

        return false;
    }
    
    public boolean insertarMultiples(ArrayList<Equipo> entre) {
        try {
            for (Equipo temp : entre) {
                insertar(temp);
            }
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean borrar(int id) {
       Equipo eliminado = consultar(id);
        if(eliminado != null){
          odb.delete(eliminado);
          return true;
        }
        return false;
    }

    @Override
    public boolean modificar(int id, Equipo nuevo) {
        Equipo modificado = consultar(id);
        if(modificado != null){
            borrar(id);
            odb.store(nuevo);
            return true;
        }
        return false;
    }
    public ArrayList<Equipo> consultar(String nombre) {
        ArrayList<Equipo> devuelve = new ArrayList<>();
        IQuery query = new CriteriaQuery(Equipo.class, Where.equal("nombre",nombre));
        query.orderByDesc("id");
        Objects<Equipo> objects = odb.getObjects(query);
        for(Equipo temp : objects){
            devuelve.add(temp);
        }
        return devuelve;
    }

    @Override
    public Equipo consultar(int id) {
        IQuery query = new CriteriaQuery(Equipo.class, Where.equal("id",id));
        query.orderByDesc("id");
        Objects<Equipo> objects = odb.getObjects(query);
        if(objects.isEmpty()){
            return null;
        }
        return objects.getFirst();
    }
    
    public ArrayList<Equipo> devulveTodos(){
        IQuery query = new CriteriaQuery(Equipo.class);
        query.orderByDesc("id");
        Objects<Equipo> objects = odb.getObjects(query);
        ArrayList<Equipo> devuelve = new ArrayList<>();
        
        for(Equipo temp : objects){
            devuelve.add(temp);
        }
        
        return devuelve;
    }

    
    public int ultimoId() {
        IQuery query = new CriteriaQuery(Equipo.class);

        query.orderByDesc("id");
        org.neodatis.odb.Objects<Equipo> objects = odb.getObjects(query);

        while (objects.hasNext()) {
            Equipo artista = objects.next();
            return artista.getId(); // Devuelve el ultimo id
        }
        return 0;
    }
}
