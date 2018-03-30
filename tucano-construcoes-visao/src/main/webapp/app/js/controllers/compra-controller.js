(function(){
    'use-strict';

    angular.module('compra')
        .controller('compraController',['$scope', '$http', '$window', '$cookies', 'growl', compraController]);

    function compraController($scope, $http, $window, $cookies, growl){

        carregarInformacoesCompra();

        function carregarInformacoesCompra(){
            var clienteSelecionadoJson = $window.sessionStorage.getItem("clienteSelecionado");
            var clienteSelecionado = (clienteSelecionadoJson == null || clienteSelecionadoJson == "") ? null : angular.fromJson(clienteSelecionadoJson);
            $scope.compra = {
                cliente: clienteSelecionado,
                valorTotal: 0,
                listaProdutos : carregarCarrinho()
            };
            definirCustoTotal();
        }

        function carregarCarrinho(){
            // var  listaProdutos = [];
            // var produto1 = {"codigo": 123456,"descricao": "Descrição 1","tipoMaterial": "Ferro","fabricante": "UNITINTAS", "valor": 12.50};
            // var produto2 = {"codigo": 324234,"descricao": "Descrição 2","tipoMaterial": "Madeira","fabricante": "UNITINTAS", "valor": 7.85};
            // var produto3 = {"codigo": 958413,"descricao": "Descrição 3","tipoMaterial": "Janela","fabricante": "UNITINTAS", "valor": 8.50};
            // listaProdutos.push(produto1);
            // listaProdutos.push(produto2);
            // listaProdutos.push(produto3);
            // return listaProdutos;

            var listaProdutos = $window.sessionStorage.getItem("listaProdutos");
            return (listaProdutos == null || listaProdutos == "")? [] : angular.fromJson(listaProdutos);

        }

        function definirCustoTotal(){
            var custoTotal = 0;
            var itensCarrinho = $scope.compra.listaProdutos;
            for(var item in itensCarrinho){
                custoTotal += itensCarrinho[item].valor;
            }
            $scope.compra.valorTotal = custoTotal;
        }

        $scope.efetuarCompra = function(){
            var mensagem = "";
            if($scope.compra.cliente.nome == "" || $scope.compra.listaProdutos.length == 0){
                mensagem = "Os dados do cliente e dos produtos escolhidos devem ser informados para efetuar a compra";
                growl.error(mensagem.bold(), {ttl : 3000});
            }else{
                // Primeira edicao
                // mensagem = "Compra efetuada com sucesso";
                // growl.success(mensagem.bold(), {ttl : 3000,});
                // $window.sessionStorage.setItem("clienteSelecionado", "");
                // $window.sessionStorage.setItem("listaProdutos", "");
                // window.location.href = "../../index.html";


                var url = "http://localhost:8445/tucano-construcoes/services/compra";
                $http.post(url, $scope.compra, {headers: {"Content-Type": "application/json"}}).then(
                    function(response){
                        if(response.data.bemSucedido){
                            growl.success(response.data.mensagem.bold(), {ttl : 3000});
                        }else{
                            growl.error(response.data.mensagem.bold(), {ttl : 3000});
                        }
                    }
                )


            }
        }


    }
})();