var libApp = angular.module("libApp", [])
 
libApp.controller("bookController", 
    function ($scope, $http)    {
        $scope.addBook = function() {
            var request = $http( {
                method  : "POST",
                url     : "/biblioteca/insertlibro",
                data    : {
                	"titolo"  : $scope.libro.titolo,
                	"autore"  : $scope.libro.autore,
                    "isbn"  : $scope.libro.isbn,
                    "anno"  : $scope.libro.anno,
                    "editore"  : $scope.libro.editore,
                    "genere": $scope.libro.genere,
                    "prezzo" : $scope.libro.prezzo,
                    "pagine" : $scope.libro.pagine,
                    "type" : $scope.libro.type,
                    "copertina" : $scope.libro.copertina
                }
            });
            request.then(
                function (response) {
                	 angular.element(document.querySelector("#divstatus").style.backgroundColor = "blue");
                    angular.element(document.querySelector("#divstatus")).css("visibility", "visible");
                    if (response.status == 200)   {
                        angular.element(document.querySelector("#divstatus")).addClass("alert-success");
                        $scope.statusmsg="Libro aggiunto con successo!";
                        $scope.libro = null; 
                    }
                    else    {
                        angular.element(document.querySelector("#divstatus")).addClass("alert-danger");
                        $scope.statusmsg="Errore: " + response.detail;
                    }
                });
             
            request.catch(
                function (response) {
                    angular.element(document.querySelector("#divstatus")).css("visibility", "visible");
                    angular.element(document.querySelector("#divstatus")).addClass("alert-danger");
                    $scope.statusmsg="eccezione:" + response.detail;
                });
                 
        }
     
    });