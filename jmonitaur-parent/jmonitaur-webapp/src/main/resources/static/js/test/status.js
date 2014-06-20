function StatusListCtrl($scope, $http) {
    $scope.statuses = eval('[{"level":"CRITICAL","systemId":"Shields","description":"30% power"},{"level":"WARNING","systemId":"Fuel","description":"40% capacity"},{"level":"INFO","systemId":"Food","description":"80% capacity"},{"level":"SUCCESS","systemId":"Phasers","description":"90% power"}]');
}