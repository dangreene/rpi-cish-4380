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
import org.cish4380.groupproject.utility.PerformanceCounter;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @Autowired
    private PerformanceCounter performanceCounter;
    
    public void setPerformanceCounter(PerformanceCounter counter) {
        this.performanceCounter = counter;
    }
    
    @RequestMapping("studentsummary")
    public ModelAndView loadViewStudents() {
        performanceCounter.start();
        Iterator<StudentSummaryResult> students = studentRepository.getStudentSummaryResults();
        String totalTime = performanceCounter.getDuration();
        
        ModelAndView modelAndView = new ModelAndView("viewstudentsummary");
        modelAndView.addObject("students", students);
        modelAndView.addObject("totalTime", totalTime);
        return modelAndView;
    }
}
