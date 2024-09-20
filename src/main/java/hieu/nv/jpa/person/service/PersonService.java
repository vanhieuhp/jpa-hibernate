package hieu.nv.jpa.person.service;

import hieu.nv.jpa.person.dto.PersonDto;
import hieu.nv.jpa.person.entity.Person;

public interface PersonService {
	Person getPerson(String id);

	Iterable<Person> getAllPersons();

	Person createPerson(PersonDto personDto);
}
