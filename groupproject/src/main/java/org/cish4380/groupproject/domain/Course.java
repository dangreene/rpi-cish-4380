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

public class Course {

    private String departmentName;    
    private String courseId;
    private Short sectionId;
    private String semester;
    private Short year;
    private String grade;
    private Short credits;
    
    public Course() {
        
    }
    
    public Course(String departmentName, String courseId, Short sectionId, String semester,
            Short year, String grade, Short credits) {
        this.departmentName = departmentName;
        this.courseId = courseId;
        this.sectionId = sectionId;
        this.semester = semester;
        this.year = year;
        this.grade = grade;
        this.credits = credits;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
    
    public Short getSectionId() {
        return sectionId;
    }

    public void setSectionId(Short sectionId) {
        this.sectionId = sectionId;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Short getYear() {
        return year;
    }

    public void setYear(Short year) {
        this.year = year;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Short getCredits() {
        return credits;
    }

    public void setCredits(Short credits) {
        this.credits = credits;
    }

}
