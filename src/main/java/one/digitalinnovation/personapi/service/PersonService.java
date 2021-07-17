package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.controller.dto.MessageResponseDTO;
import one.digitalinnovation.personapi.controller.dto.PersonDto;
import one.digitalinnovation.personapi.controller.form.PersonForm;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public ResponseEntity<PersonDto> createPerson(PersonForm personForm) {
        Person savedPerson = personForm.convert();
        personRepository.save(savedPerson);

        return ResponseEntity.ok(new PersonDto(savedPerson));
    }

    /*public MessageResponseDTO createPerson(Person person) {
        Person savedPerson = personRepository.save(person);

        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }*/

}
