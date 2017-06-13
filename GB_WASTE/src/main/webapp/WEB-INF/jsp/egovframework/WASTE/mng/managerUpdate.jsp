<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
  /**  
   * @Class Name : managerUpdate.jsp
   * @Description : 관리자 관리 수정 화면
   * @Modification Information  
   * @
   * @  수정일      수정자              수정내용
   * @ ---------   ---------   -------------------------------
   * @ 2017.06.08   미키    최초생성
   * 
   * @author 미키
   * @since 2017.06.08
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
	function validateManagerUpdate(event) {
		if( !$("#password").val() ) {
			alert("비밀번호를 입력해 주세요.");
			$("#password").focus();
			return false;
		}
		if( !$("#managerNm").val() ) {
			alert("관리자명을 입력해 주세요.");
			$("#managerNm").focus();
			return false;
		}	
		if( !$("#telephone2").val() ) {
			alert("전화번호를 입력해 주세요.");
			$("#telephone2").focus();
			return false;
		}	
		if( !$("#telephone3").val() ) {
			alert("전화번호를 입력해 주세요.");
			$("#telephone3").focus();
			return false;
		}
		var frm = document.managerUpdateForm;
        var cnt = frm.hjdong2.options.length;
		if( cnt == 0 ) {
			alert("해당동면을 선택해 주세요.");
			return false;
		}	
		var hjdongCd = new Array();
		var hjdongNm = new Array();
        for (var i=0 ; i < cnt ; i++){
        	hjdongCd[i] = frm.hjdong2.options[i].value;
        	hjdongNm[i] = frm.hjdong2.options[i].text;
        }
        $("#hjdongCd").val(hjdongCd);
        $("#hjdongNm").val(hjdongNm);
        
        if( $("#password").val() != $("#passwordCheck").val() ) {
			alert("비밀번호가 일치하지 않습니다.");
			$("#password").focus();
			return false;
		}
        
		$('#updateBtn').attr('disabled', true);
		return true;
	}
	function listBtn() {
		document.managerUpdateForm.action = "<c:url value='/mng/selectMngList.do'/>";
	   	document.managerUpdateForm.submit();	
	}
	function addItem(){
        var frm = document.managerUpdateForm;
        var cnt = frm.hjdong1.options.length;
        var cnt2 = 0;
 
        for (var i=0 ; i < cnt ; i++) {
            if(frm.hjdong1.options[i].selected == true) {
            	frm.hjdong2.options.add(new Option(frm.hjdong1.options[i].text, frm.hjdong1.options[i].value));
                cnt2++;
            }
        }
 
        for (var i=0 ; i < cnt2 ; i++){
            frm.hjdong1.options.remove(frm.hjdong1.selectedIndex);
        }
    }
    function removeItem(){
        var frm = document.managerUpdateForm;
        var cnt = frm.hjdong2.options.length;
        var cnt2 = 0;
 
        for (var i=0 ; i < cnt ; i++) {
            if(frm.hjdong2.options[i].selected == true) {
                frm.hjdong1.options.add(new Option(frm.hjdong2.options[i].text, frm.hjdong2.options[i].value));
                cnt2++;
            }
        }
 
        for (var i=0 ; i < cnt2 ; i++){
            frm.hjdong2.options.remove(frm.hjdong2.selectedIndex);
        }
    }
    function deleteBtn() {
    	if( !$("#password").val() ) {
			alert("비밀번호를 입력해 주세요.");
			$("#password").focus();
			return false;
		}
    	if( $("#password").val() != $("#passwordCheck").val() ) {
			alert("비밀번호가 일치하지 않습니다.");
			$("#password").focus();
			return false;
		}
	   	var result = confirm('정말 삭제하시겠습니까?'); 
	   	if(result) { 
	   		$('#deleteBtn').attr('disabled', true);
	   		document.managerUpdateForm.action = "<c:url value='/mng/deleteMngApply.do'/>";
		   	document.managerUpdateForm.submit();	
	   	} else { 
	   		return false;
	   	}
	}
</script>

<ol class="breadcrumb bc-3" >
	<li><i class="entypo-folder"></i> 대형폐기물 처리</li>
	<li>통합관리</li>
	<li class="active"><a href="/mng/selectMngList.do"><strong>관리자 관리</strong></a></li>
</ol>
<h2><strong>관리자 수정</strong></h2>
<br />
<form name="managerUpdateForm" id="managerUpdateForm" method="post" action="/mng/updateMngApply.do" onsubmit="return validateManagerUpdate(this)">
<input type="hidden" id="mngNo" name="mngNo" value="${mngNo }" />
<input type="hidden" id="hjdongCd" name="hjdongCd" />
<input type="hidden" id="hjdongNm" name="hjdongNm" />
<input type="hidden" id="passwordCheck" name="passwordCheck" value="${managerResult.password }" />
<div class="panel panel-info" data-collapsed="0">
	<div class="panel-heading">
		<div class="panel-title">
			<i class="entypo-newspaper"></i> <strong>관리자 수정</strong>
		</div>
		<div class="panel-options">
			<a href="#" data-rel="collapse"><i class="entypo-down-open"></i></a>
		</div>
	</div>
	<div class="panel-body">
		<div class="form-horizontal form-groups-bordered">
			<div class="form-group">
				<label class="col-sm-3 control-label" style="text-align:left"><span style="color:red">*</span> 관리자ID</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" data-mask="" placeholder="" id="managerId" name="managerId" value="${managerResult.managerId }" readonly >
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" style="text-align:left"><span style="color:red">*</span> 비밀번호</label>
				<div class="col-sm-4">
					<input type="password" class="form-control" data-mask="" placeholder="" id="password" name="password" >
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" style="text-align:left"><span style="color:red">*</span> 관리자명</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" data-mask="" placeholder="" id="managerNm" name="managerNm" value="${managerResult.managerNm }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" style="text-align:left"><span style="color:red">*</span> 전화번호</label>
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<div class="col-sm-5" style="width:85px; padding-right: 0px">
							<select class="form-control" id="telephone1" name="telephone1">
								<option value="02" <c:if test="${'02' eq managerResult.telephone1 }">selected="selected"</c:if>>02</option>
								<option value="031" <c:if test="${'031' eq managerResult.telephone1 }">selected="selected"</c:if>>031</option>
								<option value="032" <c:if test="${'032' eq managerResult.telephone1 }">selected="selected"</c:if>>032</option>
								<option value="033" <c:if test="${'033' eq managerResult.telephone1 }">selected="selected"</c:if>>033</option>
								<option value="041" <c:if test="${'041' eq managerResult.telephone1 }">selected="selected"</c:if>>041</option>
								<option value="042" <c:if test="${'042' eq managerResult.telephone1 }">selected="selected"</c:if>>042</option>
								<option value="043" <c:if test="${'043' eq managerResult.telephone1 }">selected="selected"</c:if>>043</option>
								<option value="051" <c:if test="${'051' eq managerResult.telephone1 }">selected="selected"</c:if>>051</option>
								<option value="052" <c:if test="${'052' eq managerResult.telephone1 }">selected="selected"</c:if>>052</option>
								<option value="053" <c:if test="${'053' eq managerResult.telephone1 }">selected="selected"</c:if>>053</option>
								<option value="054" <c:if test="${'054' eq managerResult.telephone1 }">selected="selected"</c:if>>054</option>
								<option value="055" <c:if test="${'055' eq managerResult.telephone1 }">selected="selected"</c:if>>055</option>
								<option value="061" <c:if test="${'061' eq managerResult.telephone1 }">selected="selected"</c:if>>061</option>
								<option value="062" <c:if test="${'062' eq managerResult.telephone1 }">selected="selected"</c:if>>062</option>
								<option value="063" <c:if test="${'063' eq managerResult.telephone1 }">selected="selected"</c:if>>063</option>
								<option value="064" <c:if test="${'064' eq managerResult.telephone1 }">selected="selected"</c:if>>064</option>
							</select>
						</div>
						</td>
						<td>
							<div class="col-sm-5" style="width:5px; padding-top:7px; padding-left:5px; padding-right:15px">-</div>
						</td>
						<td>
							<div class="col-sm-5" style="width:70px; padding-left:0px; padding-right:0px"><input type="text" class="form-control" maxlength="4" id="telephone2" name="telephone2" value="${managerResult.telephone2 }" /></div>
						</td>
						<td>
							<div class="col-sm-5" style="width:5px; padding-top:7px; padding-left:5px; padding-right:15px">-</div>
						</td>
						<td>
							<div class="col-sm-5" style="width:70px; padding-left:0px; padding-right:0px"><input type="text" class="form-control" maxlength="4" id="telephone3" name="telephone3" value="${managerResult.telephone3 }" /></div>
						</td>
					</tr>
				</table>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" style="text-align:left">핸드폰번호</label>
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
							<div class="col-sm-5" style="width:85px; padding-right: 0px">
								<select class="form-control" id="mobile1" name="mobile1">
									<option value="010" <c:if test="${'010' eq managerResult.mobile1 }">selected="selected"</c:if>>010</option>
									<option value="011" <c:if test="${'011' eq managerResult.mobile1 }">selected="selected"</c:if>>011</option>
									<option value="016" <c:if test="${'016' eq managerResult.mobile1 }">selected="selected"</c:if>>016</option>
									<option value="017" <c:if test="${'017' eq managerResult.mobile1 }">selected="selected"</c:if>>017</option>
									<option value="018" <c:if test="${'018' eq managerResult.mobile1 }">selected="selected"</c:if>>018</option>
									<option value="019" <c:if test="${'019' eq managerResult.mobile1 }">selected="selected"</c:if>>019</option>
								</select>
							</div>
						</td>
						<td>
							<div class="col-sm-5" style="width:5px; padding-top:7px; padding-left:5px; padding-right:15px">-</div>
						</td>
						<td>
							<div class="col-sm-5" style="width:70px; padding-left:0px; padding-right:0px"><input type="text" class="form-control" data-mask="" maxlength="4" id="mobile2" name="mobile2" value="${managerResult.mobile2 }" /></div>
						</td>
						<td>
							<div class="col-sm-5" style="width:5px; padding-top:7px; padding-left:5px; padding-right:15px">-</div>
						</td>
						<td>
							<div class="col-sm-5" style="width:70px; padding-left:0px; padding-right:0px"><input type="text" class="form-control" data-mask="" maxlength="4" id="mobile3" name="mobile3" value="${managerResult.mobile3 }" /></div>
						</td>
					</tr>
				</table>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" style="text-align:left">관리자 유형</label>
				<div class="col-sm-5">
					<div class="radio radio-replace" >
						<input type="radio" id="rd-1" name="managerType" value="T" <c:if test="${'T' eq managerResult.managerType }">checked</c:if>>
						<label>최고관리자</label>
					</div>
					<div class="radio radio-replace">
						<input type="radio" id="rd-2" name="managerType" value="S" <c:if test="${'S' eq managerResult.managerType }">checked</c:if>>
						<label>서브관리자</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" style="text-align:left"><span style="color:red">*</span> 해당동면</label>
				<div class="col-sm-5">
					<table border="0" cellpadding="0" cellspacing="0">
					    <tr>
						    <td width="200">
						    	<div style="text-align:center">전체동면</div>
						        <select id="hjdong1" name="hjdong1" size="10" style="width:100%; height:170px" multiple="multiple">
						        <c:forEach var="result" items="${hjdongList}" varStatus="status">
						        	<option value="${result.hjdongCd }">${result.hjdongNm }</option>
						        </c:forEach>
						        </select>
						    </td>
						    <td width="50" align="center"><input type="button" value=" ▶ " onclick="addItem()"><br><br><input type="button" value=" ◀ " onclick="removeItem()"></td>
						    <td width="200">
						    	<div style="text-align:center">담당동면</div>
						        <select id="hjdong2" name="hjdong2" size="10" style="width:100%; height:170px" multiple="multiple">
						        <c:forEach var="result" items="${managerDtlResult}" varStatus="status">
						        	<option value="${result.hjdongCd }">${result.hjdongNm }</option>
						        </c:forEach>
						        </select>
						    </td>
					    </tr>
					</table>
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

