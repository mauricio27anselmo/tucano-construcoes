(function(){
    'use-strict';

    angular.module('selecaoCliente')
        .controller('selecaoClienteController',['$scope', '$http', '$window', '$cookies', selecaoClienteController]);

    function selecaoClienteController($scope, $http, $window, $cookies){
        var listaClientes = [];
        var url = "http://localhost:8445/tucano-construcoes/services/cliente";
        listarClientesCadastrados();

        function listarClientesCadastrados(){
            // primeira edicao
            // var cliente1 = {"nome": "Mauricio","rg": 1234567,"cpf": 999.99999999,"email": "teste1@gmail.com","contato": "(62)9999-8888","dataNascimento": "27/10/1993","sexo": "Masculino"};
            // var cliente2 = {"nome": "Mauricio2","rg": 1234568,"cpf": 99999999999,"email": "teste1@gmail.com","contato": 629999988888,"dataNascimento": "27/10/1993","sexo": "Masculino"};
            // var cliente3 = {"nome": "Mauricio3","rg": 1234569,"cpf": 99999999999,"email": "teste1@gmail.com","contato": 629999988888,"dataNascimento": "27/10/1993","sexo": "Masculino"};
            // var cliente4 = {"nome": "Mauricio4","rg": 1234560,"cpf": 99999999999,"email": "teste1@gmail.com","contato": 629999988888,"dataNascimento": "27/10/1993","sexo": "Masculino"};
            // var cliente5 = {"nome": "Mauricio5","rg": 1234561,"cpf": 99999999999,"email": "teste1@gmail.com","contato": 629999988888,"dataNascimento": "27/10/1993","sexo": "Masculino"};
            // listaClientes.push(cliente1);
            // listaClientes.push(cliente2);
            // listaClientes.push(cliente3);
            // listaClientes.push(cliente4);
            // listaClientes.push(cliente5);
            // $scope.clientes = listaClientes;

            // segunda edicao
            // var listaClientesTexto = $window.sessionStorage.getItem("clientesRegistrados");
            // listaClientes = (listaClientesTexto == null || listaClientesTexto == "") ? [] : angular.fromJson(listaClientesTexto);
            // $scope.clientes = listaClientes;

            //edicao definitiva

            $http.get(url, {headers: {'Content-Type': "application/json"}}).then(
                function(response){
                    $scope.clientes = response.data;
                }
            );
        }

        $scope.selecionarCliente = function(cliente){
            var clienteSelecionado = angular.toJson(cliente)
            $window.sessionStorage.setItem("clienteSelecionado", clienteSelecionado);
            window.location.href = "compra.html";
        }
    }
})();