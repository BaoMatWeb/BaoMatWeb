
angular.module('sortApp', [])

.controller('mainController', function($scope) {
  $scope.sortType     = 'name'; // set the default sort type
  $scope.sortReverse  = false;  // set the default sort order
  $scope.searchFish   = '';     // set the default search/filter term
  
  // create the list of sushi rolls 
  $scope.sushi = [
{ tb: 'Thông báo đề tài gần hết hạn', ng: 'Crab', ngay: '20/5/2016' },
{ tb: 'Thông báo đề tài được duyệt', ng: 'Tuna',ngay: '8/10/2016' },
{ tb: 'Thông báo đề tài được duyệt', ng: 'Eel', ngay: '20/10/2016'},
{ tb: 'Thông báo đề tài được duyệt', ng: 'Variety', ngay: '20/10/2016'}
  ];
  
});