var APP_NAME = "/modeleArchiAngularJs";

var app = angular.module('UserApp', []);

var compareTo = function() {
    return {
        require: "ngModel",
        scope: {
            otherModelValue: "=compareTo"
        },
        link: function(scope, element, attributes, ngModel) {

            ngModel.$validators.compareTo = function(modelValue) {
                return modelValue == scope.otherModelValue;
            };

            scope.$watch("otherModelValue", function() {
                ngModel.$validate();
            });
        }
    };
};

app.directive("compareTo", compareTo);


app.factory('RefFactory', function ($http, $q, $location) {
    var factory = {
        getCommunes: getCommunes,
        getRoles:getRoles,
    };
    return factory;

    function getCommunes() {
        var deferred = $q.defer();
        $http.get('http://'+$location.host()+':'+$location.port()+APP_NAME+"/ref/commune/list").then(
            function (response) {
                deferred.resolve(response.data)
            },
            function(errResponse){
                console.error('Erreur lors de la récupération des communes');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function getRoles() {
        var deferred = $q.defer();
        $http.get('http://'+$location.host()+':'+$location.port()+APP_NAME+"/ref/userProfile/list").then(
            function (response) {
                deferred.resolve(response.data)
            },
            function(errResponse){
                console.error('Erreur lors de la récupération des roles');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
})


app.factory('UserFactory',function ($http,$q,$location) {
    var factory = {
        getAllUser:getAllUser,
        deleteUser:deleteUser,
        createUser:createUser,
        updateUser:updateUser,
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

    function createUser(user) {
        var deferred = $q.defer();
        $http.post('http://'+$location.host()+':'+$location.port()+APP_NAME+"/user/create/", user)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Erreur lors de la création de l\'utilisateur');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }

    function updateUser(user) {
        var deferred = $q.defer();
        $http.post('http://'+$location.host()+':'+$location.port()+APP_NAME+"/user/update/", user)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function(errResponse){
                    console.error('Erreur lors de la mise à jour de l\'utilisateur');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }
});


app.controller('UserController', ['$scope', 'UserFactory', 'RefFactory', function ($scope, UserFactory,RefFactory) {

    var self = this;

    self.users=[];
    self.user={id:null,ssoId:'',firstName:'',lastName:'',email:'',birthDate:'',password:'',passwordConfirm:'',userProfiles:[],ville:null};
    self.communes=[];
    self.roles=[];

    self.submit = submit;
    self.getAllUsers = getAllUsers;
    self.deleteUser = deleteUser;
    self.createUser = createUser;
    self.updateUser = updateUser;

    $scope.init = getAllUsers();
    $scope.initCreateUpdate = initCreateUpdate();

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

    function createUser(user){
        UserFactory.createUser(user)
            .then(
                getAllUsers(),
                function(errResponse){
                    console.error('Erreur lors de la création de l\'utilisateur');
                }
            );
    }

    function updateUser(user){
        UserFactory.updateUser(user)
            .then(
                getAllUsers(),
                function(errResponse){
                    console.error('Erreur lors de la mise à jour de l\'utilisateur');
                }
            );
    }

    function initCreateUpdate() {
        RefFactory.getCommunes().then(
            function (d) {
                self.communes = d;
            },
            function(errResponse){
                console.error('Erreur lors de la récupération des communes');
            }
        );

        RefFactory.getRoles().then(
            function (d) {
                self.roles = d;
            },
            function(errResponse){
                console.error('Erreur lors de la récupération des roles');
            }
        );
    }


    function submit() {
        if(self.user.id===null){
            console.log('Saving New User', self.user);
            createUser(self.user);
        }else{
            updateUser(self.user);
            console.log('User updated with id ', self.user.id);
        }
    }
}]);
