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
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
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
		//영화별 수익 및 누적 관객수 
		var movie = new Array();
		var movieTotalIncome = 0;
		var movieTotalPeople = 0;
		var movieData = ${filmArray};
		$(movieData).each(function(i,mem){
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
		            		movieTotalIncome += mem.totalPrice;
		            		array[++i] = subArray;
		            	});
		            	var data = google.visualization.arrayToDataTable(array);

		              
		              var options = {
		                title: '수익',
		                curveType: 'function',
		                legend: { position: 'bottom' },
		                animation:{
		                 startup:true,
		                 duration: 1500,
		                 easing: 'out'
		              	 },
		              	series: {
		                    0: { color: '#a561bd' },
		                    1: { color: '#c784de' },
		                    2: { color: '#f1ca3a' },
		                    3: { color: '#2980b9' },
		                    4: { color: '#e67e22' }
		                  },
		                  backgroundColor: {
		                      'fill': '#F4F4F4',
		                      'opacity': 100
		                  },
		                  
		              };

		              var chart = new google.visualization.LineChart(document.getElementById('curve_chart1'));
		              chart.draw(data, options);
		            }
		            
		            function drawAnthonyChart() {
		            	var array = new Array();
		            	array[0] = ['date','people'];
		            	$(results).each(function(i,mem){
		            		var subArray = [mem.totalDate,mem.totalPeople];
		            		movieTotalPeople += mem.totalPeople;
		            		array[++i] = subArray;
		            	});
		            	var data = google.visualization.arrayToDataTable(array);

		              
		              var options = {
		                title: '관객수',
		                curveType: 'function',
		                legend: { position: 'bottom' },
		                color:'gray',
		                animation:{
		                 startup:true,
		                 duration: 1500,
		                 easing: 'out'
		              	 },
		              	 backgroundColor: {
		                      'fill': '#F4F4F4',
		                      'opacity': 100
		                 }
		              };
		              
		              var chart = new google.visualization.LineChart(document.getElementById('curve_chart2'));
		              chart.draw(data, options);
		            }
	            });
	        }
		});
		
		//지점별 수익 및 누적 관객수 
		var branch = new Array();
		var branchTotalIncome = 0;
		var branchTicketIncome = 0;
		var branchStoreIncome = 0;
		var branchOutCome = 0;
		var branchData = ${branchArray};
		$(branchData).each(function(i,mem){
			branch.push(mem.data);
		});
		
		$("#branchIncome").autocomplete({
			source:branch,
			select:function(event, ui) {
				$(".incomeTable").css("opacity",1);
				$.getJSON('${cp}/admin/income/getBranchChat',{filmName:ui.item.value},function(results){
	            	google.charts.load('current', {'packages':['corechart']});
		            google.charts.setOnLoadCallback(drawBranchChart);

		            function drawBranchChart() {
		            	var array = new Array();
		            	array[0] = ['date','income','outcome'];
		            	$(results).each(function(i,mem){
		            		var subArray = [mem.revenueDate,mem.ticketIncome+mem.storeIncome,mem.outcome];
		            		branchTicketIncome += mem.ticketIncome;
		            		branchStoreIncome += mem.storeIncome;
		            		branchOutCome += mem.outcome;
		            		branchTotalIncome += mem.ticketIncome+mem.storeIncome-mem.outcome;
		            		array[++i] = subArray;
		            	});
		            	var data = google.visualization.arrayToDataTable(array);

		              
		              var options = {
		            		  title: 'Company Performance',
		                      hAxis: {title: 'Year',  titleTextStyle: {color: '#333'}},
		                      vAxis: {minValue: 0},
		                      animation:{
		 		                 startup:true,
		 		                 duration: 1500,
		 		                 easing: 'in'
		 		              },
		              };
		              
						
		              var chart = new google.visualization.AreaChart(document.getElementById('curve_chart3'));
		              chart.draw(data, options);
		              
		              google.visualization.events.addListener(chart,'onmouseover',function(e){
		            	  var branchTable = '';
		            	  branchTable += '<tr>';
		            	  branchTable += '<th>ㅇ</th>';
		            	  branchTable += '<th>ㅇ</th>';
		            	  branchTable += '<th>ㅇ</th>';
		            	  branchTable += '<th>ㅇ</th>';
		            	  branchTable += '</tr>';
		            	  branchTable += '<tr>';
		            	  branchTable += '<td>'+branchTicketIncome+'</td>';
		            	  branchTable += '<td>'+branchStoreIncome+'</td>';
		            	  branchTable += '<td>'+branchOutCome+'</td>';
		            	  branchTable += '<td>'+branchTotalIncome+'</td>';
		            	  branchTable += '</tr>';
		            	  branchTable += '<tr>';
		            	  branchTable += '<td>'+data.getValue(e.row,0)+'</td>';
		            	  branchTable += '<td>'+data.getValue(e.row,1)+'</td>';
		            	  branchTable += '<td>'+data.getValue(e.row,2)+'</td>';
		            	  branchTable += '<td>'+branchTotalIncome+'</td>';
		            	  branchTable += '</tr>';
		            	  $("#branchIncomeInfo").html(branchTable);
		            	  $("#branchIncomeInfo").css('opacity',1);
		              });
		              google.visualization.events.addListener(chart,'onmouseout',function(e){
		            	  $("#branchIncomeInfo").css('opacity',0);
		              });
		            }
				});
			}
		});
		
		
	});
</script>
</html>