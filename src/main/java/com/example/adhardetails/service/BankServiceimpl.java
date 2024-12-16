package com.example.adhardetails.service;

import com.example.adhardetails.entity.Bank;
import com.example.adhardetails.entity.Person;
import com.example.adhardetails.repository.BankRepository;
import com.example.adhardetails.repository.PersonRepository;
import com.example.adhardetails.serviceInterface.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BankServiceimpl implements BankService {


    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private BankRepository bankRepository;


    public String saveBank(Integer personId,Bank bank){

        // fetch person
        Optional<Person> persontemp= personRepository.findById(personId);

        //list of bank
        List<Bank> bankList=new ArrayList<>();

        //new Bank
//        Bank banktemp=new Bank();

        //set person to bank
        bank.setPerson(persontemp.get());

        //bank add
        bankList.add(bank);

        //set Bank list
        persontemp.get().setBankList(bankList);


        Person result= personRepository.save(persontemp.get());


        System.out.println("saved !!");


//       Person personResult= personRepository.save(person.get());

//        Bank bankResult= bankRepository.save(bank);

        return "Save Bank Details";
    }
}
