package one.digitalinnovation.personapi.controller;

import javax.validation.Valid;

import lombok.AllArgsConstructor;
import one.digitalinnovation.personapi.controller.request.form.UpdatePersonForm;
import one.digitalinnovation.personapi.controller.response.dto.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.tags.Tag;
import one.digitalinnovation.personapi.OpenApiConfig;
import one.digitalinnovation.personapi.controller.request.form.PersonForm;
import one.digitalinnovation.personapi.service.PersonService;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Tag(name = OpenApiConfig.TAG_PESSOAS)
@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    private final PersonService personService;

    /*@GetMapping
    public String Hello() {
        return "Hello Controller";
    }*/

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public ResponseEntity<PersonDto> createPerson(@RequestBody @Valid PersonForm personForm, UriComponentsBuilder uriComponentsBuilder) {
       return this.personService.createPerson(personForm, uriComponentsBuilder);
    }

    /*@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonForm personDto) {
       return personService.createPerson(personDto);
    }*/

    @GetMapping()
    public List<PersonDto> listAll() {
        return personService.listAll();
    }

    /*/@GetMapping("/{cpf}")
    public ResponseEntity<PersonDto> findByCpf (String cpf) {
        return personService.findByCpf(cpf);
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> findById(@PathVariable Long id) {
        return personService.finbyId(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public ResponseEntity<PersonDto> deleteById(@PathVariable Long id) {
        return personService.deleteById(id);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PersonDto> update(@PathVariable Long id, @RequestBody @Valid UpdatePersonForm personForm) {
        return personService.updateById(id, personForm);
    }

}
