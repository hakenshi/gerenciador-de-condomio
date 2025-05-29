/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciador.de.condominio.Models;

/**
 *
 * @author fkdia
 */
public abstract class Model<T> {
    public abstract T findAll();
    public abstract T findOne(int id);    
    public abstract T create(T entity);
    public abstract T update(T entity, int id);
    public abstract T delete(int id);
}
