var APP_NAME = "/modeleArchiAngularJs";

var app = angular.module('UserApp', []);



app.factory('UserFactory',function ($http,$q,$location) {
    var factory = {
        getAllUser: getAllUser,
        deleteUser:deleteUser,
    };
    return factory;
    
    
    function getAllUser() {
        var deferred = $q.defer();
        $http.get('http://'+$location.host()+':'+$location.port()+APP_NAME+"/user/list").then(
            function (response) {
                deferred.resolve(response.data)
            },
            function(errResponse){
                console.error('Erreur lors de la récupération des utilisateurs');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function deleteUser(id) {
        $http.delete('http://'+$location.host()+':'+$location.port()+APP_NAME+"/user/delete/"+id).then(
            function (response) {
                deferred.resolve(response.data)
            },
            function(errResponse){
                console.error('Erreur lors de la supression de l\'utilisateur');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
});


app.controller('UserController', ['$scope', 'UserFactory', function ($scope, UserFactory) {

    $scope.init = getAllUsers();

    var self = this;

    self.users=[];

    self.getAllUsers = getAllUsers;
    self.deleteUser = deleteUser;

    function getAllUsers() {
       UserFactory.getAllUser().then(
           function (d) {
               self.users = d;
           },
           function(errResponse){
               console.error('Erreur lors de la récupération des utilisateurs');
           }
       );
    }

    function deleteUser(id) {
        UserFactory.deleteUser(id).then(
                getAllUsers(),
            function(errResponse){
                console.error('Erreur lors de la supression de l\'utilisateur');
            }
        )
    }
}]);
