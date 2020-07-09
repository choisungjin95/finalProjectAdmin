<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="${cp }/resources/js/jquery-3.5.1.js"></script>
<div class="container" style="padding-top: 150px">
	
	<form action="${cp }/proposal/approved" method="post" onsubmit="return showMsg('true')">
		<input type="hidden" name="proNum" value="${proVo.proNum }">
		<table class="table table-dark table-hover">
			<tr>
				<th>문의 아이디</th>
				<td>${proVo.memberId }<input type="hidden" name="memberId"
					value="${proVo.memberId }"></td>
			</tr>
			<tr>
				<th>문의 지점</th>
				<td>${proVo.proAddr }<input type="hidden" name="proAddr"
					value="${proVo.proAddr }"></td>
			</tr>
			<tr>
				<th>오픈 목적</th>
				<td>${proVo.proGoal }<input type="hidden" name="proGoal"
					value="${proVo.proGoal }"></td>
			</tr>
			<tr>
				<th>오픈 규모</th>
				<td>${proVo.proScale }<input type="hidden" name="proScale"
					value="${proVo.proScale }"></td>
			</tr>
			<tr>
				<th>진행 상태</th>
				<td>${proVo.proStatus }<input type="hidden" name="proStatus"
					value="${proVo.proStatus }"></td>
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
					<input type="submit" value="승인" class="btn btn-outline-dark" name="btn_approval">
					<input type="button" value="반려" class="btn btn-outline-dark" id="rejected" name="btn_reject"
						onclick="showMsg('false')">
				</c:when>

			</c:choose>
			<a href="${cp }/proposal/brManagement" class="btn btn-outline-dark">목록보기</a>
		</div>
	</form>
</div>
	<script type="text/javascript">
	function showMsg(e){
		if(e=='true'){
			alert("승인되었습니다.");
			//location.href='${cp}/proposal/approved?proNum=${proVo.proNum }';
			return true;
		}else{
			alert("반려되었습니다");
			location.href='${cp}/proposal/rejected?proNum=${proVo.proNum }';
		}
	};
	</script>