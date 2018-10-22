'use strict';

var module = angular.module('PlayerService.controllers', []);

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
		}
]);