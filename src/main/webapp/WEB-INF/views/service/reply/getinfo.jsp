<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<div class="container">
	<div class="bg-contact2">
		<h2 style="text-align: center">문의</h2>
		<table border="1" width="500" class="table table-striped table-bordered no-wrap dataTable" role="grid" aria-describedby="zero_config_info">
			<thead>
				<tr>
					<th>제목</th>
						<td>${vo.qnaTitle }</td>
					<th>아이디</th>
						<td>${vo.memId }</td>
					<th>문의일</th>
						<%-- <fmt:formatDate value="${vo.askRegdate }" pattern="yyyy-MM-dd" var="regdate"/> --%>
						<td>${vo.askRegdate }</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>내용</th>
					<td colspan="5">${vo.askContent }</td>
				</tr>
			</tbody>
		</table>

		<h2 style="text-align: center">답변</h2>
		<c:choose>
			<c:when test="${vo1.replyNum > 0 }">
				<form method="post" action="${cp }/service/reply/update.do">
					<input type="text" name="askNum" value="${vo.askNum }">
					<input type="text" name="staffId" value="${vo.memId }">
					<input type="text" name="replyNum" value="${vo1.replyNum }">
					<label for="qnaTitle">제목</label>
					<input type="text" name="qnaTitle" value="${vo1.qnaTitle }" class="form-control" id="qnaTitle"><br> <!-- 답변 제목 -->
					<label for="replyContent">내용</label>
					<textarea rows="5" cols="50" name="replyContent" class="form-control" id="replyContent">${vo1.replyContent }</textarea><br> <!-- 답변 내용 -->
					<input type="submit" value="저장" class="btn btn-primary">
					<input type="button" value="돌아가기" onclick="history.go(-1)" class="btn btn-primary">
				</form>
			</c:when>
			<c:otherwise>
				<form method="post" action="${cp }/service/reply/insert.do">
					<div class="form-group">
						<input type="hidden" name="askNum" value="${vo.askNum }">
						<input type="hidden" name="staffId" value="${vo.memId }">
						<label for="qnaTitle">제목</label>
						<input type="text" name="qnaTitle" class="form-control" id="qnaTitle"><br> <!-- 답변 제목 -->
						<label for="replyContent">내용</label>
						<textarea rows="5" cols="50" name="replyContent" class="form-control" id="replyContent"></textarea><br> <!-- 답변 내용 -->
						<input type="submit" value="저장" class="btn btn-primary">
						<input type="button" value="돌아가기" onclick="history.go(-1)" class="btn btn-primary">
					</div>
				</form>
			</c:otherwise>
		</c:choose>
	</div>
</div>

	