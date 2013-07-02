describe('Status controllers', function() {

    describe('StatusListCtrl', function(){
        var scope, ctrl, $httpBackend;

        // The injector ignores leading and trailing underscores here (i.e. _$httpBackend_).
        // This allows us to inject a service but then attach it to a variable
        // with the same name as the service.
        beforeEach(inject(function(_$httpBackend_, $rootScope, $controller) {
            $httpBackend = _$httpBackend_;
            $httpBackend.expectGET('service/statusJSON').
            respond([
                {level: 'Critical', systemId: "Shields", description: "Down"},
                {level: 'Warning', systemId: "Oxygen", description: "Running low"}]);

            scope = $rootScope.$new();
            ctrl = $controller(StatusListCtrl, {$scope: scope});
        }));

        it('should create "statuses" model with 2 statuses fetched from xhr', function() {
            expect(scope.statuses).toBeUndefined();
            $httpBackend.flush();

            expect(scope.statuses).toEqual([
                {level: 'Critical', systemId: "Shields", description: "Down"},
                {level: 'Warning', systemId: "Oxygen", description: "Running low"}
            ]);
        });
    });
});