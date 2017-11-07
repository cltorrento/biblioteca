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
                console.log('Fetching all Books');
                var deferred = $q.defer();
                $http.get(urls.BOOK_SERVICE_API)
                    .then(
                        function (response) {
                            console.log('Fetched successfully all Books');
                            $localStorage.books = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading Books');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function getAllBooks(){
                return $localStorage.books;
            }

            function getBook(id) {
                console.log('Fetching Book with id :'+id);
                var deferred = $q.defer();
                $http.get(urls.BOOK_SERVICE_API + id)
                    .then(
                        function (response) {
                            console.log('Fetched successfully Book with id :'+id);
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while loading Book with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function createBook(Book) {
                console.log('Creating Book');
                var deferred = $q.defer();
                $http.post(urls.BOOK_SERVICE_API, Book)
                    .then(
                        function (response) {
                            loadAllBooks();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                           console.error('Error while creating Book : '+errResponse.data.errorMessage);
                           deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function updateBook(Book, id) {
                console.log('Updating Book with id '+id);
                var deferred = $q.defer();
                $http.put(urls.BOOK_SERVICE_API + id, Book)
                    .then(
                        function (response) {
                            loadAllBooks();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while updating Book with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function removeBook(id) {
                console.log('Removing Book with id '+id);
                var deferred = $q.defer();
                $http.delete(urls.BOOK_SERVICE_API + id)
                    .then(
                        function (response) {
                            loadAllBooks();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while removing Book with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

        }
    ]);