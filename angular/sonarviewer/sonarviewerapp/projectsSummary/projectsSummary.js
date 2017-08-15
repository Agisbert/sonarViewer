'use strict';

angular.module('sonarViwerApp.projectsSummary', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/projectsSummary', {
    templateUrl: 'projectsSummary/projectsSummary.html',
    controller: 'projectsSummary'
  });
}])

.controller('projectsSummary', [function() {

}]);