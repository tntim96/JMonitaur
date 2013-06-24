function StatusListCtrl($scope) {
  $scope.statuses = [
    {"level": "Critical",
    "name": "DB Connection"},
    {"level": "Warning",
    "name": "Memory Usage"},
    {"level": "INFO",
    "name": "Web-Services Connection"},
    {"level": "OK",
    "name": "Exception Count"}
    ];
}