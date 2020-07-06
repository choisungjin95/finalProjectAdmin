<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="${cp }/resources/css/qna/main.css">
<style>
	.question{
		padding: 50px;
	}
	#question a img{
		width: 400px;
	}
</style>
<div class="container">
	<div class="container-contact2">
		<div id="question">
			<a href="${cp }/service/reply/askList.do" class="question">
				<img alt="qna" src="${cp }/resources/images/qna.png">
			</a>
			<a href="${cp}/service/qna/list.do" class="question">
				<img alt="faq" src="${cp }/resources/images/faq.png">
			</a>
		</div>
	</div>
</div>