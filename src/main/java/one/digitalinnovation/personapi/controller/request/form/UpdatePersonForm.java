package one.digitalinnovation.personapi.controller.request.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.entity.Phone;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePersonForm {
    @NotNull
    @NotEmpty
    @Size(min = 5)
    private String firstName;

    @NotNull
    @NotEmpty
    @Size(min = 5)
    private String lastName;

    @NotNull
    @NotEmpty
    private List<Phone> phones;

    public Person Update() {
        return new Person(firstName, lastName, phones);
    }

    public Person convert() {
        return new Person(firstName, lastName, phones);
    }
}
