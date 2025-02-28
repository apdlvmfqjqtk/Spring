<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" as="style" crossorigin
	href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/variable/pretendardvariable.min.css" />
<style>
body {
	font-family: "Pretendard Variable", Pretendard, -apple-system,
		BlinkMacSystemFont, system-ui, Roboto, "Helvetica Neue", "Segoe UI",
		"Apple SD Gothic Neo", "Noto Sans KR", "Malgun Gothic",
		"Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", sans-serif;
}
</style>
<title>메인 페이지</title>
</head>
<body>
	<h2>메인 페이지</h2>
	<div>섹션 아이디 : ${session_id}</div>
	<div>섹션 네임 : ${session_id}님 환영합니다.</div>
	<ul>
		<li><a href="/blist">게시판</a></li>
		<li><a href="/login">로그인</a></li>
		<li><a href="/member">회원가입</a></li>
		<li><a href="/mlist">회원리스트</a></li>
		<li><a href="/member/logout">로그아웃</a></li>
		<li><a href="/board/boardWrite">글쓰기</a></li>
		<hr>
		<li><a href="/board/bview?bno=2">게시글보기</a></li>
		<li><a href="/member/memInfo">회원정보</a></li>
	</ul>
</body>
</html>