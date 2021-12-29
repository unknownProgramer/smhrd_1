<%@page import="com.model.teamVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model.conDetailVO"%>
<%@page import="com.model.conDetailDAO"%>
<%@page import="com.model.teamDAO"%>
<%@page import="com.model.memberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">
<%
memberVO memberInfo = (memberVO) session.getAttribute("loginMemberSession");
%>
<head>
<meta charset="UTF-8">
<meta name="description" content="Aler Template">
<meta name="keywords" content="Aler, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Aler | Template</title>

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
   <script src="http://code.jquery.com/jquery-1.8.2.min.js"></script>

   <!-- 헤드 시작 -->
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
   teamDAO TDAO = new teamDAO();
   conDetailDAO CDAO = new conDetailDAO();
   conDetailVO contest = null;

   ArrayList<teamVO> allTeam = TDAO.showAllTeam();
   ArrayList<teamVO> leader = new ArrayList<teamVO>();

   for (int i = 0; i < allTeam.size(); i++) {
      if (allTeam.get(i).getTmType() == 0) {
         leader.add(allTeam.get(i));
      }
   }
   %>

   <!-- Blog Details Section Begin -->
   <section class="blog-details-section spad"
      style="width: 1000px; clear: both; margin: auto;">
      <div class="section-title" style="margin-left: 60px">
         <h4>팀원 모집 게시판</h4>
      </div>
      <div>
         <button type="button" class="btn btn-primary"
            style="margin-bottom: 10px; float: right; background: #1b5ac2; color: #ffffff; border: 0; outline: 0;"
            name="writeTeam" onClick="location.href='recruitTeam.jsp'">작성하기</button>
      </div>

      <table class="table table-hover" style="width: 1000px;">
         <thead>
            <tr
               style="background-color: #c8c8c8; font-size: 15px; text-align: center">
               <th scope="col"
                  style="width: 100px; background-color: #8B4513; color: white">모집여부</th>
               <th scope="col" style="width: 300px">제목</th>
               <th scope="col" style="width: 100px">파티장</th>
               <th scope="col" style="width: 400px">참여 공모전 제목</th>
               <th scope="col" style="width: 100px">현황</th>
            </tr>
         </thead>
         <tbody>
            <%for(int i=leader.size();i>0;i--){ 
            int party=leader.get(i-1).getTmNum();
            %>
            <tr style="font-size: 13px">
               <th scope="row">
                  <%if(leader.get(i-1).getTmFull()==TDAO.showTeamMemberNum(leader.get(i-1).getTmNum())){%>
                  모집완료 <%}else{%> 모집중 <%} %>
               </th>
               <td><a href="applicationTeam.jsp?idx=<%=party%>"> <%if (leader.get(i-1).getTitle()==null){ %>
                     <%=leader.get(i-1).getMemId() %>의 파티 <%}else {%> <%=leader.get(i-1).getTitle() %>
                     <%} %></a></td>
               <td><%=leader.get(i-1).getMemId() %></td>
               <td><%=CDAO.selectCon(leader.get(i-1).getCntNum()).getConName()  %></td>
               <td style="text-align: center"><%=TDAO.showTeamMemberNum(leader.get(i-1).getTmNum()) %>/<%=leader.get(i-1).getTmFull() %></td>
            </tr>
            <%} %>
         </tbody>
      </table>
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