package one.digitalinnovation.personapi.controller.form;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.entity.Phone;
import one.digitalinnovation.personapi.enums.PhoneType;

@Getter
@Setter
public class PersonForm {
	
	@NotNull
	@NotEmpty
	@Size(min = 5)
	private String firstName;
	
	@NotNull
	@NotEmpty
	@Size(min = 10)
	private String lastName;
	
	@NotNull
	@NotEmpty
	@Size(min = 8, max = 11)
	private String cpf;
	
	@NotNull
	@NotEmpty
	private List<String> phones;

	public Person convert() {
		List<Phone> phones = this.phones.stream().map(phone -> {
			//FIXME Aqui é preciso refinar essa conversão (ou ajustar o modelo do Form), para que seja possível identificar o tipo de telefone.
			Phone entidade = new Phone();
			entidade.setType(PhoneType.HOME);
			entidade.setNumber(phone);
			return entidade;
		}).collect(Collectors.toList());
		return new Person(firstName, lastName, cpf, phones);
	}

}
