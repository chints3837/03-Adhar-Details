package com.example.adhardetails.service;

import com.example.adhardetails.entity.Bank;
import com.example.adhardetails.entity.Person;
import com.example.adhardetails.exception.UserException;
import com.example.adhardetails.repository.PersonRepository;
import com.example.adhardetails.serviceInterface.PersonService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceimpl implements PersonService {

    @Autowired
    public PersonRepository personRepository;

    @Override
    public Person savePerson(Person person){

        String ex;

        try{
            if(person==null){
                ex="Enter Person Details";
                throw new UserException(ex);
            }
        }catch (Exception e){
            System.out.println("Exception Occured :"+e.toString());
        }


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

    @Override
    public Person getPersonById(Integer personId){

        String ex;

        try {
            if(personId==null){
                ex="Enter person id";
                throw new UserException(ex);
            }
        }catch (Exception e){
            System.out.println("Exception Occured :"+e.toString());
        }

        Optional<Person> personResult= personRepository.findById(personId);

        return personResult.get();
    }


    @Override
    public Person findPersonByAdhar(Long adharid){

        try {
            if(adharid==null){
                throw new UserException("Please enter valid adhar id");
            }
        }catch (Exception e){
            System.out.println("Exception Occured :"+e.toString());
        }

        Person personResult=personRepository.findByPAdharcardNo(adharid);
        try {
            if(personResult==null){
                throw new UserException("Person not found");
            }
        }catch (Exception e){
            System.out.println("Exception Occured :"+e.toString());
        }

        return personResult;
    }

    @Override
    public Person findPersonByPancardId(String pancardId) {
        try {
            if(pancardId==null){
                throw new UserException("Please enter valid Pan-card id");
            }
        }catch (Exception e){
            System.out.println("Exception Occured :"+e.toString());
        }

        System.out.println("inside serviceimpl findPersonByPancardId() ");

        Person personResult=personRepository.findByPPancardNo(pancardId);
        try {
            if(personResult==null){
                throw new UserException("Person not found");
            }
        }catch (Exception e){
            System.out.println("Exception Occured :"+e.toString());
        }
        return personResult;
    }

    @Override
    public Person updatePersonByAdharcardNo(Long adharId,String personName){

        try {
            if(adharId==null){
                throw new UserException("Please enter valid Adhar card id");
            }
        }catch (Exception e){
            System.out.println("Exception Occured :"+e.toString());
        }

        Person personTemp=personRepository.findByPAdharcardNo(adharId);

        try {
            if(personTemp==null){
                throw new UserException("Person not found");
            }
        }catch (Exception e){
            System.out.println("Exception Occured :"+e.toString());
        }

        personTemp.setpName(personName);
        Person personResult=personRepository.save(personTemp);

        return personResult;
    }

}
