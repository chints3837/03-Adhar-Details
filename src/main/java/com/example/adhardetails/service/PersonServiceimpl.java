package com.example.adhardetails.service;

import com.example.adhardetails.entity.Bank;
import com.example.adhardetails.entity.Person;
import com.example.adhardetails.repository.PersonRepository;
import com.example.adhardetails.serviceInterface.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceimpl implements PersonService {

    @Autowired
    public PersonRepository personRepository;



    public Person savePerson(Person person){


        // create Object internally
        Person personIn=new Person();

        personIn.setpAdharcardNo(person.getpAdharcardNo());
        personIn.setpPancardNo(person.getpPancardNo());
        personIn.setpName(person.getpName());


        List<Bank> bankList= new ArrayList<>();

        if(person.getBankList() !=null) {
            for(Bank bank:person.getBankList()){

                Bank bankobj=new Bank(bank.getBid(),bank.getbAcNo(),bank.getbBankName(),bank.getbBankType());

                //bankobj.setPerson(person);
                bankobj.setPerson(personIn);

                bankList.add(bankobj);
            }
        }


        personIn.setBankList(bankList);


        //final result after person save
        Person personResult=personRepository.save(person);

        System.out.println("Person saved !!");

        return personResult;
    }

    public Person getPersonById(Integer personId){

        Optional<Person> personResult= personRepository.findById(personId);

        return personResult.get();
    }

    public Person findPersonByAdhar(Long adharid){
        Person personResult=personRepository.findByPAdharcardNo(adharid);
        return personResult;
    }

    @Override
    public Person findPersonByPancardId(String pancardId) {
        System.out.println("inside serviceimpl findPersonByPancardId() ");

        Person personResult=personRepository.findByPPancardNo(pancardId);
        return personResult;
    }

    public Person updatePersonByAdharcardNo(Long adharId,String personName){

        Person personTemp=personRepository.findByPAdharcardNo(adharId);
        personTemp.setpName(personName);
        Person personResult=personRepository.save(personTemp);

        return personResult;
    }




}
