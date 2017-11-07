<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Libro</span></div>
		<div class="panel-body">
	        <div class="formcontainer">
	            <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
	            <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
	            <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
	                <input type="hidden" ng-model="ctrl.libro.titolo" />
	                <!-- "titolo":null,"autore":null,"isbn":null,"anno":null,"editore":null,"genere":null,"prezzo":0.0,"pagine":0 -->
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="titolo">Titolo</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.libro.titolo" id="titolo" class="username form-control input-sm" placeholder="Enter your name"/>
	                        </div>
	                    </div>
	                </div>

	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="isbn">ISBN</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.libro.isbn" id="isbn" class="form-control input-sm" placeholder="Enter your Age."/>
	                        </div>
	                    </div>
	                </div>
	
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="Autore">Autore</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.libro.autore" id="autore" class="form-control input-sm" placeholder="Enter your Salary."/>
	                        </div>
	                    </div>
	                </div>
	                 <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="Anno">Anno</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.libro.anno" id="anno" class="form-control input-sm" placeholder="Enter your Salary."/>
	                        </div>
	                    </div>
	                </div>
	                 <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="Editore">Editore</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.libro.editore" id="editore" class="form-control input-sm" placeholder="Enter your Salary."/>
	                        </div>
	                    </div>
	                </div>
 <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="Genere">Genere</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.libro.genere" id="genere" class="form-control input-sm" placeholder="Enter your Salary."/>
	                        </div>
	                    </div>
	                </div>
	                
	                 <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="Prezzo">Prezzo</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.libro.prezzo" id="prezzo" class="form-control input-sm" placeholder="Enter your Salary."/>
	                        </div>
	                    </div>
	                </div>
	                 <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="Pagine">Pagine</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.libro.pagine" id="pagine" class="form-control input-sm" placeholder="Enter your Salary."/>
	                        </div>
	                    </div>
	                </div>
	                <div class="row">
	                    <div class="form-actions floatRight">
	                        <input type="submit"  value="{{!ctrl.book.titolo ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
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
		            <tr ng-repeat="u in ctrl.getAllBooks()">
		                <td>{{u.titolo}}</td>
		                <td>{{u.isbn}}</td>
		                <td>{{u.autore}}</td>
		                <td><button type="button" ng-click="ctrl.editBook(u.titolo)" class="btn btn-success custom-width">Edit</button></td>
		                <td><button type="button" ng-click="ctrl.removeBook(u.titolo)" class="btn btn-danger custom-width">Remove</button></td>
		            </tr>
		            </tbody>
		        </table>		
			</div>
		</div>
    </div>
</div>