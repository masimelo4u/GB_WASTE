<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
  /**  
   * @Class Name : wasteList.jsp
   * @Description : 수거신청 관리 목록 화면
   * @Modification Information  
   * @
   * @  수정일      수정자              수정내용
   * @ ---------   ---------   -------------------------------
   * @ 2017.04.19   미키    최초생성
   * 
   * @author 미키
   * @since 2017.04.19
   * @version 1.0
   * @see
   * 
   *  Copyright (C) by 미키 All right reserved.
   */
%>
<link rel="stylesheet" href="/assets/js/jquery-ui/css/no-theme/jquery-ui-1.10.3.custom.min.css">
<link rel="stylesheet" href="/assets/css/font-icons/entypo/css/entypo.css">
<link rel="stylesheet" href="//fonts.googleapis.com/css?family=Noto+Sans:400,700,400italic">
<link rel="stylesheet" href="/assets/css/bootstrap.css">
<link rel="stylesheet" href="/assets/css/neon-core.css">
<link rel="stylesheet" href="/assets/css/neon-theme.css">
<link rel="stylesheet" href="/assets/css/neon-forms.css">
<link rel="stylesheet" href="/assets/css/custom.css">

<style>
	.short {
	width:150px;
	overflow:hidden;
	text-overflow:ellipsis;
	white-space:nowrap;
	/* border:1px solid red; */
	}
</style>
<script type="text/javaScript" language="javascript" defer="defer">
	function fn_addView() {
	   	document.wasteListForm.action = "<c:url value='/wst/addWasteApplyView.do'/>";
	   	document.wasteListForm.submit();		
	}
	function fn_egov_select(id, oid) {
		document.wasteListForm.wasteApplyNo.value = id;
		document.wasteListForm.oid.value = oid;
	   	document.wasteListForm.action = "<c:url value='/wst/updateWasteApplyView.do'/>";
	   	document.wasteListForm.submit();		
	}
</script>
<!-- <script type="text/javascript" language="javascript">
	$(function() {
		$('.dot1').dotdotdot({
		      ellipsis: '...',//말줄임 뭘로 할지
		      watch : false, //윈도우 창에따라서 업데이트 할건지, 윈도우가 리사이즈될 때 업데이트할 건지
		      wrap : 'letter',//word(단어단위), letter(글 단위), children(자식단위) 자르기
		      height  : 20,
		      tolerance : 20 //글이 넘치면 얼만큼 height 늘릴건지
		  });
	});
</script> -->
			
<ol class="breadcrumb bc-3" >
	<li><i class="entypo-folder"></i> 대형폐기물 처리</li>
	<li>수거신청 관리</li>
	<li class="active"><a href="/wst/selectWasteList.do"><strong>수거신청 관리</strong></a></li>
</ol>
<h2><strong>수거신청 관리</strong></h2>
<br />
<script type="text/javascript">
	jQuery( document ).ready( function( $ ) {
		var d = new Date();
		var month = d.getMonth()+1;
		var day = d.getDate();
		var today = d.getFullYear() + '-' +
		    (month<10 ? '0' : '') + month + '-' +
		    (day<10 ? '0' : '') + day;
		if($("#cDateF").val() == "") {
			$("#cDateF").val(today);	
		}
		if($("#cDateT").val() == "") {
			$("#cDateT").val(today);	
		}
		var $table4 = jQuery( "#table-4" );
		$table4.DataTable( {
			"aLengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]],
			"bStateSave": true,
			pageLength: 10,
			//pagingType : "full_numbers",
			"bPaginate": true,
	        bLengthChange: true,
	        //lengthMenu : [ [ 1, 3, 5, 10, -1 ], [ 1, 3, 5, 10, "All" ] ],
	        responsive: true,
	        processing: true,
	        ordering: true,
	        searching: true,
			//dom: 'Bfrtip',
	 		//buttons: [	'excelHtml5'],
			columnDefs: [ {
	            orderable: true,
	            //className: 'select-checkbox',
	            targets:   0
	        } ],
	         select: {
	            style:    'os',
	            selector: 'td:first-child'
	        },
	        order: [[ 0, 'desc' ]]
		} );
		// Initalize Select Dropdown after DataTables is created
		$table4.closest( '.dataTables_wrapper' ).find( 'select' ).select2( {
			minimumResultsForSearch: -1
		});
	} );		
