<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
.container3{
	position: relative;
    left: 795px;
    bottom: auto;
    padding-top: 10px;
}
</style>
<!-- 게시판 -->
<div class="container">
	<table class="table table-striped">
		<thead>
			<tr>
				<td>No.</td>
				<td>지점명</td>
				<td>지점장</td>
				<td>지점상태</td>
				<td>개설일</td>
		</thead>
		<tbody>
		<c:forEach var="vo" items="${list }">
			<tr>
				<td>${vo.branchNum }</td>
				<td>${vo.brName }</td>
				<td>${vo.memId }</td>
				<td>${vo.brStatus }</td>
				<fmt:formatDate value="${vo.brRegdate }" pattern="yyyy-MM-dd" var="brRegdate"/>
				<td>${brRegdate }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
<!-- 페이징 처리 -->
<div class="container2">
	<ul class="pagination justify-content-center" style="margin:20px 0">
		<c:forEach var="i" begin="${pu.startPageNum }" end="${pu.endPageNum }">
			<c:choose>
				<c:when test="${i==pu.pageNum }">
					<li class="page-item active"><a class="page-link" href="/projectAdmin/branch.do?pageNum=${i }&keyword=${keyword}">${i }</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link" href="/projectAdmin/branch.do?pageNum=${i }&keyword=${keyword}">${i }</a></li>				
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</ul>	
</div>
<!-- 검색 -->
<div class="container3">
<form class="form-inline" method="post" action="/projectAdmin/branch.do">
	<div class="input-group mb-3">
		<div class="input-group-prepend">
			<span class="input-group-text"><i class="fas fa-search"></i></span>
		</div>
		<input type="text" class="form-control" placeholder="검색어를 입력해주세요." name="keyword" value="${keyword }">
			<div class="input-group-btn">
				<button type="button" class="btn btn-secondary" type="submit">검색</button>
			</div>
	</div>
</form>
</div>
