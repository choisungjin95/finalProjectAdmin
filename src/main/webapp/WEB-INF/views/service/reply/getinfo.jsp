<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
아이디 <input type="text" name="memId" value="${vo.memId }"><br>
제목 <input type="text" name="qnaTitle" value="${vo.qnaTitle }"><br>
내용 <input type="text" name="askContent" value="${vo.askContent }"><br>
등록일 <input type="text" name="askRegdate" value="${vo.askRegdate }"><br>

<form method="post" action="${cp }/service/reply/insert.do">
	<input type="hidden" name="askNum" value="${vo.askNum }">
	<input type="hidden" name="staffId" value="${vo.memId }">
	
	<input type="text" name="qnaTitle"> <!-- 답변 제목 -->
	<textarea rows="5" cols="50" name="replyContent"></textarea> <!-- 답변 내용 -->
	
	<input type="submit" value="답변달기">
</form>