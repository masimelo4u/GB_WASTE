<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
  /**  
   * @Class Name : managerList.jsp
   * @Description : 관리자 목록 화면
   * @Modification Information  
   * @
   * @  수정일      수정자              수정내용
   * @ ---------   ---------   -------------------------------
   * @ 2017.04.05   NIOH    최초생성
   * 
   * @author (◕ᴗ◕✿)
   * @since 2017.04.05
   * @version 1.0
   * @see
   * 
   *  Copyright (C) by HANSHIN All right reserved.
   */
%>

<link type="text/css" rel="stylesheet" href="<c:url value='/DataTables-1.10.13/media/css/jquery.dataTables.css'/>"/>
<link type="text/css" rel="stylesheet" href="<c:url value='/DataTables-1.10.13/extensions/Select/css/select.dataTables.css'/>"/>
	
<script type="text/javascript" src="<c:url value='/DataTables-1.10.13/media/js/jquery.js'/>"></script>
<script type="text/javascript" src="<c:url value='/DataTables-1.10.13/media/js/jquery.dataTables.js'/>"></script>
<script type="text/javascript" src="<c:url value='/DataTables-1.10.13/extensions/Select/js/dataTables.select.js'/>"></script>

<script type="text/javaScript" language="javascript" defer="defer">
	$(document).ready(function() {
	    $('#mnglist').DataTable( {
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
	} );
<!--
/* 글 수정 화면 function */
function fn_egov_select(id) {
	document.listForm.selectedId.value = id;
   	document.listForm.action = "<c:url value='/sample/updateSampleView.do'/>";
   	document.listForm.submit();		
}

/* 글 등록 화면 function */
function fn_egov_addView() {
   	document.listForm.action = "<c:url value='/sample/addSampleView.do'/>";
   	document.listForm.submit();		
}

/* 글 목록 화면 function */
function fn_egov_selectList() {
	document.listForm.action = "<c:url value='/sample/egovSampleList.do'/>";
   	document.listForm.submit();
}

/* pagination 페이지 링크 function */
function fn_egov_link_page(pageNo){
	document.listForm.pageIndex.value = pageNo;
	document.listForm.action = "<c:url value='/sample/egovSampleList.do'/>";
   	document.listForm.submit();
}

-->
</script>
<ol class="breadcrumb bc-3" >
	<li><a href="#"><i class="fa-home"></i>홈</a></li>
	<li><a href="#">통합 관리</a></li>
	<li class="active"><strong>관리자 관리</strong></li>
</ol>
<h2><strong>관리자 관리</strong></h2>
<br />
<!-- <script type="text/javascript">
jQuery( document ).ready( function( $ ) {
	var $table1 = jQuery( '#table-1' );
	
	// Initialize DataTable
	$table1.DataTable( {
		"aLengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]],
		"bStateSave": true
	});
	
	// Initalize Select Dropdown after DataTables is created
	$table1.closest( '.dataTables_wrapper' ).find( 'select' ).select2( {
		minimumResultsForSearch: -1
	});
} );
</script>	 -->	
<!-- <script type="text/javascript">
jQuery( document ).ready( function( $ ) {
	var $table4 = jQuery( "#table-4" );
	
	$table4.DataTable( {
		dom: 'Bfrtip',
		buttons: [
			'copyHtml5',
			'excelHtml5',
			'csvHtml5',
			'pdfHtml5'
		]
	} );
} );		
</script> -->
<!-- <table class="table table-bordered datatable" id="table-4">
	<thead>
		<tr>
			<th>Rendering engine</th>
			<th>Browser</th>
			<th>Platform(s)</th>
			<th>Engine version</th>
			<th>CSS grade</th>
		</tr>
	</thead>
	<tbody>
		<tr class="odd gradeX">
			<td>Trident</td>
			<td>Internet Explorer 4.0</td>
			<td>Win 95+</td>
			<td class="center">4</td>
			<td class="center">X</td>
		</tr>
		<tr class="even gradeC">
			<td>Trident</td>
			<td>Internet Explorer 5.0</td>
			<td>Win 95+</td>
			<td class="center">5</td>
			<td class="center">C</td>
		</tr>
		<tr class="odd gradeA">
			<td>Trident</td>
			<td>Internet Explorer 5.5</td>
			<td>Win 95+</td>
			<td class="center">5.5</td>
			<td class="center">A</td>
		</tr>
		<tr class="even gradeA">
			<td>Trident</td>
			<td>Internet Explorer 6</td>
			<td>Win 98+</td>
			<td class="center">6</td>
			<td class="center">A</td>
		</tr>
	</tbody>
</table>		 -->		
<form:form commandName="searchVO" name="listForm" method="post">
<input type="hidden" name="selectedId" />
<div id="content_pop">
	<!-- List -->
	<div id="table">
		<table width="100%" border="0" cellpadding="0" cellspacing="0" id="mnglist" class="display">
			<thead>
	            <tr>
	                <th>번호</th>
	                <th>관리자ID</th>
	                <th>관리자명</th>
	                <th>연락처</th>
	                <th>해당동면</th>
	                <th>유형</th>
	                <th>최근접속일</th>
	                <th>삭제</th>
	            </tr>
        	</thead>  
			<tbody>
			<c:forEach var="result" items="${resultList}" varStatus="status">
			<tr>
				<td align="center" class="listtd"><c:out value="${result.wasteMngNo }"/></td>
				<td align="center" class="listtd"><a href="javascript:fn_egov_select('<c:out value="${result.managerId }"/>')"><c:out value="${result.managerId }"/></a></td>
				<td align="left" class="listtd"><c:out value="${result.managerNm }"/>&nbsp;</td>
				<td align="center" class="listtd"><c:out value="${result.telephone }"/>&nbsp;</td>
				<td align="center" class="listtd"><c:out value="${result.hjdongNm }"/>&nbsp;</td>
				<td align="center" class="listtd"><c:out value="${result.managerType }"/>&nbsp;</td>
				<td align="center" class="listtd"><c:out value="${result.lastLogin }"/>&nbsp;</td>
				<td align="center" class="listtd">&nbsp;</td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- /List -->
	<%-- <div id="paging">
		<ui:pagination paginationInfo = "${paginationInfo}"
				   type="image"
				   jsFunction="fn_egov_link_page"
				   />
		<form:hidden path="pageIndex" />
	</div> --%>
<%-- 	<div id="sysbtn1">
		<ul>
		<div id="sysbtn">
			<ul>
				<li><span class="btn_blue_l"><a href="javascript:fn_egov_addView();">관리자 등록</a><img src="<c:url value='/images/egovframework/example/btn_bg_r.gif'/>" style="margin-left:6px;"></span></li>
			</ul>
		</div>
		</ul>
	</div> --%>
</div>
</form:form>
