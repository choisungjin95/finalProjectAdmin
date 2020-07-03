<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
<table class="table table-dark table-hover">
	<tr>
		<th>글번호</th>
		<th>지점명</th>
		<th>요청일</th>
		<th>상태</th>
		

	<tr>
		<c:forEach var="list" items="${list}">
			<tr>
			
				<th>${list.proNum }</th>
				<th>${list.proAddr }</th>
				<th>${list.proRegdate}</th>
				<th>${list.proStatus }</th>
			<tr>
		</c:forEach>
</table>
</div>