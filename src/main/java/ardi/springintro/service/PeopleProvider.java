package ardi.springintro.service;

import ardi.springintro.model.Person;

import java.util.List;

public interface PeopleProvider {

    public List<Person> getPeople();

    public Person getPerson(int index);


}