</script>
<form name="wasteListForm" id="wasteListForm" method="post" action="/wst/selectWasteList.do">
<input type="hidden" id="wasteApplyNo" name="wasteApplyNo" />
<input type="hidden" id="oid" name="oid" />
<div class="panel panel-info" data-collapsed="0">
	<!-- panel head -->
	<div class="panel-heading">
		<div class="panel-title"><i class="entypo-search"></i> <strong>검색</strong></div>
		<div class="panel-options">
			<!-- <a href="#sample-modal" data-toggle="modal" data-target="#sample-modal-dialog-1" class="bg"><i class="entypo-cog"></i></a> -->
			<a href="#" data-rel="collapse"><i class="entypo-down-open"></i></a>
			<!-- <a href="#" data-rel="reload"><i class="entypo-arrows-ccw"></i></a>
			<a href="#" data-rel="close"><i class="entypo-cancel"></i></a> -->
		</div>
	</div>
	<!-- panel body -->
	<div class="panel-body">
		
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr>
				<td>
					<select class="form-control" id="collectDate" name="collectDate">
						<option value="">수거여부</option>
						<option value="Y" <c:if test="${'Y' eq collectDate }">selected="selected"</c:if>>수거</option>
						<option value="N" <c:if test="${'N' eq collectDate }">selected="selected"</c:if>>미수거</option>
					</select>
				</td>
				<td>
					<select class="form-control" id="payStatus" name="payStatus">
						<option value="">결제여부</option>
						<option value="Y" <c:if test="${'Y' eq payStatus }">selected="selected"</c:if>>결제</option>
						<option value="N" <c:if test="${'N' eq payStatus }">selected="selected"</c:if>>미결제</option>
						<option value="C" <c:if test="${'C' eq payStatus }">selected="selected"</c:if>>취소</option>
						<option value="R" <c:if test="${'R' eq payStatus }">selected="selected"</c:if>>환불</option>
						<option value="PR" <c:if test="${'PR' eq payStatus }">selected="selected"</c:if>>일부환불</option>
						<option value="IC" <c:if test="${'IC' eq payStatus }">selected="selected"</c:if>>인증기처리</option>
					</select>
				</td>
				<td>
					<select class="form-control" id="reqHjdong" name="reqHjdong">
						<option value="">지역선택</option>
						<option value="강북구청" <c:if test="${'강북구청' eq reqHjdong }">selected="selected"</c:if>>강북구청</option>
						<option value="미아동" <c:if test="${'미아동' eq reqHjdong }">selected="selected"</c:if>>미아동</option>
						<option value="번1동" <c:if test="${'번1동' eq reqHjdong }">selected="selected"</c:if>>번1동</option>
						<option value="번2동" <c:if test="${'번2동' eq reqHjdong }">selected="selected"</c:if>>번2동</option>
						<option value="번3동" <c:if test="${'번3동' eq reqHjdong }">selected="selected"</c:if>>번3동</option>
						<option value="삼각산동" <c:if test="${'삼각산동' eq reqHjdong }">selected="selected"</c:if>>삼각산동</option>
						<option value="삼양동" <c:if test="${'삼양동' eq reqHjdong }">selected="selected"</c:if>>삼양동</option>
						<option value="송중동" <c:if test="${'송중동' eq reqHjdong }">selected="selected"</c:if>>송중동</option>
						<option value="송천동" <c:if test="${'송천동' eq reqHjdong }">selected="selected"</c:if>>송천동</option>
						<option value="수유1동" <c:if test="${'수유1동' eq reqHjdong }">selected="selected"</c:if>>수유1동</option>
						<option value="수유2동" <c:if test="${'수유2동' eq reqHjdong }">selected="selected"</c:if>>수유2동</option>
						<option value="수유3동" <c:if test="${'수유3동' eq reqHjdong }">selected="selected"</c:if>>수유3동</option>
						<option value="우이동" <c:if test="${'우이동' eq reqHjdong }">selected="selected"</c:if>>우이동</option>
						<option value="인수동" <c:if test="${'인수동' eq reqHjdong }">selected="selected"</c:if>>인수동</option>
					</select>
				</td>
				<td>
					<div class="input-group">
					
						<input type="text" class="form-control datepicker" data-format="yyyy-mm-dd" id="cDateF" name="cDateF" size="14" value="${cDateF }">
						<div class="input-group-addon">
							<a href="#"><i class="entypo-calendar"></i></a>
						</div>
					</div>
				</td>
				<td>
					<div class="input-group">
						<input type="text" class="form-control datepicker" data-format="yyyy-mm-dd" id="cDateT" name="cDateT" size="14" value="${cDateT }">
						<div class="input-group-addon">
							<a href="#"><i class="entypo-calendar"></i></a>
						</div>
					</div>
				</td>
				<td>
					<div>
						<input type="text" class="form-control" id="requestNm" name="requestNm" placeholder="신청인을 입력하세요" value="${requestNm }">
					</div>
				</td>
				<td style="width:5%; text-align:right">
					<button type="submit" class="btn btn-primary">검색</button>
				</td>
			</tr>
		</table>
		
	</div>
