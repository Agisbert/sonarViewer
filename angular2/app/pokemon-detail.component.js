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
var router_1 = require('@angular/router');
var pokemon_service_1 = require('./pokemon.service');
var PokemonDetailComponent = (function () {
    function PokemonDetailComponent(pokemonService, route) {
        this.pokemonService = pokemonService;
        this.route = route;
    }
    PokemonDetailComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.sub = this.route.params.subscribe(function (params) {
            var id = +params['id'];
            _this.pokemonService.getPokemon(id)
                .then(function (pokemon) { return _this.pokemon = pokemon; });
        });
    };
    PokemonDetailComponent.prototype.ngOnDestroy = function () {
        this.sub.unsubscribe();
    };
    PokemonDetailComponent.prototype.goBack = function () {
        window.history.back();
    };
    PokemonDetailComponent = __decorate([
        core_1.Component({
            selector: 'my-pokemon-detail',
            templateUrl: 'app/pokemon-detail.component.html'
        }), 
        __metadata('design:paramtypes', [pokemon_service_1.PokemonService, router_1.ActivatedRoute])
    ], PokemonDetailComponent);
    return PokemonDetailComponent;
}());
exports.PokemonDetailComponent = PokemonDetailComponent;
//# sourceMappingURL=pokemon-detail.component.js.map