angular.module('hello', []).controller('home', function($http) {
	var self = this;
	$http.get('test/all/').then(function(response) {
		self.greeting = response.data;
	})
});
