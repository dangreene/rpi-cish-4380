/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.cish4380.groupproject.springconfig;

import com.mongodb.Mongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author Dan
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.cish4380.groupproject")
public class WebConfig {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver
                = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");

        return resolver;
    }
    
    @Bean(name = "mongoTemplate")
    public MongoTemplate getMongoTemplate(Mongo mongo) {
        return new MongoTemplate(mongo, "student");
    }

    @Bean(name = "mongo")
    public Mongo getMongoInstance() throws Exception {
        return new Mongo("localhost", 27017);
    }
}
