<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>뷰페이지</title>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
  <link rel="stylesheet" href="/css/style.css">
  <link rel="stylesheet" href="/css/read.css">
  <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
  <script>
  	funtion readUrl(input){
			if(input.files && input.files[0]){ //파일 이름이 있으면..
				var reader = new FileReader(); // 파일읽기 객체 가져오기
				reader.onload = funtion(e) {
					document.getElementById("preview").src = e.target.result;
				};
				reader.readAsDataURL(input.files[0]);
			}else{
				document.getElementById("preview").src="";
			}
		}
  </script>
</head>
<body>
<section>
    <h1>NOTICE</h1>

    <table>
      <colgroup>
        <col width="80%">
        <col width="10%">
        <col width="10%">
        
      </colgroup>
      <tr>
        <th colspan="3">제목</th>
      </tr>
      <tr>
        <td colspan="3"><strong>게시판 글제목이 들어갑니다.</strong></td>
      </tr>
      <tr>
        <td>작성자가 들어갑니다.</td>
        <td>조회수</td>
        <td>111</td>
      </tr>
      <tr>
        <td colspan="3" class="article">글 내용이 들어갑니다.</td>
      </tr>
      <tr>
      <tr>
      	<th>이미지 표시</th>
      	<td>
      		<input type="file" name="files" id="file" onchange="readUrl(this);">
      	</td>
      </tr>
      <tr>
      	<td>
      		<img name="preview" id="file" onchange="readUrl(this);">
      	</td>
      </tr>
        <td colspan="3"><strong>다음글</strong> <span class="separator">|</span> [키즈잼] 2월 프로그램 안내</td>
      </tr>
      <tr>
        <td colspan="3"><strong>이전글</strong> <span class="separator">|</span> [키즈잼] 2020년 1분기 정기 휴관일 안내</td>
      </tr>
    </table>

    <a href=""><div class="list">목록</div></a>
    <a href=""><div class="list">삭제</div></a>
    <a href=""><div class="list">수정</div></a>
    <a href=""><div class="list">답변달기</div></a>
  </section>
</body>
</html>