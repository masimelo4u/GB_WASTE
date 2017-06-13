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
   * @ 2017.04.19   NIOH    최초생성
   * 
   * @author (◕ᴗ◕✿)
   * @since 2017.04.19
   * @version 1.0
   * @see
   * 
   *  Copyright (C) by HANSHIN All right reserved.
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

<script src="/assets/js/jquery-1.11.3.min.js"></script>

<ol class="breadcrumb bc-3" >
	<li><i class="fa-home"></i>홈</li>
	<li>대형폐기물 처리</li>
	<li>수거신청 관리</li>
	<li class="active"><strong>수거신청 관리</strong></li>
</ol>
<h2><strong>수거신청 관리</strong></h2>
<br />
<script type="text/javascript">
jQuery( document ).ready( function( $ ) {
	var $table4 = jQuery( "#table-4" );
 	
	$table4.DataTable( {
		pageLength: 10,
		//pagingType : "full_numbers",
		bPaginate: true,
        bLengthChange: true,
        //lengthMenu : [ [ 1, 3, 5, 10, -1 ], [ 1, 3, 5, 10, "All" ] ],
        responsive: true,
        //bAutoWidth: true,
        processing: true,
        ordering: true,
        //bServerSide: true,
        searching: true,
		dom: 'Bfrtip',
 		buttons: [	'excelHtml5'],
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
	
	var d = new Date();
	
	var month = d.getMonth()+1;
	var day = d.getDate();

	var today = d.getFullYear() + '-' +
	    (month<10 ? '0' : '') + month + '-' +
	    (day<10 ? '0' : '') + day;
	
	$("#cDateF").val(today);
	$("#cDateT").val(today);
	
});		
</script>
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
		<form name="wasteListForm" id="wasteListForm" method="get" action="/wst/wasteList.do">
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr>
				<td>
					<select class="form-control" id="collectDate" name="collectDate">
						<option value="">수거여부</option>
						<option value="Y" <c:if test="${'Y' eq result.collectDate }">selected="selected"</c:if>>수거</option>
						<option value="N">미수거</option>
					</select>
				</td>
				<td>
					<select class="form-control" id="payStatus" name="payStatus">
						<option value="">결제여부</option>
						<option value="Y">결제</option>
						<option value="N">미결제</option>
						<!-- <option value="3">환불</option>
						<option value="4">일부환불</option>
						<option value="5">인증기처리</option>
						<option value="6">취소</option> -->
					</select>
				</td>
				<td>
					<select class="form-control" id="reqHjdong" name="reqHjdong">
						<option value="">지역선택</option>
						<option value="강북구청">강북구청</option>
						<option value="미아동">미아동</option>
						<option value="번1동">번1동</option>
						<option value="번2동">번2동</option>
						<option value="번3동">번3동</option>
						<option value="삼각산동">삼각산동</option>
						<option value="삼양동">삼양동</option>
						<option value="송중동">송중동</option>
						<option value="송천동">송천동</option>
						<option value="수유1동">수유1동</option>
						<option value="수유2동">수유2동</option>
						<option value="수유3동">수유3동</option>
						<option value="우이동">우이동</option>
						<option value="인수동">인수동</option>
					</select>
				</td>
				<td>
					<div class="input-group">
					
						<input type="text" class="form-control datepicker" data-format="yyyy-mm-dd" id="cDateF" name="cDateF" size="14">
						<div class="input-group-addon">
							<a href="#"><i class="entypo-calendar"></i></a>
						</div>
					</div>
				</td>
				<td>
					<div class="input-group">
						<input type="text" class="form-control datepicker" data-format="yyyy-mm-dd" id="cDateT" name="cDateT" size="14">
						<div class="input-group-addon">
							<a href="#"><i class="entypo-calendar"></i></a>
						</div>
					</div>
				</td>
				<td>
					<div>
						<input type="text" class="form-control" id="accountNm" name="accountNm" placeholder="신청인을 입력하세요">
					</div>
				</td>
				<td>
					<button type="submit" class="btn btn-primary">검색</button>
				</td>
			</tr>
		</table>
		</form>
	</div>
</div>
<div align="right" style="margin-bottom: 10px">
	<button type="button" class="btn btn-blue">수거신청 등록</button>
</div>
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
				<%-- <td align="center"><a href="javascript:fn_egov_select('<c:out value="${result.wasteApplyNo }"/>')"><c:out value="${result.requestNm }"/></a></td> --%>
				<td align="center"><c:out value="${result.requestNm }"/></td>
				<td align="center"><c:out value="${result.reqTelephone }"/></td>
				<td align="center"><c:out value="${result.reqHjdong }"/></td>
				<td align=""><c:out value=""/></td>
				<td align="right"><c:out value="${result.price }"/></td>
				<td align="center"><c:out value="${result.payStatus }"/>(<c:out value="${result.payType }"/>)</td>
				<td align="center"><c:out value="${result.collectDate }"/></td>
				<td align="center"><c:out value="${result.managerId }"/></td>
				<td align="center"><button type="button" class="btn btn-white btn-xs">인쇄</button></td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
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
	</tfoot>
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
