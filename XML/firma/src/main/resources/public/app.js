

// Declare app level module which depends on views, and components
var app = angular.module('myApp', [
    'ngRoute',
]).
    config(['$locationProvider', '$routeProvider', '$httpProvider', function ($locationProvider, $routeProvider, $httpProvider) {


        $locationProvider.hashPrefix('!');
        $routeProvider.when("/fakture", {
            template: "<fakture></fakture>",
        })
        $routeProvider.otherwise({ redirectTo: '/' });
    }]);



app.run(function ($http) {
    /* $http.interceptors.push(function ($q, dependency1, dependency2) {
         return {
             'request': function (config) {
                 console.log("req");
             },
 
             'response': function (response) {
                 console.log("resp");
             }
         };
     });*/
});






var appConfig = {
    apiUrl: "https://localhost:10011/api/",
    config: {
        headers: {
            "CsrfToken": localStorage.getItem("X-CSRF-TOKEN"),
            "AuthEmail": localStorage.getItem("basicAuthEmail"),
            "BankId": localStorage.getItem("bankId")
        }
    }
};