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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.mongodb.WriteResult;
import org.cish4380.groupproject.domain.Student;



@Component
public class StudentRepository implements Repository<Student> {

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
    public WriteResult update(Student object) {
        return mongoTemplate.updateFirst(new Query(Criteria.where("id").is(object.getId())),
                Update.update("FirstName", object.getFirstName()),
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

}
