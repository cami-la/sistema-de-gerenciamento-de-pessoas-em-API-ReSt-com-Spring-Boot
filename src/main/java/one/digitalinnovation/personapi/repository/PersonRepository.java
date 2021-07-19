package one.digitalinnovation.personapi.repository;

import one.digitalinnovation.personapi.controller.response.dto.PersonDto;
import one.digitalinnovation.personapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByCpf(String cpf);

    //Person findByCpf();
}
