<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ include file = "header.jsp" %>
		<title>회원리스트</title>
	</head>
	<body>
	  <h2>회원리스트</h2>
	  <table>
	    <colgroup>
	      <col width="15%">
	      <col width="15%">
	      <col width="15%">
	      <col width="15%">
	      <col width="10%">
	      <col width="15%">
	      <col width="15%">
	    </colgroup>
	    <tr>
	      <th>아이디</th>
	      <th>패스워드</th>
	      <th>이름</th>
	      <th>전화번호</th>
	      <th>성별</th>
	      <th>취미</th>
	      <th>가입일</th>
	    </tr>
	    <c:forEach items="${list}" var="mdto">
	      <tr>
	        <td><a = href="/memInfo?id=${mdto.id}">${mdto.id}</td></a>
	        <td>${mdto.pw }</td>
	        <td>${mdto.name }</td>
	        <td>${mdto.phone }</td>
	        <td>${mdto.gender }</td>
	        <td>${mdto.hobby }</td>
	        <td>${mdto.mdate }</td>
	      </tr>
	    </c:forEach>
	    
	  </table>
	  
	   <div><a href="/">메인페이지 이동</a></div>
<%@ include file = "footer.jsp" %>