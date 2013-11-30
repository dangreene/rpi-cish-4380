/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cish4380.groupproject.dataaccess.tests;

import java.util.Iterator;
import org.cish4380.groupproject.dataaccess.MongoStudentWithCourseRepository;
import org.cish4380.groupproject.dataaccess.Repository;
import org.cish4380.groupproject.dataaccess.StudentsSummaryRepository;
import org.cish4380.groupproject.domain.StudentSummaryResult;
import org.cish4380.groupproject.domain.StudentWithCourse;
import org.cish4380.groupproject.springconfig.WebConfig;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import org.junit.AfterClass;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Dan
 */
public class MongoStudentWithCourseRepositoryTests {
    public Repository<StudentWithCourse> getStudentRepository() {

        MongoStudentWithCourseRepository repo = null;

        try {
            repo = new MongoStudentWithCourseRepository();
            WebConfig config = new WebConfig();
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
        testRepository.createTestData();
    }

    private static Repository<StudentWithCourse> testRepository;

    @Test
    public void GetRepository_ReturnsInstance() {
        assertThat(testRepository, is(not(equalTo(null))));
    }

    @Test
    public void StudentSummary_SummaryResultsReturned() {
        StudentsSummaryRepository repo = (StudentsSummaryRepository)testRepository;
        Iterator<StudentSummaryResult> results = repo.getStudentSummaryResults();
        
        int count = 0;
        while (results.hasNext()) {
            count++;
            results.next();
        }
        assertThat(count, is(equalTo(3)));
    }
    
    @AfterClass
    public static void oneTimeTearDown() {
        testRepository.createTestData();
    }
}
