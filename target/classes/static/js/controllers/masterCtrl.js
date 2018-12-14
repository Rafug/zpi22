
angular.module('myApp.controllers',[]);


angular.module('myApp.controllers')
    .controller('masterCtrl',
        ['$rootScope','$scope', '$http', '$timeout', '$interval', '$q',
            function ($rootScope, $scope, $http, $timeout, $interval, $q ) {

                $scope.M = {};
                $scope.logins=false;
                $scope.pass=false;
                $scope.M.tsp = [];

                //noinspection JSAnnotator,JSAnnotator
                $http.get('http://localhost:8445/jd')
                    .then(function(response) {
                        $scope.myTest = response.data;
                    });

                $http.get($rootScope.M.URL + '/temp?id=1')
                    .then(function(response) {
                        $scope.myTest2 = response.data;
                    });

            }
        ]
    );
