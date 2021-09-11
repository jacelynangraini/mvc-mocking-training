package ardi.springintro.controller;

import ardi.springintro.model.Person;
import ardi.springintro.service.PeopleProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class PeopleController {

  @Autowired
  private PeopleProvider starwarsPeople;

  @GetMapping("/people")
  public List<Person> getPeople() {
    List<Person> people = starwarsPeople.getPeople();

    return people;
  }

  @GetMapping("/people/{index}")
  public Person getMovie(@PathVariable(name = "index") int urutan) {
    Person person = starwarsPeople.getPerson(urutan);

    return person;
  }

}
