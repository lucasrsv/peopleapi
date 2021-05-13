package com.lucas.peopleapi.utils;

import com.lucas.peopleapi.dto.request.PersonDTO;
import com.lucas.peopleapi.dto.request.PhoneDTO;
import com.lucas.peopleapi.entity.Person;
import com.lucas.peopleapi.entity.Phone;
import com.lucas.peopleapi.enums.PhoneType;

import java.time.LocalDate;
import java.util.Collections;

public class PhoneUtils {
    private static final String PHONE_NUMBER = "8199999-9999";
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static final long PHONE_ID = 1L;

    public static PhoneDTO createFakeDTO() {
        return PhoneDTO.builder()
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }

    public static Phone createFakeEntity() {
        return Phone.builder()
                .id(PHONE_ID)
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }
}
