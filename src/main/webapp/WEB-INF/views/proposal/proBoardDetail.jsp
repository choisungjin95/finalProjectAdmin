<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container" style="padding-top: 150px">
	<table class="table table-dark table-hover">
		<tr>
			<th>문의 아이디</th>
			<td>${proVo.memberId }</td>
		</tr>
		<tr>
			<th>문의 지점</th>
			<td>${proVo.proAddr }</td>
		</tr>
		<tr>
			<th>오픈 목적</th>
			<td>${proVo.proGoal }</td>
		</tr>
		<tr>
			<th>오픈 규모</th>
			<td>${proVo.proScale }</td>
		</tr>
		<tr>
			<th>진행 상태</th>
			<td>${proVo.proAddr }</td>
		</tr>
		<tr>
			<th>이전글</th>
			<td><a href="${cp }/proposal/proBoardDetail?proNum=${preVo.proNum}">${preVo.proAddr }</a></td>
		</tr>
		<tr>
			<th>다음글</th>
			<td><a href="${cp }/proposal/proBoardDetail?proNum=${nextVo.proNum}">${nextVo.proAddr }</a></td>
		</tr>
	</table>
</div>