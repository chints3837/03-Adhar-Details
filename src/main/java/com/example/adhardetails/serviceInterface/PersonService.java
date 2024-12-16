package com.example.adhardetails.serviceInterface;

import com.example.adhardetails.entity.Person;
import org.springframework.stereotype.Service;

@Service
public interface PersonService {

    Person findPersonByAdhar(Long id);

    Person findPersonByPancardId(String id);

    Person updatePersonByAdharcardNo(Long adharId,String personName);
}
