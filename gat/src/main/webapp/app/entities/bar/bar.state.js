(function() {
    'use strict';

    angular
        .module('gatApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('bar', {
            parent: 'entity',
            url: '/bar',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'gatApp.bar.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/bar/bars.html',
                    controller: 'BarController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('bar');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('bar-detail', {
            parent: 'entity',
            url: '/bar/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'gatApp.bar.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/bar/bar-detail.html',
                    controller: 'BarDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('bar');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'Bar', function($stateParams, Bar) {
                    return Bar.get({id : $stateParams.id});
                }]
            }
        })
        .state('bar.new', {
            parent: 'bar',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/bar/bar-dialog.html',
                    controller: 'BarDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                name: null,
                                age: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('bar', null, { reload: true });
                }, function() {
                    $state.go('bar');
                });
            }]
        })
        .state('bar.edit', {
            parent: 'bar',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/bar/bar-dialog.html',
                    controller: 'BarDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['Bar', function(Bar) {
                            return Bar.get({id : $stateParams.id});
                        }]
                    }
                }).result.then(function() {
                    $state.go('bar', null, { reload: true });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('bar.delete', {
            parent: 'bar',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/bar/bar-delete-dialog.html',
                    controller: 'BarDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['Bar', function(Bar) {
                            return Bar.get({id : $stateParams.id});
                        }]
                    }
                }).result.then(function() {
                    $state.go('bar', null, { reload: true });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
