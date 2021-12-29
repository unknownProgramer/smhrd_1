<%@page import="com.model.conDetailDAO"%>
<%@page import="com.model.conDetailVO"%>
<%@page import="com.model.memberVO"%>
<%@ page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
<!DOCTYPE html>

<html lang="zxx">
<%
memberVO memberInfo = (memberVO) session.getAttribute("loginMemberSession");
%>
<%
conDetailVO con = new conDetailVO();
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

	<header class="header-section" style="margin:0px">
		<div
			style="background-image: url('img/mainTopBig.png'); width: 2000px; height: 155px;">
			<div class="hs-top"
				style="margin-top: 0px; height: 165px;">
				<div class="container">
					<div class="ten" style="padding: 1px">
						<div class="logo">
							<a href="./mainPageJSP.jsp"><img src="img/logo/mainLogo.png" style="margin-top:10px"></a>
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
								<li style="font-size: 10px"><a
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
				style="margin-left: 33%; width: 600px; height: 44; border: 2px solid #1b5ac2; background: #ffffff;">
				<form action="searchService">
					<input class="textBar" type="text" placeholder="원하는 공모전 검색!"
						style="font-size: 16px; width: 500px; height: 0%; padding: 20px; border: 0px; outline: none;"
						name="search">
					<button class="search"
						style="width: 90px; height: 40px; border: 0px; background: #1b5ac2; outline: none; float: right; color: #ffffff">검색</button>
				</form>
			</div>
		</div>
	</header>
	<!-- 헤드 끝 -->


	<!-- Blog Details Section Begin -->

	<%
	conDetailDAO dao = new conDetailDAO();

	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");

		String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
		String user = "campus_k3_1006";
		String password = "smhrd3";
		int idx = Integer.parseInt(request.getParameter("idx"));

		String sql = "SELECT * FROM contest where cnt_num = ?";
		Connection conn = DriverManager.getConnection(url, user, password);
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, idx);

		//2. 데이터베이스 연결 객체(Connection) 생성
		ResultSet rs = stmt.executeQuery();

		int num = 0;
		String pcntPosition = null;
		String pcntContent = null;
		int pcntType = 0;

		if (rs.next()) {
			num = rs.getInt(1);
			String name = rs.getString(2);
			String host = rs.getString(3);
			String field = rs.getString(4);
			String qualification = rs.getString(5);
			String fromDate = rs.getString(6).substring(0, 10);
			String toDate = rs.getString(7).substring(0, 10);
			String homePage = rs.getString(8);
			String smallImg = rs.getString(9);
			String bigImg = rs.getString(10);
			String content = rs.getString(11);
	%>

	<section class="blog-details-section spad">
		<div>
			<h3 class="fw-bolder mb-1" style="margin-left: 20%">
				<b>공모전 대외활동 정보</b>
			</h3>
			<hr style="width: 1160px" color=black size=1px>
		</div>
		<div class="container mt-5"
			style="background-color: #F6F6F6; border-radius: 10px; margin-top: -10%">
			<div>
				<div>
					<article>
						<header class="mb-4" style="padding: 3%">
							<div class="section-title" style="padding-top: 2%;">
								<h4><%=name%></h4>
							</div>
						</header>
						<figure class="mb-4">
							<img src=<%=smallImg%>
								style="float: left; margin-left: 5%; width: 25%; height: 35%"
								alt="..." />
						</figure>
						<section class="mb-5">
							<table class="content" style="margin-left: 35%;">
								<tbody>
									<tr>
										<td width="100" height="50"><b>분야</b></td>
										<td><%=field%></td>
									</tr>
									<tr>
										<td width="100" height="50"><b>응모대상</b></td>
										<td><%=qualification%></td>
									</tr>
									<tr>
										<td width="100" height="50"><b>주최/주관</b>
										<td><%=host%></td>
									</tr>
									<tr>
										<td width="100" height="50"><b>후원/협찬</b></td><%=host%><td></td>
									</tr>
									<tr>
										<td width="100" height="50"><b>접수기간</b></td>
										<td><%=fromDate%>~<%=toDate%></td>
									</tr>
									<tr>
										<td width="100" height="50"><b>총상금</b></td>
										<td>Ipsum</td>
									</tr>
								</tbody>
							</table>
							<hr style="width: 350px">
							<div class="section-title" style="padding: 3%">
								<h4>상세내용</h4>
							</div>
							<div style="margin-left: 3%">
								<p class="fs-5 mb-4">
									<img src=<%=bigImg%>><br> <br>
								</p>
								<p><%=content%></p>
							</div>
							<div>
								<form action="PersonalContestService" action="mojipService">
									<table style="margin: auto;">
										<tr>
											<td>
												<ul style="list-style: none;">
													<li><input name="cntNum" value="<%=num%>"
														style="display: none;"></li>
													<li><input name="pcntPosition"
														value="<%=pcntPosition%>" style="display: none;"></li>
													<li><input name="pcntContent" value="<%=pcntContent%>"
														style="display: none;"></li>
													<li><input name="pcntType" value="<%=pcntType%>"
														style="display: none;"></li>
													<li><button type="submit" class="beHead"
															style="width: 150px; height: 50px; margin-bottom: 10px; margin-left: 40px; margin-right: 40px; float: right; background: #1b5ac2; color: #ffffff; border: 0; outline: 0;">
															나의 공모전 추가</button></li>
												</ul>
											</td>
											<td><button type="button" class="beHead"
													style="width: 150px; height: 50px; margin-bottom: 10px; margin-left: 40px; margin-right: 40px; float: right; background: #1b5ac2; color: #ffffff; border: 0; outline: 0;"
													name="beHead"
													onclick="location.href='recruitTeam2.jsp?idx=<%=idx%>'">
													파티원 모집하기</button></td>
											<td><button type="button" class="beMember"
													style="width: 150px; height: 50px; margin-bottom: 10px; margin-left: 40px; margin-right: 40px; float: right; background: #1b5ac2; color: #ffffff; border: 0; outline: 0;"
													name="beMember" onclick="location.href='teamBoardJSP.jsp'">
													모집게시판</button></td>
										</tr>
									</table>
								</form>
							</div>
							<figure>
							</figure>
						</section>

					</article>
					<%
					stmt.executeUpdate(sql);
					rs.close();
					stmt.close();
					conn.close();
					}

					} catch (Exception e) {
					}
					%>

					<!-- Comments section-->
					<section class="mb-5">
						<div class="card bg-light">
							<div class="card-body">
								<!-- Comment form-->
								<form class="mb-4">
									<textarea class="form-control" rows="3" placeholder="댓글을 달아주세요"></textarea>
								</form>
								<!-- Comment with nested comments-->
								<div class="d-flex mb-4">
									<!-- Parent comment-->
									<div class="flex-shrink-0">
										<img class="rounded-circle"
											src="https://dummyimage.com/50x50/ced4da/6c757d.jpg"
											alt="..." />
									</div>
									<div class="ms-3">
										<div class="fw-bold">Commenter Name</div>
										If you're going to lead a space frontier, it has to be
										government; it'll never be private enterprise. Because the
										space frontier is dangerous, and it's expensive, and it has
										unquantified risks.
										<!-- Child comment 1-->
										<div class="d-flex mt-4">
											<div class="flex-shrink-0">
												<img class="rounded-circle"
													src="https://dummyimage.com/50x50/ced4da/6c757d.jpg"
													alt="..." />
											</div>
											<div class="ms-3">
												<div class="fw-bold">Commenter Name</div>
												And under those conditions, you cannot establish a
												capital-market evaluation of that enterprise. You can't get
												investors.
											</div>
										</div>
										<!-- Child comment 2-->
										<div class="d-flex mt-4">
											<div class="flex-shrink-0">
												<img class="rounded-circle"
													src="https://dummyimage.com/50x50/ced4da/6c757d.jpg"
													alt="..." />
											</div>
											<div class="ms-3">
												<div class="fw-bold">Commenter Name</div>
												When you put money directly to a problem, it makes a good
												headline.
											</div>
										</div>
									</div>
								</div>
								<!-- Single comment-->
								<div class="d-flex">
									<div class="flex-shrink-0">
										<img class="rounded-circle"
											src="https://dummyimage.com/50x50/ced4da/6c757d.jpg"
											alt="..." />
									</div>
									<div class="ms-3">
										<div class="fw-bold">Commenter Name</div>
										When I look at the universe and all the ways the universe
										wants to kill us, I find it hard to reconcile that with
										statements of beneficence.
									</div>
								</div>
							</div>
						</div>
					</section>
				</div>
			</div>
		</div>
		<input type="button">
	</section>
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