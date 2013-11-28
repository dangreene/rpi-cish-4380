/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cish4380.groupproject.controller;

import java.util.List;
import org.cish4380.groupproject.dataaccess.Repository;
import org.cish4380.groupproject.domain.Course;
import org.cish4380.groupproject.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Dan
 */
@Controller
public class StudentController {

    private final Repository<Student> studentRepository;

    @Autowired
    public StudentController(Repository<Student> repository) {
        this.studentRepository = repository;
        this.studentRepository.dropCollection();
        this.studentRepository.createCollection();

        Student s1 = new Student("11128", "Zhang", "Comp. Sci.");
        s1.addCourse(new Course("CS-101", (short)1,"Fall", (short)2009,"A", (short)4));
        s1.addCourse(new Course("CS-347", (short)1,"Fall", (short)2009,"A-", (short)3));
        
        Student s2 = new Student("12345", "Shankar", "Comp. Sci.");
        s2.addCourse(new Course("CS-101", (short)1,"Fall", (short)2009,"C", (short)4));
        s2.addCourse(new Course("CS-190", (short)2,"Spring", (short)2009,"A", (short)3));
        s2.addCourse(new Course("CS-315", (short)1,"Spring", (short)2010,"A", (short)3));
        s2.addCourse(new Course("CS-347", (short)1,"Fall", (short)2009,"A", (short)3));

        Student s3 = new Student("19991", "Brandt", "History");
        s3.addCourse(new Course("HIS-351", (short)1,"Spring", (short)2010,"B", (short)3));
        
        Student s4 = new Student("23121", "Chavez", "Finance");
        s4.addCourse(new Course("FIN-201", (short)1,"Spring", (short)2010,"C+", (short)3));
        
        Student s5 = new Student("44553", "Peltier", "Physics");
        s5.addCourse(new Course("PHY-101", (short)1,"Fall", (short)2009,"B-", (short)3));
        
        Student s6 = new Student("45678", "Levy", "Physics");
        s6.addCourse(new Course("CS-101", (short)1,"Fall", (short)2009,"F", (short)4));
        s6.addCourse(new Course("CS-101", (short)1,"Spring", (short)2010,"B+", (short)4));
        s6.addCourse(new Course("CS-319", (short)1,"Spring", (short)2010,"B", (short)3));
        
        Student s7 = new Student("54321", "Williams", "Comp. Sci.");
        s7.addCourse(new Course("CS-101", (short)1,"Fall", (short)2009,"A-", (short)4));
        s7.addCourse(new Course("CS-190", (short)2,"Spring", (short)2009,"B+", (short)3));
        
        Student s8 = new Student("55739", "Sanchez", "Music");
        s8.addCourse(new Course("MU-199", (short)1,"Spring", (short)2010,"A-", (short)4));
        
        Student s9 = new Student("70557", "Snow", "Physics");
        
        Student s10 = new Student("76543", "Brown", "Comp. Sci.");
        s10.addCourse(new Course("CS-101", (short)1,"Fall", (short)2009,"A", (short)4));
        s10.addCourse(new Course("CS-319", (short)2,"Spring", (short)2010,"A", (short)3));
        
        Student s11 = new Student("76653", "Aoi", "Elec. Eng.");
        s11.addCourse(new Course("EE-181", (short)1,"Spring", (short)2009,"C", (short)3));
        
        Student s12 = new Student("98765", "Bourikas", "Elec. Eng.");
        s12.addCourse(new Course("CS-101", (short)1,"Fall", (short)2009,"C-", (short)4));
        s12.addCourse(new Course("CS-315", (short)1,"Spring", (short)2010,"B", (short)3));
        
        Student s13 = new Student("98988", "Tanaka", "Biology");
        s13.addCourse(new Course("BIO-101", (short)1,"Summer", (short)2009,"A", (short)3));
        s13.addCourse(new Course("BIO-301", (short)1,"Summer", (short)2010,"B", (short)3));
    }

    @RequestMapping("/")
    public String loadIndex() {
        return "index";
    }

    @RequestMapping("students")
    public ModelAndView loadViewStudents() {
        List<Student> students = studentRepository.getAll();
        ModelAndView modelAndView = new ModelAndView("viewstudents");
        modelAndView.addObject("students", students);
        return modelAndView;
    }

    @RequestMapping(value = "students/{id}", method = RequestMethod.GET)
    public ModelAndView loadStudent(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("viewstudent");
        Student student = studentRepository.getOne(id);
        modelAndView.addObject("student", student);
        return modelAndView;
    }

}
