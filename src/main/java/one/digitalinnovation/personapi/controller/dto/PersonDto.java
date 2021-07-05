package one.digitalinnovation.personapi.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.entity.Phone;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String cpf;
    private List<String> phones;

    public PersonDto(Person person) {
        this.id = person.getId();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.cpf = person.getCpf();
        this.phones = converterPhone(person);
    }


    public List<String> converterPhone(Person person) {
        List<Phone> phones = person.getPhones();
        return phones.stream().map(Phone::toString).collect(Collectors.toList());
    }


}
