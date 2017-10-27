<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width-device-width", initial-scale="1">
<link rel="stylesheet" href="resources/css/bootstrap.css">
<title>Spring 게시판 웹 사이트</title>
</head>
<body>
		<%
				String userID = null;
				if(session.getAttribute("id") != null){
					userID = (String) session.getAttribute("id");
				}		
		%>
		<nav class="navbar navbar-default">
				<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed" 
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" 
						aria-expanded="false">
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>		
						</button>
						<a class="navbar-brand" href="home">JSP 게시판 웹 사이트</a>
				</div>
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
								<li><a href="home">HOME</a></li>
								<li><a href="list">게시판</a></li>
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
		</nav>
		
		<div class="container">
				<div class="jumbotron">
						<div class="container">
								<h1>웹 사이트 소개</h1>
								<p>Spring 웹 사이트입니다.</p>
								<p><a class="btn btn-primary btn-pull" href="#" role="button">자세히 알아보기</a></p>								
								
								session id : ${id}
						</div>
				</div>
		
		</div>
		
		<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
		<script src="resources/js/bootstrap.js"></script>
</body>
</html>