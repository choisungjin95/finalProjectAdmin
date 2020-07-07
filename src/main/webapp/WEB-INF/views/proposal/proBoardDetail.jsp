<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container" style="padding-top: 150px">
	<form action="${cp }/proposal/approved" method="post">
		<input type="hidden" name="proNum" vaLue="${proVo.proNum }">
		<table class="table table-dark table-hover">
			<tr>
				<th>문의 아이디</th>
				<td>${proVo.memberId }<input type="hidden" name="memberId"
					vaLue="${proVo.memberId }"></td>
			</tr>
			<tr>
				<th>문의 지점</th>
				<td>${proVo.proAddr }<input type="hidden" name="proAddr"
					vaLue="${proVo.proAddr }"></td>
			</tr>
			<tr>
				<th>오픈 목적</th>
				<td>${proVo.proGoal }<input type="hidden" name="proGoal"
					vaLue="${proVo.proGoal }"></td>
			</tr>
			<tr>
				<th>오픈 규모</th>
				<td>${proVo.proScale }<input type="hidden" name="proScale"
					vaLue="${proVo.proScale }"></td>
			</tr>
			<tr>
				<th>진행 상태</th>
				<td>${proVo.proStatus }<input type="hidden" name="proStatus"
					vaLue="${proVo.proStatus }"></td>
			</tr>

			<tr>
				<th>이전글</th>
				<td><a
					href="${cp }/proposal/proBoardDetail?proNum=${preVo.proNum}">${preVo.proAddr }</a></td>
			</tr>
			<tr>
				<th>다음글</th>
				<td><a
					href="${cp }/proposal/proBoardDetail?proNum=${nextVo.proNum}">${nextVo.proAddr }</a></td>
			</tr>
		</table>
		<div class="container">
			<c:choose>
				<c:when test="${proVo.proStatus=='대기중' }">
					<input type="submit" value="승인" class="btn btn-outline-dark">
					<input type="button" value="반려" class="btn btn-outline-dark"
						id="rejected"
						onclick="location.href='${cp}/proposal/rejected?proNum=${proVo.proNum }'">
				</c:when>

			</c:choose>
			<a href="${cp }/proposal/brManagement" class="btn btn-outline-dark">목록보기</a>
		</div>
	</form>
</div>