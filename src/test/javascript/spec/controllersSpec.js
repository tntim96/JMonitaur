describe('Status controllers', function () {
    var $httpBackend, $rootScope, createController, authRequestHandler;

    beforeEach(module('jmonStatus'));

    beforeEach(inject(function ($injector) {
        // Set up the mock http service responses
        $httpBackend = $injector.get('$httpBackend');
        // backend definition common for all tests
        authRequestHandler = $httpBackend.when('GET', '/statusJSON')
            .respond([{level: 'Critical', systemId: "Shields", description: "Down"},
                {level: 'Warning', systemId: "Oxygen", description: "Running low"}]
        );

        // Get hold of a scope (i.e. the root scope)
        $rootScope = $injector.get('$rootScope');
        // The $controller service is used to create instances of controllers
        var $controller = $injector.get('$controller');

        createController = function () {
            return $controller('StatusListCtrl', {'$scope': $rootScope});
        };
    }));


    afterEach(function () {
        $httpBackend.verifyNoOutstandingExpectation();
        $httpBackend.verifyNoOutstandingRequest();
    });


    it('should create "statuses" model with 2 statuses fetched from xhr', function () {
        $httpBackend.expectGET('/statusJSON');
        createController();
        $httpBackend.flush();

        expect($rootScope.statuses).toEqual([
            {level: 'Critical', systemId: "Shields", description: "Down"},
            {level: 'Warning', systemId: "Oxygen", description: "Running low"}
        ]);
    });
});