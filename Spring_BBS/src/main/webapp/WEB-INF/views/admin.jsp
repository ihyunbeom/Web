<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width-device-width", initial-scale="1">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/dashboard.css">

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
								<%
								if(userID != null){
									if(userID.equals("admin@admin")){
								%>
									<li><a href = "admin">관리자페이지</a>
								<%
									}
								}
								%>
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
		
		<div class="container-fluid">
	      <div class="row">
	        <div class="col-sm-3 col-md-2 sidebar">
	          <ul class="nav nav-sidebar">
	            <li class="active"><a href="#">Overview <span class="sr-only">(current)</span></a></li>
	            <li><a href="#">User</a></li>
	            <li><a href="#">Board</a></li>
	            <li><a href="#">Page</a></li>
	          </ul>
	        </div>
	        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	          <h1 class="page-header">Overview</h1>
	
	          <div class="row placeholders">
	            <div class="col-xs-6 col-sm-3 placeholder">
	            	<div class="panel">
			    67
	              <h4>총 회원수</h4>
	              </div>
	            </div>
	            <div class="col-xs-6 col-sm-3 placeholder">
	            	<div class="panel">
			    8
	              <h4>신규 가입자수</h4>
	              </div>
	            </div>
	            <div class="col-xs-6 col-sm-3 placeholder">
	            	<div class="panel">
			    32
	              <h4>총 게시물수</h4>
	              </div>
	            </div>
	            <div class="col-xs-6 col-sm-3 placeholder">
	            	<div class="panel">
			    130
	              <h4>총 접속자</h4>
	              </div>
	            </div>
	          </div>
	
	          <h2 class="sub-header">User info</h2>
	          <div class="table-responsive">
	            <table class="table table-striped">
	              <thead>
	                <tr>
	                  <th>ID</th>
	                  <th>Email</th>
	                  <th>Name</th>
	                  <th>Gender</th>
	                  <th>Tel</th>
	                  <th>Grade</th>
	                  <th>Created</th>
	                </tr>
	              </thead>
	              <tbody>
	              <%
	              for(int i=0;i<20;i++){
			 	  %>
	                <tr>
	                  <td>201202868</td>
	                  <td>bum4224@naver.com</td>
	                  <td>이현범</td>
	                  <td>남자</td>
	                  <td>01096914224</td>
	                  <td>0</td>
	                  <td>2017-11-10 11:53:41.0</td>
	                </tr>
	                <%
	              }
	                %>
	              </tbody>
	            </table>
	          </div>
	        </div>
	      </div>
	    </div>
      

      
      	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>
