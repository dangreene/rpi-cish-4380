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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Dan
 */
@Controller
public class StudentController {

    @Autowired
    private Repository<Student> studentRepository;
    
    public void setStudentRepository(Repository<Student> repository) {
       studentRepository = repository; 
    }
   
    @RequestMapping("students") 
    public ModelAndView loadViewStudents(Model m) {
        createTestData(studentRepository);
        List<Student> students = studentRepository.getAll();
        ModelAndView modelAndView = new ModelAndView("viewstudents");
        modelAndView.addObject("students", students);
        return modelAndView;
    }
    
    private void createTestData(Repository<Student> repository){
        repository.dropCollection();
        repository.createCollection();
        repository.create(new Student("Dan", "Greene"));
        repository.create(new Student("John", "Geoghegan"));
        repository.create(new Student("Jon", "Braverman"));
    }
   
}
