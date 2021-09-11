package ardi.springintro.service.impl;

import ardi.springintro.model.Person;
import ardi.springintro.model.Planet;
import ardi.springintro.model.SwapiPlanet;
import ardi.springintro.model.SwapiPlanet;
import ardi.springintro.service.PlanetProvider;
import ardi.springintro.service.SwapiClient;

import java.util.ArrayList;
import java.util.List;

public class StarwarsPlanet implements PlanetProvider {
    SwapiClient swapiClient;

    public StarwarsPlanet(SwapiClient swapiClient) {
        this.swapiClient = swapiClient;
    }

    @Override
    public List<Planet> getPlanets() {
        List<SwapiPlanet> swapiPlanets = swapiClient.getPlanets();

        List<Planet> response = new ArrayList<>();

        for (SwapiPlanet swapiPlanet: swapiPlanets) {
            Planet planet = new Planet();
            planet.setName(swapiPlanet.getName());
            planet.setClimate(swapiPlanet.getClimate());
            planet.setTerrain(swapiPlanet.getTerrain());

            response.add(planet);
        }

        return response;
    }

    @Override
    public Planet getPlanet(int index) {
        SwapiPlanet swapiPlanet = swapiClient.getPlanet(index);

        Planet response = new Planet();
        response.setName(swapiPlanet.getName());
        response.setClimate(swapiPlanet.getClimate());
        response.setTerrain(swapiPlanet.getTerrain());

        return response;
    }
}
