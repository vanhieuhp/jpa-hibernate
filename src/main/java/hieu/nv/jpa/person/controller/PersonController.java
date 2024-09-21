package hieu.nv.jpa.person.controller;

import hieu.nv.jpa.person.dto.PersonDto;
import hieu.nv.jpa.person.entity.Person;
import hieu.nv.jpa.person.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

	private final PersonService personService;

	@PostMapping
	public ResponseEntity<Person> createPerson(@RequestBody PersonDto personDto) {
		Person person = personService.createPerson(personDto);
		return ResponseEntity.ok(person);
	}

	@GetMapping
	public ResponseEntity<Iterable<Person>> getAllPersons() {
		Iterable<Person> persons = personService.getAllPersons();
		return ResponseEntity.ok(persons);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Person> getPerson(@PathVariable String id) {
		Person person = personService.getPerson(id);
		if (person != null) {
			return ResponseEntity.ok(person);
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Person> updatePerson(@PathVariable String id, @RequestBody PersonDto personDto) {
		Person person = personService.updatePerson(id, personDto);
		if (person != null) {
			return ResponseEntity.ok(person);
		}
		return ResponseEntity.notFound().build();
	}
}
