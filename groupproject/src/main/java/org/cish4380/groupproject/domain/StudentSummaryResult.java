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
public class StudentSummaryResult {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public StudentSummary getValue() {
        return value;
    }

    public void setValue(StudentSummary value) {
        this.value = value;
    }
    private StudentSummary value;
}
