<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script src="http://code.jquery.com/jquery-3.4.1.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/moviebox.css">
<script>
	//조회할 날짜를 계산
	var dt = new Date();
	//0(1월)부터 시작하기때문에 1더해주기
	var m = dt.getMonth() + 1;
	if (m < 10) { 
		var month = "0" + m;
	} else { 
		var month = m + ""; }
	//당일 박스오피스는 안나오기때문에 전날 박스오피를 가져오기위해 -1해줌
	var d = dt.getDate() - 1;
	if (d < 10) { 
		var day = "0" + d;
	} else { 
		var day = d + ""; }
	var y = dt.getFullYear();
	var year = y + "";
	var result = year + month + day;
	
	//천단위마다 콤마찍어주는 함수
	function addComma(num) {
		// 문자열 길이가 3과 같거나 작은 경우 입력 값을 그대로 리턴
		if (num.length <= 3) {
			return num;
		}
		// 3단어씩 자를 반복 횟수 구하기
		var count = Math.floor((num.length - 1) / 3);
		// 결과 값을 저정할 변수
		var result = "";
		// 문자 뒤쪽에서 3개를 자르며 콤마(,) 추가
		for (var i = 0; i < count; i++) {
			// 마지막 문자(length)위치 - 3 을 하여 마지막인덱스부터 세번째 문자열 인덱스값 구하기
			var length = num.length;
			var strCut = num.substr(length - 3, length);
			// 반복문을 통해 value 값은 뒤에서 부터 세자리씩 값이 리턴됨.
			// 입력값 뒷쪽에서 3개의 문자열을 잘라낸 나머지 값으로 입력값 갱신
			num = num.slice(0, length - 3);
			// 콤마(,) + 신규로 자른 문자열 + 기존 결과 값
			result = "," + strCut + result;
		}
		// 마지막으로 루프를 돌고 남아 있을 입력값(value)을 최종 결과 앞에 추가
		result = num + result;
		// 최종값 리턴
		return result;
	}
	//박스오피스 로딩하는 함수시작
	$(function() {
		$.ajax({
					//&itemPerPage: 1-10위 까지의 데이터가 출력되도록 설정
					url : "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.xml?key=f6ccd7e65568c45255e2c2dcb2dcd0e1&targetDt="
							+ result + "&itemPerPage=10",
					dataType : "xml",
					success : function(data) {
						var $data = $(data).find("boxOfficeResult>dailyBoxOfficeList>dailyBoxOffice");
						//데이터를 테이블 구조에 저장.
						if ($data.length > 0) {
							var table = $("<table/>").attr("class", "table");
							//<table>안에 테이블의 컬럼 타이틀 부분인 thead 태그
							var thead = $("<thead/>").append($("<tr/>"))
									.append(
											//추출하고자 하는 컬럼들의 타이틀 정의
											$("<th width='100px' style='background-color:#f0f0f0'/>").html("순위"),
											$("<th width='300px' style='background-color:#f0f0f0'/>").html("영화 제목"),
											$("<th width='200px' style='background-color:#f0f0f0'/>").html("영화 개봉일"),
											$("<th width='200px' style='background-color:#f0f0f0'/>").html("오늘 관객수"),
											$("<th width='200px' style='background-color:#f0f0f0'/>").html("누적 관객수"),
											$("<th width='200px' style='background-color:#f0f0f0'/>").text("상세보기"));
							var tbody = $("<tbody/>");
							
							$.each($data, function(i, o) {
								//오픈 API에 정의된 변수와 내가 정의한 변수 데이터 파싱
								var rank = $(o).find("rank").text(); // 순위
								var movieNm = $(o).find("movieNm").text(); //영화명
								var openDt = $(o).find("openDt").text();// 영화 개봉일
								var audiCnt = $(o).find("audiCnt").text(); //해당일의 관객수
								var audiAcc = $(o).find("audiAcc").text(); //누적 관객수
								//<tbody><tr><td>태그안에 파싱하여 추출된 데이터 넣기
								var row = $("<tr style='background-color:#f0f0f0'/>").append(
										$("<td style='background-color:#f0f0f0'/>").text(rank),
										$("<td style='background-color:#f0f0f0'/>").text(movieNm),
										$("<td style='background-color:#f0f0f0'/>").text(openDt),
										$("<td style='background-color:#f0f0f0'/>").text(addComma(audiCnt)),
										$("<td style='background-color:#f0f0f0'/>").text(addComma(audiAcc)),
										$("<td style='background-color:#f0f0f0'/>").html("<input type='button' id='id_check' class='btn btn-outline-primary' value='상세보기' onclick='goSearch(\""+ movieNm +"\")'>")
										
								);

								tbody.append(row);
							});// end of each 
							table.append(thead);
							table.append(tbody);
							$(".wrap").append(table);
						}
					},
					//에러 발생시 "실시간 박스오피스 로딩중"메시지가 뜨도록 한다.
					error : function() {
						alert("실시간 박스오피스 로딩중...");
					}
				});
		
	}); //박스오피스 로딩하는 함수끝
	
	function goSearch(movieNm) {
		console.log(movieNm);
	    var regExp = /[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]/gi;
	    var t
	    if(regExp.test(movieNm)){
	        t = movieNm.replace(regExp, "");
	    }else{
	    	t = movieNm;
	    }
		location.href="${cp}/movieinfo/moviesearch.do?query="+t;
		
	}
</script>

	<div id="movieChart">
		<div id="mo_searchBox">
			<h3 >- 실시간 박스오피스 -</h3>
				<div id="mo_inline">
				</div>		
		</div>
		<div class="wrap"></div>	
	</div>
	
