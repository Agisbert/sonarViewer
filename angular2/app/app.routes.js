"use strict";
var router_1 = require('@angular/router');
var pokemons_component_1 = require('./pokemons.component');
var dashboard_component_1 = require('./dashboard.component');
var pokemon_detail_component_1 = require('./pokemon-detail.component');
var routes = [
    {
        path: 'pokemons',
        component: pokemons_component_1.PokemonsComponent
    },
    {
        path: 'dashboard',
        component: dashboard_component_1.DashboardComponent
    },
    {
        path: '',
        redirectTo: '/dashboard',
        pathMatch: 'full'
    },
    {
        path: 'detail/:id',
        component: pokemon_detail_component_1.PokemonDetailComponent
    }
];
exports.appRouterProviders = [
    router_1.provideRouter(routes)
];
//# sourceMappingURL=app.routes.js.map