</div>
<div align="right" style="margin-bottom: 10px">
	<a href="javascript:fn_addView();"><button type="button" class="btn btn-blue">수거신청 등록</button></a>
</div>
</form>
<table class="table table-bordered datatable" id="table-4">
	<thead>
		<tr>
			<th style="text-align:center">번호</th>
			<th style="text-align:center">신청일</th>
			<th style="text-align:center">신청인</th>
			<th style="text-align:center">연락처</th>
			<th style="text-align:center">해당지역</th>
			<th style="text-align:center">폐기물명</th>
			<th style="text-align:center">수수료</th>
			<th style="text-align:center">결제여부</th>
			<th style="text-align:center">수거일</th>
			<th style="text-align:center">관리자ID</th>
			<th style="text-align:center">신고증</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="result" items="${resultList}" varStatus="status">
			<tr>
				<td align="center"><c:out value="${result.rnum }"/></td>
				<td align="center"><c:out value="${result.creationDate }"/></td>
				<td align="center"><a href="javascript:fn_egov_select('<c:out value="${result.wasteApplyNo }"/>', '<c:out value="${result.oid }"/>')"><font color="#0072BC"><b><c:out value="${result.requestNm }"/></b></font></a></td>
				<td align="center"><c:out value="${result.reqTelephone }"/></td>
				<td align="center"><c:out value="${result.reqHjdong }"/></td>
				<td align="left"  width="170"><div class="short"><a href="javascript:fn_egov_select('<c:out value="${result.wasteApplyNo }"/>', '<c:out value="${result.oid }"/>')"><font color="#0072BC"><c:out value="${result.item }"/></font></a></div></td>
				<td align="right"><font color="#D42020"><b><c:out value="${result.price }"/></b></font></td>
				<td align="center"><c:out value="${result.payStatus }"/>(<c:out value="${result.payType }"/>)</td>
				<td align="center"><c:out value="${result.collectDate }"/></td>
				<td align="center"><c:out value="${result.managerId }"/></td>
				<td align="center"><button type="button" class="btn btn-white btn-xs">인쇄</button></td>
			</tr>
		</c:forEach>
	</tbody>
	<!-- <tfoot>
		<tr>
			<th style="text-align:center">번호</th>
			<th style="text-align:center">신청일</th>
			<th style="text-align:center">신청인</th>
			<th style="text-align:center">연락처</th>
			<th style="text-align:center">해당지역</th>
			<th style="text-align:center">폐기물명</th>
			<th style="text-align:center">수수료</th>
			<th style="text-align:center">결제여부</th>
			<th style="text-align:center">수거일</th>
			<th style="text-align:center">관리자ID</th>
			<th style="text-align:center">신고증</th>
		</tr>
	</tfoot> -->
</table>
	
	
<!-- Imported styles on this page -->
<link rel="stylesheet" href="/assets/js/datatables/datatables.css">
<link rel="stylesheet" href="/assets/js/select2/select2-bootstrap.css">
<link rel="stylesheet" href="/assets/js/select2/select2.css">
<link rel="stylesheet" href="/assets/js/daterangepicker/daterangepicker-bs3.css">
<link rel="stylesheet" href="/assets/js/icheck/skins/minimal/_all.css">
<link rel="stylesheet" href="/assets/js/icheck/skins/square/_all.css">
<link rel="stylesheet" href="/assets/js/icheck/skins/flat/_all.css">
<link rel="stylesheet" href="/assets/js/icheck/skins/futurico/futurico.css">
<link rel="stylesheet" href="/assets/js/icheck/skins/polaris/polaris.css">

<script src="/assets/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" language="javascript" src="/jQuery.dotdotdot-master/src/jquery.dotdotdot.min.js"></script>

<!-- Imported scripts on this page -->
<script src="/assets/js/datatables/datatables.js"></script>
<script src="/assets/js/select2/select2.min.js"></script>
<script src="/assets/js/bootstrap-tagsinput.min.js"></script>
<script src="/assets/js/typeahead.min.js"></script>
<script src="/assets/js/bootstrap-datepicker.js"></script>
<script src="/assets/js/bootstrap-timepicker.min.js"></script>
<script src="/assets/js/bootstrap-colorpicker.min.js"></script>
<script src="/assets/js/moment.min.js"></script>
<script src="/assets/js/daterangepicker/daterangepicker.js"></script>
<script src="/assets/js/jquery.multi-select.js"></script>
<script src="/assets/js/icheck/icheck.min.js"></script>

