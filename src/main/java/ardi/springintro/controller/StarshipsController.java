package ardi.springintro.controller;

import ardi.springintro.model.Species;
import ardi.springintro.model.Starship;
import ardi.springintro.service.SpeciesProvider;
import ardi.springintro.service.StarshipProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class StarshipsController {

  @Autowired
  private StarshipProvider starshipProvider;

  @GetMapping("/starships")
  public List<Starship> getStarships() {
    List<Starship> starships = starshipProvider.getStarships();

    return starships;
  }

  @GetMapping("/starships/{index}")
  public Starship getStarship(@PathVariable(name = "index") int urutan) {
    Starship starship = starshipProvider.getStarship(urutan);

    return starship;
  }

}
