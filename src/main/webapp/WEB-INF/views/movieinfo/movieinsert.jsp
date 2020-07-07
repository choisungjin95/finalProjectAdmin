<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<link rel="stylesheet" type="text/css"
	href="${cp}/resources/css/movieinsert.css">    
	

<h1>영화판권구매</h1>
<form>
<div id="film">
	제목<br>
	<input type="text" id="title" value="title"><br>
	감독<br>
	<input type="text" id="filmhead" value="감독"><br>
	줄거리<br>
	<textarea rows="10" cols="35"></textarea><br>
	개봉일<br>
	<input type="date" id="startdate" min="2020-01-01" max="2020-12-31"><br>
	종료일<br>
	<input type="date" id="enddate" min="2020-01-01" max="2020-12-31"><br>
	판권가<br>
	<input type="text" id="movieprice" value="price"><br>
	<div>
		<select id="test"></select>
	</div>
</div>
</form>
<script>
	for(var i=0;i<${list.length};i++){
		$("#test").append("<option value="${list.name}">${list.name}</option>");
	}
</script>
