<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%
  /**  
   * @Class Name : popSpec.jsp
   * @Description : 폐기물 규격 팝업 화면
   * @Modification Information  
   * @
   * @  수정일      수정자              수정내용
   * @ ---------   ---------   -------------------------------
   * @ 2017.05.10   미키    최초생성
   * 
   * @author 미키
   * @since 2017.05.10
   * @version 1.0
   * @see
   * 
   *  Copyright (C) by 미키 All right reserved.
   */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">

	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<meta name="author" content="" />
	<link rel="icon" href="/assets/images/favicon.ico">
	<title>대형폐기물 처리</title>
</head>
<script src="/assets/js/jquery-1.11.3.min.js"></script>

<link rel="stylesheet" href="/assets/js/jquery-ui/css/no-theme/jquery-ui-1.10.3.custom.min.css">
<link rel="stylesheet" href="/assets/css/font-icons/entypo/css/entypo.css">
<link rel="stylesheet" href="//fonts.googleapis.com/css?family=Noto+Sans:400,700,400italic">
<link rel="stylesheet" href="/assets/css/bootstrap.css">
<link rel="stylesheet" href="/assets/css/neon-core.css">
<link rel="stylesheet" href="/assets/css/neon-theme.css">
<link rel="stylesheet" href="/assets/css/neon-forms.css">
<link rel="stylesheet" href="/assets/css/custom.css">
<%@ page import="java.util.*" %>

<style>
	.short {
	width:150px;
	overflow:hidden;
	text-overflow:ellipsis;
	white-space:nowrap;
	/* border:1px solid red; */
	}
</style>
<script src="/assets/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript"> 
	function selectSpecBtn(item, spec, price) {	
		window.opener.document.getElementById('item${rNum}').value = item;
		window.opener.document.getElementById('spec${rNum}').value = spec;
		window.opener.document.getElementById('price${rNum}').value = price;
		window.opener.document.getElementById('amount${rNum}').value = "1";
		window.opener.setTotalMoney(${rNum});
	    window.close();
	    
	}
	function writeSpecBtn() {
		window.opener.document.getElementById('item${rNum}').value = $("#item").val();
		window.opener.document.getElementById('spec${rNum}').value = $("#spec").val();
		window.opener.document.getElementById('price${rNum}').value = $("#price").val();
		window.opener.document.getElementById('amount${rNum}').value = "1";
		window.opener.setTotalMoney(${rNum});
	    window.close();
	}
	function comma(str) {
	    str = String(str);
	    return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
	}
	function uncomma(str) {
	    str = String(str);
	    return str.replace(/[^\d]+/g, '');
	}
	function inputNumberFormat(obj) {
	    obj.value = comma(uncomma(obj.value));
	}
</script>
<h3><strong>&nbsp;&nbsp;폐기물 및 규격</strong></h3>
<br />
<form name="wasteRegistForm" id="wasteRegistForm" method="post" action="/wst/addWasteApply.do" onsubmit="return validateWasteRegist(this)">
<div class="panel panel-info" data-collapsed="0">
	<div class="panel-heading">
		<div class="panel-title">
			<strong>직접 입력</strong>
		</div>
		<div class="panel-options">
			<a href="#" data-rel="collapse"><i class="entypo-down-open"></i></a>
		</div>
	</div>
	<div class="panel-body">
		<div class="form-horizontal form-groups-bordered">
			<div class="form-group">
				<table border="0" cellpadding="0" cellspacing="0" width="100%">
				<tr>
					<td align="center" style="padding-left:5px"><input type="text" class="form-control" placeholder="품목" id="item" name="item"></td>
					<td align="center" style="padding-left:5px"><input type="text" class="form-control" placeholder="규격" id="spec" name="spec"></td>
					<td align="center" style="padding-left:5px"><input type="text" class="form-control" placeholder="금액" id="price" name="price" onkeyup="inputNumberFormat(this)" style="text-align:right"></td>
					<td align="center" style="padding-left:5px; padding-right:5px"><a href="#n" onclick="writeSpecBtn(); return false;"><button type="submit" class="btn btn-primary">선택</button></a></td>
				</tr>
				</table>
			</div>
		</div>
	</div>
</div>
</form>

<table class="table table-bordered datatable" id="table-1">
	<thead>
		<tr>
			<th style="text-align:center" width="165">품목</th>
			<th style="text-align:center">규격</th>
			<th style="text-align:center" width="100">부과금액</th>
			<th style="text-align:center" width="70">선택</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="result" items="${resultList}" varStatus="status">
			<tr>
				<td align="center"><c:out value="${result.item }"/></td>
				<td align="center"><c:out value="${result.spec }"/></td>
				<td align="right"><c:out value="${result.price }"/></td>
				<td align="center"><a href="#n" onclick="selectSpecBtn('${result.item }', '${result.spec }', '${result.price }'); return false;"><button type="button" class="btn btn-white btn-xs">선택</button></a></td>
			</tr>
		</c:forEach>
	</tbody>
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

<!-- Bottom scripts (common) -->
<script src="/assets/js/gsap/TweenMax.min.js"></script>
<script src="/assets/js/jquery-ui/js/jquery-ui-1.10.3.minimal.min.js"></script>
<script src="/assets/js/bootstrap.js"></script>
<script src="/assets/js/joinable.js"></script>
<script src="/assets/js/resizeable.js"></script>
<script src="/assets/js/neon-api.js"></script>

<!-- Imported scripts on this page -->
<script src="/assets/js/datatables/datatables.js"></script>
<script src="/assets/js/select2/select2.min.js"></script>
<script src="/assets/js/neon-chat.js"></script>

<!-- JavaScripts initializations and stuff -->
<script src="/assets/js/neon-custom.js"></script>

<!-- Demo Settings -->
<script src="/assets/js/neon-demo.js"></script>