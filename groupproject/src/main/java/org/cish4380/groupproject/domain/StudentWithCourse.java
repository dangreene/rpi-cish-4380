/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cish4380.groupproject.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Dan
 */
@Document(collection = "StudentWithCourse")
public class StudentWithCourse {
    private Course course;
    private String studentId;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    
    public StudentWithCourse() {

    }

    public StudentWithCourse(String studentId, String name, String departmentName, Course course) {
        this.studentId = studentId;
        this.name = name;
        this.departmentName = departmentName;
        this.course = course;
    }
    
    @Id
    private String id;

    public String getId() {
        return id;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String firstName) {
        this.name = firstName;
    }
    
    private String departmentName;
    
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
