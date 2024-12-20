package com.example.adhardetails.service;

import com.example.adhardetails.entity.Bank;
import com.example.adhardetails.entity.Person;
import com.example.adhardetails.exception.UserException;
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


    @Override
    public String saveBank(Integer personId,Bank bank){

        String ex;

        try {
            if(personId==null){
                ex="Please enter Person id";
                throw new UserException(ex);
            } else if (bank.getbBankType()==null) {
                ex="Please enter Bank type";
                throw new UserException(ex);
            } else if (bank.getbBankName()==null) {
                ex="Please enter Bank name";
                throw new UserException(ex);
            } else if (bank.getbAcNo()==null) {
                ex="Please enter Bank AC no";
                throw new UserException(ex);
            }
        }catch (Exception e){
            System.out.println("Exception Occured :"+e.toString());
        }

        // fetch person
        Optional<Person> persontemp= personRepository.findById(personId);
        try{
            if(persontemp.get()==null){
                ex="Person not Found !!";
                throw new Exception(ex);
            }

        }catch (Exception e){
            System.out.println("Exception Occured :"+e.toString());
        }


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
