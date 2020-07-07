<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/moviesearch.css">
<script>
	//crossDomain 해결코드
	/*
	$(function() {
		$.ajaxPrefilter(function(options, originalOptions, jqXHR) {
			if (options.crossDomain && jQuery.support.cors) {
				options.url = "https://cors-anywhere.herokuapp.com/" + options.url;
			}
		});
	});
	
	*/
	

	$(function() {
		$.popup = function() {
			$('.wrap3').css('display','block');
		}
		$.close = function() {
			$('.wrap3').css('display','none');
			
			//그전에 출력되있는 정보는 삭제해줌
			$('#table2').remove();
		}
		// form에서 값 받아오기
		$.serviceAPISearchBlog = function() {
			
			if ("" == $.trim($("#query").val())) {
				$("#query").val("검색어");
			}
			$.ajax({
						context : this,
						traditional : true,
						//json 요청 url
						url : "${pageContext.request.contextPath}/movieinfo/moviesearchOk.do",
						method : "GET",
						type : "GET",
						dataType : "JSON",
						contentType : "application/x-www-form-urlencoded; charset=UTF-8",
						data : $("#serviceAPISearchForm").serialize(),
						success : function(data, textStatus, jqXHR) {
							if (data != null) {
								//JSON을 문자열로 바꿔줌
								var json = JSON.stringify(data);
								if (json.length > 0) {
									var table2 = $("<table/>").attr("id","table2");
									$('#table2').remove();
									
									//<table>안에 테이블의 컬럼 타이틀 부분인 thead 태그
									var thead2 = $("<thead/>").append(
											$("<tr/>")).append(
									//추출하고자 하는 컬럼들의 타이틀 정의
											$("<th/>").html("포스터"),
											$("<th width='200px;'/>").html("영화제목"),
											$("<th width='300px;'/>").html("감독"),
											$("<th width='500px;'/>").html("주연배우"),
											$("<th width='100px;'/>").html("제작년도"),
											$("<th width='100px;'/>").html("평점"),
											$("<th width='100px;'/>").text("구매"));
									var tbody2 = $("<tbody/>");
									var item = JSON.parse(json);
									$(item.items).each(function(i,data1) {
											console.log("이치문후.."+data1.title);		
														var title = data1.title.replace(/<b>|<\/b>/g,'');
														var link = data1.link;
														var img = data1.image;
														var director = data1.director.replace(/\|/g,' | ');
														var actor = data1.actor.replace(/\|/g,' | ');
														var pubDate = data1.pubDate;
														var rate = data1.userRating;
														var row2 = $("<tr/>").append(
																		//포스터이미지클릭시 링크이동
																		$("<td> <a href='"+ link +"' target='_blank'> <img id=\"img_src\" src="+ img +"></a> </td>"),
																		$("<td/>").text(title),
																		$("<td/>").text(director),
																		$("<td/>").text(actor),
																		$("<td/>").text(pubDate),
																		$("<td/>").text(rate),
																		$("<td/>").html("<input type='button' id='id_check' class='btn btn-outline-primary' value='구매' onclick='goBuy(\""+ title +"\")'>")
																		);
														tbody2.append(row2);
													});// end of each 
									table2.append(thead2);
									table2.append(tbody2);
									$(".wrap2").append(table2);
									console.log("영화정보 나와야.."+query);
								}
							}else{
								console.log("error");
							}
						},
						error : function(jqXHR, textStatus, errorThrown) { //에러났을때
							var errorResponseCode = "";
							errorResponseCode += "readyState : ";
							errorResponseCode += jqXHR.readyState;
							if ("0" == jqXHR.readyState) {
								errorResponseCode += "-UNSENT";
							}
							if ("1" == jqXHR.readyState) {
								errorResponseCode += "-OPENED";
							}
							if ("2" == jqXHR.readyState) {
								errorResponseCode += "-HEADERS_RECEIVED";
							}
							if ("3" == jqXHR.readyState) {
								errorResponseCode += "-LOADING";
							}
							if ("4" == jqXHR.readyState) {
								errorResponseCode += "-DONE";
							}
							alert(errorResponseCode);
							alert($("#query").val());
						},
						complete : function(jqXHR, textStatus) {
						}
					});
		}
		$("input").keydown(function (event) {
	        if (event.which === 13) {    //enter
	            console.log($(this).val());
	            $('#submit').click();
	            return false;
	        }
	    });
	});
	
	function goBuy(title) {
		//alert(title);
		location.href="${cp}/movieinfo/moviebuy.do?title="+title;
	}



</script>

	<div id="movieChart">
		
		<div id="mo_searchBox">
			<form name="serviceAPISearchForm" id="serviceAPISearchForm"	method="post" action="" onsubmit="return false;">
				<div id="mo_inline">
					<div id="MovieSearchInput" >		
						<input class="form-control" type="text" id="query"  name="query" placeholder="영화 검색" value="${query}" />
					</div>
				</div>
				
				<button class="btn btn-primary"  type="button" id="submit" onclick="$.serviceAPISearchBlog(); $.popup();">검색</button>
			</form>
		</div>
		
		<div class="wrap"></div>
		
	</div>
	<div class="wrap3">
		<h5 style="display:inline-block; font-weight: bold;">포스터를 클릭하면 네이버 영화정보로 넘어갑니다.</h5>
		<div id="close" onclick="$.close();" style="float:right;">X</div>
		<div class="wrap2" id="popup"></div>
	</div>
	
	<div id="bottomSpace"></div>
