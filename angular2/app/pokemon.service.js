"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require('@angular/core');
var mock_pokemons_1 = require('./mock-pokemons');
var PokemonService = (function () {
    function PokemonService() {
    }
    PokemonService.prototype.getPokemons = function () {
        return Promise.resolve(mock_pokemons_1.POKEMONS);
        ;
    };
    PokemonService.prototype.getPokemonsSlowly = function () {
        // return new Promise<Pokemon[]>(resolve =>
        //   setTimeout(() => resolve(POKEMONS), 20000) // 2 seconds
        // );
        return this.getPokemons();
    };
    PokemonService.prototype.getPokemon = function (id) {
        return this.getPokemons()
            .then(function (pokemons) { return pokemons.find(function (pokemon) { return pokemon.id === id; }); });
    };
    PokemonService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [])
    ], PokemonService);
    return PokemonService;
}());
exports.PokemonService = PokemonService;
//# sourceMappingURL=pokemon.service.js.map