<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../include/header.jsp" />

<link rel="stylesheet" type="text/css" href="./css/cart/cart_list.css">
<div class="cart-area">

	<div class="title-area">
		<h2>장바구니</h2>
	</div>
	<div class="cart-main-area">
		
		<table class="cart-table" border="1">
		 <colgroup>
		  <col style="width:45px">
		  <col style="width:150px">
		  <col style="width:150px">
		  <col style="width:350px">
		  <col style="width:120px">
		  <col style="width:120px">
		  <col style="width:120px">
		  <col style="width:140px">
		 </colgroup>
		 <thead>
		  <tr>
		   <th scope="col">
		    <input type="checkbox" class="all_check_input" checked="checked">
		   </th>
		   <th scope="col">이미지</th>
		   <th scope="col">분류</th>
		   <th scope="col">상품정보</th>
		   <th scope="col">판매가</th>
		   <th scope="col">수량</th>
		   <th scope="col">합계</th>
		   <th scope="col">선택</th>
		  </tr>
		 </thead>
		 <c:if test="${!empty cvo}">
		 <tbody>
		 
		<c:forEach var="c" items="${cvo}">
		  <tr>
		   <td class="cart_info" style="width:1px;">
		    <input type="checkbox" class="cart_checkbox" name="cart_checkbox" data-no="${c.cart_no}" checked="checked">
		    <input type="hidden" class="total_before_price_input" value="${c.p_before_price * c.amount_count}">
		    <input type="hidden" class="cart_sale_price_input" value="${c.cart_sale_price}">
		   </td>
		   <td><img src="/upload${c.p_img1}"/></td>
		   <td>
		    <ul class="classification-area">
		     <li>${c.p_class}</li>
		     <li>${c.p_category}</li>
		    </ul>
		   </td>
		   <td>
		     <ul class="product-info-area">
		      <li class="product-name"><b>${c.p_name}</b></li>
		      <li class="product-option">[ 옵션 ]</li>
		      <li class="product-option">색상 : ${c.cart_color}</li>
		      <li class="product-option">사이즈 : ${c.cart_size}</li>
		     </ul>
		   </td>
		   <td>
		    <ul class="price-info-area">
		     <li><span class ="before_price">${c.p_before_price}</span>원</li>
		     <li><span class = "p_price"><b>${c.p_price}</b></span>원</li>
		    </ul>
		   </td>
		   <td>
		    <span class="count-select-area">
		     <input type="button" class="minusBtn" value="-">
		     <input class="amount_count" name="amount_count" value="${c.amount_count}" readonly>
		     <input type="button" class="plusBtn" value="+">
		     <br>
		     <input type="button" class="count_modifyBtn" value="변경" data-no="${c.cart_no}" data-price="${c.p_price}" data-saleprice="${c.p_before_price - c.p_price}">
		    </span>
		   </td>
		   <td>
		    <span class="each_price_span">${c.cart_price}</span>원
		   </td>
		   <td>
		    <span class="each-Btn-area">
		     <input type="button" class="orderBtn" value="주문하기">
		     <br>
		     <input type="button" class="deleteBtn" value="X 삭제" data-no="${c.cart_no}">
		    </span>
		   </td>
		  </tr>
		  </c:forEach> 
		 </tbody>
		 </c:if>
		 <c:if test="${empty cvo}">
		  <tbody>
		  <tr>
		   <th colspan="8" style="height:100px; color:grey; font-size:20px;">
		   	 장바구니에 담긴 상품이 없습니다.
		   </th>
		  </tr>
		  </tbody>
		 </c:if>
		 <tfoot>
		  <tr>
		   <td colspan="8">
		        상품구매금액(<span class="allPrice_span"></span>)원
		     - 상품할인금액(<span class="allSalePrice_span"></span>)원
		     = 합계 : <b><span class="finalPrice_span"></span></b>원
		   </td>
		  </tr>
		 </tfoot>
		</table>
	</div>
	<div class="cart-allBtn-area">
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>
	 <input type="button" class="select-orderBtn" value="선택상품 주문하기">
	 
	<script>
	
	 $(".select-orderBtn").click(function(){
		
		IMP.init('imp53454156');
		  
		  IMP.request_pay({
		    pg: 'html5_inicis',
		    pay_method: 'card',
		    merchant_uid : 'merchant_'+new Date().getTime(),
		    name : '결제테스트',
		    amount : 200,
		    buyer_email : 'iamport@siot.do',
		    buyer_name : '구매자',
		    buyer_tel : '010-1234-5678',
		    buyer_addr : '서울특별시 강남구 삼성동',
		    buyer_postcode : '123-456'
		  }, function (rsp) { // callback
		      console.log(rsp);
		  	  //결제검증
		  	  $.ajax({
		  		  type : "POST",
		  		  url : "/verifyIamport/" + rsp.imp_uid
		  	  }),done(function(data) {
		  		  console.log(data);
		  		  
		  		  if(rsp.paid_amount == data.response.amount){
		  			  alert("결제 및 결제검증완료");
		  		  } else{
		  			  alert("결제 실패");
		  		  }
		  	  })
		   });
		 });
	</script>
	 <input type="button" class="select-deleteBtn" value="선택상품 삭제">
	</div>
	<!-------------------- 장바구니 리스트 관련 기능과 아작스 불러오기 -------------------->
	<script src="./js/cart/cart_list.js"></script>
	
	
</div>
<jsp:include page="../include/footer.jsp" />