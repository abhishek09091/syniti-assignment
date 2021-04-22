package com.assignment.synitiassignment.configuraiton;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Converter {

    @Bean(name = "processMapper")
    public ObjectMapper processMapper(){
        return new ObjectMapper();
    }
}
