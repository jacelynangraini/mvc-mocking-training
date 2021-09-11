package ardi.springintro.service;

import ardi.springintro.model.Movie;
import ardi.springintro.model.Planet;
import ardi.springintro.model.SwapiPlanet;

import java.util.List;

public interface PlanetProvider {

    public List<Planet> getPlanets();
    public Planet getPlanet(int index);

}
