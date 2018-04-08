(function(){
    'use-strict';

    angular.module('ofertas')
        .controller('ofertasController',['$scope', '$http', '$window', '$cookies', 'growl', ofertasController]);

    function ofertasController($scope, $http, $window, $cookies, growl){
        $(document).ready(function(){
            $('[data-toggle="tooltip"]').tooltip(); 
        });
        
        carregarProdutos();


        function carregarProdutos(){
            //primeira edição
            // var  listaProdutos = [];
            // var produto1 = {"codigo": 123456,"descricao": "Descrição 1","tipoMaterial": "Ferro","fabricante": "UNITINTAS", "valor": 12.50};
            // var produto2 = {"codigo": 324234,"descricao": "Descrição 2","tipoMaterial": "Madeira","fabricante": "UNITINTAS", "valor": 7.85};
            // var produto3 = {"codigo": 958413,"descricao": "Descrição 3","tipoMaterial": "Janela","fabricante": "UNITINTAS", "valor": 8.50};
            // var produto4 = {"codigo": 778121,"descricao": "Descrição 4","tipoMaterial": "Decoração","fabricante": "UNITINTAS", "valor": 3.50};
            // var produto5 = {"codigo": 226643,"descricao": "Descrição 5","tipoMaterial": "Decoração","fabricante": "UNITINTAS", "valor": 1.50};
            // var produto6 = {"codigo": 141502,"descricao": "Descrição 6","tipoMaterial": "Madeira","fabricante": "UNITINTAS", "valor": 12.78};
            // var produto7 = {"codigo": 654123,"descricao": "Descrição 7","tipoMaterial": "Ferro","fabricante": "UNITINTAS", "valor": 11.50};
            // listaProdutos.push(produto1);
            // listaProdutos.push(produto2);
            // listaProdutos.push(produto3);
            // listaProdutos.push(produto4);
            // listaProdutos.push(produto5);
            // listaProdutos.push(produto6);
            // listaProdutos.push(produto7);
            // $scope.produtos = listaProdutos;
            // $scope.listaCompras = [];
            // $window.sessionStorage.setItem("clienteSelecionado", "");
            // $window.sessionStorage.setItem("listaProdutos", "");
            var url = "http://localhost:8445/tucano-construcoes/services/produto";
            $http.get(url, {headers:{"Content-Type": "application/json"}}).then(
                function (response) {
                    $scope.produtos = response.data;
                }
            );
            $scope.listaCompras = [];
            $window.sessionStorage.setItem("clienteSelecionado", "");
            $window.sessionStorage.setItem("listaProdutos", "");
        }

        $scope.adicionarCarrinho = function(produto){
            $scope.listaCompras.push(produto);
        }

        $scope.retirarCarrinho = function(item){
            var indice = $scope.listaCompras.indexOf(item);
            $scope.listaCompras.splice(indice, 1);
        }

        $scope.efetuarCompra = function(){
            if($scope.listaCompras != [] && $scope.listaCompras.length > 0){
                var listaProdutosComprados = angular.toJson($scope.listaCompras)
                $window.sessionStorage.setItem("listaProdutos", listaProdutosComprados);
                window.location.href = "compra.html";
            }else{
                var mensagemErro = "O carrinho deve possuir itens para que a compra possa ser efetuada";
                growl.error(mensagemErro.bold(), {ttl : 3000});
            }

        }
    }
})();