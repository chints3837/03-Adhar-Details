package com.example.adhardetails.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "Bank")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer bid;

    public Long bAcNo;

    public String bBankName;

    public String bBankType;


    @ManyToOne
    @JoinColumn(name = "p_id",nullable = false)
    @JsonIgnore
    public Person person;

    public Bank(){

    }

    public Bank(Integer bid, Long bAcNo, String bBankName, String bBankType, Person person) {
        this.bid = bid;
        this.bAcNo = bAcNo;
        this.bBankName = bBankName;
        this.bBankType = bBankType;
        this.person = person;
    }
    public Bank(Integer bid, Long bAcNo, String bBankName, String bBankType) {
        this.bid = bid;
        this.bAcNo = bAcNo;
        this.bBankName = bBankName;
        this.bBankType = bBankType;
    }


    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Long getbAcNo() {
        return bAcNo;
    }

    public void setbAcNo(Long bAcNo) {
        this.bAcNo = bAcNo;
    }

    public String getbBankName() {
        return bBankName;
    }

    public void setbBankName(String bBankName) {
        this.bBankName = bBankName;
    }

    public String getbBankType() {
        return bBankType;
    }

    public void setbBankType(String bBankType) {
        this.bBankType = bBankType;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
