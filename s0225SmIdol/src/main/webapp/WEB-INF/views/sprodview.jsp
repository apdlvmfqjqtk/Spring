<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fm"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <title>물건 상세 뷰</title>
	<link rel="stylesheet" as="style" crossorigin href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/variable/pretendardvariable.min.css" />  
  <style>
    /* 기본 초기화 */
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
    }
		a {
			text-decoration: none;
			color:white;
		}
    body {
      font-family: "Pretendard Variable", sans-serif;
      background-color: #f5f5f5;
      color: #333;
    }

    /* 헤더: 화면 최상단에 고정 (sticky) */
    header {
      width: 100%;
      background-color: #fafaf8;
      display: flex;
      justify-content: space-between;
      align-items: center;
      padding: 0 20px;
      box-shadow: 0 1px 3px rgba(0,0,0,0.1);
      position: sticky;   /* 상단 고정 */
      top: 0;
      z-index: 10;
    }

    .header-left h1 {
      font-size: 1.5rem;
      font-weight: bold;
      cursor: pointer;
    }

    .header-right nav ul {
      display: flex;
      list-style: none;
      gap: 20px;
    }

    .header-right nav ul li {
      cursor: pointer;
      font-size: 0.9rem;
      color: #666;
      transition: color 0.2s ease;
    }

    .header-right nav ul li:hover {
      color: #000;
    }

    .icons {
      display: flex;
      gap: 15px;
      margin-left: 20px;
    }

    .icons span {
      cursor: pointer;
      font-size: 0.9rem;
      color: #666;
      transition: color 0.2s ease;
    }

    .icons span:hover {
      color: #000;
    }

    /* wrapper: 상단·하단 섹션 모두 폭 1200px로 고정 */
    .wrapper {
      max-width: 1200px;
      margin: 0 auto;
      padding: 40px 20px; /* 좌우 20px, 위아래 40px */
    }

    /* 메인 컨테이너 (상단 상품정보 섹션) */
    .main-container {
      display: flex;
      gap: 40px;
      margin-bottom: 40px; /* 아래쪽 여백 */
    }

    /* 왼쪽 상품 이미지 섹션 */
    .product-images {
      flex: 1;
      background-color: #fafaf8;
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0 1px 3px rgba(0,0,0,0.1);
    }
    .main-image {
      width: 100%;
      text-align: center;
      margin-bottom: 20px;
    }
    .main-image img {
      max-width: 100%;
      height: auto;
      border: 1px solid #eee;
      background-color: #fafaf8;
      mix-blend-mode: multiply;
    }
    .thumbnail-list {
      display: flex;
      gap: 10px;
      justify-content: center;
    }
    .thumbnail-list img {
      width: 60px;
      height: 60px;
      object-fit: cover;
      cursor: pointer;
      border: 1px solid #eee;
      border-radius: 4px;
      transition: border-color 0.2s ease;
    }
    .thumbnail-list img:hover {
      border-color: #aaa;
    }

    /* 오른쪽 상품 정보 섹션 */
    .product-info {
      flex: 1;
      display: flex;
      flex-direction: column;
      gap: 20px;
    }
    .product-header {
      background-color: #fafaf8;
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0 1px 3px rgba(0,0,0,0.1);
    }
    .product-header .brand {
      font-size: 0.9rem;
      color: #888;
      margin-bottom: 5px;
    }
    .product-header .title {
      font-size: 1.4rem;
      font-weight: bold;
      margin-bottom: 10px;
      line-height: 1.4;
    }
    .product-header .sub-info {
      font-size: 0.9rem;
      color: #555;
      line-height: 1.6;
    }

    .product-pricing {
      background-color: #fafaf8;
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0 1px 3px rgba(0,0,0,0.1);
      display: flex;
      flex-direction: column;
      gap: 15px;
    }
    .price-row {
      display: flex;
      justify-content: space-between;
      align-items: center;
    }
    .price-row .label {
      font-size: 1rem;
      color: #555;
    }
    .price-row .price {
      font-size: 1.2rem;
      font-weight: bold;
      color: #eb5757;
    }
    .action-buttons {
      display: flex;
      gap: 10px;
      margin-top: 10px;
    }
    .action-buttons button {
      flex: 1;
      padding: 15px 0;
      border: none;
      border-radius: 6px;
      font-size: 1rem;
      cursor: pointer;
      transition: background-color 0.2s ease;
      font-weight: bold;
    }
    .buy-btn {
      background-color: #eb5757;
      color: #fafaf8;
    }
    .buy-btn:hover {
      background-color: #cf4545;
    }
    .sell-btn {
      border: 2px solid #eb5757;
      background-color: ;
      color: #fafaf8;
      transition: background-color 0.2s ease;
    }
    .sell-btn:hover {
      background-color: #25A767;
    }
    .shipping-info {
      background-color: #fafaf8;
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0 1px 3px rgba(0,0,0,0.1);
      font-size: 0.9rem;
      line-height: 1.6;
    }
    .shipping-info .info-row {
      display: flex;
      justify-content: space-between;
      margin-bottom: 8px;
    }
    .shipping-info .info-row span {
      color: #666;
    }
    .shipping-info .info-row .value {
      font-weight: bold;
    }
    .interest {
      color: #eb5757;
      font-weight: bold;
      cursor: pointer;
      margin-left: 5px;
    }

    /* 상품설명 및 평점 섹션 (하단) */
    .product-description {
      margin-bottom: 40px; /* 위 섹션과 통일감 */
      background-color: #fafaf8;
      border-radius: 8px;
      box-shadow: 0 1px 3px rgba(0,0,0,0.1);
      padding: 20px;
    }
    .description-image img {
      width: 100%;
      height: auto;
      border-radius: 4px;
      border: 1px solid #eee;
      display: block;
    }
    /* Collapsible 영역: prodlist.png 전용 */
    .collapsible-image {
      max-height: 1000px; /* 접었을 때 보여줄 높이 */
      overflow: hidden;
      position: relative;
      transition: max-height 0.3s ease;
    }
    .collapsible-image.expanded {
      max-height: none; /* 펼쳐졌을 때 제한 없음 */
    }
    .toggle-btn {
      display: block;
      width: 100%;
      padding: 10px;
      background-color: #eee;
      border: none;
      border-top: 1px solid #ddd;
      cursor: pointer;
      font-size: 1rem;
      text-align: center;
      margin-bottom: 10px;
    }

    /* 상품 상세 정보 섹션 */
    .product-details, .extra-box {
      margin-bottom: 40px;
      background-color: #fafaf8;
      border-radius: 8px;
      box-shadow: 0 1px 3px rgba(0,0,0,0.1);
      padding: 20px;
    }
    .product-details h2, .extra-box h2 {
      margin-bottom: 10px;
      font-size: 1.4rem;
    }
    .product-details p, .extra-box p {
      font-size: 1rem;
      line-height: 1.5;
      color: #555;
    }
    
    a{
    	text-decoration: none;
    	text-indent: none;
    	color: green;
    	font-size: 14px;
    }
  </style>
