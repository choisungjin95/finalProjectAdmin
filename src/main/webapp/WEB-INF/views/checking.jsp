<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
<title>MegaCinema</title>
<link rel="icon" type="image/png" href="${cp}/resources/logo/logo.png" />
<link rel="stylesheet" type="text/css"
	href="${cp }/resources/css/checking.css">
</head>

<div id="alldiv">
	<div id="gifdiv">
		<img alt="" src="${cp}/resources/images/jerry.gif">
	</div>
	<div id="checkdiv">
		<h1>관리자 로그인</h1>
		<h2>비밀번호를 입력해주세요.</h2>
		<form action="${cp }/main.do" method="post">
			<div class="in-line" id="formdiv">
				<input type="password" name="pwd" id="pwd" placeholder="비밀번호 입력">
				<input type="submit" name="name" id="btn" value="GO">
			</div>
		</form>
		<span>${checkPwd }</span>
	</div>
</div>