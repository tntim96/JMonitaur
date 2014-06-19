function StatusListCtrl($scope, $http) {
    $http.get('/statusJSON').success(function(data) {
        $scope.statuses = data;
    });
}