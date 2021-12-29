<%@page import="com.model.scoreDAO"%>
<%@page import="com.model.memberDAO"%>
<%@page import="com.model.conDetailDAO"%>
<%@page import="com.model.postVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model.conDetailVO"%>
<%@page import="com.model.memberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="zxx">
<%
memberVO memberInfo = (memberVO) session.getAttribute("loginMemberSession");
%>
<%
conDetailDAO contestDAO = new conDetailDAO();
ArrayList<conDetailVO> conArr = contestDAO.calList();

conDetailVO contest100 = contestDAO.selectCon(100);
conDetailVO contest90 = contestDAO.selectCon(90);
conDetailVO contest50 = contestDAO.selectCon(50);

memberDAO DAO =new memberDAO();
ArrayList<Integer> level=DAO.topLevel();
scoreDAO sDAO=new scoreDAO();

memberVO anotherMemberInfo=null;

// 공모전 ArrayList에 담아 가져와서!
%>
<head>
<meta charset="UTF-8">
<meta name="description" content="Aler Template">
<meta name="keywords" content="Aler, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>깔꼼</title>

<!-- 켈린더 -->
<!-- jquery CDN -->
<script src="https://code.jquery.com/jquery-3.6.0.slim.js"></script>
<script src="jquery-3.6.0.min.js"></script>
<!-- fullcalendar CDN -->
<link
	href='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.css'
	rel='stylesheet' />
<script
	src='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.js'></script>
<!-- fullcalendar 언어 CDN -->
<script
	src='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/locales-all.min.js'></script>

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,600,700,800,900&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Lato:400,700,900&display=swap"
	rel="stylesheet">

<!-- Css Styles -->
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
<link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
<link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
<link rel="stylesheet" href="css/nice-select.css" type="text/css">
<link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
<link rel="stylesheet" href="css/magnific-popup.css" type="text/css">
<link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
<link rel="stylesheet" href="css/style.css" type="text/css">
<style>
.imgPadding {
	padding-left: 10%;
	padding-right: 10%;
}
</style>
</head>

