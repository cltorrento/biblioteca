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
            console.log('Submitting');
            if (self.Book.id === undefined || self.Book.id === null) {
                console.log('Saving New Book', self.Book);
                createBook(self.Book);
            } else {
                updateBook(self.Book, self.Book.id);
                console.log('Book updated with id ', self.Book.id);
            }
        }

        function createBook(Book) {
            console.log('About to create Book');
            BookService.createBook(Book)
                .then(
                    function (response) {
                        console.log('Book created successfully');
                        self.successMessage = 'Book created successfully';
                        self.errorMessage='';
                        self.done = true;
                        self.Book={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Error while creating Book');
                        self.errorMessage = 'Error while creating Book: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }


        function updateBook(Book, id){
            console.log('About to update Book');
            BookService.updateBook(Book, id)
                .then(
                    function (response){
                        console.log('Book updated successfully');
                        self.successMessage='Book updated successfully';
                        self.errorMessage='';
                        self.done = true;
                        $scope.myForm.$setPristine();
                    },
                    function(errResponse){
                        console.error('Error while updating Book');
                        self.errorMessage='Error while updating Book '+errResponse.data;
                        self.successMessage='';
                    }
                );
        }


        function removeBook(id){
            console.log('About to remove Book with id '+id);
            BookService.removeBook(id)
                .then(
                    function(){
                        console.log('Book '+id + ' removed successfully');
                    },
                    function(errResponse){
                        console.error('Error while removing Book '+id +', Error :'+errResponse.data);
                    }
                );
        }


        function getAllBooks(){
            return BookService.getAllBooks();
        }

        function editBook(id) {
            self.successMessage='';
            self.errorMessage='';
            BookService.getBook(id).then(
                function (Book) {
                    self.Book = Book;
                },
                function (errResponse) {
                    console.error('Error while removing Book ' + id + ', Error :' + errResponse.data);
                }
            );
        }
        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.Book={};
            $scope.myForm.$setPristine(); //reset Form
        }
    }


    ]);