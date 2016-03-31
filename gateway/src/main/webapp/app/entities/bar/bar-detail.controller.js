(function() {
    'use strict';

    angular
        .module('gatApp')
        .controller('BarDetailController', BarDetailController);

    BarDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'entity', 'Bar'];

    function BarDetailController($scope, $rootScope, $stateParams, entity, Bar) {
        var vm = this;
        vm.bar = entity;
        vm.load = function (id) {
            Bar.get({id: id}, function(result) {
                vm.bar = result;
            });
        };
        var unsubscribe = $rootScope.$on('gatApp:barUpdate', function(event, result) {
            vm.bar = result;
        });
        $scope.$on('$destroy', unsubscribe);

    }
})();
