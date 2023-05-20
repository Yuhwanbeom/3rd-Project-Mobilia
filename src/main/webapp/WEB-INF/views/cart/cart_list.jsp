<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../include/header.jsp" />
<link rel="stylesheet" type="text/css" href="./css/cart/cart_list.css">
<script src="./js/cart/cart_list.js"></script>
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
		    <input type="checkbox" class="cart_checkbox" checked="checked">
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
		     <input type="button" class="modifyBtn" value="변경">
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
		  <script>
		 	$(document).ready(function(){
		 		setTotalInfo();
		 	});
		 	
		 	$(".cart_checkbox").on("change", function(){
		 		
		 		setTotalInfo($(".cart_info"));
		 	});
		 	
		 	$(".all_check_input").on("click", function(){
		 		
		 		if($(".all_check_input").prop("checked")){
		 			$(".cart_checkbox").prop("checked", true);
		 		} else{
		 			$(".cart_checkbox").prop("checked", false);
		 		}
		 		setTotalInfo($(".cart_info"));
		 		
		 	});
		 	
		 	function setTotalInfo(){
		 		let allPrice = 0;
		 		let allSalePrice = 0;
		 		let finalPrice = 0;
		 		
		 		$(".cart_info").each(function(index, element){
		 			if($(element).find(".cart_checkbox").is(":checked") == true){
			 			allPrice += parseInt($(element).find(".total_before_price_input").val());//할인전금액 더하기
			 			allSalePrice += parseInt($(element).find(".cart_sale_price_input").val()); //할인금액 더하기
		 			}
			 	});
			 	
			 	
			 	finalPrice = parseInt(allPrice - allSalePrice);
			 	
			 	$(".allPrice_span").text(allPrice);
			 	$(".allSalePrice_span").text(allSalePrice);
			 	$(".finalPrice_span").text(finalPrice);
		 	 }
		 	
		  </script>
		  </c:forEach> 
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
	 <input type="button" class="all-orderBtn" value="선택상품 주문하기">
	 <input type="button" class="all-deleteBtn" value="선택상품 삭제">
	</div>
	<script>
		  	$('.deleteBtn').on("click", function(){
		 		
		 		var cart_no = $('.deleteBtn').data('no');
		 		
		 		 $.ajax({
					  type:'post',
					  url:'/cart/delete',
					  headers:{
						  "Content-Type" :"application/json",
						  "X-HTTP-Method-Override":"POST"
					  },
					  dataType:'text',
					  data: JSON.stringify({
						  
						  cart_no : cart_no,
					  }),
					  success:function(result){
						  if(result == 'SUCCESS'){
							  alert('상품삭제 완료');
							  location.reload();
						  }
					  }
				  });
		 	});
	</script>
</div>
<jsp:include page="../include/footer.jsp" />