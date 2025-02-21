<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>로그아웃 페이지</title>
	<script>
		if("${chkLogin}" == "0"){
			alert("로그아웃이 되었습니다.")
			location.href ="/"
		}else{
			location.href ="/"
		}
	</script>
	</head>
	<body>
		<h2>로그아웃이 완료되었습니다.</h2>
		<a href="/">메인화면으로 이동</a>
	</body>
</html>