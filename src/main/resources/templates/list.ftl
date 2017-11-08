<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Nuovo libro</span></div>
		<div class="panel-body">
	        <div class="formcontainer">
	            <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
	            <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
	            <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
	                <input type="hidden" ng-model="ctrl.book.titolo" />
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="titolo">Titolo</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.book.titolo" id="titolo" class="form-control input-sm" placeholder="Inserisci il titolo."/>
	                        </div>
	                    </div>
	                </div>

	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="isbn">ISBN</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.book.isbn" id="isbn" class="form-control input-sm" placeholder="Inserisci il codice ISBN."/>
	                        </div>
	                    </div>
	                </div>
	
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="Autore">Autore</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.book.autore" id="autore" class="form-control input-sm" placeholder="Inserisci l'autore."/>
	                        </div>
	                    </div>
	                </div>
	                 <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="Anno">Anno</label>
	                        <div class="col-md-7">
	                            <input type="number" ng-model="ctrl.book.anno" id="anno" min="1452" max="2100" required class="form-control input-sm" placeholder="Inserisci l'anno di pubblicazione."/>
	                        </div>
	                    </div>
	                </div>
	                 <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="Editore">Editore</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.book.editore" id="editore" class="form-control input-sm" placeholder="Inserisci l'editore."/>
	                        </div>
	                    </div>
	                </div>
                    <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="Genere">Genere</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.book.genere" id="genere" class="form-control input-sm" placeholder="Inserisci il genere."/>
	                        </div>
	                    </div>
	                </div>
	                
	                 <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="Prezzo">Prezzo</label>
	                        <div class="col-md-7">
	                            <input type="number" ng-model="ctrl.book.prezzo" id="prezzo" required class="form-control input-sm" placeholder="Inserisci il prezzo."/>
	                        </div>
	                    </div>
	                </div>
	                 <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="Pagine">Pagine</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.book.pagine" id="pagine" class="form-control input-sm" placeholder="Inserisci il numero di pagine."/>
	                        </div>
	                    </div>
	                </div>
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="Tipo">Tipo</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.book.type" id="pagine" class="form-control input-sm" placeholder="Inserisci il tipo."/>
	                        </div>
	                    </div>
	                </div>
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="URL">URL</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.book.copertina" id="pagine" class="form-control input-sm" placeholder="Inserisci l'URL della copertina."/>
	                        </div>
	                    </div>
	                </div>
	                <div class="row">
	                    <div class="form-actions floatRight">
	                        <input type="submit"  value="{{!ctrl.book.copertina ? 'Aggiungi' : 'Modifica'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
	                        <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
	                    </div>
	                </div>
	            </form>
    	    </div>
		</div>	
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Lista dei libri </span></div>
		<div class="panel-body">
			<div class="table-responsive">
		        <table class="table table-hover">
		            <thead>
		            <tr>
		                <th>TITOLO</th>
		                <th>AUTORE</th>
		                <th>ISBN</th>
		                <th>ANNO</th>
		                <th>EDITORE</th>
		                <th>GENERE</th>
		                <th>PREZZO</th>
		                <th>PAGINE</th>
		                <th>TIPO</th>
		                <th>URL</th>
		                <th width="100"></th>
		                <th width="100"></th>
		                <th width="100"></th>
		                <th width="100"></th>
		                <th width="100"></th>
		                <th width="100"></th>
		                <th width="100"></th>
		                <th width="100"></th>
		                <th width="100"></th>
		                <th width="100"></th>
		            </tr>
		            </thead>
		            <tbody>
		            <tr ng-repeat="b in ctrl.getAllBooks()">
		                <td>{{b.titolo}}</td>
		                <td>{{b.autore}}</td>
		                <td>{{b.isbn}}</td>
		                <td>{{b.anno}}</td>
		                <td>{{b.editore}}</td>
		                <td>{{b.genere}}</td>
		                <td>{{b.brezzo}}</td>
		                <td>{{b.pagine}}</td>
		                <td>{{b.type}}</td>
		                <td><a href=" {{ b.copertina }}"><img src=" {{ b.copertina }}" width="70%"/></a></td>
		                <td><button type="button" ng-click="ctrl.editBook(b)" class="btn btn-success custom-width">Modifica</button></td>
		                <td><button type="button" ng-click="ctrl.removeBook(b)" class="btn btn-danger custom-width">Rimuovi</button></td>
		            </tr>
		            </tbody>
		        </table>		
			</div>
		</div>
    </div>
</div>