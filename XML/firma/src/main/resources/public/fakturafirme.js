app.component('fakturafirme', {
	templateUrl: 'fakturefirme.html',
	controller:['$scope', '$http','$stateParams','$location', function FirmeController($scope,$http,$stateParams,$location) {
		
		$http.get('/api/faktura/prikaz/idFirme/'+).
        then(function(response) {
        	console.log('Naidje li odje')
            $scope.fakture = response.data;
        });
		
		
		
	
		}]
});