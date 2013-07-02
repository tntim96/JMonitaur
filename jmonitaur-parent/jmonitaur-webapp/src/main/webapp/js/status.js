function StatusListCtrl($scope, $http) {
    $http.get('service/statusJSON').success(function(data) {
        $scope.statuses = data;
    });
}