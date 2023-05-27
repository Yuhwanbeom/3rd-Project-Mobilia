<%@ page contentType="text/html; charset=UTF-8"%>
<jsp:include page="../include/myshop_left-look.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css" href="./css/member/order_list.css">
 <h2>과거 주문내역</h2>
 <label class="info-text">구매확정이 처리된 주문내역을 볼 수 있는 공간입니다.</label>
 </div>
 <div class="select-state">
  <a href="/myshop_orderlist?m_id=${m_id}&order_state=0">주문목록</a> <a href="/myshop_orderlist?m_id=${m_id}&order_state=-1">반품목록</a> <a href="/myshop_orderlist?m_id=${m_id}&order_state=1" class="now-order-state">과거주문내역</a>
 </div>
 <div class="orderlist-table-area">
  <table class="order_list-table" border="1">
		 <colgroup>
		  <col style="width:250px">
		  <col style="width:250px">
		  <col style="width:250px">
		  <col style="width:250px">
		 </colgroup>
		 <thead>
		  <tr>
		   <th scope="col">주문번호</th>
		   <th scope="col">상품이름</th>
		   <th scope="col">결제금액</th>
		   <th scope="col">구매확정 날짜</th>
		  </tr>
		 </thead>
		 <c:if test="${!empty ovo}">
		  <tbody>
		   <c:forEach var="o" items="${ovo}">
		    <tr>
		     <td>
		      <a href="#">${o.order_no}</a>
		     </td>
		     <td>
		      ${o.order_name}
		     </td>
		     <td>
		      <b>${o.order_price}</b>원
		     </td>
		     <td class="Btn-area">
		      <label>${o.order_date}</label>
		     </td>
		    </tr>
		   </c:forEach>
		  </tbody>
		 </c:if>
		 
   </table>

		</div>
	</div>
</div>
<jsp:include page="../include/footer.jsp" />