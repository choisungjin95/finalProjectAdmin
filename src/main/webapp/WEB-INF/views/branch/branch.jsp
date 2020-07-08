<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link rel="stylesheet" href="//cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.21/js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
	    $('#branch').DataTable({
		  order: [[0, "desc"]], // asc 또는 desc
		  lengthChange: false,
		  ordering: true,
		  info: false,
		  paging: false,
		  scrollX: true,
		  scrollY: 550,
		  columnDefs: [
				// 2번째 항목 넓이를 100px로 설정
				{ targets: 0, width: 150 },
				{ targets: 1, width: 200 },
				{ targets: 2, width: 240 },
				{ targets: 3, width: 250 },
				{ targets: 4, width: 250 }]
		});
	});
</script>
</head>
<style>
	.container3{
		position: relative;
	    left: 795px;
	    bottom: 13px;
	    padding-top: 0px;
	}
</style>
<!-- 게시판 -->
<body>
<div class="container">
	<table id="branch" class="table table-striped" style="width:100%">
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
</body>
</html>