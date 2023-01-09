/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoad;

import static com.mycompany.proyectoad.ProyectoAD.odb;
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
public class DAOEntrenador implements IDAO<Entrenador> {

    ODB odb;

    public DAOEntrenador(ODB odb) {
        this.odb = odb;
    }

    @Override
    public ArrayList<Entrenador> verTodos() {
        ArrayList<Entrenador> devuelve = new ArrayList<>();

        Objects<Entrenador> objects = odb.getObjects(Entrenador.class);
        for (Entrenador temp : objects) {
            devuelve.add(temp);
        }
        return devuelve;
    }

    @Override
    public boolean insertar(Entrenador entre) {
        Entrenador temp = consultar(entre.getId());
        if(temp != null){
          entre.setId(ultimoId()+1);  
        }
        if (entre != null) {
            odb.store(entre);
            return true;
        }

        return false;
    }

    public boolean insertarMultiples(ArrayList<Entrenador> entre) {
        try {
            for (Entrenador temp : entre) {
                insertar(temp);
            }
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean borrar(int id) {
        Entrenador eliminado = consultar(id);
        if(eliminado != null){
          odb.delete(eliminado);
          return true;
        }
        return false;
    }

    @Override
    public boolean modificar(int id, Entrenador nuevo) {
        Entrenador modificado = consultar(id);
        if(modificado != null){
            borrar(id);
            odb.store(nuevo);
            return true;
        }
        return false;
    }

    
    public ArrayList<Entrenador> consultar(String nombre) {
        ArrayList<Entrenador> devuelve = new ArrayList<>();
        IQuery query = new CriteriaQuery(Entrenador.class, Where.equal("nombre",nombre));
        query.orderByDesc("id");
        Objects<Entrenador> objects = odb.getObjects(query);
        for(Entrenador temp : objects){
            devuelve.add(temp);
        }
        return devuelve;
    }
    

    @Override
    public Entrenador consultar(int id) {
       
        IQuery query = new CriteriaQuery(Entrenador.class, Where.equal("id",id));
        query.orderByDesc("id");
        Objects<Entrenador> objects = odb.getObjects(query);
        if(objects.isEmpty()){
            return null;
        }
        return objects.getFirst();
    }

    
    public int ultimoId() {
        IQuery query = new CriteriaQuery(Entrenador.class);

        query.orderByDesc("id");
        org.neodatis.odb.Objects<Entrenador> objects = odb.getObjects(query);

        while (objects.hasNext()) {
            Entrenador artista = objects.next();
            return artista.getId(); // Devuelve el ultimo id
        }
        return 0;
    }
}
