package com.example.adhardetails.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer pId;

    @Column
    public String pName;

    @Column
    public Long pAdharcardNo;

    @Column
    public String pPancardNo;


    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = false)
    public List<Bank> bankList;


    public Person(){

    }

    public Person(Integer pId, String pName, Long pAdharcardNo, String pPancardNo) {
        this.pId = pId;
        this.pName = pName;
        this.pAdharcardNo = pAdharcardNo;
        this.pPancardNo = pPancardNo;
    }


    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Long getpAdharcardNo() {
        return pAdharcardNo;
    }

    public void setpAdharcardNo(Long pAdharcardNo) {
        this.pAdharcardNo = pAdharcardNo;
    }

    public String getpPancardNo() {
        return pPancardNo;
    }

    public void setpPancardNo(String pPancardNo) {
        this.pPancardNo = pPancardNo;
    }

    public List<Bank> getBankList() {
        return bankList;
    }

    public void setBankList(List<Bank> bankList) {
        this.bankList = bankList;
    }
}
