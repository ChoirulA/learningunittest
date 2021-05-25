package com.infosys.learning.controller;

import com.infosys.learning.dto.Person;
import com.infosys.learning.live.Live;
import com.infosys.learning.service.LearningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class LearningController {
    @Autowired
    LearningService learningService;

    @GetMapping(value = "/getpersonname")
    public String getPersonName(@RequestParam(value = "gender", defaultValue = "gender") String gender){
        return learningService.getName(gender);
    }

    @GetMapping(value = "/getpersonnamev2")
    public Person getPersonNameV2(@RequestParam(value = "gender", defaultValue = "gender") String gender){
        return learningService.getNameV2(gender);
    }

    @PostMapping(value = "/getpersonnamev3", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getPersonNameV3(@RequestBody(required = true) Person person){
        return learningService.getNameV3(person.getName());
    }

    //Tugas 2

    @GetMapping(value = "/getcity")
    public String getCity(@RequestParam(value = "city", defaultValue = "city") String city){
        return learningService.getCity(city);
    }

    @GetMapping(value = "/getcityv2")
    public Live getCityV2(@RequestParam(value = "city", defaultValue = "city") String city){
        return learningService.getCityV2(city);
    }

    @PostMapping(value = "/getcityv3", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getCityV3(@RequestBody(required = true) Live live){
        return learningService.getCityV3(live.getCity());
    }
}
