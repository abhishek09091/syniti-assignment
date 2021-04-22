package com.assignment.synitiassignment.controller;

import java.io.File;
import java.util.*;

import com.assignment.synitiassignment.pojo.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProcessController {

    @Autowired
    private ObjectMapper processMapper;

    @RequestMapping("/process")
    public List<String> processRecord(){

        List<Person> person = null;
        try {
            person = Arrays.asList(processMapper.readValue(new File("/Users/abhishektripathi/Downloads/syniti-assignment/src/main/resources/data.json"),Person[].class));
            //System.out.println(person);
            System.out.println("Initial Size of the list:" + person.size());
            return process(person);

        }catch (Exception ex){
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }

    private List<String> process(List<Person> personList){

        List<String> res = new ArrayList<>();
        Set<Person> unqiuePerson = new HashSet<>();
        for(Person person: personList){

            if(person.getAddress() == null || person.getName() == null || person.getZip() == null){
                res.add(person.getId());
            }else if(unqiuePerson.contains(person)){
                res.add(person.getId());
            }else{
                unqiuePerson.add(person);
            }
        }
        System.out.println(unqiuePerson);
        System.out.println("All the correct unqiue records: " + unqiuePerson.size());
        System.out.println("Size after removing the duplicates: " + res.size());
        return res;
    }

}
