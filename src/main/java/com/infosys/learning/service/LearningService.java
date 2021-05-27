package com.infosys.learning.service;

import com.infosys.learning.data.Data;
import com.infosys.learning.data.Respond;
import com.infosys.learning.dto.Person;
import com.infosys.learning.live.Live;
import com.infosys.learning.model.User;
import com.infosys.learning.dto.UserRequest;
import com.infosys.learning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class LearningService {

    @Autowired
    UserRepository userRepository;

    public String getName(String gender){
        Person person = new Person();
        if("man".equals(gender)){
            person.setName("John");
        }else{
            person.setName("Jane");
        }
        return person.getName();
    }

    public Person getNameV2(String gender){
        Person person = new Person();
        if("man".equals(gender)){
            person.setName("John Walker");
        }else{
            person.setName("Amanda Waller");
        }
        return person;
    }

    public String getNameV3(String name){
        String fullName = "not identified";
        if("John".equals(name)){
            fullName = "John Doe";
        }else{
            fullName = "Jane Doe";
        }
        return fullName;
    }

    //Tugas 2

    public String getCity(String city){
        Live live = new Live();
        if("Bantul".equals(city)){
            live.setCity("Yogyakarta");
        }else{
            live.setCity("Other City");
        }
        return live.getCity();
    }

    public Live getCityV2(String city){
        Live live = new Live();
        if("Bantul".equals(city)){
            live.setCity("Yogyakarta");
        }else{
            live.setCity("Other City");
        }
        return live;
    }

    public String getCityV3(String city){
        Live live = new Live();
        String address = "Undefined";
        if("Bantul".equals(city)){
            address = "Perum Graha Sedayu Sejahtera";
        }else{
            address = "Other City";
        }
        return address;
    }

    //Tugas 3

    public Respond getPerson(String name, int yearOfBirth){
        Respond respond = new Respond();
        Data data = new Data();

        respond.setName(name);

        Date date = new Date();
        SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
        String currentYear = getYearFormat.format(date);
        int now = Integer.parseInt(currentYear);

        data.setAge(now-yearOfBirth);

        respond.setData(data);
        return respond;
    }

    //Tugas 4

    public String register(UserRequest userRequest){
        User existUser = userRepository.findByUserName(userRequest.getUsername());
        if(existUser != null){
            return "Register failed, username is already exist";
        }else{
            User user = new User();
            user.setUserName(userRequest.getUsername());
            user.setPassWord(userRequest.getPassword());
            userRepository.save(user);

            return "Register Success!";
        }
    }

    public User login(UserRequest userRequest){
        User existUser = userRepository.findByUserNameAndPassWord(userRequest.getUsername(), userRequest.getPassword());
        if(existUser == null){
            return null;
        }else{
            return existUser;
        }
    }
}
