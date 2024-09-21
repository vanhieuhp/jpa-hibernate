package hieu.nv.jpa.person.service;

import hieu.nv.jpa.person.dto.PersonDto;
import hieu.nv.jpa.person.entity.Person;
import hieu.nv.jpa.person.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Transactional
	@Override
	public Person createPerson(PersonDto personDto) {
		Person entity = new Person();
		entity.setUsername(personDto.getUsername());

		personRepository.save(entity);

		entity.setEmail(personDto.getEmail());
		entity.setPhoneNumber(personDto.getPhoneNumber());
		return entity;
	}

	@Transactional
	@Override
	public Person updatePerson(String id, PersonDto personDto) {
		Person entity = personRepository.findById(id).orElse(null);
		if (entity != null) {
			if (personDto.getUsername() != null) {
				entity.setUsername(personDto.getUsername());
			}
			if (personDto.getEmail() != null) {
				entity.setEmail(personDto.getEmail());
			}

			if (personDto.getPhoneNumber() != null) {
				entity.setPhoneNumber(personDto.getPhoneNumber());
			}
		}
		return entity;
	}
}
