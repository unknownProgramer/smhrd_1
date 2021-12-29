<%@page import="com.model.DdayVO"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model.conDetailDAO"%>
<%@page import="com.model.conDetailVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.model.memberVO"%>
<%@page import="com.model.scoreDAO"%>
<!DOCTYPE html>
<html lang="zxx">
<%
memberVO memberInfo = (memberVO) session.getAttribute("loginMemberSession");
if (memberInfo == null) {
	out.println("<script>alert('로그인이 필요한 서비스입니다. 로그인페이지로 이동합니다.'); window.location='./LoginJSP.jsp';</script>");
}
%>
<head>
<meta charset="UTF-8">
<meta name="description" content="Aler Template">
<meta name="keywords" content="Aler, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>깔꼼</title>

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
</head>
<style>
#noteHead {
	font-size: 25px;
	width: 100px;
}

#noteContent {
	font-size: 18px;
	margin: 1%;
	.
	menu
	a
	{
	cursor
	:
	pointer;
}

.menu a {
	cursor: pointer;
}

.menu .hide {
	display: none;
}
</style>
<script src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
<script>
	$(document).ready(function() {
		$(".menu>button").click(function() {
			var submenu = $(this).next("ul");
			if (submenu.is(":visible")) {
				submenu.slideUp();
			} else {
				submenu.slideDown();
			}
		});
	});
</script>
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
			<a href="./index.html"> <img src="img/logo.png" alt="">
			</a>
		</div>
		<div id="mobile-menu-wrap"></div>
		<div class="om-widget">
			<ul>
				<li><i class="icon_mail_alt"></i> Aler.support@gmail.com</li>
				<li><i class="fa fa-mobile-phone"></i> 125-711-811 <span>125-668-886</span></li>
			</ul>
			<a href="#" class="hw-btn">Submit property</a>
		</div>
		<div class="om-social">
			<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
				class="fa fa-twitter"></i></a> <a href="#"><i
				class="fa fa-youtube-play"></i></a> <a href="#"><i
				class="fa fa-instagram"></i></a> <a href="#"><i
				class="fa fa-pinterest-p"></i></a>
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

	<%
	conDetailDAO CDAO = new conDetailDAO();
	ArrayList<conDetailVO> allCon = new ArrayList<conDetailVO>();
	ArrayList<DdayVO> D_day = CDAO.D_Day();

	ArrayList<DdayVO> soonCon = new ArrayList<DdayVO>();

	for (int i = 0; i < 100; i++) {
		allCon.add(CDAO.selectCon(i + 1));
	}

	for (int i = 0; i < 100; i++) {
		if (D_day.get(i).getD_day() < 0 && D_day.get(i).getD_day() > -30) {
			soonCon.add(D_day.get(i));
		}
	}
	%>

	<!-- Property Comparison Section Begin -->

	<section class="contact-form-section spad" style="margin-left: 30%">
		<h4 style="border: 2px">모집글쓰기</h4>
		<hr>
		<div class="row">
			<div class="col-lg-12">
				<div class="cf-content" style="margin_bottom: 10%">
					<form action="mojipService" class="cc-form">
						<div>
							<select name="cntNum" style="height: 46px">
								<option value="none" style="color: gray" disabled>공모전
									조회</option>
								<%
								for (int i = 0; i < soonCon.size(); i++) {
								%>
								<option
									value="<%=allCon.get(soonCon.get(i).getIndex()).getConNum()%>"><%=allCon.get(soonCon.get(i).getIndex()).getConName()%>
									D<%=soonCon.get(i).getD_day()%>
								</option>
								<%
								}
								%>
							</select>
						</div>
						<div class="group-input">
							<input type="text" name="title" placeholder="제목을 작성하세요"
								style="width: 300px; margin-left: 3%"> <input
								type="text" name="position" placeholder="팀장님의 역할"
								style="width: 150px"> <input type="text" name="full"
								placeholder="필요인원" style="width: 100px">
						</div>
						<textarea
							placeholder="팀원 모집에 관한 내용을 작성바랍니다. 팀원이 어떤 역할을 수행해야하는지도 작성해주세요."
							name="content"></textarea>
						<button type="submit" class="site-btn" name="memberId"
							value="<%=memberInfo.getMemId()%>">작성하기</button>
					</form>
				</div>
			</div>
		</div>
	</section>

	<!-- Property Comparison Section End -->


	<!-- Contact Section Begin -->
	
	<!-- Contact Section End -->

	<!-- Footer Section Begin -->
	<footer>
		<div id ="footer" style = "background-color : rgb(44,44,44); clear:both; height:350px;" >
			<div class="footer">
			<h1>
			 <a href="./mainPageJSP.jsp">
			 	<imag src="img/logo/mainLogo.png" alt ="logo">
			 </a>
			</h1>
			<div id ="footer-area">
				<div style="margin-left:10%; color:#fff;">
				<br>
					<p>
						<span style="font-family:dotum; font-size:25px">
							<strong> (주) 깔꼼 </strong>
						</span>
					</p>
					<p>
						<span style ="font-size:20px">
							<span style="font-family:dotum">
							
							대표 : 애벌레   &nbsp;&nbsp;&nbsp;&nbsp; 주소 : 광주광역시 스마트인재개발원
							<br>
							공모전 제휴 문의 : eberle@naver.com &nbsp;&nbsp; 마케팅 제휴 : eberle@naver.com 
							<br>
							홍보문의 : eberle@naver.com
							<br>
							고객문의:eberle@naver.com / 1555-1555(09:00~18:00)
							<br>
							사업자등록번호 : 000-00-0000 | tel: 1588-1588&nbsp;
							<br>
							<br>
								㈜깔꼼은 통신판매중개자로서 통신판매의 당사자가 아닙니다. 따라서, 등록된 공모전 및 활동에 대하여 ㈜깔꼼은 어떠한 책임도 지지 않습니다.
							<br>	
						Copyright © kakaostyle Corp. All rights reserved
							</span>
						</span>
					</p>
				
					</div>
				
				
			 </div></div>
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