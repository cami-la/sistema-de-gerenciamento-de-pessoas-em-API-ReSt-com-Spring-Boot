package one.digitalinnovation.personapi.service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.personapi.controller.request.form.UpdatePersonForm;
import one.digitalinnovation.personapi.controller.request.form.PersonForm;
import one.digitalinnovation.personapi.controller.response.dto.PersonDto;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private PersonRepository personRepository;

    //private final PersonMapper personMapper = PersonMapper.INSTANCE;

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
        Optional<Person> personById = personRepository.findById(id);
        return personById.map(person -> ResponseEntity.ok(new PersonDto(person)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<PersonDto> deleteById(Long id) {
        Optional<Person> personById = personRepository.findById(id);
        if(personById.isPresent()) {
            personRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<PersonDto> findByCpf(String cpf) {
        Person byCpf = personRepository.findByCpf(cpf);
        Person personByCpf = personRepository.findByCpf(cpf);
        if (personByCpf != null) {
            return ResponseEntity.ok(new PersonDto(personByCpf));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<PersonDto> updateById(Long id, UpdatePersonForm personForm) {
        Optional<Person> personById = personRepository.findById(id);
        if (personById.isPresent()) {
            Person person = personById.get();
            person.setFirstName(personForm.getFirstName());
            person.setLastName(personForm.getLastName());
            person.setPhones(personForm.getPhones());

            return ResponseEntity.ok(new PersonDto(personById.get()));
        }
        return ResponseEntity.notFound().build();
    }


}
