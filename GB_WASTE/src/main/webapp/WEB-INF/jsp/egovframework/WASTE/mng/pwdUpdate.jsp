<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
  /**  
   * @Class Name : pwdUpdate.jsp
   * @Description : 비밀번호 변경 화면
   * @Modification Information  
   * @
   * @  수정일      수정자              수정내용
   * @ ---------   ---------   -------------------------------
   * @ 2017.06.07   미키    최초생성
   * 
   * @author 미키
   * @since 2017.06.07
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
	function validatePwdUpdate(event) {
		if( !$("#password").val() ) {
			alert("현재 비밀번호를 입력해 주세요.");
			$("#password").focus();
			return false;
		}
		if( !$("#newPassword").val() ) {
			alert("새 비밀번호를 입력해 주세요.");
			$("#newPassword").focus();
			return false;
		}
		if( !$("#newPasswordChk").val() ) {
			alert("새 비밀번호 확인을 입력해 주세요.");
			$("#newPasswordChk").focus();
			return false;
		}
        if( $("#password").val() != $("#passwordCheck").val() ) {
			alert("새 비밀번호가 일치하지 않습니다.");
			$("#passwordCheck").focus();
			return false;
		}
		$('#updateBtn').attr('disabled', true);
		return true;
	}
	function refreshView() {
		$("#password").val("");
		$("#newPassword").val("");
		$("#newPasswordChk").val("");
	}
</script>

<ol class="breadcrumb bc-3" >
	<li><i class="entypo-folder"></i> 대형폐기물 처리</li>
	<li>통합관리</li>
	<li class="active"><a href="/mng/updatePwdView.do"><strong>비밀번호 변경</strong></a></li>
</ol>
<h2><strong>비밀번호 변경</strong></h2>
<br />
<blockquote class="blockquote-default">
<div style="font-size:12px">
	<p style="font-weight:600; font-size:1.1em">안내를 숙지하고 이용해 주시기 바랍니다</p>
	<!-- <span class="pw_img" style="position:absolute; top:185px; left:60px; z-index:1"><img src="/images/WASTE/pw_img1.gif" alt="" /></span> -->
	<div class="pw_img" style="float:left; width:150px; padding-top:18px; padding-right:0px; padding-bottom:0px; padding-left:10px;"><img src="/images/WASTE/pw_img1.gif" alt="" /></div>
	<!-- <ul class="bu" style="padding-top:5px; padding-right:0px; padding-bottom:0px; padding-left:170px"> -->
	<div>
	<ul class="bu">
		<li>현재 비밀번호를 입력한 후 새로 사용할 비밀번호를 입력하십시오.</li>
		<li>4자리 이상 연속되거나 동일한 비밀번호 사용 불가합니다. (예: 1234, 1111)</li>
		<li>다음 항목과 4자 이상 연속적으로 동일한 비밀번호는 사용 불가합니다.<br/><span style="color:red">주민(사업자) 등록번호, 회원ID, 전화번호, 휴대폰번호, E-mail 주소</span></li>
		<li>특수문자 중 <, >, , ‘ 사용 불가합니다.</li>
		<li>비밀번호를 변경하지 않으시면 기존 비밀번호로 저장됩니다.</li>
		<li>기존에 사용한 비밀번호나 타 사이트와는 다른 비밀번호를 사용하시고, 주기적으로 비밀번호를 변경해 주십시오.</li>
		<li><span style="color:red">주민등록번호, 생일, 학번, 전화번호 등과 관련된 개인정보는 타인이 쉽게 알아낼 수 있으니 피하시기 바랍니다.</span> </li>
	</ul>
	</div>
</div>
</blockquote>
<form name="pwdUpdateForm" id="pwdUpdateForm" method="post" action="/mng/updatePwdApply.do" onsubmit="return validatePwdUpdate(this)">
<div class="panel panel-info" data-collapsed="0">
	<div class="panel-heading">
		<div class="panel-title">
			<i class="entypo-newspaper"></i> <strong>비밀번호 변경</strong>
		</div>
		<div class="panel-options">
			<a href="#" data-rel="collapse"><i class="entypo-down-open"></i></a>
		</div>
	</div>
	<div class="panel-body">
		<div class="form-horizontal form-groups-bordered">
			<div class="form-group">
				<label class="col-sm-3 control-label" style="text-align:left"><span style="color:red">*</span> 현재 비밀번호</label>
				<div class="col-sm-4">
					<input type="password" class="form-control" data-mask="" placeholder="" id="password" name="password" maxlength="50">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" style="text-align:left"><span style="color:red">*</span> 새 비밀번호</label>
				<div class="col-sm-4">
					<input type="password" class="form-control" data-mask="" placeholder="" id="newPassword" name="newPassword" maxlength="50">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" style="text-align:left"><span style="color:red">*</span> 새 비밀번호 확인</label>
				<div class="col-sm-4">
					<input type="password" class="form-control" data-mask="" placeholder="" id="newPasswordChk" name="newPasswordChk" maxlength="50">
				</div>
			</div>
		</div>
	</div>
</div>

<div style="padding-top:10px; padding-bottom:10px; text-align:center">
	<button type="submit" id="updateBtn" name="updateBtn" class="btn btn-blue" style="width:80px">확인</button>
	<a href="#n" onclick="refreshView(); return false;"><div class="btn btn-default" style="width:80px">다시입력</button></a>
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

