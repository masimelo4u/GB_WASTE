<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
  /**  
   * @Class Name : hjdongUpdate.jsp
   * @Description : 행정동 관리 수정 화면
   * @Modification Information  
   * @
   * @  수정일      수정자              수정내용
   * @ ---------   ---------   -------------------------------
   * @ 2017.06.12   미키    최초생성
   * 
   * @author 미키
   * @since 2017.06.12
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
	function validateHjdongUpdate(event) {
		if( !$("#bjdongNm").val() ) {
			alert("법정동을 선택해 주세요.");
			$("#bjdongNm").focus();
			return false;
		}	
		if( !$("#bunji1").val() ) {
			alert("번지를 입력해 주세요.");
			$("#bunji1").focus();
			return false;
		}		
		if( !$("#bunji2").val() ) {
			alert("번지를 입력해 주세요.");
			$("#bunji2").focus();
			return false;
		}
		if( !$("#hjdongNm").val() ) {
			alert("행정동을 선택해 주세요.");
			$("#hjdongNm").focus();
			return false;
		}	
        
		$('#updateBtn').attr('disabled', true);
		return true;
	}
	function listBtn() {
		document.hjdongUpdateForm.action = "<c:url value='/hjd/selectHjdongList.do'/>";
	   	document.hjdongUpdateForm.submit();	
	}
	function deleteBtn() {
	   	var result = confirm('정말 삭제하시겠습니까?'); 
	   	if(result) { 
	   		document.hjdongUpdateForm.action = "<c:url value='/hjd/deleteHjdongApply.do'/>";
		   	document.hjdongUpdateForm.submit();	
	   	} else { 
	   		return false;
	   	}
	}
</script>

<ol class="breadcrumb bc-3" >
	<li><i class="entypo-folder"></i> 대형폐기물 처리</li>
	<li>통합관리</li>
	<li class="active"><a href="/hjd/selectHjdongList.do"><strong>행정동 관리</strong></a></li>
</ol>
<h2><strong>행정동 수정</strong></h2>
<br />
<form name="hjdongUpdateForm" id="hjdongUpdateForm" method="post" action="/hjd/updateHjdongApply.do" onsubmit="return validateHjdongUpdate(this)">
<input type="hidden" id="hjdongNo" name="hjdongNo" value="${hjdongResult.wasteHjdongNo }"/>
<div class="panel panel-info" data-collapsed="0">
	<div class="panel-heading">
		<div class="panel-title">
			<i class="entypo-newspaper"></i> <strong>행정동 수정</strong>
		</div>
		<div class="panel-options">
			<a href="#" data-rel="collapse"><i class="entypo-down-open"></i></a>
		</div>
	</div>
	<div class="panel-body">
		<div class="form-horizontal form-groups-bordered">
			<div class="form-group">
				<label class="col-sm-3 control-label" style="text-align:left">법정동</label>
				<div class="col-sm-3">	
					<select class="form-control" id="bjdongNm" name="bjdongNm" style="width:100%">
						<option value="">선택</option>
						<option value="미아동" <c:if test="${'미아동' eq hjdongResult.bjdongNm }">selected="selected"</c:if>>미아동</option>
						<option value="번동" <c:if test="${'번동' eq hjdongResult.bjdongNm }">selected="selected"</c:if>>번동</option>
						<option value="수유동" <c:if test="${'수유동' eq hjdongResult.bjdongNm }">selected="selected"</c:if>>수유동</option>
						<option value="우이동" <c:if test="${'우이동' eq hjdongResult.bjdongNm }">selected="selected"</c:if>>우이동</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" style="text-align:left">번지</label>
				<div class="col-sm-5">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td>
								<div style="width:115px; padding-right:5px"><input type="text" class="form-control" maxlength="10" id="bunji1" name="bunji1" value="${hjdongResult.bunji1 }" /></div>
							</td>
							<td>
								<div style="width:5px; padding-top:0px; padding-left:5px; padding-right:15px">-</div>
							</td>
							<td>
								<div style="width:115px; padding-left:0px; padding-right:5px"><input type="text" class="form-control" maxlength="10" id="bunji2" name="bunji2" value="${hjdongResult.bunji2 }" /></div>
							</td>
						</tr>
					</table>
					<div style="padding-top:5px"><span style="color:red">* 510 번지처럼 부번이 없는 경우는 510-0 번지 입니다.</span></div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" style="text-align:left">행정동</label>
				<div class="col-sm-3">	
					<select class="form-control" id="hjdongNm" name="hjdongNm" style="width:100%">
						<option value="">선택</option>
						<option value="미아동" <c:if test="${'미아동' eq hjdongResult.hjdongNm }">selected="selected"</c:if>>미아동</option>
						<option value="번1동" <c:if test="${'번1동' eq hjdongResult.hjdongNm }">selected="selected"</c:if>>번1동</option>
						<option value="번2동" <c:if test="${'번2동' eq hjdongResult.hjdongNm }">selected="selected"</c:if>>번2동</option>
						<option value="번3동" <c:if test="${'번3동' eq hjdongResult.hjdongNm }">selected="selected"</c:if>>번3동</option>
						<option value="삼각산동" <c:if test="${'삼각산동' eq hjdongResult.hjdongNm }">selected="selected"</c:if>>삼각산동</option>
						<option value="삼양동" <c:if test="${'삼양동' eq hjdongResult.hjdongNm }">selected="selected"</c:if>>삼양동</option>
						<option value="송중동" <c:if test="${'송중동' eq hjdongResult.hjdongNm }">selected="selected"</c:if>>송중동</option>
						<option value="송천동" <c:if test="${'송천동' eq hjdongResult.hjdongNm }">selected="selected"</c:if>>송천동</option>
						<option value="수유1동" <c:if test="${'수유1동' eq hjdongResult.hjdongNm }">selected="selected"</c:if>>수유1동</option>
						<option value="수유2동" <c:if test="${'수유2동' eq hjdongResult.hjdongNm }">selected="selected"</c:if>>수유2동</option>
						<option value="수유3동" <c:if test="${'수유3동' eq hjdongResult.hjdongNm }">selected="selected"</c:if>>수유3동</option>
						<option value="우이동" <c:if test="${'우이동' eq hjdongResulthjdongNm }">selected="selected"</c:if>>우이동</option>
						<option value="인수동" <c:if test="${'인수동' eq hjdongResult.hjdongNm }">selected="selected"</c:if>>인수동</option>
					</select>
				</div>
			</div>
		</div>
	</div>
</div>

<div style="padding-top:10px; padding-bottom:10px; text-align:center">
	<button type="submit" id="updateBtn" name="updateBtn" class="btn btn-blue" style="width:80px">수정</button>
	<a href="#n" onclick="deleteBtn(); return false;"><button type="submit" id="deleteBtn" name="deleteBtn" class="btn btn-red" style="width:80px">삭제</button></a>
</div>

</form>
	
<!-- Imported styles on this page -->
<link rel="stylesheet" href="/assets/js/select2/select2-bootstrap.css">
<link rel="stylesheet" href="/assets/js/select2/select2.css">
<link rel="stylesheet" href="/assets/js/daterangepicker/daterangepicker-bs3.css">
<link rel="stylesheet" href="/assets/js/icheck/skins/minimal/_all.css">
<link rel="stylesheet" href="/assets/js/icheck/skins/square/_all.css">
<link rel="stylesheet" href="/assets/js/icheck/skins/flat/_all.css">
<link rel="stylesheet" href="/assets/js/icheck/skins/futurico/futurico.css">
<link rel="stylesheet" href="/assets/js/icheck/skins/polaris/polaris.css">

<script src="/assets/js/jquery-ui/js/jquery-ui-1.10.3.minimal.min.js"></script>

<!-- Imported scripts on this page -->
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

