(function(){
    'use-strict';

    angular.module('cadastroCliente',['ngAnimate', 'ngCookies', 'angular-growl'])
        .config(['growlProvider',function (growlProvider){
            growlProvider.globalDisableCountDown(true);
        }])

})();