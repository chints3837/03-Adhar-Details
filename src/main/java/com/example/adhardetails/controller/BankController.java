package com.example.adhardetails.controller;

import com.example.adhardetails.entity.Bank;

import com.example.adhardetails.service.BankServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController {

    @Autowired
    private BankServiceimpl bankServiceimpl;

    @PostMapping("/addBank/{personId}")
    public String addBank(@PathVariable Integer personId, @RequestBody Bank bank){

        return bankServiceimpl.saveBank(personId,bank);

    }
}
