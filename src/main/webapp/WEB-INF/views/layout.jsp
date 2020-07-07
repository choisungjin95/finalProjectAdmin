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
				$.getJSON('${cp}/admin/income/getBranchChat',{filmName:ui.item.value},function(results){
	            	google.charts.load('current', {'packages':['corechart']});
	            	google.charts.load('current', {'packages':['table']});
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
			             var Tabledata = new google.visualization.DataTable();
			             Tabledata.addColumn('string', '영업기간');
			             Tabledata.addColumn('number', '티켓수익');
			             Tabledata.addColumn('number', '매점수익');
			             Tabledata.addColumn('number', '지출');
			             Tabledata.addColumn('number', '총 이윤');
			             Tabledata.addRows([
			                ['영업기간',{v: branchTicketIncome, f:'$'+branchTicketIncome},
			                	{v: branchStoreIncome, f:'$'+branchStoreIncome},
			                	{v: branchOutCome, f:'$'+branchOutCome},
			                	{v: branchTotalIncome, f:'$'+branchTotalIncome}]
			             ]);
			             
			             var Tabledata2 = new google.visualization.DataTable();
			             Tabledata2.addColumn('string', 'Name');
			             Tabledata2.addColumn('number', 'Salary');
			             Tabledata2.addColumn('boolean', 'Full Time Employee');
			             Tabledata2.addRows([
			                ['Mike',  {v: 10000, f: '$10,000'}, true],
			                ['Jim',   {v: 8000,   f: '$8,000'},  false],
			                ['Alice', {v: 12500, f: '$12,500'}, true],
			                ['Bob',   {v: 7000,  f: '$7,000'},  true]
			             ]);
			             
			              var chart = new google.visualization.AreaChart(document.getElementById('curve_chart3'));
			              chart.draw(data, options);
			              var table = new google.visualization.Table(document.getElementById('table_div'));
			              table.draw(Tabledata, {showRowNumber: true, width: '100%', height: '100%'});
			              
			              google.visualization.events.addListener(chart,'onmouseover',function(e){
			            	  /*var branchTable = '';
			            	  branchTable += '<tr><th>날짜</th><th>수입</th><th>지출</th></tr>';
			            	  branchTable += '<tr><td>'+data.getValue(e.row,0)+'</td><td>'+data.getValue(e.row,1)+'</td><td>'+data.getValue(e.row,2)+'</td></tr>';
			            	  $("#branchIncomeInfo").html(branchTable);*/
			            	  var Tabledata2 = new google.visualization.DataTable();
					             Tabledata2.addColumn('string', '영업기간');
					             Tabledata2.addColumn('number', '수익');
					             Tabledata2.addColumn('number', '지출');
					             Tabledata2.addRows([
					                [data.getValue(e.row,0),
					                	{v: data.getValue(e.row,1), f: '$'+data.getValue(e.row,1)},
					                	{v: data.getValue(e.row,2), f: '$'+data.getValue(e.row,2)} ]
					             ]);
					             var table2 = new google.visualization.Table(document.getElementById('table_div2'));
					             table2.draw(Tabledata2, {showRowNumber: true, width: '100%', height: '100%'});
			              });
			              google.visualization.events.addListener(chart,'onmouseout',function(e){
			            	  //$("#branchIncomeInfo").empty();
			            	  $("#table_div2").empty();
			              });

			       }

		            });//$getjson
		     
		        
				}
		});
		
		
	});
</script>
</html>