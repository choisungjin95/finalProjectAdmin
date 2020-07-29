<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="icon" type="image/png" href="${cp }/resources/images/icons/favicon.ico"/>
	<link rel="stylesheet" type="text/css" href="${cp }/resources/vendor/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${cp }/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="${cp }/resources/vendor/animate/animate.css">
	<link rel="stylesheet" type="text/css" href="${cp }/resources/vendor/css-hamburgers/hamburgers.min.css">
	<link rel="stylesheet" type="text/css" href="${cp }/resources/vendor/select2/select2.min.css">
	<link rel="stylesheet" type="text/css" href="${cp }/resources/css/qna/util.css">
	<link rel="stylesheet" type="text/css" href="${cp }/resources/css/qna/main.css">
<div class="bg-contact2">
	<div class="container-contact2">
		<div class="wrap-contact2">
			<form class="contact2-form validate-form" method="post" action="${cp }/service/qna/insertOk.do">
			<span class="contact2-form-title">
						질문 생성
					</span>

					<div class="wrap-input2 validate-input" data-validate="Name is required">
						<input class="input2" type="text" name="qnaTitle">
						<span class="focus-input2" data-placeholder="자주하는 질문"></span>
					</div>

					<div class="wrap-input2 validate-input" data-validate = "Message is required">
						<textarea class="input2" name="qnaContent"></textarea>
						<span class="focus-input2" data-placeholder="답변"></span>
					</div>

					<div class="container-contact2-form-btn">
						<div class="wrap-contact2-form-btn">
							<div class="contact2-form-bgbtn"></div>
							<button class="contact2-form-btn" style="margin-left: 212px; background: black;">
								등록하기
							</button>
						</div>
					</div>
			</form>
		</div>
	</div>
</div>