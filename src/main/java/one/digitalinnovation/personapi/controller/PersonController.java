package one.digitalinnovation.personapi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.tags.Tag;
import one.digitalinnovation.personapi.OpenApiConfig;
import one.digitalinnovation.personapi.controller.dto.PersonDto;
import one.digitalinnovation.personapi.controller.form.PersonForm;
import one.digitalinnovation.personapi.service.PersonService;

@Tag(name = OpenApiConfig.TAG_PESSOAS)
@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    /*@GetMapping
    public String Hello() {
        return "Hello Controller";
    }*/

    @PostMapping
    public ResponseEntity<PersonDto> createPerson(@RequestBody @Valid PersonForm personForm) {
       return this.personService.createPerson(personForm);
    }

}
