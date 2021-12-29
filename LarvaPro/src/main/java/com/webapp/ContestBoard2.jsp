<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.model.conDetailDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.model.conDetailVO"%>
<%@page import="com.model.memberVO"%>
<%@ page import="java.sql.*"%>
	<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html lang="zxx">
<% memberVO memberInfo=(memberVO)session.getAttribute("loginMemberSession");%>
<% conDetailVO con= new conDetailVO(); %>
<%
	conDetailDAO manager = new conDetailDAO();
	List<conDetailVO> list = manager.getList(); // getList 메서드 호출
	
%>


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js">
</script>
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
	<section class="blog-details-section spad"
		style="width: 1100px; clear: both; margin: auto;">
		<h2 class="fw-bolder mb-1">
			<b>공모전 정보</b>
		</h2>
		<table class="table table-hover" style="width: 1100px;">
			<thead>
				<tr>
					<th scope="col" style="width:100px">번호</th>
					<th scope="col" style="width:500px">제목</th>
					<th scope="col" style="width:100px">작성자</th>
					<th scope="col" style="width:160px">공모전 기간</th>
				</tr>
			</thead>
			<tbody>
				<!-- private int conNum; //공모전 번호
	private String conName;// 공모전 이름
	private String conHost;//주체,주관
	private String conField; //응모분야
	private String conQualfication; //참가자격
	private String conFromDate; //시작날짜
	private String conToDate; //끝 날짜
	private String conHomePage; //홈페이지>>공모전 주체하는 홈페이지
	private String conPostBig; //큰 포스터
	private String conPostSmall; //작은 포스터
	private String conContent; //공모전 상세 -->

				<%
			
	int total = 0;
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");			
		String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
		String user = "campus_k3_1006";
		String password = "smhrd3";
		Connection conn = DriverManager.getConnection(url,user,password);
		Statement stmt = conn.createStatement();
		String sqlCount = "SELECT COUNT(*) FROM contest";
		ResultSet rs = stmt.executeQuery(sqlCount);
		
		if(rs.next()){
			total = rs.getInt(1);
		}
		rs.close();
		out.print("<a style='color:#4169E1'>총 게시물 : " + total + "개</a>");
		
		String sqlList = "SELECT cnt_num,cnt_name, cnt_from_date, cnt_to_date from(select cnt_num,cnt_name, cnt_from_date, cnt_to_date from contest order by cnt_from_date DESC) where cnt_num between 60 and 79";
		rs = stmt.executeQuery(sqlList);
			
		if(total==0){
		
	%>
				<tr align="center" bgcolor="#FFFFFF" height="30">
					<td colspan="6">등록된 글이 없습니다.</td>
				</tr>
				<%}else{
		}while(rs.next()){
			int idx=rs.getInt(1);
			String name=rs.getString(2);
			String fromDate=rs.getString(3).substring(0,10);
			String toDate=rs.getString(4).substring(0,10);		
		%>


				<tr>
					<th scope="row"><%=idx%></th>
					<td style="font-size: 15px"><a href="ContestDetailsJSP.jsp?idx=<%=idx%>"
						style="color: black;"><%=name%></a></td>
					<td style="font-size: 15px">admin</td>
					<td style="font-size: 15px"><%=fromDate + "~" + toDate%></td>
				</tr>
				<%}
		rs.close();
		stmt.close();
		conn.close();
		}catch(Exception e ){
			out.println(e.toString());
		}
	
	%>


			</tbody>
		</table>
		<div style="margin-left: 40%">
			<ul class="pagination">
				<li class="page-item disabled"><a class="page-link" href="#">&laquo;</a>
				</li>
				<li class="page-item"><a class="page-link"
					href="ContestBoard.jsp">1</a></li>
				<li class="page-item active"><a class="page-link"
					href="ContestBoard2.jsp">2</a></li>
				<li class="page-item"><a class="page-link"
					href="ContestBoard3.jsp">3</a></li>
				<li class="page-item"><a class="page-link" href="#">&raquo;</a>
				</li>
			</ul>
		</div>
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
    $(function(){
    	$("#loginBtn img").mouseover(function(){
    		$(this).attr("src","img/logo/loginOn.png");
    	});
    	$("#loginBtn img").mouseout(function(){
    		$(this).attr("src","img/logo/loginOff.png");
    	});
    });
    
    //로그아웃 버튼 메소드
    $(function(){
    	$("#logoutBtn img").mouseover(function(){
    		$(this).attr("src","img/logo/logoutOn.png");
    	});
    	$("#logoutBtn img").mouseout(function(){
    		$(this).attr("src","img/logo/logoutOff.png");
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