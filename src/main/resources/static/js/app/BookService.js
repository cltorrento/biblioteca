'use strict';

angular.module('crudApp').factory('BookService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

            var factory = {
                loadAllBooks: loadAllBooks,
                getAllBooks: getAllBooks,
                getBook: getBook,
                createBook: createBook,
                updateBook: updateBook,
                removeBook: removeBook
            };

            return factory;

            function loadAllBooks() {
                console.log('Carico tutti i libri');
                var deferred = $q.defer();
                $http.get(urls.BOOK_SERVICE_API)
                    .then(
                        function (response) {
                            console.log('Lista libri caricata con successo');
                            $localStorage.books = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Errore nel caricamento della lista dei libri');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function getAllBooks(){
                return $localStorage.books;
            }

            function getBook(isbn) {
                console.log('Cerco il libro con ISBN: '+isbn);
                var deferred = $q.defer();
                $http.get(urls.READ_BOOK + isbn)
                    .then(
                        function (response) {
                            console.log('Il libro con ISBN: '+isbn+' è stato trovato');
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Errore nella ricerca del libro con ISBN: '+isbn);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function createBook(Book) {
                console.log('Creazione nuovo libro ')+Book;
                var deferred = $q.defer();
                $http({
                    url: urls.CREATE_BOOK,
                    dataType: 'json',
                    method: 'POST',
                    data: Book,
                    headers: {
                        "Content-Type": "application/json"
                    }
                })
                    .then(
                        function (response) {
                            loadAllBooks();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                           console.error('Errore nella creazione del nuovo libro : '+errResponse.data.errorMessage);
                           deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function updateBook(Book) {
                console.log('Modifica del libro con ISBN: '+Book.isbn);
                var deferred = $q.defer();
                $http({
                    url: urls.UPDATE_BOOK,
                    dataType: 'json',
                    method: 'PUT',
                    data: Book,
                    headers: {
                        "Content-Type": "application/json"
                    }
                })
                    .then(
                        function (response) {
                            loadAllBooks();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Errore in modifica del libro con ISBN: '+Book.isbn);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function removeBook(Book) {
                console.log('Cancellazione del libro con ISBN: '+Book.isbn);
                var deferred = $q.defer();
                $http({
                    url: urls.DELETE_BOOK,
                    dataType: 'json',
                    method: 'DELETE',
                    data: Book,
                    headers: {
                        "Content-Type": "application/json"
                    }
                })
                    .then(
                        function (response) {
                            loadAllBooks();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Errore nella cancellazione del libro con ISBN :'+Book.isbn);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

        }
    ]);