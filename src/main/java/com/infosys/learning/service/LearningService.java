package com.infosys.learning.service;

import com.infosys.learning.dto.Person;
import org.springframework.stereotype.Service;

@Service
public class LearningService {
    public String getName(String gender){
        Person person = new Person();
        if("man".equals(gender)){
            person.setName("John");
        }else{
            person.setName("Jane");
        }
        return person.getName();
    }
}
