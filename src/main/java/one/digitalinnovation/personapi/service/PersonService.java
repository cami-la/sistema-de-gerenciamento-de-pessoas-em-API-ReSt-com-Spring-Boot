package one.digitalinnovation.personapi.service;

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
        Person person = personForm.convert();
        personRepository.save(person);

        return ResponseEntity.ok(new PersonDto(person));
    }


}
