<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container">
	<div class="bg-contact2">
		<h2>문의</h2>
		아이디 <input type="text" name="memId" value="${vo.memId }" readonly="readonly"><br>
		제목 <input type="text" name="qnaTitle" value="${vo.qnaTitle }" readonly="readonly"><br>
		내용 <input type="text" name="askContent" value="${vo.askContent }" readonly="readonly"><br>
		<textarea name="askContent" readonly="readonly" rows="5" cols="50">${vo.askContent }</textarea><br>
		<fmt:formatDate value="${vo.askRegdate }" pattern="yyyy-MM-dd" var="regdate"/>
		등록일 <input type="text" name="askRegdate" value="${regdate }" readonly="readonly"><br>
		<br>
		
		<h2>답변</h2>
		<c:choose>
			<c:when test="${vo1.replyNum > 0 }">
				<form method="post" action="${cp }/service/reply/update.do">
					<input type="hidden" name="askNum" value="${vo.askNum }">
					<input type="hidden" name="staffId" value="${vo.memId }">
					<input type="hidden" name="replyNum" value="${vo1.replyNum }">
					제목 <input type="text" name="qnaTitle" value="${vo1.qnaTitle }"><br> <!-- 답변 제목 -->
					내용 <textarea rows="5" cols="50" name="replyContent">${vo1.replyContent }</textarea><br> <!-- 답변 내용 -->
					<input type="submit" value="저장">
					<input type="button" value="돌아가기" onclick="location.href='${cp }/service/reply/askList.do'">
				</form>
			</c:when>
			<c:otherwise>
				<form method="post" action="${cp }/service/reply/insert.do">
					<input type="hidden" name="askNum" value="${vo.askNum }">
					<input type="hidden" name="staffId" value="${vo.memId }">
					제목 <input type="text" name="qnaTitle" value="${vo1.qnaTitle }"><br> <!-- 답변 제목 -->
					내용 <textarea rows="5" cols="50" name="replyContent">${vo1.replyContent }</textarea><br> <!-- 답변 내용 -->
					<input type="submit" value="저장">
					<input type="button" value="돌아가기" onclick="location.href='${cp }/service/reply/askList.do'">
				</form>
			</c:otherwise>
		</c:choose>
	</div>
</div>

	