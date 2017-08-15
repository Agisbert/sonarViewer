'use strict';

// Declare app level module which depends on views, and components
angular.module('sonarViwerApp', [
  'ngRoute',
  'sonarViwerApp.projectsSummary',
  'sonarViwerApp.view2',
  'sonarViwerApp.version'
]).
config(['$locationProvider', '$routeProvider', function($locationProvider, $routeProvider) {
  $locationProvider.hashPrefix('!');

  $routeProvider.otherwise({redirectTo: '/projectsSummary'});
}]);
