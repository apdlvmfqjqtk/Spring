<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ include file = "../header.jsp" %>
<title>로그인 페이지</title>
<script>
	if("${pram.loginChk}"=="0"){
		alert("아이디 또는 패스워드가 틀렸습니다. 다시 시도해주세요.")
	}
</script>
</head>
<body>
	<body>
	  <h2>로그인</h2>
	  <form action="login" method="post">
	    <label>아이디</label>
	    <input type="text" name="id"><br/>
	    <label>패스워드</label>
	    <input type="password" name="pw"><br/>
	    <input type="submit" value="로그인">
	  </form>
	  
	  <div><a href="/">메인페이지 이동</a></div>
	
<%@ include file = "../footer.jsp" %>