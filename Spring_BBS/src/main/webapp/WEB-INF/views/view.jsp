<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
								<li><a href="list">공지사항</a></li>
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
											<th colspan="3" style="background-color: #eeeeee; text-align: center;">게시판 글 보기</th>
									</tr>
							</thead>
							<tbody>
									
									<tr>
											<td style="width: 20%;">글 제목</td>
											<td colspan="2">${view.bbsTitle}</td>										
									</tr>		
									<tr>
											<td>작성자</td>
											<td colspan="2">${view.userEmail}</td>										
									</tr>		
									<tr>
											<td>작성일자</td>
											<td colspan="2">${view.bbsCreated}</td>										
									</tr>
									<tr>
											<td>내용</td>
											<td colspan="2" style="min-height: 200px; text-align: left;">${view.bbsContent}</td>
																					
									</tr>									
							</tbody>						
					</table>
					
	                   <div class="comments-list">
	                   		<c:forEach items="${list}" var="dto">
		                       <div class="media">
		                           <p class="pull-right"><small>5 days ago</small></p>
		                            <a class="media-left" href="#">
		                            </a>
		                            <div class="media-body">
		                              <strong>이현범</strong>
		                              <p>&nbsp;&nbsp;&nbsp;Wow! this is really great.</p>
		                            </div>
		                          </div>
	                          </c:forEach>
	                   </div>
					
					
					<form method="post" action="reply">
						<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
							<tbody>
									<tr>										
											<td><textarea class="form-control" placeholder="댓글을 적어주세요." name="bbsReply" maxlength="1024" style="height: 50px;"></textarea></td>
									</tr>
							</tbody>						
						</table>
						<input type="submit" class="btn btn-primary pull-right" value="댓글추가">
				
					</form>
					
					<form method="post" action="update">	
					<a href="list" class="btn btn-primary">목록</a>
						<c:if test="${sessionScope.id == view.userEmail}">
							<a href="update?bbsID=${view.bbsID}" class="btn btn-primary">수정</a>
							<a onclick="return confirm('정말로 삭제하시겠습니까?')" href="delete?bbsID=${view.bbsID}" class="btn btn-primary">삭제</a>
	    				</c:if>
    				</form>
    				
				</div>
		</div>
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>