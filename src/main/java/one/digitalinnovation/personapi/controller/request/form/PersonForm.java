package one.digitalinnovation.personapi.controller.request.form;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.entity.Phone;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonForm {
	private final DateTimeFormatter fornmatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

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
	@CPF
	@Size(min = 8, max = 11)
	private String cpf;

	private String birthDate;
	
	/*@NotNull
	@NotEmpty
	private List<String> phones;*/

	@NotNull
	@NotEmpty
	private List<Phone> phones;


	public Person convert() {

		LocalDate birthDate = LocalDate.parse(this.birthDate, fornmatter);

		return new Person(firstName, lastName, cpf, birthDate, phones);
	}



}
