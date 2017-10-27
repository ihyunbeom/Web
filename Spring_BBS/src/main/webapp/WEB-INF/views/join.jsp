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
								<li><a href="home">메인</a></li>
								<li><a href="list">게시판</a></li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
								<li class="dropdown">
										<a href="#" class="dropdown-toggle"
										data-toggle="dropdown" role="button" aria-haspopup="true"
										aria-expanded="false">접속하기<span class="caret"></span></a>
										<ul class="dropdown-menu">
												<li class="active"><a href="login">로그인</a></li>
												<li><a href="join">회원가입</a></li>
						</ul>
				</div>
		</nav>
		<div class="container">
				<div class="col-lg-4"></div>
				<div class="col-lg-4">
						<div class="jumbotron" style="padding-top: 20dp;">
								<form method="post" action="joinAction">
										<h3 style="text-alien: center;">회원가입 화면</h3>
										<div class="form-group">
												<input type="email" class="form-control" placeholder="이메일" name="userEmail" maxlength="20">
										</div>
										<div class="form-group">
												<input type="password" class="form-control" placeholder="비밀번호" name="userPassword" maxlength="20">
										</div>
										<div class="form-group">
												<input type="text" class="form-control" placeholder="이름" name="userName" maxlength="20">
										</div>
										<div class="form-group" style="text-align: center;">
												<div class="btn-group" data-toggle="buttons">
														<label class="btn btn-primary active">
																<input type="radio" name="userGender" autocomplete="off" value="남자" checked>남자</input>
														</label>
														<label class="btn btn-primary active">
																<input type="radio" name="userGender" autocomplete="off" value="여자" checked>여자</input>
														</label>
												</div>
										</div>										
										<div class="form-group">
												<input type="tel" class="form-control" placeholder="전화번호"  name="userTel" maxlength="20">
										</div>										
										<input type="submit" class="btn btn-primary form-control" value="회원가입">
								</form>
				</div>
		</div>
		<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
		<script src="resources/js/bootstrap.js"></script>
		
</body>
</html>