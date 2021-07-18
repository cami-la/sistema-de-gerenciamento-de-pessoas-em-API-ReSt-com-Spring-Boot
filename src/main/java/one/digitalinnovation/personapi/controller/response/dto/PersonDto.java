package one.digitalinnovation.personapi.controller.response.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.entity.Phone;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {
    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String lastName;

    @NotEmpty
    @CPF
    private String cpf;

    private LocalDate birthDate;

    @Valid
    @NotEmpty
    private List<String> phones;

    public PersonDto(Person person) {
        this.id = person.getId();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.cpf = person.getCpf();
        this.birthDate = person.getBirthDate();
        this.phones = converterPhone(person);
    }

    public List<String> converterPhone(Person person) {
        List<Phone> phones = person.getPhones();
        return phones.stream().map(Phone::toString).collect(Collectors.toList());
    }

    public static List<PersonDto> converter(List<Person> peoples) {
        return peoples.stream().map(PersonDto::new).collect(Collectors.toList());
    }

}
