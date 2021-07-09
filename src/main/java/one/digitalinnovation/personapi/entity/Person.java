package one.digitalinnovation.personapi.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
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
