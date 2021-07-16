package one.digitalinnovation.personapi.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
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

	private LocalDateTime birthDate;

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	private List<Phone> phones;

	public Person(String firstName, String lastName, String cpf, List<Phone> phones) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.cpf = cpf;
		this.phones = phones;
	}
}
