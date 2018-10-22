'use strict'

angular.module('memoryGame.services', []).factory('PlayerService',
		[ "$http", "CONSTANTS", function($http, CONSTANTS) {
			var service = {};
			service.getPlayerById = function(playerId) {
				var url = CONSTANTS.getPlayerByIdUrl + playerId;
				return $http.get(url);
			}
			service.getAllPlayers = function() {
				return $http.get(CONSTANTS.getAllPlayers);
			}
			service.savePlayer = function(playerDto) {
				return $http.post(CONSTANTS.savePlayer, playerDto);
			}
			return service;
		}
]);