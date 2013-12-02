/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cish4380.groupproject.controller;

import java.util.List;
import javax.annotation.Resource;
import org.cish4380.groupproject.dataaccess.StudentRepository;
import org.cish4380.groupproject.domain.Student;
import org.cish4380.groupproject.utility.PerformanceCounter;
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
    
    @Resource(name = "mongoStudentRepository")
    private StudentRepository studentRepository;
    
    public void setRepository(StudentRepository repository) {
        this.studentRepository = repository;
        this.studentRepository.createTestData();
    }
    
    @Autowired
    private PerformanceCounter performanceCounter;
    
    public void setPerformanceCounter(PerformanceCounter counter) {
        this.performanceCounter = counter;
    }
    
    public StudentController() {
   
    }

    @RequestMapping("/")
    public String loadIndex() {
        return "index";
    }

    @RequestMapping("students")
    public ModelAndView loadViewStudents() {
        performanceCounter.start();
        List<Student> students = studentRepository.getAll();
        String totalTime = performanceCounter.getDuration();
        ModelAndView modelAndView = new ModelAndView("viewstudents");
        
        modelAndView.addObject("students", students);
        modelAndView.addObject("totalTime", totalTime);
        return modelAndView;
    }

    @RequestMapping(value = "students/{id}", method = RequestMethod.GET)
    public ModelAndView loadStudent(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("viewstudent");
        performanceCounter.start();
        Student student = studentRepository.getOne(id);
        String totalTime = performanceCounter.getDuration();
        modelAndView.addObject("student", student);
        modelAndView.addObject("totalTime", totalTime);
        return modelAndView;
    }

}
