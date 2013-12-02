/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cish4380.groupproject.domain;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Dan
 */
@Document(collection = "student")
public class Student {

    @Id
    private String id;
    private String name;
    private String departmentName;
    private final List<Course> courses = new ArrayList<>();
    
    public Student() {

    }

    public Student(String id, String name, String departmentName) {
        this.id = id;
        this.name = name;
        this.departmentName = departmentName;
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

    public void setName(String firstName) {
        this.name = firstName;
    }
    
    
    
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    

    public Iterable<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

}
