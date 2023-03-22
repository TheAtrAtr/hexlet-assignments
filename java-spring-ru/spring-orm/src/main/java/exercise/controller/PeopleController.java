package exercise.controller;

import exercise.model.Person;
import exercise.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;

@RestController
@RequestMapping("/people")
public class PeopleController {

    // Автоматически заполняем значение поля
    @Autowired
    private PersonRepository personRepository;

    @GetMapping(path = "/{id}")
    public Person getPerson(@PathVariable long id) {
        return this.personRepository.findById(id);
    }

    @GetMapping(path = "")
    public Iterable<Person> getPeople() {
        return this.personRepository.findAll();
    }

    // BEGIN
    @PostMapping(path = "")
    public void AddPerson(@RequestBody Person person) {
        personRepository.save(person);
    }

    @DeleteMapping(path = "/{id}")
    public void DeletePerson(@PathVariable("id") long id) {
        personRepository.deleteById(id);
    }

    @PatchMapping(path = "/{id}")
    public void PatchPerson(@PathVariable("id") long id, @RequestBody Person person) {
        Person person_base = personRepository.findById(id);
        person_base.setFirstName(person.getFirstName());
        person_base.setLastName(person.getLastName());
        personRepository.save(person_base);
    }
    // END
}
