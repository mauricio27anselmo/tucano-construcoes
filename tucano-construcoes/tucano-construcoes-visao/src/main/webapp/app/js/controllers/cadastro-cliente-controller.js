(function(){
    'use-strict';

    angular.module('cadastroCliente')
        .controller('cadastroClienteController',['$scope', '$http', '$window', '$cookies', 'growl', cadastroClienteController]);

    function cadastroClienteController($scope, $http, $window, $cookies, growl){
        var listaClientes = [];
        var url="http://localhost:8445/tucano-construcoes/services/cliente"
        carregarPagina()

        function carregarPagina(){
            definirMascaras();
            var listaClientesTexto = $window.sessionStorage.getItem("clientesRegistrados");
            listaClientes = (listaClientesTexto == null || listaClientesTexto == "") ? [] : angular.fromJson(listaClientesTexto);
        }

        function definirMascaras(){
            $(document).ready(function(){
                $('.cpf').mask('000.000.000-00');
                $('.rg').mask('0000000');
                $('.telefone').mask('(00)0000-0000');
                $('.email').blur(function(){
                    alert("OK");
                })
            });
        }

        $scope.cadastrarCliente = function(cliente){
            // primeiro processo
            // listaClientes.push(cliente);
            // var mensagemErro = "Cadastro efetuado com sucesso";
            // growl.success(mensagemErro.bold(), {ttl : 3000});
            // var listaClientesTexto = angular.toJson(listaClientes);
            // $window.sessionStorage.setItem("clientesRegistrados", listaClientesTexto);
            // window.location.href = "../../index.html";

            //processo definitivo
            $http.post(url, cliente, {headers:{'Content-Type': "application/json"}}).then(
                function(response){
                    if(response.data.bemSucedido){
                        growl.success(response.data.mensagem.bold(), {ttl : 3000});
                    }else{
                        growl.error(response.data.mensagem.bold(), {ttl : 3000});
                    }
                }
            );


        }

        $scope.validarEmail = function(){
            var email = $scope.cliente == undefined? "": $scope.cliente.email;
            var emailExpressaoRegular = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
            var emailValido = emailExpressaoRegular.test(email);
            var mensagemValidacao = ""
            if(!emailValido){
                mensagemValidacao = "Email inválido!";
                growl.warning(mensagemValidacao.bold(), {ttl:3000});
                $scope.cliente.email = "";
            }
        }


    }
})();