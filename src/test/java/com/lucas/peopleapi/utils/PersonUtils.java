package com.lucas.peopleapi.utils;

import com.lucas.peopleapi.dto.request.PersonDTO;
import com.lucas.peopleapi.entity.Person;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.util.Collections;

public class PersonUtils {
    private static final String FIRST_NAME = "Lucas";
    private static final String LAST_NAME = "Valença";
    private static final String CPF = "574.251.940-07";
    private static final long ID = 1L;
    private static final LocalDate BIRTH_DATE = LocalDate.of(2021, 05, 13);

    public static PersonDTO createFakeDTO() {
        return PersonDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .birthDate("13-05-2021")
                .cpf(CPF)
                .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .build();
    }

    public static Person createFakeEntity() {
        return Person.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .birthDate(BIRTH_DATE)
                .cpf(CPF)
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
    }

}