</head>
<body>

<!-- 헤더: .wrapper 바깥에 두어야 sticky가 문제 없이 동작 -->
<header>
  <div class="header-left">
    <h1>FANZY</h1>
  </div>
  <div class="header-right">
    <nav>
      <ul>
        <li>HOME</li>
        <li>STYLE</li>
        <li>SHOP</li>
      </ul>
    </nav>
    <div class="icons">
      <span>검색</span>
      <span>♥</span>
      <span>장바구니</span>
      <span>마이페이지</span>
    </div>
  </div>
</header>

<div class="wrapper">
  <!-- 메인 컨테이너 -->
  <div class="main-container">
    <!-- 왼쪽 상품 이미지 섹션 -->
    <div class="product-images">
      <div class="main-image">
        <img src="/images/stelLive/riko.jpg" alt="Product Main Image" />
      </div>
      <div class="thumbnail-list">
        <img src="/images/stelLive/riko.jpg" alt="Thumb1">
        <img src="/images/stelLive/rin.jpg" alt="Thumb2">
        <img src="/images/stelLive/nana.jpg" alt="Thumb3">
      </div>
    </div>

    <!-- 오른쪽 상품 정보 섹션 -->
    <div class="product-info">
      <div class="product-header">
        <a href="/sprods?artistNo=${artist.artist_no}"><div class="brand">${artist.artist_group_name}</div></a>
        <div class="title">${prod.shop_title}</div>
        <div class="sub-info">
          출시일 25/02/2020<br/>
          컬러: Green<br/>
        	제조국 : 중국
        </div>
      </div>

      <div class="product-pricing">
        <div class="price-row">
          <span class="label">일반 구매가</span>
          <span class="price">
          	<fm:formatNumber value="${prod.shop_price}" pattern="#,###" /> ₩
          </span>
        </div>
        <div class="price-row">
          <span class="label">회원 구매가 <a href="/">회원이란?</a></span>
          <span class="price">
          	<fm:formatNumber value="${prod.shop_discount_price}" pattern="#,###" /> ₩
					</span>
        </div>
        <div class="action-buttons">
          <!-- <button class="sell-btn" onclick="location.href= '/spayment' ">관심등록</button> -->
          <button class="buy-btn" onclick="location.href= '/spayment' ">구매</button>
        </div>
      </div>

      <div class="shipping-info">
        <div class="info-row">
          <span>국내 배송비</span>
          <span class="value">무료</span>
        </div>
        <div class="info-row">
          <span>해외 배송비</span>
          <span class="value">Asia: 10,000 ₩ &nbsp&nbsp Etc: 30,000 ₩</span>
        </div>
        <div class="info-row">
          <span>멤버쉽 혜택 안내</span>
          <span class="value">상품가 1% 포인트 적립</span>
        </div>
        <div>
          브랜드: <span>Supreme</span>
          <span class="interest">관심상품</span>
        </div>
      </div>
    </div>
  </div><!-- /.main-container -->

  <!-- 상품설명 이미지와 평점 섹션 -->
  <div class="product-description">
    <div class="description-image">
      <!-- 첫 번째 상품설명 이미지 -->
      <img src="/images/stelLive/memAll.jpg" alt="Product Description Image" />
      <!-- prodlist.png는 접을 수 있는 영역으로 -->
      <div class="collapsible-image">
        <img src="/images/prodlist.png" alt="Long Product Description" />
      </div>
      <button class="toggle-btn">더보기</button>
    </div>
  </div>

  <!-- 상품 상세 정보 섹션 -->
  <div class="product-details">
    <h2>상품 상세 정보</h2>
    <p>여기에 상품에 대한 상세한 정보를 입력하세요. 소재, 기능, 사용법 등 중요한 내용들을 기술하면 좋음.</p>
  </div>

  <!-- 추가 정보 상자 섹션 -->
  <div class="extra-box">
    <h2>추가 정보</h2>
    <p>여기에 다른 내용을 자유롭게 입력하세요. 이벤트, 관련 소식, 사용자 후기 등 다양한 정보를 넣을 수 있음.</p>
  </div>
</div><!-- /.wrapper -->
<!-- 썸네일 클릭 시 메인 이미지 교체 & collapsible toggle 스크립트 -->
<script>
document.addEventListener('DOMContentLoaded', function() {
	  // 썸네일 클릭 시 메인 이미지 교체
	  const thumbnails = document.querySelectorAll('.thumbnail-list img');
	  const mainImage = document.querySelector('.main-image img');
	  thumbnails.forEach(thumbnail => {
	    thumbnail.addEventListener('click', function() {
	      mainImage.src = this.src;
	    });
	  });
	
	  // collapsible-image 토글
	  const toggleBtn = document.querySelector('.toggle-btn');
	  const collapsibleImage = document.querySelector('.collapsible-image');
	
	  toggleBtn.addEventListener('click', function() {
	    if (collapsibleImage.classList.contains('expanded')) {
	      collapsibleImage.classList.remove('expanded');
	      toggleBtn.textContent = '더보기';
	    } else {
	      collapsibleImage.classList.add('expanded');
	      toggleBtn.textContent = '접기';
	    }
	  });
	});
</script>
