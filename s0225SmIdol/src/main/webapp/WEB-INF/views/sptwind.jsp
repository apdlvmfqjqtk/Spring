<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<title>Order Page</title>
<link rel="stylesheet" as="style" crossorigin
	href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/variable/pretendardvariable.min.css" />
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>
/* 기본 스타일 리셋 */
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

body {
	font-family: "Pretendard Variable", sans-serif;
	background-color: #F7F7FA; /* 대충 회색 배경 */
	padding: 20px;
}

/* 메인 컨테이너: 왼쪽, 오른쪽 분할 */
.wrapper {
	display: flex;
	max-width: 1200px;
	margin: 0 auto;
}

/* 왼쪽 컬럼 */
.left-col {
	width: 60%;
	margin-right: 20px;
}
/* 오른쪽 컬럼 (sticky) */
.right-col {
	width: 40%;
	position: sticky;
	top: 20px; /* 스크롤 내려도 이 위치에 고정 */
	align-self: flex-start; /* 내용 위쪽 정렬 */
}

/* 각 섹션 박스 스타일 */
.box {
	background-color: #fff;
	border: 1px solid #000; /* 사진처럼 검은색 테두리 */
	margin-bottom: 20px;
	padding: 15px;
	border-radius: 10px; /* 둥글둥글하게 */
}

/* 박스 제목 */
.box h3 {
	margin-bottom: 10px;
	font-size: 1rem;
	font-weight: bold;
}

/* 간단한 라벨 스타일 */
label {
	display: block;
	margin-bottom: 5px;
	font-weight: bold;
}

/* input, textarea, select 등 */
input[type="text"], select, textarea, #rewardInput {
	width: 100%;
	padding: 5px;
	margin-bottom: 5px;
	border: 1px solid #ccc;
	font-size: 0.9rem;
	border-radius: 5px; /* 둥글둥글하게 */
}

/* Add 버튼 등 */
.box #confirmBtn, #addAddressBtn {
	padding: 5px 10px;
	background-color: #444;
	color: #fff;
	border: none;
	cursor: pointer;
	font-size: 0.8rem;
	border-radius: 5px; /* 둥글둥글하게 */
}

/* 오른쪽 패널(가격, confirm) */
.price-info {
	margin-bottom: 20px;
}

.price-info p {
	margin-bottom: 5px;
	font-size: 0.9rem;
}

#confirmBtn {
	width: 100%;
	padding: 10px;
	background-color: #f5c3b2;
	border: none;
	color: #fff;
	font-size: 1rem;
	cursor: pointer;
	border-radius: 5px; /* 둥글둥글하게 */
}

textarea {
resize: none;
}
</style>

<c:if test="${empty mdto}">
  <script>
    alert("로그인 하셔야 구매가 가능합니다.");
    location.href = "/login";
  </script>
