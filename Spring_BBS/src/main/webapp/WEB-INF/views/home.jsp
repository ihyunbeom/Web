<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width-device-width", initial-scale="1">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/jumbotron.css">

<title>R-Cube 기술창업학회</title>
</head>
<body>
		<%
				String userID = null;
				if(session.getAttribute("id") != null){
					userID = (String) session.getAttribute("id");
				}
		%>
		<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
				<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
						aria-expanded="false">
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="home">R-Cube</a>
				</div>
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
								<li><a href="home">HOME</a></li>
								<li><a href="intro">학회소개</a></li>
								<li><a href="list?pageNumber=1">자유게시판</a></li>
						</ul>
						<%
								if(userID == null){
						%>
						<ul class="nav navbar-nav navbar-right">
								<li class="dropdown">
										<a href="#" class="dropdown-toggle"
										data-toggle="dropdown" role="button" aria-haspopup="true"
										aria-expanded="false">접속하기<span class="caret"></span></a>
										<ul class="dropdown-menu">
												<li><a href="login">로그인</a></li>
												<li><a href="join">회원가입</a></li>
										</ul>
								</li>
						</ul>
						<%
								}else{
						%>
						<ul class="nav navbar-nav navbar-right">
								<li class="dropdown">
										<a href="#" class="dropdown-toggle"
										data-toggle="dropdown" role="button" aria-haspopup="true"
										aria-expanded="false">회원관리<span class="caret"></span></a>
										<ul class="dropdown-menu">
												<li><a href="logoutAction">로그아웃</a></li>
										</ul>
								</li>
						</ul>
						<%
								}
						%>
				</div>
				</div>
		</nav>

		<div class="jumbotron banner">
				<div class="container">
						<h1>R - Cube</h1>
						<p>Revolutionary Reverse engineering Research</p>
						<p>기술 창업 학회</p>
						<!--  session id : ${id} -->
				</div>
		</div>

    <div class="container">
      <!-- Example row of columns -->
      <div class="row">
        <div class="col-md-4">
          <h3>2017년도 신입 학회원 모집</h3>
          <p>상시모집<br/>
			재학생/복학생 환영<br/>
			컴퓨터전자시스템공학부 A/B반 모두 가능<br/>
			문의전화: 010-6605-0703 (박선우)<br/>
			위치: 공학관 104-2호</p>
        </div>
        <div class="col-md-4">
          <h3>학회방 wifi 설치</h3>
          <p>
			와이파이 이름 : R-Cube<br/>
			비밀번호 : 학회장에게 문의</p>
       </div>
        <div class="col-md-4">
          <h3>학술제 팀원 모집</h3>
          <p>
          2017.10.01 ~ 2017.11.10<br/>
          신청 : 매주 수요일 회의시간</p>
        </div>
      </div>
      
      	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>
