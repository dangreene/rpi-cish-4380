/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cish4380.groupproject.dataaccess;

import org.cish4380.groupproject.domain.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Dan
 */
public final class RepositoryFactory {
    public static Repository<Student> getStudentRepository() {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		
		return ctx.getBean("studentRepository",StudentRepository.class);
	}
}
