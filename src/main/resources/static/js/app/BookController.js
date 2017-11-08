'use strict';

angular.module('crudApp').controller('BookController',
    ['BookService', '$scope',  function( BookService, $scope) {

        var self = this;
        self.book = {};
        self.books=[];

        self.submit = submit;
        self.getAllBooks = getAllBooks;
        self.createBook = createBook;
        self.updateBook = updateBook;
        self.removeBook = removeBook;
        self.editBook = editBook;
        self.reset = reset;

        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;

        function submit() {
            console.log('Submitting '+self.book);
            if (self.book.id === undefined || self.book.id === null) {
                console.log('Salvataggio del nuovo libro', self.book);
                createBook(self.book);
            } else {
                updateBook(self.book);
                console.log('Libro modificato, ISBN: ', self.book.isbn);
            }
        }

        function createBook(book) {
            console.log('Inserisco un nuovo libro');
            BookService.createBook(book)
                .then(
                    function (response) {
                        console.log('Libro inserito correttamente');
                        self.successMessage = 'Libro inserito correttamente';
                        self.errorMessage='';
                        self.done = true;
                        self.book={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Errore nell\'inserimento del libro');
                        self.errorMessage = 'Errore nell\'inserimento del libro: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }


        function updateBook(book){
            console.log('Modifica libro '+book.isbn);
            BookService.updateBook(book)
                .then(
                    function (response){
                        console.log('Libro modificato con successo');
                        self.successMessage='Libro modificato con successo';
                        self.errorMessage='';
                        self.done = true;
                        $scope.myForm.$setPristine();
                    },
                    function(errResponse){
                        console.error('Errore in modifica del libro');
                        self.errorMessage='Errore in modifica del libro '+errResponse.data;
                        self.successMessage='';
                    }
                );
        }


        function removeBook(book){
            console.log('Cancellazione del libro con ISBN: '+book.isbn);
            BookService.removeBook(book)
                .then(
                    function(){
                        console.log('Il libro con ISBN: '+book.isbn + ', è stato correttamente rimosso');
                    },
                    function(errResponse){
                        console.error('Errore nella cancellazione del libro con ISBN: '+book.isbn +', Errore :'+errResponse.data);
                    }
                );
        }


        function getAllBooks(){
            return BookService.getAllBooks();
        }

        function editBook(book) {
            self.successMessage='';
            self.errorMessage='';
            BookService.getBook(book.isbn).then(
                function (book) {
                    self.book = book;
                },
                function (errResponse) {
                    console.error('Errore nella modifica del libro con ISBN: ' + book.isbn + ', Errore :' + errResponse.data);
                }
            );
        }
        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.book={};
            $scope.myForm.$setPristine(); //reset Form
        }
    }


    ]);