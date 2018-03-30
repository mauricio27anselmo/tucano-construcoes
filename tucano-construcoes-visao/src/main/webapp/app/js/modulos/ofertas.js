(function(){
    'use-strict';

    angular.module('ofertas',['ngAnimate', 'ngCookies', 'angular-growl'])
        .config(['growlProvider',function (growlProvider){
            growlProvider.globalDisableCountDown(true);
        }])
})();