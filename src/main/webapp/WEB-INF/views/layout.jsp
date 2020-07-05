<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>views/layout.jsp</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="${cp}/resources/css/main.css"
	type="text/css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
</head>
<body>
	<div id="wrap">
		<div id="header">
			<tiles:insertAttribute name="header" />
		</div>
		<div id="content">
			<tiles:insertAttribute name="content" />
		</div>
		<div id="footer">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
</body>
<script>
	$(function() {
		var movie = new Array();
		var data = ${array};
		$(data).each(function(i,mem){
			movie.push(mem.data);
		});
		$("#movieIncome").autocomplete({
			source:movie,
			select:function(event, ui) {
	            $.getJSON('${cp}/admin/income/getChat',{filmName:ui.item.value},function(results){
	            	google.charts.load('current', {'packages':['corechart']});
		            google.charts.setOnLoadCallback(drawChart);
		            google.charts.setOnLoadCallback(drawAnthonyChart);

		            function drawChart() {
		            	var array = new Array();
		            	array[0] = ['date','income'];
		            	$(results).each(function(i,mem){
		            		var subArray = [mem.totalDate,mem.totalPrice];
		            		array[++i] = subArray;
		            	});
		            	var data = google.visualization.arrayToDataTable(array);

		              
		              var options = {
		                title: '수익',
		                curveType: 'function',
		                legend: { position: 'bottom' }
		              };

		              var chart = new google.visualization.LineChart(document.getElementById('curve_chart1'));
		              chart.draw(data, options);
		            }
		            
		            function drawAnthonyChart() {
		            	var array = new Array();
		            	array[0] = ['date','people'];
		            	$(results).each(function(i,mem){
		            		var subArray = [mem.totalDate,mem.totalPeople];
		            		array[++i] = subArray;
		            	});
		            	var data = google.visualization.arrayToDataTable(array);

		              
		              var options = {
		                title: '관객수',
		                curveType: 'function',
		                legend: { position: 'bottom' },
		                color:'gray'
		              };

		              var chart = new google.visualization.LineChart(document.getElementById('curve_chart2'));
		              chart.draw(data, options);
		            }
	            });
	        }
		});
	});
</script>
</html>