</c:if>
</head>
<body>

	<div class="wrapper">
		<!-- 왼쪽 컬럼 -->
		<div class="left-col">

			<!-- Order (Product name) -->
			<div class="box">
				<h3>Order (Product name)</h3>
				<p>상품번호: ${param.sprodId}</p>
				<p>주문개수: ${param.quantity}개</p>
				<p>상품명: ${sdto.shop_title}</p>
				<p>상품가격 : ${sdto.shop_price}</p>
			</div>

			<!-- Customer -->
			<div class="box">
				<h3>Customer</h3>
				<p>Add user information</p>
				<button>Add</button>
			</div>

			<!-- Address -->
			<div class="box">
				<h3>주소</h3>
				<input type="text" id="sample6_postcode" class="addressInput"
					placeholder="우편번호"> <input type="button" id="addAddressBtn"
					onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
				<br> <input type="text" id="sample6_address" placeholder="주소"><br>
				<input type="text" id="sample6_detailAddress" placeholder="상세주소">
				<input type="text" id="sample6_extraAddress" placeholder="참고항목">

				<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
				<script>
          function sample6_execDaumPostcode() {
              new daum.Postcode({
                  oncomplete: function(data) {
                      var addr = ''; 
                      var extraAddr = ''; 
      
                      if (data.userSelectedType === 'R') {
                          addr = data.roadAddress;
                      } else {
                          addr = data.jibunAddress;
                      }
      
                      if(data.userSelectedType === 'R'){
                          if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                              extraAddr += data.bname;
                          }
                          if(data.buildingName !== '' && data.apartment === 'Y'){
                              extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                          }
                          if(extraAddr !== ''){
                              extraAddr = ' (' + extraAddr + ')';
                          }
                          document.getElementById("sample6_extraAddress").value = extraAddr;
                      
                      } else {
                          document.getElementById("sample6_extraAddress").value = '';
                      }
      
                      document.getElementById('sample6_postcode').value = data.zonecode;
                      document.getElementById("sample6_address").value = addr;
                      document.getElementById("sample6_detailAddress").focus();
                  }
              }).open();
          }
      </script>
			</div>

			<!-- Option (Shipping Option) -->
			<div class="box">
				<h3>배송</h3>
				<label for="shippingSelect" id="shippingLabel">택배사 선택</label> <select id="shippingSelect">
					<option value="">-- Select Shipping --</option>
					<option value="20">Standard ($20)</option>
					<option value="30">Express ($30)</option>
				</select>
			</div>

			<!-- Site Rewards -->
			<div class="box">
			  <h3>적립금 사용</h3>
			  <label for="rewardInput" id="rewardLabel">
			    적용 가능 금액 입력 (최대 ${Math.floor(sdto.shop_price * param.quantity * 0.01)})
			  </label>
			  <p>보유 적립금: ${mdto.member_mileage}</p>
			  <p id="errorMessage" style="color: red; display: none;">보유 적립금보다 많은 금액은 입력할 수 없습니다.</p>
			  <input type="number"
			         id="rewardInput"
			         min="0"
			         max="${Math.floor(sdto.shop_price * param.quantity * 0.01)}"
			         placeholder="사용할 적립금 입력">
			</div>
			
			<script>
			  // 보유 적립금, 숫자로 변환
			  const availableMileage = Number(${mdto.member_mileage});
			  
			  const rewardInput = document.getElementById('rewardInput');
			  const errorMessage = document.getElementById('errorMessage');
			  
			  rewardInput.addEventListener('input', function() {
			    const inputVal = Number(this.value);
			    if (inputVal > availableMileage) {
			      errorMessage.style.display = 'block';
			    } else {
			      errorMessage.style.display = 'none';
			    }
			  });
			</script>


			<!-- Payment method -->
			<div class="box">
				<h3>결제수단</h3>
				<select id="paymentMethod">
					<option value="kakaopay">카카오페이</option>
					<option value="tosspay">토스페이</option>
				</select>
			</div>

			<!-- Please Note -->
			<div class="box">
				<h3>배송 메시지</h3>
				<textarea rows="4" placeholder="배송 주의사항을 기입해주세요."></textarea>
			</div>

		</div>

		<!-- 물건정보 ajax -->
		<script>
			function buyBtn() {
				if(confirm("상품을 구매하시겠습니까?")) {
					alert("구매하겠습니다.")
			
			    var shop_title = "${sdto.shop_title}";
			    var shop_price = ${sdto.shop_price};
			    var quantity = ${param.quantity};
    			// 이후 이 변수들을 자유롭게 사용 가능

			    let pnm = shop_title;
			    let ppc = shop_price * quantity;
    
					let buyDate = {
						name: pnm,
						totalPrice: ppc
					};
					
					$.ajax({
              url: '/pay/orderPay',
              type: 'POST',
              data: buyDate,
              dataType: 'json',
              success: function(data) {
            	  alert("성공");
                  console.log(data);
                  console.log(data.next_redirect_pc_url);
            	  location.href = data.next_redirect_pc_url;
              },
              error:function(){
            	  alert("실패");
              }
          });
					
				} else {
					alert("결제가 취소되었습니다.")
				} // if문
			} // function
		</script>

		<!-- 오른쪽 정보, 구매버튼 -->
		<div class="right-col">
			<div class="box price-info">
				<p>
					<strong>Price</strong>
				</p>
				<p>Product: 30</p>
				<p>개수 ${param.quantity}개</p>
				<p>Shipping: 20</p>
				<p>total: ${sdto.shop_price * param.quantity}</p>
				<p>rewards: $5</p>
			</div>
			<div id="confirmBtn" onclick="buyBtn()">Confirm</button>
		</div>
	</div>

</body>
</html>
