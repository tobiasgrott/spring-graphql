package com.grott.graphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GraphQLApp {
    public static void main(String[] args){
        SpringApplication app = new SpringApplication(GraphQLApp.class);
        app.run(args);
    }
}