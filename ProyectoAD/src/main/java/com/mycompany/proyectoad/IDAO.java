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
public interface IDAO<T> {
    public ArrayList<T> verTodos();
    public boolean insertar (T o);
    public boolean borrar (int id);
    public boolean modificar (int id, T nuevo);
    public T consultar (int id);
    
}