<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1 class="font-weight-light">최종관리자 입니다.</h1>
	<div>
		<div style="margin: auto;width: 80%;height: 80%;vertical-align: middle; border: 1px solid red;">
		<h1>비밀번호를 입력해주세요.</h1>
		<form action="${cp }/main.do" method="post">
			<input type="password" name="pwd">
			<input type="submit" value="확인하기.">
		</form>
		<span>${checkPwd }</span>
	</div>
</div>