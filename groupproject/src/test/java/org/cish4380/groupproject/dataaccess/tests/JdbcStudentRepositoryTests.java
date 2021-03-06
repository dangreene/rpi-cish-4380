/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cish4380.groupproject.dataaccess.tests;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import java.util.Iterator;
import java.util.List;
import org.cish4380.groupproject.dataaccess.JdbcStudentRepository;
import org.cish4380.groupproject.dataaccess.StudentRepository;
import org.cish4380.groupproject.domain.Course;
import org.cish4380.groupproject.domain.Student;
import org.cish4380.groupproject.domain.StudentSummaryResult;
import org.cish4380.groupproject.springconfig.WebConfig;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Dan
 */
public class JdbcStudentRepositoryTests {

    public StudentRepository getStudentRepository() {

        JdbcStudentRepository repo = new JdbcStudentRepository();
        WebConfig config = new WebConfig();
        repo.setJdbcTemplate(config.getJdbcTemplate(config.getMySqlDataSource()));
        return repo;
    }

    @Before
    public void SetupTest() {
        //TODO: Instantiate repo
        testRepository = getStudentRepository();
    }

    private StudentRepository testRepository;

    @Test
    public void NewRepository_ReturnsInstance() {
        assertThat(testRepository, is(not(equalTo(null))));
    }

    @Test
    public void GetAll_HasStudents_ReturnsStudents() {
        List<Student> students = testRepository.getAll();

        Student s = Iterables.find(students, new Predicate<Student>() {
            @Override
            public boolean apply(Student s) {
                return s.getId().equals("11128");
            }
        });

        int count = 0;
        
        for (Course courses : s.getCourses()) {
            count++;
        }

        assertThat(s.getName(), is(equalTo("Zhang")));
        assertThat(count, is(equalTo(2)));
    }

    @Test
    public void GetOne_StudentExists_ReturnsStudent() {
        Student student = testRepository.getOne("11128");
        int count = 0;
        
        for (Course courses : student.getCourses()) {
            count++;
        }

        assertThat(student.getName(), is(equalTo("Zhang")));
        assertThat(count, is(equalTo(2)));
        
    }
    
    @Test
    public void getStudentSummaryResults() {
        
        Iterator<StudentSummaryResult> summaries = testRepository.getStudentSummaryResults();

        StudentSummaryResult s = Iterators.find(summaries, new Predicate<StudentSummaryResult>() {
            @Override
            public boolean apply(StudentSummaryResult s) {
                return s.getId().equals("11128");
            }
        });
        
        assertThat(s.getValue().getTotalCredits(), is(equalTo(7)));
    }
    
    @Test
    public void getStudentSummaryResults_nocourses_0credits() {
        Iterator<StudentSummaryResult> summaries = testRepository.getStudentSummaryResults();

        StudentSummaryResult s = Iterators.find(summaries, new Predicate<StudentSummaryResult>() {
            @Override
            public boolean apply(StudentSummaryResult s) {
                return s.getId().equals("70557");
            }
        });
        
        assertThat(s.getValue().getTotalCredits(), is(equalTo(0)));
    }
}
