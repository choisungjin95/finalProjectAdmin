<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<link rel="stylesheet" type="text/css"
	href="${cp}/resources/css/movieinsert.css">    
<script>
	$(function(){
		var title = ${api}.items[0].title.replace(/<b>|<\/b>/g,'');
		$("#title").val(title);
		var director = ${api}.items[0].director.replace(/[|]/g,'');
		$("#filmHead").val(director);
		var actor = ${api}.items[0].actor;
		var str=actor.split("|");
		console.log(str[1]);
		for(var i=0;i<str.length-1;i++){
			var strr=str[i].replace(" ","");
			console.log(strr);
			$("#actor").append("<input type='hidden' name='human' value="+strr+"></input>");
			$("#actor").append("<li name='human1' value="+str[i]+">"+str[i]+"</li>");
		} 
		var image = ${api}.items[0].image;
		$("#img").attr("src",image);
		$("#immg").val(image);
		
	});
</script>

<h1>- 영화판권구매 -</h1>
<form action="${cp }/movieinfo/moviebuyOk.do" method = "post">
	<div id="main">
		<div id="film">
			제목<br>
			<input type="text" id="title" name="filmName"><br>
			감독<br>
			<input type="text" id="filmHead" name="filmHead"><br>
			줄거리<br>
			<textarea style="resize: none;" rows="10" cols="35" id="filmStory" name="filmStory"></textarea><br>
			개봉일<br>
			<input type="date" id="filmStart" name="filmStart" min="2020-01-01" max="2020-12-31"><br>
			종료일<br>
			<input type="date" id="filmEnd" name="filmEnd" min="2020-01-01" max="2020-12-31"><br>
			판권가<br>
			<input type="text" id="filmPrice" name="filmPrice" value="0"><br>
		</div>
		<div id="cast">
			장르<br>
			<select name="genreNum" id="genre">
				<c:forEach var="vo" items="${list }">
					<option value="${vo.genreNum }">${vo.sffPosition }</option>
				</c:forEach>
			</select><br>
			출연진<br>
			<ul id="actor">
			
			</ul>
			이미지<br>
			<input type="text" name="filename" id="immg">
			<img id="img" src="">
		</div>
	</div>
	<input type="submit" id="add" value="등록">
</form>
