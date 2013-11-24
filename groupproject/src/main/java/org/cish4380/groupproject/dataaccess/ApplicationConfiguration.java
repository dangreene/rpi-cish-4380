/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cish4380.groupproject.dataaccess;

import com.mongodb.Mongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 *
 * @author Dan
 */
@Configuration
public class ApplicationConfiguration {
	
	@Bean(name = "mongoTemplate")
	public MongoTemplate getMongoTemplate(Mongo mongo){
		return new MongoTemplate(mongo,"student");
	}
	
	@Bean(name = "mongo")
	public Mongo getMongoInstance() throws Exception {
		return new Mongo("localhost", 27017);
	}
	
	@Bean(name = "studentRepository")
	public StudentRepository getStudentRepository(){
		return new StudentRepository();
	}
	
}
