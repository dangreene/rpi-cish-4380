/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cish4380.groupproject.dataaccess;

import java.util.List;

/**
 *
 * @author Dan
 */
public interface Repository<T> {

    public T getOne(String id);

    public List<T> getAll();

    public void create(T object);

    public void update(T object);

    public void createCollection();

    public void dropCollection();
    
    public void createTestData();

}
