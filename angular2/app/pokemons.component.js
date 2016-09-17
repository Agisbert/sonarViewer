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
var pokemon_service_1 = require('./pokemon.service');
var PokemonsComponent = (function () {
    function PokemonsComponent(router, pokemonService) {
        this.router = router;
        this.pokemonService = pokemonService;
        this.title = 'Tour of Pokemons';
    }
    PokemonsComponent.prototype.getPokemons = function () {
        var _this = this;
        this.pokemonService.getPokemonsSlowly().then(function (pokemons) { return _this.pokemons = pokemons; });
    };
    PokemonsComponent.prototype.ngOnInit = function () {
        this.getPokemons();
    };
    PokemonsComponent.prototype.onSelect = function (pokemon) { this.selectedPokemon = pokemon; };
    PokemonsComponent.prototype.gotoDetail = function () {
        this.router.navigate(['/detail', this.selectedHero.id]);
    };
    PokemonsComponent = __decorate([
        core_1.Component({
            selector: 'my-pokemons',
            templateUrl: 'app/pokemons.component.html',
            styleUrls: ['app/pokemons.component.css']
        }), 
        __metadata('design:paramtypes', [Object, pokemon_service_1.PokemonService])
    ], PokemonsComponent);
    return PokemonsComponent;
}());
exports.PokemonsComponent = PokemonsComponent;
//# sourceMappingURL=pokemons.component.js.map