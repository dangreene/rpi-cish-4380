/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cish4380.groupproject.controller;

import java.util.Iterator;
import javax.annotation.Resource;
import org.cish4380.groupproject.dataaccess.StudentRepository;
import org.cish4380.groupproject.domain.StudentSummaryResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Dan
 */
@Controller
public class StudentSummaryController {
    @Resource(name = "mongoStudentRepository")
    private StudentRepository studentRepository;
    
    public void setRepository(StudentRepository repository) {
        this.studentRepository = repository;
        this.studentRepository.createTestData();
    }
    
    @RequestMapping("studentsummary")
    public ModelAndView loadViewStudents() {
        Iterator<StudentSummaryResult> students = studentRepository.getStudentSummaryResults();
        ModelAndView modelAndView = new ModelAndView("viewstudentsummary");
        modelAndView.addObject("students", students);
        return modelAndView;
    }
}