<body>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>

	<!-- Offcanvas Menu Wrapper Begin -->
	<div class="offcanvas-menu-overlay"></div>
	<div class="offcanvas-menu-wrapper">
		<div class="canvas-close">
			<span class="icon_close"></span>
		</div>
		<div class="logo">
			<a href="./index.html"> <img src="img/logo/kka1.png" alt="">
			</a>
		</div>
		<div id="mobile-menu-wrap"></div>
		<div class="om-widget">
			<%
			if (memberInfo != null) {
				out.print("<a href='loginJSP.jsp' class='hw-btn'><img src='img/logo/loginOff.png' id='loginBtn'></a>");
			} else {
				out.print("<a href='loginJSP.jsp' class='hw-btn'><img src='img/logo/logoutOff.png' id='logoutBtn'></a>");
			}
			%>

		</div>

	</div>
	<!-- Offcanvas Menu Wrapper End -->

	<!-- 헤드 시작 -->
	<header class="header-section" style="margin: 0px">
		<div
			style="background-image: url('img/mainTopBig.png'); width: 2000px; height: 155px;">
			<div class="hs-top" style="margin-top: 0px; height: 165px;">
				<div class="container">
					<div class="ten" style="padding: 1px">
						<div class="logo">
							<a href="./mainPageJSP.jsp"><img src="img/logo/mainLogo.png"
								style="margin-top: 10px"></a>
						</div>
						<nav class="nav-menu">
							<%
							if (memberInfo == null) {
								out.print(
								"<a href='./LoginJSP.jsp' style='margin-left:90%;' id='loginBtn'><img src='img/logo/loginOff.png' width='180px' height='32px' style='margin-top:25px'></a>");
							} else if (memberInfo != null) {
								out.print(
								"<a href='./LogoutJSP.jsp' style='margin-left:95%;' id='logoutBtn'><img src='img/logo/logoutOff.png' width='110px' height='32px' style='margin-top:25px'></a>");
							}
							%>
							<ul style="text-align: center; margin-left: 7%;">
								<li style="font-size: 10px"><a href="./mainPageJSP.jsp"
									style="color: #ffffff;">메인</a></li>
								<li><a href="#" style="color: #ffffff;">마이페이지</a>
									<ul class="dropdown"
										style="display: inline-block; width: 150px;">
										<li style="margin-right: 40%"><a
											href="./mypageProfileJSP.jsp">내정보</a></li>
										<li style="margin-right: 28%"><a
											href="./mypageContestJSP.jsp">내 공모전</a></li>
										<li style="margin-right: 38%"><a
											href="./mypageTeamJSP.jsp">나의 팀</a></li>
										<li style="margin-right: 40%"><a
											href="./mypageMessageJSP.jsp">쪽지함</a></li>
									</ul></li>
								<li><a href="./ContestBoard.jsp" style="color: #ffffff;">공모전</a></li>
								<li><a href="./teamBoardJSP.jsp" style="color: #ffffff;">팀원모집</a></li>
							</ul>
						</nav>
					</div>
				</div>
				<div></div>
			</div>
		</div>
		<div class="canvas-open">
			<span class="icon_menu"></span>
		</div>
		<div
			style="padding: 48px; background-color: #4169E1; box-shadow: 1px 1px gray; width: 2000px">
			<div class="pcntSearchText"
				style="margin-left: 33%; width: 600px; border: 2px solid #1b5ac2; background: #ffffff;">
				<form action="searchService">
					<input class="textBar" type="text" placeholder="원하는 공모전 검색!"
						style="font-size: 16px; width: 500px; height: 100%; padding: 10px; border: 0px; outline: none;"
						name="search">
					<button class="search"
						style="width: 90px; height: 40px; border: 0px; background: #1b5ac2; outline: none; float: right; color: #ffffff">검색</button>
				</form>
			</div>
		</div>
	</header>
	<!-- 헤드 끝 -->

	<!-- Hero Section Begin -->
	<section class="hero-section"
		style="width: 1100px; height: 700px; margin: 40px 0px 0px 440px; position: relative;">
		<div class="container" style="width: 650px;">
			<div class="hs-slider owl-carousel">
				<div class="hs-item set-bg">
					<a href="#"><img src="<%=contest100.getConPostBig()%>"></a>
				</div>
				<div class="hs-item set-bg">
					<a href="#"><img src="<%=contest90.getConPostBig()%>"></a>
				</div>
				<div class="hs-item set-bg">
					<a href="#"><img src="<%=contest50.getConPostBig()%>"></a>
				</div>
			</div>
		</div>
	</section>
	<!-- Hero Section End -->

	<!-- calendar Section Begin -->
	<div class="calbul" style="margin-top: 30px">
		<div class="cal-left">
			<div class="calendar" style="margin-left: 430px; margin-top: 70px;">
				<div class="section-title" style="margin-left: 10px">
					<h5>공모전 일정</h5>
					<!-- calendar 태그 -->
					<div id='calendar-container'
						style="margin-top: 10px; padding: 20px; width: 550px; margin-left: -15px">
						<div id='calendar'></div>
					</div>
					<script>
   (function(){
             $(function(){
               // calendar element 취득
               var calendarEl = $('#calendar')[0];
               // full-calendar 생성하기
               var calendar = new FullCalendar.Calendar(calendarEl, {
                 height: '495px', // calendar 높이 설정
                 expandRows: true, // 화면에 맞게 높이 재설정
                 slotMinTime: '08:00', // Day 캘린더에서 시작 시간
                 slotMaxTime: '20:00', // Day 캘린더에서 종료 시간
                 // 해더에 표시할 툴바
                 headerToolbar: {
                   left: 'prev,next today',
                   center: 'title',
                   right: 'dayGridMonth,timeGridWeek,timeGridDay,listWeek'
                 },
              initialView: 'dayGridMonth', // 초기 로드 될때 보이는 캘린더 화면(기본 설정: 달)
                 initialDate: '2021-10-22', // 초기 날짜 설정 (설정하지 않으면 오늘 날짜가 보인다.)
                 navLinks: true, // 날짜를 선택하면 Day 캘린더나 Week 캘린더로 링크
                 editable: true, // 수정 가능?
                 selectable: true, // 달력 일자 드래그 설정가능
                 nowIndicator: true, // 현재 시간 마크
                 dayMaxEvents: true, // 이벤트가 오버되면 높이 제한 (+ 몇 개식으로 표현)
                 locale: 'ko', // 한국어 설정
                 eventAdd: function(obj) { // 이벤트가 추가되면 발생하는 이벤트
                   console.log(obj);
                 },
                 eventChange: function(obj) { // 이벤트가 수정되면 발생하는 이벤트
                   console.log(obj);
                 },
                 eventRemove: function(obj){ // 이벤트가 삭제되면 발생하는 이벤트
                   console.log(obj);
                 },
                 select: function(arg) { // 캘린더에서 드래그로 이벤트를 생성할 수 있다.
                   var title = prompt('Event Title:');
                   if (title) {
                     calendar.addEvent({
                       title: title,
                       start: arg.start,
                       end: arg.end,
                       allDay: arg.allDay
                     })
                   }
                   calendar.unselect()
                 },
                 // 이벤트 
                 
        // 
        events: [
          
        ]
      });

       // 여기서 이벤트 추가s

      		<%for (int i = 0; i < conArr.size(); i += 5) {%>
      			     calendar.addEvent({
				         title: '<%=conArr.get(i).getConName()%>',
				         start: '<%=conArr.get(i).getConFromDate()%>',
				         end: '<%=conArr.get(i).getConToDate()%>'
										})
					<%}%>
						// 캘린더 랜더링
								calendar.render();
							});

						})();
					</script>
				</div>
				<div id='calendar-container'>
					<div id='calendar'></div>
				</div>
			</div>
		</div>



		<div class="cal-right">
			<div class="moim">
				<div class="section-title" style="margin-left: -60px">
					<h5>불타는 모임</h5>
				</div>

				<section class="agent-section spad">
					<div class="container"
						style="margin-left: -70px; margin-top: -110px">
						<div class="as-slider owl-carousel">
							<div class="row">
								<div class="as-item1" style="padding-right: 5px">
									<div class="as-item"
										style="box-shadow: 2px 3px 8px 0px gray; width: 190px;">
										<div class="as-pic">
											<img src="img/hero/gong1.jpg" alt="">
										</div>
										<div class="as-text">
											<div class="at-title">
												<h6></h6>
											</div>
											<ul>
												<li>제목 <span>215</span></li>
												<li>팀장 <span>0</span></li>
												<li>팀 인원 <span>1/4</span></li>
											</ul>
										<a href="#" class="primary-btn">지원하기</a>
										</div>
									</div>
								</div>
								<div class="row"></div>
								<div class="as-item2" style="padding-right: 5px">
									<div class="as-item"
										style="box-shadow: 2px 3px 8px 0px gray; width: 190px;">
										<div class="as-pic">
											<img src="img/hero/gong2.jpg" alt="">
										</div>
										<div class="as-text">
											<div class="at-title">
												<h6></h6>
											</div>
											<ul>
												<li>Property <span>215</span></li>
												<li>팀장 <span>닉네임</span></li>
												<li>팀 인원 <span>2/4</span></li>
											</ul>
											<a href="#" class="primary-btn">지원하기</a>
										</div>
									</div>
								</div>
								<div class="row"></div>
								<div class="as-item3">
									<div class="as-item"
										style="box-shadow: 2px 3px 8px 0px gray; width: 190px;">
										<div class="as-pic">
											<img src="img/hero/gong3.jpg" alt="">
										</div>
										<div class="as-text">
											<div class="at-title">
												<h6></h6>

											</div>
											<ul>
												<li>Property <span>215</span></li>
												<li>팀장 <span>닉네임</span></li>
												<li>팀 인원 <span>3/4</span></li>
											</ul>
											<a href="#" class="primary-btn">지원하기</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</section>
			</div>
		</div>
	</div>




	<!-- calendar Section End -->

	<!-- Team Section Begin -->
	<section class="team-section spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-md-8">
					<div class="section-title" style="margin-left: 60px">
						<h4>이달의 랭킹</h4>
					</div>
				</div>
			</div>
			<div class="row" style="margin-left: 50px">
				<%for(int i=0;i<3;i++){
			anotherMemberInfo=DAO.getMemberInfo(level.get(i));
			%>
				<div class="col-md-4">
					<div class="ts-item">
						<div class="ts-text">
							<p style="color: red"><%=level.get(i) %></p>
							<%if (level.get(i) > 66) {%>
							<img src='img/tiger/tiger03.png'>
							<%} else if (level.get(i) < 66 && level.get(i) > 33 ) { %>
							<img src='img/tiger/tiger02.png'>
							<%} else if ( level.get(i) < 33) {%>
							<img src='img/tiger/tiger01.png'>
							<%} %>
							<h5><%=anotherMemberInfo.getMemNickName() %></h5>
							<span><%=anotherMemberInfo.getMemHi() %></span> <span>평점:<%=sDAO.showScore(anotherMemberInfo.getMemId()) %></span>
							<p><%=anotherMemberInfo.getMemEmail() %></p>
						</div>
					</div>
				</div>
				<%} %>
				<!-- <div class="col-md-4">
					<div class="ts-item">
						<div class="ts-text">
							<p style="color: red">level:76</p>
							<img src="img/tiger/tiger02.png" alt="">
							<h5>닉네임</h5>
							<span>인사말</span> <span>평점</span>
							<p>공모전 수상 내역</p>
						</div>
					</div>
				</div>
				<div class="col-md-4">
					<div class="ts-item">
						<div class="ts-text">
							<p style="color: red">level:22</p>
							<img src="img/tiger/tiger01.png" alt="">
							<h5>닉네임</h5>
							<span>인사말</span> <span>평점</span>
							<p>공모전 수상 내역</p>
						</div>
					</div>
				</div> -->
			</div>
		</div>
	</section>
	<!-- Team Section End -->



	<!-- Footer Section Begin -->
	<footer>
		<div id="footer"
			style="background-color: rgb(44, 44, 44); clear: both; height: 350px;">
			<div class="footer">
				<h1>
					<a href="./mainPageJSP.jsp"> <imag src="img/logo/mainLogo.png"
							alt="logo"></a>
				</h1>
				<div id="footer-area">
					<div style="margin-left: 10%; color: #fff;">
						<br>
						<p>
							<span style="font-family: dotum; font-size: 25px"> <strong>
									(주) 깔꼼 </strong>
							</span>
						</p>
						<p>
							<span style="font-size: 20px"> <span
								style="font-family: dotum"> 대표 : 애벌레
									&nbsp;&nbsp;&nbsp;&nbsp; 주소 : 광주광역시 스마트인재개발원 <br> 공모전 제휴
									문의 : eberle@naver.com &nbsp;&nbsp; 마케팅 제휴 : eberle@naver.com <br>
									홍보문의 : eberle@naver.com <br> 고객문의:eberle@naver.com /
									1555-1555(09:00~18:00) <br> 사업자등록번호 : 000-00-0000 | tel:
									1588-1588&nbsp; <br> <br> ㈜깔꼼은 통신판매중개자로서 통신판매의 당사자가
									아닙니다. 따라서, 등록된 공모전 및 활동에 대하여 ㈜깔꼼은 어떠한 책임도 지지 않습니다. <br>
									Copyright © kakaostyle Corp. All rights reserved
							</span>
							</span>
						</p>

					</div>
				</div>
			</div>
		</div>
	</footer>
	<!-- Footer Section End -->

	<script>
		//로그인,회원가입 버튼 메소드
		$(function() {
			$("#loginBtn img").mouseover(function() {
				$(this).attr("src", "img/logo/loginOn.png");
			});
			$("#loginBtn img").mouseout(function() {
				$(this).attr("src", "img/logo/loginOff.png");
			});
		});

		//로그아웃 버튼 메소드
		$(function() {
			$("#logoutBtn img").mouseover(function() {
				$(this).attr("src", "img/logo/logoutOn.png");
			});
			$("#logoutBtn img").mouseout(function() {
				$(this).attr("src", "img/logo/logoutOff.png");
			});
		});
	</script>

	<!-- Js Plugins -->
	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/mixitup.min.js"></script>
	<script src="js/jquery-ui.min.js"></script>
	<script src="js/jquery.nice-select.min.js"></script>
	<script src="js/jquery.slicknav.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.richtext.min.js"></script>
	<script src="js/image-uploader.min.js"></script>
	<script src="js/main.js"></script>
</body>

</html>