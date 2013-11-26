/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cish4380.groupproject.domain;

/**
 *
 * @author Dan
 */
public class StudentSummary {
    private String id;
    private String name;
    private String department;
    private Integer totalCredits;

    public StudentSummary(String id, String name, String department, Integer totalCredits) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.totalCredits = totalCredits;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(Integer totalCredits) {
        this.totalCredits = totalCredits;
    }

    
    
    
}
