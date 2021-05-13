package com.lucas.peopleapi.service;

import com.lucas.peopleapi.dto.response.MessageResponseDTO;
import com.lucas.peopleapi.dto.request.PersonDTO;
import com.lucas.peopleapi.entity.Person;
import com.lucas.peopleapi.exception.PersonNotFoundException;
import com.lucas.peopleapi.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lucas.peopleapi.repository.PersonRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return createMessageResponse(savedPerson.getId(), "Created person with ID ");
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = checkIfPersonExists(id);
        return personMapper.toDTO(person);
    }

    public void delete(Long id) throws PersonNotFoundException {
        checkIfPersonExists(id);
        personRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        checkIfPersonExists(id);
        Person personToUpdate = personMapper.toModel(personDTO);
        Person updatedPerson = personRepository.save(personToUpdate);

        return createMessageResponse(updatedPerson.getId(), "Updated person with ID ");
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }

    private Person checkIfPersonExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }
}
