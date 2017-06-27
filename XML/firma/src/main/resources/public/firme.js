app.component('firme', {
	templateUrl: 'firme.html',
	controller:['$scope', '$http','$location','$window', function FirmeController($scope,$http,$location,$window) {
		$http.get('/api/firma').
        then(function(response) {
            $scope.firme = response.data;
        });
		
		
	
		$scope.fakture = [];
		$scope.prikaziFakture = function(id){
			$scope.fakture = [];
			$http.get('/api/faktura/prikaz/'+id).then(function(response){ /// vidis nema greske, cek
				$scope.lista = response.data; // probaj sad
				var i;
				for(i=0; i<$scope.lista.length;i++){
					$scope.fakture.push($scope.lista[i]);
				}
				console.log(response.data);
				console.log(response.data.content);
				console.log('BIO SAM OVDE');
			},function(response){
				alert(response.statusText);
			});
			var i = 0;
	//		console.log($scope.fakture);
			var x = document.getElementById('skrivenaTabela');
		    if (x.style.display === 'none') {
		        x.style.display = 'block';
		    } 
		    
		}
		
		$scope.platiFakturu = function(id){
			console.log('USAO')
    		$scope.idd = id;
    		console.log($scope.idd);
    		$("#isplata").click();
		}
		
		$scope.isplata = function(){
    		console.log($scope.nalog);
    		console.log($scope.idd);
    		
    		$http({url:'/api/nalogzaprenos/'+$scope.idd,method:"POST",
    			data: JSON.stringify($scope.nalog),headers:{"Content-Type":"application/json"}})
    			
    		$scope.nalog = {}
    		$("#OtkaziIsplatu").click();
    		
    		
    	}
		
		$scope.zatvori = function(){
			var x = document.getElementById('skrivenaTabela');
		    x.style.display = 'none';
		      
		}
		
		$scope.firminID = '';
		$scope.otvoriFormu = function(id){
			$scope.firminID = id;
			
			var x = document.getElementById('skrivenaForma');
			if (x.style.display === 'none') {
		        x.style.display = 'block';
		    }
			
			$http.get('/api/firma').
	        then(function(response) {
	            $scope.kupci = $scope.firme;
	            var i=0;
	            console.log($scope.kupci);
	            for(i=0;i<$scope.kupci.length;i++){
	            	
	            	if($scope.kupci[i].brojRacuna==$scope.firminID)
	            	{	
	            		console.log('SPLICE');
	            		
	            		console.log($scope.kupci.id);
	            		$scope.kupci.splice(i, 1);
	            	}	
	            }
	        });
		
		}
		
		$scope.aktivirajStavku = function(){
    		
    		$("#stavke").click();
    	}
		
		$scope.listaStavki = [];
    	
    	$scope.DodajStavku = function(){
    		console.log($scope.stavka);
    		$scope.listaStavki.push($scope.stavka);
    		$scope.stavka = {};
    		$("#OtkaziStavku").click();
    		
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
    		
    		$http({url:'/api/faktura/'+$scope.firminID+"/"+$scope.kupac.id,method:"POST",
    			data: JSON.stringify($scope.faktura),headers:{"Content-Type":"application/json"}})
		}
		
		$scope.aktivirajStavku = function(){
    		
    		$("#stavke").click();
    		
    	}
		
		$scope.zatvori2 = function(){
			var x = document.getElementById('skrivenaForma');
		    x.style.display = 'none';
		    $http.get('/api/firma').
	        then(function(response) {
	            $scope.firme = response.data;
	        });
		}
		
		
	
		}]
});