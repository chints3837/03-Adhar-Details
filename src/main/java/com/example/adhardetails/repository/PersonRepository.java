package com.example.adhardetails.repository;

import com.example.adhardetails.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {

    Person findByPAdharcardNo(Long adharId);


    Person findByPPancardNo(String panId);
}