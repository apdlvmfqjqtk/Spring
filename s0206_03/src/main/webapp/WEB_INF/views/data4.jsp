<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>data4</title>
		<style>
			h2{text-align: center;}
			table,th,td{border: 1px solid black; border-collapse: collapse;}
			table{text-align: center;  width: 800px; margin: 10px auto;}
			th,td{height: 40px}
		</style>
	</head>
	<body>
		<h2>data4</h2>
		<table>
		<colgroup>
			<col width="*%">
			<col width="*%">
		</colgroup>
			<tr>
				<th>페이지 번호</th>
				<th>제목</th>
			</tr>
			<tr>
				<td>test_no</td>
				<td>test_title</td>
			</tr>
			<tr>
				<td>${bno}</td>
				<td>${btitle }</td>
			</tr>
		</table>
		<div><a href="/">메인페이지 이동</a></div>
	</body>
</html>