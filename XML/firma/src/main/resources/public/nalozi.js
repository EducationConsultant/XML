app.component('nalozi', {
    templateUrl: 'nalozi.html',
    controller: ['$scope', '$http', function NalogZaPrenos($scope,$http) {
    	$http.get('api/nalozi').
        then(function(response) {
            $scope.nalozi = response.data;
            
        });
       
    }]
});