package com.lucas.peopleapi.repository;

import com.lucas.peopleapi.dto.request.PersonDTO;
import com.lucas.peopleapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
