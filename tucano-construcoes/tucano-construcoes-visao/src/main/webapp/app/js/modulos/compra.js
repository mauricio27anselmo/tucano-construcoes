(function(){
    'use-strict';

    angular.module('compra',['ngAnimate', 'ngCookies','angular-growl'])
        .config(['growlProvider',function (growlProvider){
            growlProvider.globalDisableCountDown(true);
        }])
})();