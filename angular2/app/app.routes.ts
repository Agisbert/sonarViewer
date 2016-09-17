import { provideRouter, RouterConfig }  from '@angular/router';
import { PokemonsComponent } from './pokemons.component';
import { DashboardComponent } from './dashboard.component';
import { PokemonDetailComponent} from './pokemon-detail.component'

const routes: RouterConfig = [
    {
        path: 'pokemons',
        component: PokemonsComponent
    },
    {
        path: 'dashboard',
        component: DashboardComponent
    },
    {
        path: '',
        redirectTo: '/dashboard',
        pathMatch: 'full'
    },
    {
        path: 'detail/:id',
        component: PokemonDetailComponent
    }
];

export const appRouterProviders = [
  provideRouter(routes)
];
