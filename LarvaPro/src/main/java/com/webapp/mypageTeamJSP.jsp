<%@page import="com.model.scoreDAO"%>
<%@page import="java.util.HashSet"%>
<%@page import="com.model.conDetailDAO"%>
<%@page import="com.model.teamVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model.personalcontestDAO"%>
<%@page import="com.model.personalcontestVO"%>
<%@page import="com.model.conDetailVO"%>
<%@page import="com.model.teamDAO"%>
<%@page import="com.model.memberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
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
	a {
	cursor: pointer;
	}
}

.menu .hide {
	display: none;
}
</style>
<script src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
<script>
	$(document).ready(function() {
		$(".menu>a").click(function() {
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
	<header class="header-section">
		<div
			style="background-image: url('img/mainTopBig.png'); width: 2000px; height: 225px;">
			<div class="hs-top"
				style="margin-top: 10px; border-bottom: 0px; height: 225px;">
				<div class="container">
					<div class="ten" style="padding: 3%">
						<div class="logo">
							<a href="./mainPageJSP.jsp"><img src="img/logo/mainLogo.png"
								style="witdh: 162px; height: 102px"></a>
						</div>
						<nav class="nav-menu" style="margin-top: 5%;">
							<%
							if (memberInfo == null) {
								out.print(
								"<a href='./LoginJSP.jsp' style='margin-left:90%;' id='loginBtn'><img src='img/logo/loginOff.png' width='180px' height='32px' style='margin:1%'></a>");
							} else if (memberInfo != null) {
								out.print(
								"<a href='./LogoutJSP.jsp' style='margin-left:95%;' id='logoutBtn'><img src='img/logo/logoutOff.png' width='110px' height='32px' style='margin:1%'></a>");
							}
							%>
							<ul style="text-align: center; margin-left: 7%;">
								<li class="active" style="font-size: 10px"><a
									href="./mainPageJSP.jsp" style="color: #ffffff;">메인</a></li>
								<li><a href="#" style="color: #ffffff;">마이페이지</a>
									<ul class="dropdown"
										style="display: inline-block; width: 150px;">
										<li style="margin-right: 40%"><a
											href="./mypageProfileJSP.jsp">내정보</a></li>
										<li style="margin-right: 10%"><a
											href="./mypageContestJSP.jsp">지원한 공모전</a></li>
										<li style="margin-right: 38%"><a
											href="./mypageTeamJSP.jsp">나의 팀</a></li>
										<li style="margin-right: 40%"><a
											href="./mypageMessageJSP.jsp">쪽지함</a></li>
									</ul></li>
								<li><a href="./ContestBoradJSP.jsp" style="color: #ffffff;">공모전</a></li>
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
			style="padding: 3%; background-color: #4169E1; box-shadow: 1px 1px gray; width: 2000px">
			<div class="pcntSearchText"
				style="margin-left: 33%; height: 40px; width: 600px; border: 2px solid #1b5ac2; background: #ffffff;">
				<input class="textBar" type="text" placeholder="원하는 공모전 검색!"
					style="font-size: 16px; width: 500px; height: 100%; padding: 10px; border: 0px; outline: none;">
				<button class="searchBtn"
					style="width: 50px; height: 100%; border: 0px; background: #1b5ac2; outline: none; float: right; color: #ffffff">검색</button>
			</div>
		</div>
	</header>
	<!-- 헤드 끝 -->

	<!-- 중간 헤드 시작 -->
	<section class="breadcrumb-section spad set-bg"
		data-setbg="img/grayPolygon.png" style="width: 2000px">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="breadcrumb-text">
						<h4>나의 팀</h4>
						<div class="bt-option">
							<a href="./index.html"><i class="fa fa-home"></i>메인</a> <span>나의
								팀</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- 중간 헤드 끝 -->

	<!-- Property Comparison Section Begin -->
	<div class="property-comparison-section spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 p-0">
					<div class="pc-table">
						<div class="section-title">
							<h4>내 파티 현황</h4>
						</div>
						<%
						if (memberInfo != null) {

							teamVO vo = null;
							teamDAO teamDAO = new teamDAO();
							conDetailDAO conD = new conDetailDAO();
							scoreDAO scDAO = new scoreDAO();

							personalcontestDAO PCDAO = new personalcontestDAO();
							ArrayList<personalcontestVO> myContest = PCDAO.showPersonalContest(memberInfo.getMemId());

							ArrayList<teamVO> myTeam = teamDAO.selectMyTeam(memberInfo.getMemId());

							for (int i = 0; i < myTeam.size(); i++) {
								%>
								<div style="margin: 3%; float: left">
									<form action="ScoreService">
									<table style= "position: static;">
										<tbody>
											<tr>
												<td colspan='4' style="font-size: 15px; padding : 0px 0px 0px 10px; ; background-color: #4169E1; color: white; width: 100%; height: 50px; text-align:left;">
													<%= conD.selectCon(myTeam.get(i).getCntNum()).getConName()%>
												</td>
											</tr>
											<tr>
												<td style="font-size: 13px; padding:0; background-color: gray; color: white; width: 150px; height: 50px;">팀원 아이디</td>
												<td style="font-size: 13px; padding:0; background-color: gray; color: white; width: 100px; height: 50px;">역할</td>
												<td style="font-size: 13px; padding:0; background-color: gray; color: white; width: 50px; height: 50px;">평점</td>
												<td style="font-size: 13px; padding:0; background-color: gray; color: white; width: 150px; height: 50px;">평점 주기</td>
											</tr>
											<%
												ArrayList<teamVO> myTeamMembers = teamDAO.showTeamMember(myTeam.get(i).getCntNum(), myTeam.get(i).getTmNum());
												for (teamVO vos : myTeamMembers) {%>
											<tr>
											<!-- 팀원들 이름 노출 -->
												<td style="font-size: 13px; padding:0; width: 150px; height: 46px; border-style: solid; border-width: 1px; border-color:gray;">
															<%if (vos.getTmType() == 0) {
																out.print("★");
															}%>
															<%= vos.getMemId()%>
												</td>
												<!-- 포지션 -->
												<td style="font-size: 13px; padding:0; border-style: solid; border-width: 1px; border-color:gray;"><%= myTeam.get(i).getPosition()%></td>
												<!-- 평균 평점 -->
												<td style="font-size: 13px; padding:0; border-style: solid; border-width: 1px; border-color:gray;"><%= scDAO.showScore(vos.getMemId())%></td>
												<!-- 점수 주기 -->
												<td style="border-style: solid; border-width: 1px; border-color:gray; padding:0; font-size:13px; width:50px; height:34px;" align="center" >
													<select name="receiveScore">
														<option value="5">5점</option>
														<option value="4">4점</option>
														<option value="3">3점</option>
														<option value="2">2점</option>
														<option value="1">1점</option>
													</select>
													<%if(memberInfo.getMemId().equals(vos.getMemId())){ %>
		        										<button type="submit" name="receiveId" value="<%= vos.getMemId()%>" disabled="disabled"
		        										style="font-size: 13px; background-color:gray; color:#ffffff; margin: 3px 0px; padding:0; border:0px; border-radius:5px; width:50px; height:34px;"
		        										>주기</button>
		        									<%} else{ %>
		        										<button type="submit" name="receiveId" value="<%= vos.getMemId()%>" onclick="insert();"
		        										style="font-size: 13px; background-color:#1b5ac2; color:#ffffff; margin: 3px 0px; padding:0; border:0px; border-radius:5px; width:50px; height:34px;"
		        										>주기</button>
		        									<%} %>
												</td>
											</tr>
											<%}%>
										</tbody>
									</table>
									</form>
								</div>
								<%
								}
								}
								%>
						</div>
					</div>
				</div>
			</div>
		</div>
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