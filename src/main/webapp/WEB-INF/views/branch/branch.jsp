<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<style>
.container2{
	position: relative;
    left: 50%;
    padding-top: 0px;
    padding-bottom: 20px;
}
.container3{
	position: relative;
    left: 822px;
    bottom: 45px;
    padding-top: 10px;
}
</style>
<body>
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
<div class="container2">
	<ul class="pagination">
		<c:forEach var="i" begin="${pu.startPageNum }" end="${pu.endPageNum }">
			<c:choose>
				<c:when test="${i==pu.pageNum }">
					<li><a href="/projectAdmin/branch?pageNum=${i }">${i }</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="/projectAdmin/branch?pageNum=${i }">${i }</a></li>				
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</ul>	
</div>
<div class="container3">
 <div class="col-xs-2">
  <form method="post" action="/projectAdmin/branch">
    <div class="input-group">
    <span class="input-group-addon">검색</span>
      <input type="text" class="form-control" placeholder="검색어를 입력해주세요." name="keyword" value="${keyword }">
      <div class="input-group-btn">
        <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
      </div>
    </div>
  </form>
 </div>
</div>
</body>
</html>