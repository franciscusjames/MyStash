//angular.module('crudApp').controller('ClienteController', ["$scope","$http",function($scope, $http) {

angular.module('crudApp',['ngCpfCnpj'])
.controller('ClienteController', ["$scope","$http",function($scope, $http) {

//  INICIALIZA VARIAVEIS UTILIZADAS
var emails = [];
var itemEmail = {
	objref: null,
	objrefCliente: null,
	nome: null,
	email: null,
	wfk_usuincl: null,
	wfk_dtaincl: null,
	wfk_usualte: null,
	wfk_dtaalte: null,
};
$scope.cliente = {};
$scope.aux = {};
$scope.municipio = {};
$scope.nvocc = {}; 
$scope.emails = {};
$scope.itemEmail = {};

//  ATIVA UMA ABA E DESATIVA AS OUTRAS, LIMPANDO OS CAMPOS
$scope.abaMenu = function() {
	document.scrollingElement.scrollTop = 0;
	$scope.menu = true;
	$scope.tabela = true;
	$scope.cadastro = false;
	$scope.consulta = false;
	$scope.altera = false;
	$scope.exclui = false; 
}	

$scope.abaCadastro = function() {
	document.scrollingElement.scrollTop = 0;
	$scope.menu = true;
	$scope.tabela = false;
	$scope.cadastro = true;
	$scope.consulta = false;
	$scope.altera = false;
	$scope.exclui = false;  
	$scope.limpar(); 
}

$scope.abaConsulta = function() {
	document.scrollingElement.scrollTop = 0;
	$scope.menu = true;
	$scope.tabela = false;
	$scope.cadastro = false;
	$scope.consulta = true;
	$scope.altera = false;
	$scope.exclui = false; 
	$scope.nomeAba = "Consultar";
	$scope.limpar(); 
}

$scope.abaAltera = function() {
	document.scrollingElement.scrollTop = 0;
	$scope.menu = true;
	$scope.tabela = false;
	$scope.cadastro = false;
	$scope.consulta = false;
	$scope.altera = true;
	$scope.exclui = false; 
	$scope.limpar(); 
}

$scope.abaExclui = function() {
	document.scrollingElement.scrollTop = 0;
	$scope.menu = true;
	$scope.tabela = false;
	$scope.cadastro = false;
	$scope.consulta = true;
	$scope.altera = false;
	$scope.exclui = true;
	$scope.nomeAba = "Excluir";
	$scope.limpar(); 
}

//  LIMPA DADOS CLIENTE APOS OPERACAO (CRUD)
$scope.limpar = function(){
	$scope.cliente = {};
	$scope.aux = {};
	$scope.municipio = {};
	$scope.nvocc = {}; 
	$scope.emails = {};
	emails = [];
	document.getElementById("ObjRef").disabled = false;
	document.getElementById("ObjRef2").disabled = false;
}

//  PESQUISA REGISTRO CLIENTE POR OBJREF
$scope.pesquisarObjref = function(cliente) {
	$http.get('http://localhost:8000/api/cliente/objref/' + $scope.cliente.objref)
	.then(function(response) {
		$scope.cliente = response.data;		
		$scope.trataRegistro();
		console.log(response.data);
	}, function(error){
		console.log(error); 
	});	
}

//  TRAVA CAMPO OBJREF PARA NÃO ALTERAR INDEVIDAMENTE (DESFAZ=LIMPAR)
$scope.travaCampo = function(){
	document.getElementById("ObjRef").disabled = true;
	document.getElementById("ObjRef2").disabled = true;
}

//  TRATA ALGUNS CAMPOS ANTES DE EXIBIR NO FORMULARIO
$scope.trataRegistro = function (cliente) {
	$scope.travaCampo();
	if($scope.cliente.situacao == 1){
		$scope.aux.situacao = "Ativo"; 
	}else{
		$scope.aux.situacao = "Inativo"; 
	}
	if($scope.cliente.captacao == 1){
		$scope.aux.captacao = "Sim"; 
	}else{
		$scope.aux.captacao = "Nao"; 
	}
	if($scope.cliente.objref_municipio != null){
		$scope.getMunicipio(); 	
	} 
	if($scope.cliente.referenciawmsnvocc != null){
		$scope.getNvocc(); 
	}
	if($scope.cliente.objref == undefined){
		alert('ObjRef nao encontrado!');
		$scope.limpar(); 
	}else{
		$scope.getAllEmails();
	}
}

//  PESQUISA CNPJ PARA VERIFICAÇÃO DE DUPLICIDADE/VALIDAÇÃO
$scope.pesquisarCnpj = function(cliente) {
	$http.get('http://localhost:8000/api/cliente/cnpj/' + $scope.cliente.cnpj)
	.then(function(response) {
		$scope.cliente = response.data;
		console.log(response.data); 
	}, function(error){
		alert('Registro nao encontrado!');
		console.log(error); 
	});	
}

//  BUSCA LISTA DE CLIENTES NA TELA INICIAL
$scope.pesquisarAll = function() {
	$http.get('http://localhost:8000/api/clientes')
	.then(function(response) {
		$scope.retorno = response.data;
		console.log(response.data); 
	}, function(error){
		console.log(error); 
	});	
}

//  ALTERA REGISTRO PELA TELA PRINCIPAL
$scope.mainUpd = function(item) {
	$scope.abaAltera();
	$scope.cliente = item;
	$scope.trataRegistro();
}

//  EXCLUI REGISTRO PELA TELA PRINCIPAL
$scope.mainDel = function(item) {
	$scope.abaExclui();
	$scope.cliente = item;
	$scope.trataRegistro();
}

//  CADASTRA NOVO REGISTRO
$scope.cadastrar = function(cliente) {
	$http.post('http://localhost:8000/api/cliente', $scope.cliente)
	.then(function(response) {
		$scope.cliente = response.data;
		$scope.status = response.status;
		console.log(response.data); 
		alert('Cliente ObjRef: ' + $scope.cliente.objref + ' CADASTRADO com sucesso!');
		$scope.limpar();
		document.scrollingElement.scrollTop = 0;
	}, function(error){
		alert('Erro ao cadastrar registro: Objref ou CNPJ ja cadastrados!');
		console.log(error.data); 
	});	
}

//  ALTERA REGISTRO EXISTENTE
$scope.alterar = function(cliente) {
	$http.put('http://localhost:8000/api/cliente/' + $scope.cliente.objref, $scope.cliente)
	.then(function(response) {
		$scope.cliente = response.data;
		$scope.status = response.status;
		console.log(response.data); 
		alert('Registro ObjRef: ' + $scope.cliente.objref + ' ALTERADO com sucesso!');
		$scope.limpar();
		document.scrollingElement.scrollTop = 0;
	}, function(error){
		console.log(error.data); 
	});	
}

//  EXCLUI REGISTRO EXISTENTE E EMAILS RELACIONADOS
$scope.excluir = function(cliente) {
	$http.delete('http://localhost:8000/api/cliente/' + $scope.cliente.objref)
	.then(function(response) {
		$scope.cliente = response.data;
		console.log(response.data); 
		apagaAllEmails();
		alert('Registro ObjRef: ' + $scope.cliente.objref + ' EXCLUIDO com sucesso!');
		$scope.limpar();
		document.scrollingElement.scrollTop = 0;
	}, function(error){
		console.log(error.data); 
	});	
}

//  BUSCA MUNICIPIO A PARTIR DO cliente.objref_municipio
$scope.getMunicipio = function(cliente) {
	$http.get('http://localhost:8000/api/cliente/municipio/' + $scope.cliente.objref_municipio)
	.then(function(response) {
		$scope.municipio = response.data;
		console.log(response.data); 
	}, function(error){
		alert('Codigo municipio: ' + $scope.cliente.objref_municipio + ' nao encontrado!');
		console.log(error.data); 
	});	
}

//  BUSCA NVOCC A PARTIR DO cliente.referenciawmsnvocc
$scope.getNvocc = function(cliente) {
	$http.get('http://localhost:8000/api/cliente/nvocc/' + $scope.cliente.referenciawmsnvocc)
	.then(function(response) {
		$scope.nvocc = response.data;
		console.log(response.data); 
	}, function(error){
		alert('Codigo NVOCC: ' + $scope.cliente.referenciawmsnvocc + ' nao encontrado!');
		console.log(error.data); 
	});	
}

//  BUSCA EMAILS (LIST) POR OBJREF
$scope.getAllEmails = function(cliente) {
	$http.get('http://localhost:8000/api/cliente/emails/' + $scope.cliente.objref)
	.then(function(response) {
		$scope.emails = response.data;
		console.log(response.data); 
	}, function(error){
		console.log(error); 
	});	
}

//  GRAVA EMAILS POR $scope.cliente.objref
$scope.postEmail = function(itemEmail) {
	itemEmail.objrefCliente = $scope.cliente.objref;
	$http.post('http://localhost:8000/api/cliente/email', itemEmail)
	.then(function(response) {
		itemEmail = response.data;
		$scope.status = response.status;
		console.log(response.data); 
		alert('Email ADICIONADO com sucesso!');
		$scope.itemEmail = {};
		$scope.getAllEmails();
	}, function(error){
		alert('Erro ao cadastrar email!');
		console.log(error.data); 
	});	
}

//  REMOVE EMAIL POR itemEmail.objref
$scope.apagaEmail = function(itemEmail) {
	$http.delete('http://localhost:8000/api/cliente/email/' + itemEmail.objref, itemEmail)
	.then(function(response) {
		itemEmail = response.data;
		$scope.status = response.status;
		console.log(response.data); 
		alert('Email REMOVIDO com sucesso!');
		$scope.getAllEmails();
	}, function(error){
		alert('Erro ao atualizar email!');
		console.log(error.data); 
	});	
}

//  APAGA ALL EMAILS (LIST) POR $scope.cliente.objref
function apagaAllEmails(cliente) {
	$http.delete('http://localhost:8000/api/cliente/emails/' + $scope.cliente.objref)
	.then(function(response) {
		$scope.emails = response.data;
		$scope.status = response.status;
		console.log(response.data); 
	}, function(error){
		console.log(error.data); 
	});	
}

//  CONVERTE VALORES DE TELA PARA VALORES DE TABELA
$scope.chkDatalist = function (aux) {
	if($scope.aux.situacao == "Ativo"){
		$scope.cliente.situacao = 1; 
	}else{$scope.cliente.situacao = 0; }
	if($scope.aux.captacao == "Sim"){
		$scope.cliente.captacao = 1; 
	}else{$scope.cliente.captacao = 0; }
}

}]);
