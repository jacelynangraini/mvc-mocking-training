package ardi.springintro.service.impl;

import ardi.springintro.model.Movie;
import ardi.springintro.model.Person;
import ardi.springintro.model.SwapiPeople;
import ardi.springintro.service.PeopleProvider;
import ardi.springintro.service.SwapiClient;

import java.util.ArrayList;
import java.util.List;

public class StarwarsPeople implements PeopleProvider {

    List<Movie> movies = new ArrayList<>();
    /*
    *  return daftar movie starwars
    *
    * */

    SwapiClient swapiClient;

    public StarwarsPeople(SwapiClient swapiClient) {
        this.swapiClient = swapiClient;
    }

    @Override
    public List<Person> getPeople(){
        List<SwapiPeople> swapiPeople = swapiClient.getPeople();

        List<Person> response = new ArrayList<>();

        for (SwapiPeople swapiPerson: swapiPeople) {
            Person person = new Person();
            person.setGender(swapiPerson.getGender());
            person.setName(swapiPerson.getName());

            response.add(person);
        }

        return response;
    }

    @Override
    public Person getPerson(int index) {
        SwapiPeople swapiPerson = swapiClient.getPerson(index);

        Person response = new Person();
        response.setGender(swapiPerson.getGender());
        response.setName(swapiPerson.getName());

        return response;
    }

}
