package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.controller.response.dto.MessageResponseDTO;
import one.digitalinnovation.personapi.controller.request.form.PersonForm;
import one.digitalinnovation.personapi.controller.response.dto.PersonDto;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class PersonService {

    private PersonRepository personRepository;

    //private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    /*public ResponseEntity<PersonDto> createPerson(PersonForm personForm) {
        Person savedPerson = personForm.convert();
        personRepository.save(savedPerson);

        return ResponseEntity.ok(new PersonDto(savedPerson));
    }*/

    public MessageResponseDTO createPerson(PersonForm personForm) {
        Person personToSave = personForm.convert();

        Person savedPerson = personRepository.save(personToSave);

        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }


    /*public ResponseEntity<PersonDto> listAll() {
        List<Person> allPeople = personRepository.findAll();

    }*/
}
