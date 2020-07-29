<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" type="image/png"
	href="${cp }/resources/images/icons/favicon.ico" />
<link rel="stylesheet" type="text/css"
	href="${cp }/resources/vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${cp }/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="${cp }/resources/vendor/animate/animate.css">
<link rel="stylesheet" type="text/css"
	href="${cp }/resources/vendor/css-hamburgers/hamburgers.min.css">
<link rel="stylesheet" type="text/css"
	href="${cp }/resources/vendor/select2/select2.min.css">
<link rel="stylesheet" type="text/css"
	href="${cp }/resources/css/qna/util.css">
<link rel="stylesheet" type="text/css"
	href="${cp }/resources/css/qna/main.css">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
		<div class="container-contact2">
				<span class="contact2-form-title"> 자주하는 질문목록 </span>
				<p></p>
				<table class="table table-dark table-striped" style="color: black;text-align: center;">
					<thead>
						<tr>
							<th style="width: 56px;">번호</th>
							<th>질문</th>
							<th>답변</th>
							<th style="width: 56px;">수정</th>
							<th style="width: 56px;">삭제</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="vo" items="${list }">
							<tr>
								<td>${vo.qnaNum }</td>
								<td>${vo.qnaTitle }</td>
								<td>${vo.qnaContent }</td>
								<td><a href="${cp }/service/qna/delete.do?qnaNum=${vo.qnaNum}">삭제</a></td>
								<td><a href="${cp }/service/qna/update.do?qnaNum=${vo.qnaNum}">수정</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<c:forEach var="i" begin="${pu.startPageNum }"
					end="${pu.endPageNum }">
					<button type="button" class="btn btn-dark"
					onclick="location.href='${cp }/service/qna/list.do?pageNum=${i}'">[${i }]</button>
				</c:forEach>
				<span></span>
				<span></span>
				<button type="button" class="btn btn-dark"
					onclick="location.href='${cp}/service/qna/insert.do'">질문추가하기</button>
			</div>
	</div>
</div>