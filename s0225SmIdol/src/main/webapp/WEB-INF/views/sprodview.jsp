<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fm"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<title>물건 상세 뷰</title>
<link rel="stylesheet" as="style" crossorigin
	href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/variable/pretendardvariable.min.css" />
<style>
/* 기본 초기화 */
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

a {
	text-decoration: none;
	color: white;
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
	box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
	position: sticky; /* 상단 고정 */
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
	box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
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
	box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
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
	box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
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

.sold-out-item .buy-btn {
    filter: grayscale(100%);
    pointer-events: none;  /* 클릭 안되게 */
    cursor: not-allowed;
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
	background-color:;
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
	box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
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
	box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
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
	box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
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
	margin-bottom: 5px; /* 요소들 아래에 여백 10px */
	line-height: 1.6; /* 줄 간격 조절 */
}

a {
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
				<span>검색</span> <span>♥</span> <span>장바구니</span> <span>마이페이지</span>
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
					<img src="/images/stelLive/riko.jpg" alt="Thumb1"> <img
						src="/images/stelLive/rin.jpg" alt="Thumb2"> <img
						src="/images/stelLive/nana.jpg" alt="Thumb3">
				</div>
			</div>

			<!-- 오른쪽 상품 정보 섹션 -->
			<div class="product-info">
				<div class="product-header">
					<a href="/sprods?artistNo=${artist.artist_no}"><div
							class="brand">${artist.artist_group_name}</div></a>
					<div class="title">${prod.shop_title}</div>
					<div class="sub-info">
						출시일 25/02/2020<br /> 컬러: Green<br /> 제조국 : 중국
					</div>
				</div>

				<div class="product-pricing">
					<div class="price-row">
						<span class="label">일반 구매가</span> <span class="price"> <fm:formatNumber
								value="${prod.shop_price}" pattern="#,###" /> ₩
						</span>
					</div>
					<div class="price-row">
						<span class="label">회원 구매가 <a href="/">회원이란?</a></span> <span
							class="price"> <fm:formatNumber
								value="${prod.shop_discount_price}" pattern="#,###" /> ₩
						</span>
					</div>
					<div class="action-buttons ${prod.shop_quantity == 0 ? 'sold-out-item' : ''}">
					    <button class="buy-btn" ${prod.shop_quantity == 0 ? "disabled" : ""} onclick="${prod.shop_quantity == 0 ? "" : "location.href='/sptwind'" }">
					        ${prod.shop_quantity == 0 ? "품절" : "구매"}
					    </button>
					</div>
				</div>

				<div class="shipping-info">
					<div class="info-row">
						<span>국내 배송비</span> <span class="value">무료</span>
					</div>
					<div class="info-row">
						<span>해외 배송비</span> <span class="value">Asia: 10,000 ₩
							&nbsp&nbsp Etc: 30,000 ₩</span>
					</div>
					<div class="info-row">
						<span>멤버쉽 혜택 안내</span> <span class="value">상품가 1% 포인트 적립</span>
					</div>
					<div>
						브랜드: <span>Supreme</span> <span class="interest">관심상품</span>
					</div>
				</div>
			</div>
		</div>
		<!-- /.main-container -->

		<!-- 상품설명 이미지와 평점 섹션 -->
		<div class="product-description">
			<div class="description-image">
				<!-- 첫 번째 상품설명 이미지 -->
				<img src="/images/stelLive/memAll.jpg"
					alt="Product Description Image" />
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
			<h2>FANZY 교환 및 반품 안내문</h2>

			<p>1) 교환/반품 가능 조건</p>
			<p>- 단순 변심(고객 변심)</p>
			<p>* 상품 수령 후 7일 이내 요청 가능</p>
			<p>* 음반, 포스터 등 굿즈 제품은 포장 개봉 또는 훼손 시 교환/반품 불가</p>
			<p>- 표시·광고 불일치 또는 상품 하자</p>
			<p>* 상품 수령 후 3개월 이내 또는 그 사실을 인지한 날부터 30일 이내 요청 (둘 중 빠른 기간 적용)</p>
			<p>- 특수 상품</p>
			<p>* 가전제품 등 포장이 중요한 상품은 포장 개봉/훼손 시 교환·반품 불가</p>
			<p>* 미성년자의 경우, 법정대리인 동의 없으면 상품 수령 후 7일 이내 취소/환불 가능</p>

			<hr />

			<p>2) 교환/반품 불가능 조건</p>
			<p>- 상품 수령 후 7일이 지난 경우</p>
			<p>- 고객 부주의로 상품 멸실·훼손, 사용 흔적이 남아 상품 가치가 현저히 감소한 경우</p>
			<p>- 포장 개봉/훼손으로 상품 가치 상실 (음반, 포스터, 가전제품 등)</p>
			<p>- 이벤트·프로모션 증정품 누락 시 (교환/환불 불가)</p>
			<p>- 주문제작 상품, 세일 상품 등 상세페이지에 교환/환불 불가로 명시된 상품</p>
			<p>- 오배송·불량 상품이라도 사용 흔적·훼손이 있으면 교환/반품 불가</p>

			<hr />

			<p>3) 교환/반품 절차</p>
			<p>- 사전 접수 필수: FANZY 고객센터(마이페이지 1:1 문의 등)로 주문번호, 성함, 연락처, 문제 확인용
				사진 등을 보내야 함</p>
			<p>- 임의로 택배 발송 시 반송될 수 있음</p>
			<p>- FANZY 측에서 확인 후 회수 택배를 보내거나 교환/환불 절차 진행</p>
			<p>- 지정 택배사 사용 권장 (타 택배사 이용 시 선불 부담)</p>

			<hr />

			<p>4) 배송비 및 환불 안내</p>
			<p>- 단순 변심 시</p>
			<p>* 왕복 배송비 6,000원 (최초 무료배송 상품일 경우 추가 6,000원 부과)</p>
			<p>- 상품 하자·오배송 시</p>
			<p>* FANZY가 배송비 부담</p>
			<p>- 교환</p>
			<p>* 동일 상품으로 교환, 재고 없을 시 환불</p>
			<p>- 부분 반품</p>
			<p>* 남은 상품이 무료배송 기준액 미달 시, 부분 반품 금액에서 택배비 3,000원 차감 후 환불</p>
			<p>- 취소/환불</p>
			<p>* 상품 도착 후 주말·공휴일 제외 5일 이내 처리</p>
			<p>* 수령 후 7일 초과 시 상품 금액에서 10% 취소 수수료 차감 후 환불</p>
			<p>* 결제 방식에 따라 환불 방식 달라짐</p>

			<hr />

			<p>5) 기타 주의사항</p>
			<p>- 모든 상품은 재고 소진 위험이 있으므로 단순 변심 교환은 어려울 수 있음</p>
			<p>- 무료배송 상품이어도 단순 변심 반품 시 왕복 택배비 고객 부담</p>
			<p>- FANZY 온라인 구매 상품은 FANZY 오프라인 매장에서 교환·환불 불가 (반대도 동일)</p>
			<p>- 상품은 반드시 수령 당시 상태 그대로 반품해야 함</p>
			<p>- 각 상품별 상세 안내가 다를 수 있으니, 상품 상세페이지와 1:1 문의로 최종 확인 바람</p>
			<p>
				<a href="/squestion">고객센터에 문의</a>
			</p>

		</div>
		<!-- extra-boxe -->


	</div>
	<!-- /.wrapper -->
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