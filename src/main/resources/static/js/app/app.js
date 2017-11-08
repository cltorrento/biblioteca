var app = angular.module('crudApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:9000/biblioteca',
    BOOK_SERVICE_API : 'http://localhost:9000/biblioteca/libri/',
    CREATE_BOOK : 'http://localhost:9000/biblioteca/insertlibro/',
    READ_BOOK   : 'http://localhost:9000/biblioteca/getlibro/?isbn=',
    UPDATE_BOOK : 'http://localhost:9000/biblioteca/updatelibro/',
    DELETE_BOOK : 'http://localhost:9000/biblioteca/deletelibro/'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'partials/list',
                controller:'BookController',
                controllerAs:'ctrl',
                resolve: {
                    users: function ($q, BookService) {
                        console.log('Carico tutti i libri');
                        var deferred = $q.defer();
                        BookService
                        .loadAllBooks()
                        .then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
        $urlRouterProvider.otherwise('/');
    }]);

