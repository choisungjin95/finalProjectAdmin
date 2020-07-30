<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%-- <link href="${cp }/resources/assets/extra-libs/datatables.net-bs4/css/dataTables.bootstrap4.css" rel="stylesheet">
<link href="${cp }/resources/dist/css/style.min.css" rel="stylesheet"> --%>

<div class="card-body" style="width: 60%;height: 100%;margin: auto;">
    <div class="table-responsive">
        <div id="zero_config_wrapper" class="dataTables_wrapper container-fluid dt-bootstrap4">
        <div class="row"><div class="col-sm-12 col-md-6">
        <div class="dataTables_length" id="zero_config_length">
        </div></div></div><div class="row"><div class="col-sm-12">
        <h2 style="text-align: center">문의목록</h2>
        <table id="zero_config" class="table table-striped table-bordered no-wrap dataTable" role="grid" aria-describedby="zero_config_info">
            <thead>
                <tr>
					<th>아이디</th>
					<th>제목</th>
					<th>등록일</th>
					<th>답변상태</th>
					<th>답변하기</th>
				</tr>
            </thead>
            <tbody>
             <c:forEach items="${list }" var="list">
						<tr>
							<td>${list.memId }</td>
							<td>${list.qnaTitle }</td>
							<td>${list.askRegdate }</td>
							<td>${list.response }</td>
							<td><a href="${cp }/service/reply/getinfo.do?askNum=${list.askNum}">답변</a></td>
						</tr>
					</c:forEach>
                </tbody>
        </table>
        </div></div><div class="row">
        <div class="col-sm-12 col-md-5">
        </div>
        <div class="col-sm-12 col-md-7">
        <div class="dataTables_paginate paging_simple_numbers" id="zero_config_paginate">
        <ul class="pagination">
	        <c:choose>
				<c:when test="${pu.startPageNum>5}">
		        	<li class="paginate_button page-item previous" id="zero_config_previous">
			      	  <a href="${cp }/service/reply/askList.do?pageNum=${pu.startPageNum-1 }" aria-controls="zero_config" data-dt-idx="0" tabindex="0" class="page-link">이전</a>
			      	</li>
			    </c:when>
			</c:choose>
			
		        <c:forEach var="i" begin="${pu.startPageNum }" end="${pu.endPageNum }">
					<li class="paginate_button page-item active"><a href="${cp }/service/reply/askList.do?pageNum=${i}" aria-controls="zero_config" data-dt-idx="1" tabindex="0" class="page-link">[${i }]</a></li>
				</c:forEach>
				
		 	<c:choose>
				<c:when test="${pu.endPageNum<pu.totalPageCount}">
		        	<li class="paginate_button page-item next" id="zero_config_next">
		        		<a href="${cp }/service/reply/askList.do?pageNum=${pu.endPageNum+1 }" aria-controls="zero_config" data-dt-idx="7" tabindex="0" class="page-link">다음</a>
		        	</li>
			    </c:when>
			</c:choose>
		 
		
        </ul></div></div></div></div>
    </div>
</div>





