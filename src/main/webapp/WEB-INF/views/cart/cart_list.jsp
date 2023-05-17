<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../include/header.jsp" />
<link rel="stylesheet" type="text/css" href="./css/cart/cart_list.css">
<div class="cart-area">
	<div class="title-area">
		<h2>장바구니</h2>
	</div>
	<div class="cart-main-area">
		<table id="cart-table" border="2" style="border:none; ">
		 <colgroup>
		  <col style="width:45px">
		  <col style="width:200px">
		  <col style="width:420px">
		  <col style="width:150px">
		  <col style="width:120px">
		  <col style="width:120px">
		  <col style="width:140px">
		 </colgroup>
		 <thead style="background-color:#e8e8e8;">
		  <tr>
		   <th scope="col">
		    <input type="checkbox" style="width:18px; height:18px;">
		   </th>
		   <th scope="col">이미지</th>
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
		   <td><input type="checkbox" style="width:18px; height:18px;"></td>
		   <td><img src="/upload${c.p_img1}" style="width:100px; height:100px; "/></td>
		   <td>
		     <ul style="text-align:left; list-style:none;">
		      <li style="font-size:16px;"><b>${c.p_name}</b></li>
		      <li style="font-size:14px; color:grey;">[ 옵션 ]</li>
		      <li style="font-size:14px; color:grey;">색상 : ${c.cart_color}</li>
		      <li style="font-size:14px; color:grey;">사이즈 : ${c.cart_size}</li>
		     </ul>
		   </td>
		   <td>
		    <ul style="text-align:right; list-style:none;">
		     <li><span style="font-size: 14px; color: #a1a1a1; font-weight: bold; text-decoration: line-through;">${c.p_before_price}원</span></li>
		     <li><b style="color:#971215;">${c.p_price}</b>원</li>
		    </ul>
		   </td>
		   <td>
		    <span id="count-select-area" style="float:center; text-align:center; font-size:18px;">
		     
		     <input type="button" id="minusBtn" name="minusBtn" value="-" style="width:25px; height:25px; background-color:white; border:1px solid grey;">
		     <input id="amount-count" name="amount-count" value="${c.amount_count}" style="width:30px; height:20px; text-align:center;">
		     <input type="button" id="plusBtn" name="plusBtn" value="+" style="width:25px; height:25px; background-color:white; border:1px solid grey;">
		    </span>
		    <input type="button" id="modifyBtn" value="변경" style="width:40px; height:25px; text-align:center; font-size:5px; background-color:white; border:1px solid grey;">
		   </td>
		   <td><b>${c.totalPrice}</b></td>
		   <td>
		    <input type="button" value="주문하기" style="background-color:black; color:white; width:100px; height:30px;">
		    <input type="button" value="X 삭제" style="background-color:white; border:1px solid grey; width:100px; height:30px;">
		   </td>
		  </tr>
		  </c:forEach>
		 </tbody>
		 </c:if>
		 
		 <tfoot style="background-color:#e8e8e8;">
		  <tr>
		   <td colspan="7">
		    <span>상품구매금액 <strong>price</strong></span>
		    <span> - 상품 할인금액 sale</span>
		    <span>= 합계 : 토탈금액</span>
		   </td>
		  </tr>
		 </tfoot>
		</table>

	</div>
</div>
<jsp:include page="../include/footer.jsp" />