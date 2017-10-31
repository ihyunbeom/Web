<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width-device-width", initial-scale="1">
<link rel="stylesheet" href="resources/css/bootstrap.css">
<title>R-Cube 기술창업학회</title>
</head>
<body>
		<%
				String userID = null;
				if(session.getAttribute("id") != null){
					userID = (String) session.getAttribute("id");
				}		
		%>
		<nav class="navbar navbar-default">
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
				</div>
		</nav>
		session id : ${id}
		<div class="container">
				<div class="row">
						<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
								<thead>
										<tr>
												<th style="background-color: #eeeeee; text-align: center;">번호</th>
												<th style="background-color: #eeeeee; text-align: center;">작성자</th>
												<th style="background-color: #eeeeee; text-align: center;">제목</th>
												<th style="background-color: #eeeeee; text-align: center;">작성일</th>
										</tr>
								</thead>
								<tbody>
										<c:forEach items="${list}" var="dto">
										<tr>
											<td>${dto.bbsID}</td>
											<td>${dto.userEmail}</td>
											<td>												
												<a href="view?bbsID=${dto.bbsID}">${dto.bbsTitle}</a></td>
											<td>${dto.bbsCreated}</td>											
										</tr>
										</c:forEach>
								</tbody>
						</table>
						<%
								if(userID != null){
						%>
						<a href="write" class="btn btn-primary pull-right">글쓰기</a>
						<%
								}
						%>
				</div>
		</div>
		
		<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
		<script src="resources/js/bootstrap.js"></script>
</body>
</html>