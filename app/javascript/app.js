'use strict';

var memoryGameCITApp = angular.module('memoryGameCITApp', []);

memoryGameCITApp.factory('memoryGame', function() {
    var tileNames = ['bulbasaur', 'charmander', 'squirtle', 'pikachu', 'eevee', 'chikorita', 'cyndaquil', 'mudkip'];
    return new MemoryGame(tileNames)
});

memoryGameCITApp.controller('MemoryGameControl', function MemoryGameControl($scope, memoryGame){
    $scope.memoryGame = memoryGame;
});

memoryGameCITApp.directive('memoryGameCard', function() {
    return {
        restrict: 'E',
        template: '<div class="container">' +
                    '<div class="class" ng-class="flippedCard: tile.cardFlipped">' +
                      '<img class="front" ng-src="img/pokeball.png">'  +
                      '<img class="back" ng-src="img/{{tile.cardTitle}}.png">' +
                    '</div>' +
                   '</div>',
        scope: {
            tile: '='
        }
    }
});