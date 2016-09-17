import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { PokemonService } from './pokemon.service'
import { Pokemon } from './pokemon';


@Component({
  selector: 'my-pokemon-detail',
  templateUrl: 'app/pokemon-detail.component.html'

})
export class PokemonDetailComponent implements OnInit, OnDestroy{

  pokemon: Pokemon;
  sub: any;

  constructor(
  	private pokemonService: PokemonService,
    private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      let id = +params['id'];
      this.pokemonService.getPokemon(id)
        .then(pokemon => this.pokemon = pokemon);
    });
  }
  
  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  goBack() {
    window.history.back();
  }

}