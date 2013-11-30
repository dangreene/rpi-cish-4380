/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cish4380.groupproject.controller;

import java.util.List;
import org.cish4380.groupproject.dataaccess.Repository;
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
        this.studentRepository.createTestData();
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
