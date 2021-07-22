package one.digitalinnovation.personapi.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "PERSON")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false, unique = true)
	private String cpf;

	private LocalDate birthDate;

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	private List<Phone> phones;

	public Person(String firstName, String lastName, String cpf, LocalDate birthDate, List<Phone> phones) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.cpf = cpf;
		this.birthDate = birthDate;
		this.phones = phones;
	}

	public Person(String firstName, String lastName, List<Phone> phones) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phones = phones;
	}
}
