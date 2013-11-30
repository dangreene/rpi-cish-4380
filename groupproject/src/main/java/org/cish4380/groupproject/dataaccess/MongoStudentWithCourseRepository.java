/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cish4380.groupproject.dataaccess;

import java.util.Iterator;
import java.util.List;
import org.cish4380.groupproject.domain.Course;
import org.cish4380.groupproject.domain.StudentSummaryResult;
import org.cish4380.groupproject.domain.StudentWithCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapreduce.MapReduceResults;

/**
 *
 * @author Dan
 */
public class MongoStudentWithCourseRepository implements Repository<StudentWithCourse>, StudentsSummaryRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void setMongoTemplate(MongoTemplate template) {
        this.mongoTemplate = template;
    }

    @Override
    public StudentWithCourse getOne(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<StudentWithCourse> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(StudentWithCourse object) {
        mongoTemplate.insert(object);
    }

    @Override
    public void update(StudentWithCourse object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createCollection() {
        if (!mongoTemplate.collectionExists(StudentWithCourse.class)) {
            mongoTemplate.createCollection(StudentWithCourse.class);
        }
    }

    @Override
    public void dropCollection() {
        if (mongoTemplate.collectionExists(StudentWithCourse.class)) {
            mongoTemplate.dropCollection(StudentWithCourse.class);
        }
    }

    @Override
    public void createTestData() {
        StudentWithCourse s1c1 = new StudentWithCourse("11128", "Zhang", "Comp. Sci.", new Course("CS-101", (short) 1, "Fall", (short) 2009, "A", (short) 4));

        StudentWithCourse s1c2 = new StudentWithCourse("11128", "Zhang", "Comp. Sci.", new Course("CS-347", (short) 1, "Fall", (short) 2009, "A-", (short) 3));

        StudentWithCourse s2c1 = new StudentWithCourse("12345", "Shankar", "Comp. Sci.", new Course("CS-101", (short) 1, "Fall", (short) 2009, "C", (short) 4));
        StudentWithCourse s2c2 = new StudentWithCourse("12345", "Shankar", "Comp. Sci.", new Course("CS-190", (short) 2, "Spring", (short) 2009, "A", (short) 3));
        StudentWithCourse s2c3 = new StudentWithCourse("12345", "Shankar", "Comp. Sci.", new Course("CS-315", (short) 1, "Spring", (short) 2010, "A", (short) 3));
        StudentWithCourse s2c4 = new StudentWithCourse("12345", "Shankar", "Comp. Sci.", new Course("CS-347", (short) 1, "Fall", (short) 2009, "A", (short) 3));

        StudentWithCourse s3c1 = new StudentWithCourse("19991", "Brandt", "History", new Course("HIS-351", (short) 1, "Spring", (short) 2010, "B", (short) 3));
        this.create(s1c1);
        this.create(s1c2);
        this.create(s2c1);
        this.create(s2c2);
        this.create(s2c3);
        this.create(s2c4);
        this.create(s3c1);
    }

    @Override
    public Iterator<StudentSummaryResult> getStudentSummaryResults() {
        String mapFunction = "function() { \n"
                + "	var output = {\n"
                + "        department: this.departmentName,\n"
                + "        name: this.name,\n"
                + "        credits: this.course.credits\n"
                + "    };\n"
                + "    emit(this.studentId, output);\n"
                + "}";
        String reduceFunction = "function (key, values) {\n"
                + "	var output = {\n"
                + "        department: \"\",\n"
                + "        name: \"\",\n"
                + "        totalCredits: 0\n"
                + "    };\n"
                + "    \n"
                + "    if (values.length > 0) {\n"
                + "    	output.department = values[0].department;\n"
                + "        output.name = values[0].name;\n"
                + "    }\n"
                + "    \n"
                + "    for (var i = 0; i < values.length; i++) {\n"
                + "    	output.totalCredits += values[i].credits;\n"
                + "    }\n"
                + "    return output;  \n"
                + "}";
        MapReduceResults<StudentSummaryResult> reduceResult
                = mongoTemplate.mapReduce(
                        "StudentWithCourse",
                        mapFunction,
                        reduceFunction,
                        StudentSummaryResult.class);

        return reduceResult.iterator();
    }

}
