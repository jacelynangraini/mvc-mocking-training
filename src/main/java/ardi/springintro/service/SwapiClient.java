package ardi.springintro.service;

import ardi.springintro.model.*;

import java.util.List;

public interface SwapiClient {
  // films
  List<SwapiFilm> getFilms();
  SwapiFilm getFilm(int index);

  // people
  List<SwapiPeople> getPeople();
  SwapiPeople getPerson(int index);

  // planets
  List<SwapiPlanet> getPlanets();
  SwapiPlanet getPlanet(int index);

  // species
  List<SwapiSpecies> getSpecies();
  SwapiSpecies getSingleSpecies(int index);

  // starships
  List<SwapiStarship> getStarships();
  SwapiStarship getStarship(int index);

  // vehicles
  List<SwapiVehicle> getVehicles();
  SwapiVehicle getVehicle(int index);
}
