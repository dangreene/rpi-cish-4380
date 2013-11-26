/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cish4380.groupproject.domain;

import org.springframework.data.annotation.Id;

/**
 *
 * @author Dan
 */
public abstract class BaseEntity {
    @Id
    private String id;

    public String getId() {
        return id;
    }
    
    public BaseEntity(){
        super();
    }
}