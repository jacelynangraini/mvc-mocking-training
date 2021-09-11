package ardi.springintro.service.impl;

import ardi.springintro.model.Planet;
import ardi.springintro.model.Species;
import ardi.springintro.model.SwapiPlanet;
import ardi.springintro.model.SwapiSpecies;
import ardi.springintro.service.PlanetProvider;
import ardi.springintro.service.SpeciesProvider;
import ardi.springintro.service.SwapiClient;

import java.util.ArrayList;
import java.util.List;

public class StarwarsSpecies implements SpeciesProvider {
    SwapiClient swapiClient;

    public StarwarsSpecies(SwapiClient swapiClient) {
        this.swapiClient = swapiClient;
    }

    @Override
    public List<Species> getSpecies() {
        List<SwapiSpecies> swapiSpecies = swapiClient.getSpecies();

        List<Species> response = new ArrayList<>();

        for (SwapiSpecies swapiSpecies1: swapiSpecies) {
            Species species = new Species();
            species.setName(swapiSpecies1.getName());
            species.setClassification(swapiSpecies1.getClassification());
            species.setLanguage(swapiSpecies1.getLanguage());

            response.add(species);
        }

        return response;
    }

    @Override
    public Species getSingleSpecies(int index) {
        SwapiSpecies swapiSpecies = swapiClient.getSingleSpecies(index);

        Species response = new Species();
        response.setName(swapiSpecies.getName());
        response.setClassification(swapiSpecies.getClassification());
        response.setLanguage(swapiSpecies.getLanguage());

        return response;
    }
}
