<h1>IT 관련 공모전 통합 서비스 개발 프로젝트_v.0.1</h1>

스인개(스마트 인재 개발원)에서 진행한 첫 프로젝트. 주로 JSP로 이뤄졌으며 매우 조잡하고 투박하지만
첫 프로젝트임을 감안한다면 나쁘지 않은 완성도.
이번 프로젝트에선 팀장을 맡았으며 약 1달간의 기간동안 기능에 중점을 둔 서비스 개발을 진행했다. <br><br>
사실 프로젝트 라고 하기에도 부끄러울 정도로 조악한 DB 설계와 톰캣 서버를 활용한 JSP간 통신이다 보니 웹 페이지간 이동이 말도 안되게 느리다. (파티 생성창 같은 경우 20초 이상 걸리기도 했다...) <br>
그렇다 보니 코드를 나열해가며 프로젝트 결과물을 설명하기 보단 웹개발을 한번도 해본 적 없던 독문과 학생이 처음 진행한 프로젝트 라는것을 중점으로 작성해 보겠다. <br><br>
현재는 Spring 프레임 워크를 활용해 개선해 나갈 계획을 세우고 있다.

<h3>1. 메인 페이지</h3>

![그림1](https://user-images.githubusercontent.com/91005194/147706335-7113a022-de18-4a5c-b28d-4bea8fd6bffe.png) <br>
메인 페이지의 구성은 맨 위 로그인, 로그아웃부터 가운데 공모전에 대한 정보를 검색할 수 있는 검색창, 가운데 슬라이드는 DB에 저장된 공모전에 대한 정보 (물론 크롤링한 정보)가 있다. <br><br>
물론 검색창 또한 크롤링한 Data를 DB에서 끌어다 쓰는것 뿐이다. 간단한 SQL 문장으로 구현했다. <br><br>

<h3>2. 마이 페이지</h3>

![image](https://user-images.githubusercontent.com/91005194/148238191-f2212464-f477-4c57-b9a2-d77befd75e57.png) <br>
session 생성 및 userVO를 통한 마이페이지 구현에 성공했다. 나의 공모전 정보와 파티정보, 개인정보를 볼 수 있는 간단한 웹페이지를 구현했다. <br>
모든 기능은 MVC 모델을 기반으로 메소드를 구현했으며, 간단한 select, delete를 활용해 별점정보나 파티원을 추가, 삭제하는 기능을 구현했다. <br><br>

<h3>3. 레벨링 시스템</h3>

![image](https://user-images.githubusercontent.com/91005194/148242384-97735959-4d80-4f5a-812e-6b336541b62c.png) <br>
DB 설계 시 Table을 따로 생성해 유저의 레벨 정보를 추가했다. 사실 DB 설계시 User Table을 제대로 생성했다면 Column에 레벨정보를 추가하기만 하면 되지만, 이미 테스트 User와 Table간 PK를 설정해둔 상태라 Column을 추가하기 부담스러웠다. <br>
DB 설계가 중요하단것을 느끼는 프로젝트 였다. <br><br>

<h3>4. DB 설계</h3>

![image](https://user-images.githubusercontent.com/91005194/148243499-5d49cd99-7d62-4495-9fb1-f976a86c117a.png) <br>
DB 설계시 타 팀원들과 상의하면서 실제 공모전 사이트(Webiti)를 참고하여 설계했다.
