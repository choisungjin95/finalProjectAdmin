<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- This page plugin CSS -->
    <link href="${cp }/resources/assets/extra-libs/datatables.net-bs4/css/dataTables.bootstrap4.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="${cp }/resources/dist/css/style.min.css" rel="stylesheet">

<div class="card-body">
    <div class="table-responsive">
        <div id="zero_config_wrapper" class="dataTables_wrapper container-fluid dt-bootstrap4">
        <div class="row"><div class="col-sm-12 col-md-6">
        <div class="dataTables_length" id="zero_config_length">
        </div></div></div><div class="row"><div class="col-sm-12">
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
							<fmt:formatDate value="${list.askRegdate }" pattern="yyyy-MM-dd" var="regdate"/>
							<td>${regdate }</td>
							<td>${list.response }</td>
							<td><a href="${cp }/service/reply/getinfo.do?askNum=${list.askNum}">답변</a></td>
						</tr>
					</c:forEach>
                </tbody>
        </table>
        </div></div><div class="row"><div class="col-sm-12 col-md-5"><div class="dataTables_info" id="zero_config_info" role="status" aria-live="polite">Showing 1 to 10 of 57 entries</div></div><div class="col-sm-12 col-md-7"><div class="dataTables_paginate paging_simple_numbers" id="zero_config_paginate"><ul class="pagination"><li class="paginate_button page-item previous disabled" id="zero_config_previous"><a href="#" aria-controls="zero_config" data-dt-idx="0" tabindex="0" class="page-link">Previous</a></li><li class="paginate_button page-item active"><a href="#" aria-controls="zero_config" data-dt-idx="1" tabindex="0" class="page-link">1</a></li><li class="paginate_button page-item "><a href="#" aria-controls="zero_config" data-dt-idx="2" tabindex="0" class="page-link">2</a></li><li class="paginate_button page-item "><a href="#" aria-controls="zero_config" data-dt-idx="3" tabindex="0" class="page-link">3</a></li><li class="paginate_button page-item "><a href="#" aria-controls="zero_config" data-dt-idx="4" tabindex="0" class="page-link">4</a></li><li class="paginate_button page-item "><a href="#" aria-controls="zero_config" data-dt-idx="5" tabindex="0" class="page-link">5</a></li><li class="paginate_button page-item "><a href="#" aria-controls="zero_config" data-dt-idx="6" tabindex="0" class="page-link">6</a></li><li class="paginate_button page-item next" id="zero_config_next"><a href="#" aria-controls="zero_config" data-dt-idx="7" tabindex="0" class="page-link">Next</a></li></ul></div></div></div></div>
    </div>
</div>


