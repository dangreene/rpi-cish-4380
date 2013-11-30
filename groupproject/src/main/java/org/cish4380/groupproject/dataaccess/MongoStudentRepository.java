/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cish4380.groupproject.dataaccess;

/**
 *
 * @author Dan
 */
import java.util.Iterator;
import java.util.List;
import org.cish4380.groupproject.domain.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import org.cish4380.groupproject.domain.Student;
import org.cish4380.groupproject.domain.StudentSummaryResult;
import org.springframework.data.mongodb.core.mapreduce.MapReduceResults;

@Component("mongoStudentRepository")
public class MongoStudentRepository implements StudentRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void setMongoTemplate(MongoTemplate template) {
        this.mongoTemplate = template;
    }

    @Override
    public Student getOne(String id) {
        // TODO Auto-generated method stub
        return mongoTemplate.findOne(new Query(Criteria.where("id").is(id)), Student.class);
    }

    @Override
    public List<Student> getAll() {
        // TODO Auto-generated method stub
        return mongoTemplate.findAll(Student.class);
    }

    @Override
    public void create(Student object) {
        mongoTemplate.insert(object);
    }

    @Override
    public void update(Student object) {
        mongoTemplate.updateFirst(new Query(Criteria.where("id").is(object.getId())),
                Update.update("Name", object.getName()),
                Student.class);
    }

    @Override
    public void createCollection() {
        if (!mongoTemplate.collectionExists(Student.class)) {
            mongoTemplate.createCollection(Student.class);
        }
    }

    @Override
    public void dropCollection() {
        if (mongoTemplate.collectionExists(Student.class)) {
            mongoTemplate.dropCollection(Student.class);
        }
    }

    @Override
    public void createTestData() {
        this.dropCollection();
        this.createCollection();
        Student s1 = new Student("11128", "Zhang", "Comp. Sci.");
        s1.addCourse(new Course("CS-101", (short) 1, "Fall", (short) 2009, "A", (short) 4));
        s1.addCourse(new Course("CS-347", (short) 1, "Fall", (short) 2009, "A-", (short) 3));
        this.create(s1);

        Student s2 = new Student("12345", "Shankar", "Comp. Sci.");
        s2.addCourse(new Course("CS-101", (short) 1, "Fall", (short) 2009, "C", (short) 4));
        s2.addCourse(new Course("CS-190", (short) 2, "Spring", (short) 2009, "A", (short) 3));
        s2.addCourse(new Course("CS-315", (short) 1, "Spring", (short) 2010, "A", (short) 3));
        s2.addCourse(new Course("CS-347", (short) 1, "Fall", (short) 2009, "A", (short) 3));
        this.create(s2);

        Student s3 = new Student("19991", "Brandt", "History");
        s3.addCourse(new Course("HIS-351", (short) 1, "Spring", (short) 2010, "B", (short) 3));
        this.create(s3);

        Student s4 = new Student("23121", "Chavez", "Finance");
        s4.addCourse(new Course("FIN-201", (short) 1, "Spring", (short) 2010, "C+", (short) 3));
        this.create(s4);

        Student s5 = new Student("44553", "Peltier", "Physics");
        s5.addCourse(new Course("PHY-101", (short) 1, "Fall", (short) 2009, "B-", (short) 3));
        this.create(s5);

        Student s6 = new Student("45678", "Levy", "Physics");
        s6.addCourse(new Course("CS-101", (short) 1, "Fall", (short) 2009, "F", (short) 4));
        s6.addCourse(new Course("CS-101", (short) 1, "Spring", (short) 2010, "B+", (short) 4));
        s6.addCourse(new Course("CS-319", (short) 1, "Spring", (short) 2010, "B", (short) 3));
        this.create(s6);

        Student s7 = new Student("54321", "Williams", "Comp. Sci.");
        s7.addCourse(new Course("CS-101", (short) 1, "Fall", (short) 2009, "A-", (short) 4));
        s7.addCourse(new Course("CS-190", (short) 2, "Spring", (short) 2009, "B+", (short) 3));
        this.create(s7);

        Student s8 = new Student("55739", "Sanchez", "Music");
        s8.addCourse(new Course("MU-199", (short) 1, "Spring", (short) 2010, "A-", (short) 4));
        this.create(s8);

        Student s9 = new Student("70557", "Snow", "Physics");
        this.create(s9);

        Student s10 = new Student("76543", "Brown", "Comp. Sci.");
        s10.addCourse(new Course("CS-101", (short) 1, "Fall", (short) 2009, "A", (short) 4));
        s10.addCourse(new Course("CS-319", (short) 2, "Spring", (short) 2010, "A", (short) 3));
        this.create(s10);

        Student s11 = new Student("76653", "Aoi", "Elec. Eng.");
        s11.addCourse(new Course("EE-181", (short) 1, "Spring", (short) 2009, "C", (short) 3));
        this.create(s11);

        Student s12 = new Student("98765", "Bourikas", "Elec. Eng.");
        s12.addCourse(new Course("CS-101", (short) 1, "Fall", (short) 2009, "C-", (short) 4));
        s12.addCourse(new Course("CS-315", (short) 1, "Spring", (short) 2010, "B", (short) 3));
        this.create(s12);

        Student s13 = new Student("98988", "Tanaka", "Biology");
        s13.addCourse(new Course("BIO-101", (short) 1, "Summer", (short) 2009, "A", (short) 3));
        s13.addCourse(new Course("BIO-301", (short) 1, "Summer", (short) 2010, "B", (short) 3));
        this.create(s13);
    }

    @Override
    public Iterator<StudentSummaryResult> getStudentSummaryResults() {
        String mapFunction = "function() { \n"
                + "    var output = {\n"
                + "        department: this.departmentName,\n"
                + "        name: this.name,\n"
                + "        totalCredits: 0\n"
                + "    };\n"
                + "    \n"
                + "    for (var i = 0; i < this.courses.length; i++) {\n"
                + "        output.totalCredits += this.courses[i].credits;\n"
                + "    }  \n"
                + "    emit(this._id, output);\n"
                + "}";
        String reduceFunction = "function (key, values) {\n"
                + "    return values;  \n"
                + "}";
        MapReduceResults<StudentSummaryResult> reduceResult
                = mongoTemplate.mapReduce(
                        "student",
                        mapFunction,
                        reduceFunction,
                        StudentSummaryResult.class);

        return reduceResult.iterator();
    }
}
