<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>메인페이지</title>
	</head>
	<body>
		<h2>메인페이지</h2>
		<div><a href="/member">회원가입</a></div>
		<div><a href="/memberinfo">회원가입 정보</a></div>
		<div><a href="/stuInput">학생성적 입력</a></div>
		<!-- 파라미터 전달 방식 -->
		<div><a href="/data?bno=10">데이터전달 1</a></div>
		
		<div><a href="/data2/100">데이터전달2</a></div>
		<div><a href="/data3/1,2,3">데이터전달3</a></div>
		<div><a href="/data4">데이터전달_객체</a></div>
	</body>
</html>