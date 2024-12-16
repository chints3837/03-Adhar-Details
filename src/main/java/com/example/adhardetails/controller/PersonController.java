package com.example.adhardetails.controller;

import com.example.adhardetails.entity.Person;
import com.example.adhardetails.service.PersonServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {


    @Autowired
    private PersonServiceimpl personServiceimpl;



    @PostMapping("/addPerson")
    public Person addPerson(@RequestBody Person person){

        Person personResult=personServiceimpl.savePerson(person);


        return personResult;
    }

    @GetMapping("/getPerson/{personId}")
    public Person getPersonById(@PathVariable Integer personId){

        Person personResult= personServiceimpl.getPersonById(personId);

        return personResult;
    }

    @GetMapping("/getPersonByAdhar/{adharId}")
    public Person findByadharcardNo(@PathVariable Long adharId){
        System.out.println("Inside findByPadharcardNo()");
        Person personResult=personServiceimpl.findPersonByAdhar(adharId);

        return personResult;

    }

    @GetMapping("/getPersonByPancardId/{panId}")
    public Person findPersonByPandcarId(@PathVariable String panId){
        System.out.println("Inside findPersonByPandcarId()");
        Person personResult=personServiceimpl.findPersonByPancardId(panId);

        return personResult;

    }


    @PutMapping("/updateRecordUsingAdharNo/{adharId}")
    public Person updatePersonByAdharNo(@PathVariable Long adharId,@RequestBody Person person){
        System.out.println("Inside findByPadharcardNo()");
        Person personResult=personServiceimpl.updatePersonByAdharcardNo(adharId,person.getpName());

        return personResult;
    }

}
