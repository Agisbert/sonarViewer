import { Component } from '@angular/core';
import { OnInit } from '@angular/core';


import { Pokemon } from './pokemon';
import { PokemonDetailComponent } from './pokemon-detail.component';
import { PokemonService } from './pokemon.service'


@Component({
  selector: 'my-pokemons',
  templateUrl: 'app/pokemons.component.html',
  styleUrls:  ['app/pokemons.component.css']
})



export class PokemonsComponent implements OnInit{

  title = 'Tour of Pokemons';
  pokemons: Pokemon[];
  selectedPokemon: Pokemon;

  constructor(
    private router: Router,
    private pokemonService: PokemonService) { }

  getPokemons() {
   this.pokemonService.getPokemonsSlowly().then(pokemons => this.pokemons = pokemons);
  }
  

  ngOnInit() {
    this.getPokemons();
  }

  onSelect(pokemon: Pokemon) { this.selectedPokemon = pokemon; }

  gotoDetail() {
    this.router.navigate(['/detail', this.selectedHero.id]);
  }
}
