package ardi.springintro.service.impl;

import ardi.springintro.model.*;
import ardi.springintro.service.SwapiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Component
public class SwapiClientImpl implements SwapiClient {

  @Autowired
  @Qualifier("swapiWebClient")
  private WebClient swapiWebClient;

  @Override
  public List<SwapiFilm> getFilms() {
    SwapiResponse<SwapiFilm> response = swapiWebClient.get()
        .uri("/films")
        .retrieve()
        .bodyToMono(new ParameterizedTypeReference<SwapiResponse<SwapiFilm>>() {})
        .block();

    return response.getResults();
  }

  @Override
  public SwapiFilm getFilm(int index) {
    SwapiFilmResponse swapiResponse = swapiWebClient.get()
            .uri("/films/" + index)
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<SwapiFilmResponse>() {})
            .block();

    SwapiFilm response = new SwapiFilm(swapiResponse.getTitle(), swapiResponse.getEpisode_id());
    return response;

  }

  @Override
  public List<SwapiPeople> getPeople() {
    SwapiResponse<SwapiPeople> response = swapiWebClient.get()
            .uri("/people")
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<SwapiResponse<SwapiPeople>>() {})
            .block();
    return response.getResults();
  }

  @Override
  public SwapiPeople getPerson(int index) {
    SwapiPeopleResponse swapiPeopleResponse = swapiWebClient.get()
            .uri("/people/" + index)
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<SwapiPeopleResponse>() {})
            .block();

    SwapiPeople response = new SwapiPeople(swapiPeopleResponse.getName(), swapiPeopleResponse.getGender());
    return response;
  }

  @Override
  public List<SwapiPlanet> getPlanets() {
    SwapiResponse<SwapiPlanet> response = swapiWebClient.get()
            .uri("/planets")
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<SwapiResponse<SwapiPlanet>>() {})
            .block();
    return response.getResults();
  }

  @Override
  public SwapiPlanet getPlanet(int index) {
    SwapiPlanetResponse swapiPlanetResponse = swapiWebClient.get()
            .uri("/planets/" + index)
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<SwapiPlanetResponse>() {})
            .block();

    SwapiPlanet response = new SwapiPlanet(swapiPlanetResponse.getName(), swapiPlanetResponse.getClimate(), swapiPlanetResponse.getTerrain());
    return response;
  }

  @Override
  public List<SwapiSpecies> getSpecies() {
    SwapiResponse<SwapiSpecies> response = swapiWebClient.get()
            .uri("/species")
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<SwapiResponse<SwapiSpecies>>() {})
            .block();
    return response.getResults();
  }

  @Override
  public SwapiSpecies getSingleSpecies(int index) {
    SwapiSpeciesResponse swapiSpeciesResponse = swapiWebClient.get()
            .uri("/species/" + index)
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<SwapiSpeciesResponse>() {})
            .block();

    SwapiSpecies response = new SwapiSpecies(swapiSpeciesResponse.getName(), swapiSpeciesResponse.getClassification(), swapiSpeciesResponse.getLanguage());
    return response;
  }

  @Override
  public List<SwapiStarship> getStarships() {
    SwapiResponse<SwapiStarship> response = swapiWebClient.get()
            .uri("/starships")
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<SwapiResponse<SwapiStarship>>() {})
            .block();
    return response.getResults();
  }

  @Override
  public SwapiStarship getStarship(int index) {
    SwapiStarshipResponse swapiStarshipResponse = swapiWebClient.get()
            .uri("/starships/" + index)
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<SwapiStarshipResponse>() {})
            .block();

    SwapiStarship response = new SwapiStarship(swapiStarshipResponse.getName(), swapiStarshipResponse.getManufacturer());
    return response;
  }

  @Override
  public List<SwapiVehicle> getVehicles() {
    SwapiResponse<SwapiVehicle> response = swapiWebClient.get()
            .uri("/vehicles")
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<SwapiResponse<SwapiVehicle>>() {})
            .block();
    return response.getResults();
  }

  @Override
  public SwapiVehicle getVehicle(int index) {
    SwapiVehicleResponse swapiVehicleResponse = swapiWebClient.get()
            .uri("/vehicles/" + index)
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<SwapiVehicleResponse>() {})
            .block();

    SwapiVehicle response = new SwapiVehicle(swapiVehicleResponse.getName(), swapiVehicleResponse.getManufacturer());
    return response;
  }
}
