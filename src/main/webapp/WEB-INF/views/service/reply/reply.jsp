<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h1>문의 내용</h1>
<div class="container">
	<table class="table table-bordered">
		<tr>
			<th>아이디</th>
			<th>제목</th>
			<th>등록일</th>
		</tr>
		<c:forEach items="${list }" var="list">
			<tr>
				<th>${list.memId }</th>
				<th><a href="${cp }/service/reply/getinfo.do?askNum=${list.askNum}">${list.qnaTitle }</a></th>
				<fmt:formatDate value="${list.askRegdate }" pattern="yyyy-MM-dd" var="regdate"/>
				<th>${regdate }</th>
			</tr>
		</c:forEach>
	</table>
</div>