'use strict';

MemoryGame.MESSAGE_CHOOSE = "Choose a card.";
MemoryGame.MESSAGE_VICTORY = "K.O. You Win!";

var module = angular.module('memoryGame.controllers', []);
module.controller("PlayerController", [ "$scope", "PlayerService",
		function($scope, PlayerService) {

			$scope.playerDto = {
				playerId : null,
				playerName : null,
				playerPoints : null,
				playerPlays: null
			};

			PlayerService.getPlayerById(1).then(function(value) {
				console.log(value.data);
			}, function(reason) {
				console.log("Player not found!");
			}, function(value) {
				console.log("No callback implemented!");
			});

			$scope.savePlayer = function() {
				UserService.playerUser($scope.playerDto).then(function() {
					UserService.getAllUsers().then(function(value) {
						$scope.allUsers= value.data;
					}, function(reason) {
						console.log("No players found!");
					}, function(value) {
						console.log("No callback implemented!");
					});

					$scope.playerDto = {
						playerId : null,
						playerName : null,
				        playerPoints : null,
				        playerPlays: null
					};
				}, function(reason) {
					console.log("Player not saved!");
				}, function(value) {
					console.log("No callback implemented!");
				});
			}
		} ]);

function Tile(cardTitle) {
    this.cardTitle = cardTitle;
    this.cardFlipped = false;
}

Tile.prototype.cardFlip = function() {
    this.cardFlipped = !this.cardFlipped;
}

function makeDeckCards(tileNames) {
    var tileDeck = [];

    tileNames.forEach(function(name) {
        tileDeck.push(new Tile(name));
        tileDeck.push(new Tile(name));
    });

    return tileDeck;
}

function removeRandomTile(tileDeck) {
    var i = Math.floor(Math.random() * tileDeck.length);

    return tileDeck.splice(i, 1)[0];
}

function makeMatrixCards(tileDeck) {
    var matrixDimension = Math.sqrt(tileDeck.length), matrix = [];

    for(var row = 0; row < matrixDimension; row++) {
        matrix[row] = [];

        for(var col = 0; col < matrixDimension; col++) {
            matrix[row][col] = removeRandomTile(tileDeck);
        }
    }

    return matrix;
}

function MemoryGame(tileNames) {
    var tileDeck = makeDeckCards(tileNames);

    this.points = 0;
    this.plays = 0;
    this.matrix = makeMatrixCards(tileDeck);
    this.message = MemoryGame.MESSAGE_CHOOSE;
    this.unmatchedPairs = tileNames.length;

    this.cardFlip = function(tile) {
        if(tile.cardFlipped) {
            return;
        }

        tile.cardFlip();
        this.plays++;

        if(!this.firstPick || this.secondPick) {

            this.points--;

            if(this.secondPick) {
                this.firstPick.cardFlip();
                this.secondPick.cardFlip();
                this.firstPick = this.secondPick = undefined;
            }

            this.firstPick = tile;

        } else {

            if(this.firstPick.cardTitle === tile.cardTitle) {
                this.unmatchedPairs--;
                this.message = (this.unmatchedPairs > 0) ? MemoryGame.MESSAGE_CHOOSE : MemoryGame.MESSAGE_VICTORY;
                this.firstPick = this.secondPick = undefined;
                this.points += 5;

            } else {
                this.secondPick = tile;
            }
        }
    }
}