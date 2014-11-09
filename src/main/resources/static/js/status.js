(function() {
    angular.module('jmonStatus', []).controller('StatusListCtrl', function($scope, $http) {
        $http.get('/statusJSON').success(function(data) {
            $scope.statuses = data;
        });
    });
}());