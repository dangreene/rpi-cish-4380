/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cish4380.groupproject.dataaccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.cish4380.groupproject.domain.Course;
import org.cish4380.groupproject.domain.Student;
import org.cish4380.groupproject.domain.StudentSummary;
import org.cish4380.groupproject.domain.StudentSummaryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

/**
 *
 * @author Dan
 */

@Component
public class JdbcStudentRepository implements StudentRepository {
    
    @Autowired
    private JdbcTemplate template;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.template = jdbcTemplate;
    }
    
    @Override
    public Student getOne(String id) {
        return this.template.query("select * from student left join takes using(ID) where ID =".concat(id), new StudentMapper()).get(0);
    }

    @Override
    public Iterator<StudentSummaryResult> getStudentSummaryResults() {
        String query = "select ID, name, dept_name, sum(credits) as tot_credits " +
                "from student left join takes using(ID) " +
                "group by ID";
        return this.template.query(query, new StudentSummaryMapper()).iterator();
    }

    @Override
    public void createTestData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private static final class StudentSummaryMapper implements ResultSetExtractor<Iterable<StudentSummaryResult>> {

        @Override
        public Iterable<StudentSummaryResult> extractData(ResultSet rs) throws SQLException, DataAccessException {
            
            List<StudentSummaryResult> summaryList = new ArrayList<>();
            
            while (rs.next()) {
                StudentSummaryResult studentResult = new StudentSummaryResult();
                StudentSummary studentSummary = new StudentSummary();
                studentResult.setId(rs.getString("ID"));
                studentSummary.setName(rs.getString("name"));
                studentSummary.setDepartment(rs.getString("dept_name"));
                studentSummary.setTotalCredits(rs.getInt("tot_credits"));
                studentResult.setValue(studentSummary);
                summaryList.add(studentResult);
            }
            
            return summaryList;
        }
    }
    
    private static final class StudentMapper implements ResultSetExtractor<List<Student>> {
        
        @Override
        public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException {
            Map<String, Student> map = new HashMap<>();
            
            while (rs.next()) {
                
                String id = rs.getString("ID");

                // Get student from map
                Student student = map.get(id);

                // If the student is not in map, create a new one and add it
                if (student == null) {
                    student = new Student(rs.getString("ID"), rs.getString("name"), rs.getString("dept_name"));
                    map.put(id, student);
                }
                
                Course course = new Course();
                course.setCourseId(rs.getString("course_id"));
                course.setSectionId(rs.getShort("sec_id"));
                course.setSemester(rs.getString("semester"));
                course.setYear(rs.getShort("year"));
                course.setGrade(rs.getString("grade"));
                course.setCredits(rs.getShort("credits"));
                
                student.addCourse(course);
            }
            return new ArrayList<>(map.values());
        }
    }
    
    @Override
    public List<Student> getAll() {
        return this.template.query("select * from student left join takes using(ID)", new StudentMapper());
    }
    
    @Override
    public void create(Student object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void update(Student object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void createCollection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void dropCollection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
