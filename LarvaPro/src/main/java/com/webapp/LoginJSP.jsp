<%@page import="com.model.memberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="EUC-KR">
<title>��� �α���</title>
<style>
* {
	margin: 0;
	padding: 0;
	font-family: sans-serif;
}

.wrap {
	height: 150%;
	width: 100%;
	background-image: url(img/background.jpg);
	background-position: center;
	background-size: cover;
	position: absolute;
}

.form-wrap {
	width: 380px;
	height: 700px;
	position: relative;
	margin: 2% auto;
	background: #fff;
	padding: 5px;
	overflow: hidden;
}

.button-wrap {
	width: 238px;
	margin: 50px auto;
	position: relative;
	box-shadow: 0em 3em 400px 4em rgb(10, 173, 248);
	border-radius: 30px;
}

#loginBtn {
	padding: 10px 32px;
	cursor: pointer;
	background: transparent;
	border: 0;
	outline: none;
	position: relative;
	color: white;
}

#regBtn {
	padding: 10px 30px;
	cursor: pointer;
	background: transparent;
	border: 0;
	outline: none;
	position: relative;
	color: black;
}

#btn {
	top: 0;
	left: 0;
	position: absolute;
	width: 118px;
	height: 100%;
	background: linear-gradient(to right, #ac989e, #1a1711);
	border-radius: 30px;
	transition: .5s;
}

.input-group {
	top: 180px;
	position: absolute;
	width: 280px;
	transition: .5s;
}

.input-field {
	width: 100%;
	padding: 10px 0;
	margin: 5px 0;
	border: none;
	border-bottom: 1px solid #999;
	outline: none;
	background: transparent;
}

.bottomSide {
	margin-bottom: 30px;
}

.submit {
	width: 85%;
	padding: 10px 30px;
	cursor: pointer;
	display: block;
	margin: auto;
	background: linear-gradient(to right, #ac989e, #1a1711);
	border: 0;
	outline: none;
	border-radius: 30px;
	color: white;
}

.checkbox {
	margin: 30px 10px 30px 0;
}

span {
	color: #777;
	font-size: 12px;
	bottom: 68px;
	position: absolute;
}

#login {
	left: 50px;
}

#register {
	left: 450px;
}
</style>
</head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js">
</script>
<body>



	<div class="wrap" style="margin-left: 8%">
		<div
			style="width: 260px; left: 0; right: 0; margin-left: 35%; margin-top: 5%;">
			<div style="margin-left: 15%; margin-bottom: 10%">
				<img src="img/KkalKkom.png" style="width: 280px; height: 70px;">
			</div>
			<div class="form-wrap">
				<div class="button-wrap">
					<div id="btn"></div>
					<button type="button" class="togglebtn"
						onclick="login();co1();changeBtnColorRegBtn()" id="loginBtn">�α���</button>
					<button type="button" class="togglebtn"
						onclick="register();co1();changeBtnColorLBtn()" id="regBtn">ȸ������</button>
				</div>

				<form id="login" action="LoginService" class="input-group"
					method="post">
					<input type="text" class="input-field" placeholder="���̵� �Է��ϼ���"
						name="loginId" required> <input type="password"
						class="input-field" placeholder="��й�ȣ�� �Է��ϼ���" name="loginPw"
						required> <input type="checkbox" class="checkbox"><span>��й�ȣ
						����</span>
					<button class="submit">�α���</button>

					<!-- �α��� ����/���� ���� -->
					<%
                    		memberVO result= (memberVO)session.getAttribute("loginMemberSession");
                    		String fail=(String)session.getAttribute("loginMemberFail");
                    		
                    		if(result!=null){
                    			out.println("<script>window.location='./mainPageJSP.jsp';</script>");
                    			
                    		}else if(fail!=null){
                    			out.println("<script>alert('ȸ�������� Ȯ���ϼ���.');</script>");
                    			session.invalidate();
                    		}%>

				</form>
				<form id="register" action="JoinService" class="input-group"
					method="post">
					<input type="text" class="input-field" placeholder="����� ���̵� �Է��ϼ���"
						name="id" required> <input type="password"
						class="input-field" placeholder="����� ��й�ȣ�� �Է��ϼ���" name="pw"
						required> <input type="text" class="input-field"
						placeholder="�̸��� �Է��ϼ���" name="name" required> <input
						type="text" class="input-field" placeholder="����� �г����� �Է��ϼ���"
						name="nick" required> <input type="email"
						class="input-field" placeholder="�̸����� �Է��ϼ���" name="email" required>
					<input type="text" class="input-field" placeholder="��ȭ��ȣ�� �Է��ϼ���"
						name="tel" required> <input type="text"
						class="input-field bottomSide" placeholder="�ּҸ� �Է��ϼ���"
						name="address" required>
					<button class="submit">ȸ������</button>
				</form>
			</div>
		</div>
	</div>
	<script>
            var x = document.getElementById("login");
            var y = document.getElementById("register");
            var z = document.getElementById("btn");
            
            
            function login(){
                x.style.left = "50px";
                y.style.left = "550px";
                z.style.left = "0";
 
            }   
            function register(){
                x.style.left = "-500px";
                y.style.left = "50px";
                z.style.left = "120px";
            }
            $("#loginBtn").on("click",function(){
                    $("#loginBtn").css("color","white");
                    $("#regBtn").css("color","black");
                  
             })
             $("#regBtn").on("click",function(){
                    $("#loginBtn").css("color","black");
                    $("#regBtn").css("color","white");
                  
             })
             $(".submit").on("click",function(){
                    $(this).css("color","gray");
                  
             })
             
             
        </script>
</body>
</html>