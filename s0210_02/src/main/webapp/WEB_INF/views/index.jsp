<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>메인 페이지</title>
		<script>
			if("${param.logout}" == "1"){
				alert("로그아웃이 되었습니다.");
				location.href="/";
			}
			w
			if("${param.chkBwrite}" == "1"){
				alert("게시글 저장됨");
				location.href="/";
			}
		</script>
	</head>
	<body>
		<h2>메인 페이지</h2>
		<div>섹션 아이디 : ${session_id}</div>
		<div>섹션 네임 : ${session_id}님 환영합니다.</div>
		<ul>
			<li><a href="/member/login">로그인</a></li>
			<li><a href="/member/logout">로그아웃</a></li>
			<li><a href="/member/member">회원가입</a></li>
			<hr>
			<li><a href="/board/blist">게시판 리스트</a></li>
			<li><a href="/board/bwrite">게시판 글쓰기</a></li>
			<li><a href="/board/bview">게시글 보기</a></li>
			<li><a href="/board/bupdate">게시글 수정</a></li>
			<li><a href="/board/breply">게시글 답변</a></li>
			<hr>
			<li><a href="/member/mlist">회원리스트</a></li>
			<li><a href="/member/memInfo">회원정보</a></li>
		</ul>
	</body>
</html>