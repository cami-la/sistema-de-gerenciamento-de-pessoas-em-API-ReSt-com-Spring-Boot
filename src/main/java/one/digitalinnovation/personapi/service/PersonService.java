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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private PersonRepository personRepository;

    //private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public ResponseEntity<PersonDto> createPerson(PersonForm personForm, UriComponentsBuilder uriComponentsBuilder) {
        Person savedPerson = personForm.convert();
        personRepository.save(savedPerson);

        URI uri = uriComponentsBuilder.path("/api/v1/people/{id}")
                .buildAndExpand(savedPerson.getId())
                .toUri();

        return ResponseEntity.created(uri)
                .body(new PersonDto(savedPerson));
    }

    /*public MessageResponseDTO createPerson(PersonForm personForm) {
        Person personToSave = personForm.convert();

        Person savedPerson = personRepository.save(personToSave);

        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }*/


    public List<PersonDto> listAll() {
        List<Person> list = personRepository.findAll();
        return PersonDto.converter(list);
    }

    public ResponseEntity<PersonDto> finbyId(Long id) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) {
            return ResponseEntity.ok(new PersonDto(person.get()));
        }
        return ResponseEntity.notFound().build();
    }

    /*public PersonDto listPerson(String cpf) {
        Person byCpf = personRepository.findByCpf();
        return new PersonDto(byCpf);
    }*/


}
