<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../include/header.jsp" />
<title>아이디 찾기</title>
</head>
<link rel="stylesheet" type="text/css" href="./css/member/login.css">
<body>
	<div class="login1">

		<form action="find_id_ok" method="post">
		
			<div class="login2">
			<h2 >아이디 찾기</h2>
				<h3>이름</h3>
				<input placeholder="이름을 입력하세요"class="input1" type="text" id="m_name" name="m_name" required>
				<h3>Email</h3>
				<input placeholder="Email을 입력하세요"class="input1" type="text" id="m_email" name="m_email" required>
				<p  class="login3">
					<button class="btn1" >찾기</button>
					<button class="btn1" onclick="location='member_login'">취소</button>
				</p>
			</div>
			



		</form>

	</div>
</body>
</html>
<jsp:include page="../include/footer.jsp" />