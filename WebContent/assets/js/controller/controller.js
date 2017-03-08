angular.module("app", ["chart.js"]).controller("BarCtrl", function ($scope) {
  $scope.labels = ['Magazine', 'CD', 'DVD', 'Audio CD'];
  $scope.color = ['#8C001A'];

  $scope.data = [
    [65, 59, 80, 81, 56, 55, 40]
  ];
  $scope.options = {
	    scales: {
	        xAxes: [{
		      scaleLabel: {
		        display: true,
		        labelString: 'Product Type'
		      }
	        }],
	        yAxes: [{
		      scaleLabel: {
		        display: true,
		        labelString: 'Total Sales (₱)'
		      }
	        }],	        
	    }
    }
});