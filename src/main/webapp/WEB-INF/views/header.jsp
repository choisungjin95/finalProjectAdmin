<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light shadow fixed-top">
  <div class="container">
   <a class="navbar-brand" href="${cp }/movieinfo/moviebox.do"> <img
		src="${cp}/resources/logo/logo.png" width="50" height="50">MegaCinema
	</a>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item active">
          <a class="nav-link" href="${cp }/movieinfo/moviebox.do">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${cp }/movieinfo/movie.do">영화 구매/판매</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${cp}/admin/income/moive.do">영화별 수익 및 누적관람객</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${cp}/admin/income/branch.do">지점별 수익 및 누적관람객</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${cp }/proposal/brManagement">지점관리</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${cp }/branch.do">상영상황 조회</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${cp}/service/service.do">고객센터</a>
        </li>
      </ul>
    </div>
  </div>
</nav>