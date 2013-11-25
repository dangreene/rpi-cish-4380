/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cish4380.groupproject.dataaccess.tests;

import org.cish4380.groupproject.dataaccess.Repository;
import org.cish4380.groupproject.dataaccess.StudentRepository;
import org.cish4380.groupproject.domain.Student;
import org.cish4380.groupproject.springconfig.WebConfig;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Dan
 */
public class StudentRepositoryTests {

    public Repository<Student> getStudentRepository() {
        StudentRepository repo = new StudentRepository();
        WebConfig config = new WebConfig();

        try {
            repo.setMongoTemplate(config.getMongoTemplate(config.getMongoInstance()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return repo;
    }

    @Before
    public void SetupTest() {
        //TODO: Instantiate repo
        testRepository = getStudentRepository();
        testRepository.dropCollection();
        testRepository.createCollection();
    }

    private Repository<Student> testRepository;

    @Test
    public void GetRepository_ReturnsInstance() {
        assertThat(testRepository, is(not(equalTo(null))));
    }

    @Test
    public void GetOne_RecordExists_ReturnsResult() {
        // Arrange
        Student student = new Student("Dan", "Greene");
        testRepository.create(student);

        // Act
        Student result = testRepository.getOne(student.getId());
        System.out.println(student.getId());

        // Assert
        assertThat(result.getFirstName(), is(equalTo("Dan")));
    }
}
