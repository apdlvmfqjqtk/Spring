<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인정보</title>
		<style>
			h2{text-align: center;}
			table,th,td{border: 1px solid black; border-collapse: collapse;}
			table{text-align: center;  width: 800px; margin: 10px auto;}
			th,td{height: 40px}
		</style>
	</head>
	<body>
		<h2>로그인정보</h2>
		<table>
		<colgroup>
			<col width="*%">
			<col width="*%">
			<col width="*%">
			<col width="*%">
			<col width="*%">
			<col width="*%">
			<col width="*%">
		</colgroup>
			<tr>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>국어</th>
				<th>영어</th>
				<th>수학</th>
				<th>합계</th>
				<th>평균</th>
			</tr>
			<tr>
				<td>test_id</td>
				<td>test_pw</td>
				<td>test_ko</td>
				<td>test_en</td>
				<td>test_math</td>
				<td>test_total</td>
				<td>test_avg</td>
			</tr>
			<tr>
				<td>${id }</td>
				<td>${pw }</td>
				<td>${k }</td>
				<td>${e }</td>
				<td>${m }</td>
				<td>${tt }</td>
				<td>${av }</td>
			</tr>
		</table>
		<div><a href="/">메인페이지 이동</a></div>
	</body>
</html>