package one.digitalinnovation.personapi.controller.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.entity.Phone;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class PersonForm {
    @NotNull @NotEmpty @Length(min=5)
    private String firstName;
    @NotNull @NotEmpty @Length(min=10)
    private String lastName;
    @NotNull @NotEmpty @Length(min=8) @Length(max=8)
    private String cpf;
    @NotNull @NotEmpty
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY) private List<String> phones;

    public Person convert() {
        List<Phone> phones = this.phones.stream().map(phone -> new Phone()).collect(Collectors.toList());
        return new Person(firstName, lastName, cpf, phones);
    }

}
