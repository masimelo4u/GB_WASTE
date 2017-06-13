<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
  /**  
   * @Class Name : specList.jsp
   * @Description : 폐기물 및 규격 관리 목록 화면
   * @Modification Information  
   * @
   * @  수정일      수정자              수정내용
   * @ ---------   ---------   -------------------------------
   * @ 2017.05.22   미키    최초생성
   * 
   * @author 미키
   * @since 2017.06.02
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
	function goPage(pageNo) {
		document.specListForm.pageNo.value = pageNo;
		document.specListForm.action = "<c:url value='/spc/selectSpecList.do'/>";
	   	document.specListForm.submit();
	}
	function fn_addView() {
	   	document.specListForm.action = "<c:url value='/spc/addSpecView.do'/>";
	   	document.specListForm.submit();		
	}
	function fn_updateView(id) {
		document.specListForm.specNo.value = id;
	   	document.specListForm.action = "<c:url value='/spc/updateSpecView.do'/>";
	   	document.specListForm.submit();		
	}
	$(function() {
		$("#pageUnit").change( function() {
			document.specListForm.pageUnit.value = this.value;
			document.specListForm.action = "<c:url value='/spc/selectSpecList.do'/>";
		   	document.specListForm.submit();
	    });	
	});
</script>
			
<ol class="breadcrumb bc-3" >
	<li><i class="entypo-folder"></i> 대형폐기물 처리</li>
	<li>폐기물 및 규격 관리</li>
	<li class="active"><a href="/spc/selectSpecList.do"><strong>폐기물 및 규격 관리</strong></a></li>
</ol>
<h2><strong>폐기물 및 규격 관리</strong></h2>
<br />
<form name="specListForm" id="specListForm" method="post" action="/spc/selectSpecList.do">
<input type="hidden" id="pageNo" name="pageNo" value="${pageNo }" />
<input type="hidden" id="specNo" name="specNo" />
<div class="panel panel-info" data-collapsed="0">
	<!-- panel head -->
	<div class="panel-heading">
		<div class="panel-title"><i class="entypo-search"></i> <strong>검색</strong></div>
		<div class="panel-options">
			<a href="#" data-rel="collapse"><i class="entypo-down-open"></i></a>
		</div>
	</div>
	<!-- panel body -->
	<div class="panel-body">
		<table border="0" cellpadding="0" cellspacing="0" width="100%" style="text-align:center">
			<tr>
				<td>
					<select class="form-control" id="sortCd" name="sortCd" style="width:100%">
						<option value="">종류선택</option>
						<option value="1" <c:if test="${'1' eq sortCd }">selected="selected"</c:if>>가전제품</option>
						<%-- <option value="2" <c:if test="${'2' eq sortCd }">selected="selected"</c:if>>냉난방기</option> --%>
						<%-- <option value="3" <c:if test="${'3' eq sortCd }">selected="selected"</c:if>>주방용품</option> --%>
						<option value="4" <c:if test="${'4' eq sortCd }">selected="selected"</c:if>>가구류</option>
						<%-- <option value="5" <c:if test="${'5' eq sortCd }">selected="selected"</c:if>>학습사무기기</option> --%>
						<option value="6" <c:if test="${'6' eq sortCd }">selected="selected"</c:if>>생활용품</option>
						<option value="7" <c:if test="${'7' eq sortCd }">selected="selected"</c:if>>기타</option>
						<option value="8" <c:if test="${'8' eq sortCd }">selected="selected"</c:if>>면제품목</option>
					</select>
				</td>
				<td>
					<select class="form-control" id="useYn" name="useYn" style="width:100%">
						<option value="">사용여부</option>
						<option value="1" <c:if test="${'1' eq useYn }">selected="selected"</c:if>>사용</option>
						<option value="2" <c:if test="${'2' eq useYn }">selected="selected"</c:if>>미사용</option>
					</select>
				</td>
				<td>
					<div>
						<input type="text" class="form-control" id="item" name="item" placeholder="품목을 입력하세요" value="${item }">
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
	<a href="<c:url value='/spc/addSpecView.do'/>"><button type="button" class="btn btn-blue">폐기물 등록</button></a>
</div>

<div class="panel panel-primary" style="margin-bottom:0px">
	<div class="panel-heading">
		<div class="panel-title">
			<div id="gridTop">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>목록</td>
						<td width="5px"></td>
						<td>
							<select class="form-control" id="pageUnit" name="pageUnit">
								<option value="10" <c:if test="${'10' eq pageUnit }">selected="selected"</c:if>>10</option>
								<option value="20" <c:if test="${'20' eq pageUnit }">selected="selected"</c:if>>20</option>
								<option value="30" <c:if test="${'30' eq pageUnit }">selected="selected"</c:if>>30</option>
							</select>
						</td>
						<td width="5px"></td>
						<td>개씩 보기</td>
					</tr>
				</table>
			</div>			
		</div>
		</form>	
		<div class="panel-title" style="float:right">
			<div id="gridTop">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>총</td>
						<td width="5px"></td>
						<td>
							<input type="text" class="form-control" value="${paginationInfo.totalRecordCount }" style="width:70px; text-align:right; background-color:#ffffff" readonly>
						</td>
						<td width="5px"></td>
						<td>건</td>
					</tr>
				</table>
			</div>			
		</div>
	</div>
	<table class="table table-bordered responsive">
		<thead>
			<tr height="40px">
				<th style="text-align:center; font-weight:bold; vertical-align:middle">번호</th>
				<th style="text-align:center; font-weight:bold; vertical-align:middle">종류</th>
				<th style="text-align:center; font-weight:bold; vertical-align:middle">품목</th>
				<th style="text-align:center; font-weight:bold; vertical-align:middle">규격</th>
				<th style="text-align:center; font-weight:bold; vertical-align:middle">부과금액</th>
				<th style="text-align:center; font-weight:bold; vertical-align:middle">사용여부</th>
				<th style="text-align:center; font-weight:bold; vertical-align:middle">수정</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="result" items="${resultList}" varStatus="status">
				<input type="hidden" id="wasteSpecNo" name="wasteSpecNo" value="${result.wasteSpecNo }" />
				<tr>
					<%-- <td align="center"><c:out value="${(paginationInfo.totalRecordCount - status.count + 1) - (paginationInfo.recordCountPerPage * paginationInfo.currentPageNo - 10)	 }"/></td> --%>
					<td align="center"><c:out value="${result.wasteSpecNo	 }"/></td>
					<td align="center"><c:out value="${result.sortNm }"/></td>
					<td align="center"><c:out value="${result.item }"/></td>
					<td align="center"><c:out value="${result.spec }"/></td>
					<td align="right"><c:out value="${result.price }"/></td>
					<td align="center"><c:out value="${result.useYn }"/></td>
					<td align="center"><a href="javascript:fn_updateView('<c:out value="${result.wasteSpecNo }"/>')"><button type="button" class="btn btn-white btn-xs">수정</button></a></td>
					<!-- <td align="center">
						<a href="#" class="btn btn-default btn-sm btn-icon icon-left">
							<i class="entypo-pencil"></i>
							Edit
						</a>
					</td> -->
				</tr>
			</c:forEach>
			<c:if test="${empty resultList}">
				<tr>
					<td align="center" colspan="7">No data available in table</td>
				</tr>
			</c:if>
		</tbody>
	</table>
</div>
	<div id="gridBottom" align="right">
		<ul class="pagination">
			<c:choose>
				<c:when test="${i eq paginationInfo.currentPageNo}"></c:when>
				<c:otherwise></c:otherwise>
			</c:choose>
			<li><a href="javascript:goPage(1)"><i class="entypo-left"></i>&nbsp;</a></li>
			<li><a href="javascript:goPage(${paginationInfo.currentPageNo-1})"><i class="entypo-left-open"></i> Previous</a></li>
			<c:forEach var="i" begin="${paginationInfo.firstPageNoOnPageList }" end="${paginationInfo.lastPageNoOnPageList }">
				<c:choose>
			        <c:when test="${i eq paginationInfo.currentPageNo}"><li class="active"><a href="javascript:goPage(${i})">${i}</a></li></c:when>
			        <c:otherwise><li><a href="javascript:goPage(${i})">${i}</a></li></c:otherwise>
			    </c:choose>
			</c:forEach>
			<li><a href="javascript:goPage(${paginationInfo.currentPageNo+1})">Next <i class="entypo-right-open"></i></a></li>
			<li><a href="javascript:goPage(${paginationInfo.totalPageCount})">&nbsp;<i class="entypo-right"></i></a></li>
		</ul>
	</div>
<!-- Imported styles on this page -->
<link rel="stylesheet" href="/assets/js/select2/select2-bootstrap.css">
<link rel="stylesheet" href="/assets/js/select2/select2.css">
<link rel="stylesheet" href="/assets/js/icheck/skins/minimal/_all.css">
<link rel="stylesheet" href="/assets/js/icheck/skins/square/_all.css">
<link rel="stylesheet" href="/assets/js/icheck/skins/flat/_all.css">
<link rel="stylesheet" href="/assets/js/icheck/skins/futurico/futurico.css">
<link rel="stylesheet" href="/assets/js/icheck/skins/polaris/polaris.css">
<link rel="stylesheet" href="/assets/js/zurb-responsive-tables/responsive-tables.css">

<script src="/assets/js/jquery-1.11.3.min.js"></script>

<!-- Imported scripts on this page -->
<script src="/assets/js/select2/select2.min.js"></script>
<script src="/assets/js/bootstrap-tagsinput.min.js"></script>
<script src="/assets/js/typeahead.min.js"></script>
<script src="/assets/js/bootstrap-colorpicker.min.js"></script>
<script src="/assets/js/moment.min.js"></script>
<script src="/assets/js/jquery.multi-select.js"></script>
<script src="/assets/js/icheck/icheck.min.js"></script>
<script src="/assets/js/zurb-responsive-tables/responsive-tables.js"></script>

