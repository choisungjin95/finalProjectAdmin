<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<div style="text-align: center; margin-top: 20px;">
	<h1>영화별 수익 및 누적관람객d</h1>
	<div class="ui-widget">
	영화 제목: <input id="movieIncome">
	</div>
	<div>
		<div id="curve_chart1" style="width:500px;height:500px;float:left;"></div>
		<div id="curve_chart2" style="width:500px;height:500px;float:left"></div>
		<div id="movieTable_div" style="width:400px; height:100px;position:absolute;left:1100px;top:300px;"></div>
		<div id="movieInfoTable_div" style="width:400px; height:100px;position:absolute;left:1100px;top:500px;"></div>
	</div>
</div>
