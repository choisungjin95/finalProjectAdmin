<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script>
	function sendPageNum(i){
		location.href='http://localhost:9090${cp }/proposal/brManagement?pageNum=${i}';
	}
</script>
<div class="container" style="padding-top: 150px">
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
					<th><a
						href="${cp }/proposal/proBoardDetail?proNum=${list.proNum }">${list.proAddr }</a></th>
					<fmt:formatDate value="${list.proRegdate }" pattern="yy-MM-dd"
						var="date" />
					<th>${date }</th>
					<th>${list.proStatus }</th>
				<tr>
			</c:forEach>
	</table>


	<div id="paging" class="container">
		<c:forEach var="i" begin="${pu.startPageNum }" end="${pu.endPageNum}">
			<c:choose>
				<c:when test="${pu.pageNum == i}">
				<a href="${cp }proposal/brManagement?pageNum=${i}"><button type="button" 
				class="btn btn-outline-dark" style="font-weight: bold">${i }</button></a>

				</c:when>
	
				<c:otherwise>
				<a href="${cp }/proposal/brManagement?pageNum=${i}"><button type="button" 
				class="btn btn-outline-dark" style="color: blue">${i }</button></a>

				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:choose>
			<c:when test="${pu.endPageNum<pu.totalPageCount}"><span class="btn btn-outline-dark"><a href="">다음</a></span></c:when>
		</c:choose>
	</div>
</div>