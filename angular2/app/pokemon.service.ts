import { Injectable } from '@angular/core';

import { POKEMONS } from './mock-pokemons';
import { Pokemon } from './Pokemon';


@Injectable()
export class PokemonService {
  getPokemons() {
      return Promise.resolve(POKEMONS);;
  }

  getPokemonsSlowly() {
 // return new Promise<Pokemon[]>(resolve =>
 //   setTimeout(() => resolve(POKEMONS), 20000) // 2 seconds
 // );
 return this.getPokemons();
  }

  getPokemon(id: number) {
  return this.getPokemons()
             .then(pokemons => pokemons.find(pokemon => pokemon.id === id));
  }

}
