import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


import { Pokemon } from './pokemon';
import { PokemonService } from './pokemon.service';


@Component({
  selector: 'my-dashboard',
  templateUrl: 'app/dashboard.component.html',
})
export class DashboardComponent implements OnInit {
  pokemons: Pokemon[] = [];

  constructor( private router: Router,
                private pokemonService: PokemonService ) { }

  ngOnInit() {
    this.pokemonService.getPokemons()
      .then(pokemons => this.pokemons = pokemons.slice(0, 3));
  }

  gotoDetail(pokemon: Pokemon) {
    let link = ['/detail', pokemon.id];
    this.router.navigate(link);
}

}
