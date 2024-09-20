package hieu.nv.jpa.person.service;

import hieu.nv.jpa.person.dto.PersonDto;
import hieu.nv.jpa.person.entity.Person;
import hieu.nv.jpa.person.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

	private final PersonRepository personRepository;

	@Override
	public Person getPerson(String id) {
		return personRepository.findById(id).orElse(null);
	}

	@Override
	public Iterable<Person> getAllPersons() {
		return personRepository.findAll();
	}

	@Override
	public Person createPerson(PersonDto personDto) {
		Person entity = new Person();
		entity.setUsername(personDto.getUsername());
		entity.setEmail(personDto.getEmail());
		entity.setPhoneNumber(personDto.getPhoneNumber());
		personRepository.save(entity);
		return entity;
	}
}
