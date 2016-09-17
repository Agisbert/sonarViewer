import { Component }       from '@angular/core';
import { PokemonService }     from './pokemon.service';
import { PokemonsComponent } from './pokemons.component';
import { ROUTER_DIRECTIVES } from '@angular/router';

@Component({
  selector: 'my-app',
template: `
  <h1>{{title}}</h1>
  <nav>
    <a [routerLink]="['/dashboard']" routerLinkActive="active">Dashboard</a>
    <a [routerLink]="['/pokemons']" routerLinkActive="active">Pokemons</a>
  </nav>
  <router-outlet></router-outlet>
`,
  directives: [ROUTER_DIRECTIVES],
  providers: [
    PokemonService
  ]
})

export class AppComponent {
  title = 'Tour of Pokemons';
}