<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width-device-width", initial-scale="1">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/jumbotron.css">
<link rel="stylesheet" href="resources/css/custom.css">

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

		<!-- Main -->
			<section id="main" class="wrapper">
				<div class="container">

					<header class="major">
						<h2>R - Cube</h2>
						<p>기술 창업 학회</p>
					</header>

					<p>R-cube란 ‘Revolutionary Reverse engineering Research'이며 여기서 reverse engineering은 기존의 프로그램을 거꾸로 분석해 아이디어와 노하우를 추출하여 기술향상과 창조를 추구하는 프로그램 행위를 말한다.  ’Revolutionary Reverse engineering Research'의 세 개의 R과 cube의 세제곱이라는 뜻에서 착안하여 혁명적인 Reverse engineering을 연구하는 팀 R-cube라는 의미가 있다. R-cube는 2001년도에 만들어 졌으며 현재 소프트웨어개발1팀, 소프트웨어개발2팀, 하드웨어개발팀, 기술전략팀 4개 부서로 나뉘어 학회 구성원들이 세미나와 회의를 통해 서로 협력하여 학회 구성원들의 IT관련 역량을 높이고 있다. </p>
					<p>21세기는 창업의 전성시대라고 해도 과언이 아닐 만큼 모든 사람들에게 창업은 꿈이자 희망이 되어버렸습니다.
					특히나 요즘 젊은 청년들은 취업과 창업이라는 갈림길에서 수많은 방황과 고민을 하면서 살아가고 있습니다.
					이러한 사회적 배경에 맞추어 본동아리는 디지털공학이라는 전공 속에서 배우는 지식들을 기초로 하여
					소속 학과 학생들이 어울려 만든 창업 동아리입니다. 현재 관련 세미나 등의 심화/예비학습 및 실무에 대한
					자체소규모 프로젝트로 기초적인 능력을 키우고 임베디드 시스템 관련 아이템 개발을 중심으로 활동하고있으며
					실제 창업행사에 적극적으로 참여함으로써 실전 경험을 쌓아가고 있습니다.
					나아가 실제 창업을 꿈꿔 볼 수도 있는 체계적인 시스템을 준비하고 있습니다.
					또한, 철저한 구성원간의 역할분담과 단순한 동아리가 아닌 실제 벤처 사업체에 근접한 조직구성을 통해
					책임감 있고 역량 있는 벤처 인력을 양성해 나가며, 미래에 대한 자신감으로 끊임없이 노력하며 배워나가는
					실력 있는 창업동아리입니다.</p>
					
					<br/><br/>
					<header class="align-center">
						<h3>- 활동 및 실적 -</h3>
					</header>
					<p>대한민국 창업대전 은상 창업동아리 지원사업<br/>
					BRICs 참가<br/>
					경기지역 창업동아리연합(KOSEN) 정회원<br/>
					선진벤처 해외연수 프로그램 참가<br/>
					KT&G 한중일 대학생 창업아이템 교류전 참가<br/>
					KT Venture Award 동상<br/>
					LG Global Challenger 참가 대학연합 창업아이디어 경진대회 동상, 장려상<br/>
					2학기 정기 C 세미나 참가 임베디드 소프트웨어 공모대전 본선 진출<br/>
					2008 대한민국 창업대전 참가<br/>
					IT 프로젝트 학술제 참가<br/>
					알고리즘 프로젝트 참여 (신찬수 교수님)<br/><br/>
					지식경제부 이브와 멘토링 IT 프로젝트 전국 3위 동상 수상 (2013)<br/>
					중소기업청 대학창업동아리 컨퍼런스 참가 (2013)<br/>
					임베디드 소프트웨어 경진대회 2팀 본선 진출 (2013)<br/>
					취업동아리 지원사업 참가 (2013)<br/>
					서울시 청년사업 프로젝트 본선진출 (2013)<br/>
					제 1회 현대 엠엔소프트 아이디어 공모전 참가 (2013)<br/>
					한국외대 창업아이디어 경진대회 우수상 2팀, 장려상 2팀 (2013)<br/>
					삼성SDS S/W동아리 챔피언쉽 본선 진출 (2013)<br/>
					제 8회 대학연합창업경진대회 우수상 수상 (2013)<br/>
					무역협회 글로벌 창업아이디어 공모전 참가 (2013)<br/>
					순천향대학교 사회적기업 창업경진대회 최우수상 (2013)<br/>
					대국민 IT 아이디어 창업지원 프로젝트 대상 (2013)<br/>
					창조경제 전국 대학생 스타트업 경진대회 대상 (2013)<br/>
					전국 대학생 ERICA 스타트업 경진대회 대상 (2013)<br/><br/>
					지식경제부 이브와 멘토링 IT 프로젝트 참가 (2015)<br/>
					대학창의 발명대회 참가 (2015)<br/>
					2015 청소년 발명경진대회 지원 (2015)<br/>
					컴퓨터전자시스템공학부 창업준비반 2팀 선정 (2015)<br/>
					교내창업아이디어경진대회 5팀 참가 (2015)<br/>
					용인시 창업아이디어 경진대회 최우수상, 우수상, 장려상 (2015)<br/>
					교내 앱 아이디어 경진대회 참가(2015)<br/>
					교내 창업아이디어 경진대회 본선 진출 (2015)<br/><br/>
					지식경제부 이브와 멘토링 IT 프로젝트 최종 본선 진출 (2016)<br/>
					HUFS 주관 튜터링 프로젝트 2팀 선정 (2016)<br/>
					Microsoft – JA KOREA Be a coding hero 참가 (2016)<br/>
					KOICA 주관 월드 프렌즈 IT 해외봉사 참가 (2016)<br/>
					안드로이드 다이어리 App 개발(2016)<br/>
					Unity3D 실시간 대전 게임 개발(2016)<br/>
					NOKNOK 게임회사 인턴십(2016)<br/><br/>
					SK청년비상 창업대회 팀[해트트릭] 최우수상(2017)<br/>
					안드로이드 풋살매니저 앱 출시(2017)<br/>
					용인시 창업아이디어 경진대회 최우수상(2017)<br/></p>
				</div>
			</section>
      
      	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>
