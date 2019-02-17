
angular.module('myApp.controllers',[]);


angular.module('myApp.controllers')
    .controller('masterCtrl',
        ['$rootScope','$scope', '$http', '$timeout', '$interval', '$q',
            function ($rootScope, $scope, $http, $timeout, $interval, $q ) {


                $scope.M = {};
                $scope.logins=false;
                $scope.pass=false;
                $scope.M.tsp = [];
                $scope.enginestatus = {};
                const URL ="http://localhost:8445"


                //noinspection JSAnnotator,JSAnnotator
                $scope.xx = function(){
                    $http.get('http://localhost:8445/test')
                        .then(function(response) {
                            console.log('XXXXX' + response.resp);
                            $scope.myTest = response.data;
                        });




                };



                let callEngine = function (arg) {
                    $http({
                        url: URL +'/'+ arg,
                        method: 'GET',
                        params: {

                        }
                    }).success(function (dane) {
                        $scope.enginestatus = dane;
                    });
                };

                $scope.startEngine = function() {
                    const nr = document.getElementById("ip2");
                    console.log("zapisuję logi: " + nr.value);
                    if(nr.value<2000){}
                    $http({
                        url: $rootScope.M.URL + '/freqs?freq=' + nr.value,
                        method: 'GET',
                    })




                    ;
                    callEngine("start");
                };



                $scope.stopEngine = function(){

                    callEngine("stop");
                };


                $scope.loadEngineState =function () {
                    callEngine("status");
                };

                $scope.reverseEngine = function () {
                    callEngine("reverse");
                };

                $scope.loadEngineState();





                $scope.jd = function () {
                    $http.get($rootScope.M.URL + '/temp?id=1')
                        .then(function(response) {
                            $scope.myTest2 = response.data;
                        });
                };



                this.postForm = function() {
                    var encodedString = 'username=' +
                        encodeURIComponent(this.inputData.username) +
                        '&password=' +
                        encodeURIComponent(this.inputData.password);

                    $http({
                        method: 'POST',
                        url: 'userauth.php',
                        data: encodedString,
                        headers: {'Content-Type': 'application/x-www-form-urlencoded'}
                    })

                        .success(function(data) {
                            console.log(data);
                            if ( data.trim() === 'correct') {
                                window.open("http://localhost:8445/test.html");
                            } else {
                                alert("Proszę wprowadzić poprawny login i hasło");
                            }
                        })
                }







            }
        ]
    )

.controller('loginCtrl'[ function($scope, $http, $location, user) {

}]);
