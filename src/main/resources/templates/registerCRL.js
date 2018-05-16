/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global angular */

angular.module('userRegistrationApp',['ngMessages','ui.router'])
    .controller('UserRegistrationCtrl',['$scope','$http','$timeout',function userRegistration($scope, $http, $timeout){
        $scope.saveData = function() {
            $http.post('http://localhost:8080/customer', this.newTodo)
                .then(function() {
                    $scope.newTodo = {};
                    $scope.successTextAlert = "Some content";
                    $scope.showSuccessAlert = true;
                    $timeout(function ()
                    {
                        $scope.$apply(function()
                        {
                            $scope.showSuccessAlert = false;
                        });
                    }, 2000);
                });
            $scope.userForm.$setPristine();
            $scope.userForm.$setUntouched();
            $scope.userForm.$submitted = false;

        };
        // switch flag
        $scope.switchBool = function (value) {
            $scope[value] = !$scope[value];
        };

    }]);
var app = angular.module('userRegistrationApp', []);

app.controller('registerCRL' , ['$scope' , '$http', '$timeout'], function($scope , $http) {
    $http.post
  $scope.newTodo = {}
  $scope.saveData = function($event){
    console.log($scope.formData)
    alert(JSON.stringify($scope.formData))
    $event.preventDefault()
  }
});
