package com.sravani.vehicles.config;

import com.mongodb.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import javax.sql.DataSource;
import java.net.UnknownHostException;
import java.util.Arrays;

@Configuration
@ComponentScan(basePackages = "com.sravani.vehicles.service")
public class AppConfig {

    @Bean(name = "mongoTemplate")
    public MongoTemplate getMongoTemplate() throws UnknownHostException {
        String url = "mongodb://localhost:27017/vehicles-db?connectTimeoutMS=300000";
        MongoClientURI uri = new MongoClientURI(url);
        MongoDbFactory dbFactory = new SimpleMongoDbFactory(uri);
        MongoTemplate template = new MongoTemplate(dbFactory);
        return template;
    }

}