app.component('fakture', {
    templateUrl: 'fakture.html',
    controller: ['$scope', '$http', function FaktureController($scope,$http) {
    	
    	
		
			
    	
    	
    	$http.get('api/firma').then(function(response){
    		$scope.firme = response.data;
    		
    		
    	})
    	
    	$http({url:'/api/faktura/'+$scope.dobavljac.id+"/"+$scope.kupac.id,method:"POST",
    			data: JSON.stringify($scope.faktura),headers:{"Content-Type":"application/json"}})
    	
    	$scope.idd= '';
    	$scope.platiFakturu = function(id){
    		console.log('USAO')
    		$scope.idd = id;
    		console.log($scope.idd);
    		$("#isplata").click();
    		
    	}
    	$scope.faktura = {}
    	$scope.KreirajFakturu = function(){
    		console.log($scope.fa.datumRacuna);
    		$scope.faktura.datumRacuna = $scope.fa.datumRacuna;
    		$scope.faktura.datumValute = $scope.fa.datumValute;
    		$scope.faktura.oznakaValute = $scope.fa.oznakaValute;
    		//$scope.fakture.nazivDobavljaca = $scope.dobavljac.naziv;
    		//$scope.fakture.nazivKupca = $scope.kupac.naziv;
    		$scope.faktura.stavka = $scope.listaStavki;
    		
    		$http({url:'/api/faktura/'+$scope.dobavljac.id+"/"+$scope.kupac.id,method:"POST",
    			data: JSON.stringify($scope.faktura),headers:{"Content-Type":"application/json"}})
    		
    	}
    	
    	$scope.aktivirajStavku = function(){
    		
    		$("#stavke").click();
    	}
    	
    	$scope.listaStavki = [];
    	
    	$scope.DodajStavku = function(){
    		console.log($scope.stavka);
    		$scope.listaStavki.push($scope.stavka);
    	}
    	
    	$scope.isplata = function(){
    		console.log($scope.nalog);
    		console.log($scope.idd);
    		
    		$http({url:'/api/nalogzaprenos/'+$scope.idd,method:"POST",
    			data: JSON.stringify($scope.nalog),headers:{"Content-Type":"application/json"}})
    		
    	}
       
    }]
});