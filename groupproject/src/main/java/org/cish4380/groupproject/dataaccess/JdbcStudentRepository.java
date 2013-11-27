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
import java.util.List;
import java.util.Map;
import org.cish4380.groupproject.domain.Course;
import org.cish4380.groupproject.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

/**
 *
 * @author Dan
 */
@Component
public class JdbcStudentRepository implements Repository<Student> {
    
    @Autowired
    private JdbcTemplate template;
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.template = jdbcTemplate;
    }
    
    @Override
    public Student getOne(String id) {
        return this.template.queryForObject("select * from student where ID =".concat(id), new SingleStudentMapper());
    }

    private static final class SingleStudentMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student student = new Student();
            student.setId(rs.getString("ID"));
            student.setName(rs.getString("name"));
            Course course = new Course();
            return student;
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
                    student = new Student(rs.getString("ID"), rs.getString("name"));
                    map.put(id, student);
                }
                
                Course course = new Course();
                course.setDepartmentName(rs.getString("dept_name"));
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
        return this.template.query("select * from student join takes using(ID)", new StudentMapper());
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
