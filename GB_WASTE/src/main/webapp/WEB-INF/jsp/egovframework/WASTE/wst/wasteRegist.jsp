<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%
  /**  
   * @Class Name : wasteRegister.jsp
   * @Description : 수거신청 등록 화면
   * @Modification Information  
   * @
   * @  수정일      수정자              수정내용
   * @ ---------   ---------   -------------------------------
   * @ 2017.04.27   미키    최초생성
   * 
   * @author 미키
   * @since 2017.04.27
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
<%@ page import="java.util.*" %>
<%
	int year, yearMin, yearMax;
	int yearResult, yearCount;
	int month;
	int date;
	
	List<String> yearList = new ArrayList<String>();
	Calendar now = Calendar.getInstance();
	
	year = now.get(Calendar.YEAR);
	month = now.get(Calendar.MONTH)+1;
	date = now.get(Calendar.DATE);
	
	yearMin = year;
	yearMax = now.get(Calendar.YEAR)+5;
	yearCount = yearMax - yearMin;
	
	yearResult = yearMin;
%>
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
	function cancelBtn() {
		document.wasteRegistForm.action = "<c:url value='/wst/selectWasteList.do'/>";
	   	document.wasteRegistForm.submit();	
	}
	function findJuso(gubun) {
		window.open("/common/juso/road.jsp?gubun=" + gubun,"_juso","width=520,height=800,scrollbars=yes");
	}
	function popSpec(rNum) {
		window.open("/popup/selectPopSpecList.do?rNum=" + rNum, "_blank", "width=600,height=600,scrollbars=yes");
	}
	function deleteBtn(rNum) {
		var item = "#item"+rNum;
		var spec = "#spec"+rNum;
		var price = "#price"+rNum;
		var amount = "#amount"+rNum;
		$(item).val("");
		$(spec).val("");
		$(price).val("");
		$(amount).val("");
	}
	function copyCheck(chkbox) {
		if ( chkbox.checked == true ) {
			$("#accPost1").val($("#reqPost1").val());
			$("#accPost2").val($("#reqPost2").val());
			$("#accAddr").val($("#reqAddr").val());
			$("#accNewAddr1").val($("#reqNewAddr1").val());
			$("#accNewAddr2").val($("#reqNewAddr2").val());
			$("#accBunji1").val($("#reqBunji1").val());
			$("#accBunji2").val($("#reqBunji2").val());
			$("#accBjdong").val($("#reqBjdong").val());
		} else {
			$("#accPost1").val("");
			$("#accPost2").val("");
			$("#accAddr").val("");
			$("#accNewAddr1").val("");
			$("#accNewAddr2").val("");
			$("#accBunji1").val("");
			$("#accBunji2").val("");
			$("#accBjdong").val("");
		}
	}
	function validateWasteRegist(event) {
		if( !$("#requestNm").val() ) {
			alert("이름을 입력해 주세요.");
			$("#requestNm").focus();
			return false;
		}		
		if( !$("#reqMobile2").val() && !$("#reqMobile3").val()) {
			alert("핸드폰 번호를 입력해 주세요.");
			$("#reqMobile2").focus();
			return false;
		}
		if( !$("#reqPost1").val() ) {
			alert("우편번호를 입력해 주세요.");
			$("#reqPost1").focus();
			return false;
		}
		if( !$("#reqPost2").val() ) {
			alert("우편번호를 입력해 주세요.");
			$("#reqPost2").focus();
			return false;
		}	
		if( !$("#accPost1").val() ) {
			alert("우편번호를 입력해 주세요.");
			$("#accPost1").focus();
			return false;
		}	
		if( !$("#accPost2").val() ) {
			alert("우편번호를 입력해 주세요.");
			$("#accPost2").focus();
			return false;
		}	
		if( !$("#accAddr").val() ) {
			alert("주소를 입력해 주세요.");
			$("#accAddr").focus();
			return false;
		}	
		if($("#price").val() == "" || $("#price").val() == 0) {
			alert("배출할 폐기물을 선택해 주세요.");
			return false;
		}
		if( !$("#date").val() ) {
			alert("배출 예정일을 입력해 주세요.");
			$("#date").focus();
			return false;
		}	
		$('#registBtn').attr('disabled', true);
		return true;
	}
	function sumPrice() {
		alert("sum");
	}
	function comma(str) {
	    str = String(str);
	    return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
	}
	function uncomma(str) {
	    str = String(str);
	    return str.replace(/[^\d]+/g, '');
	}
	function setTotalMoney(rNum) {
		var totalSum = 0;
		var tempSum = 0;
		var price = 0;
		var amount = 0;
		for(var i=1; i<=10; i++) {
			price = uncomma($("#price"+i).val());
			amount = $("#amount"+i).val();
			price = price * 1;
			amount = amount * 1;
			tempSum = parseInt(price) * parseInt(amount);
			totalSum = totalSum + tempSum;
		}
		$("#price").val(comma(totalSum));
	}
</script>

<ol class="breadcrumb bc-3" >
	<li><i class="entypo-folder"></i> 대형폐기물 처리</li>
	<li>수거신청 관리</li>
	<li class="active"><a href="/wst/selectWasteList.do"><strong>수거신청 관리</strong></a></li>
</ol>
<h2><strong>방문 수거신청 등록</strong></h2>
<br />
<form name="wasteRegistForm" id="wasteRegistForm" method="post" action="/wst/addWasteApply.do" onsubmit="return validateWasteRegist(this)">
<%-- <form:form commandName="wasteRegistForm" name="wasteRegistForm" action="addCrclm.do?${crclmVO.params}"  enctype="multipart/form-data" onsubmit="return validateCrclm(this)"> --%>
<input type="hidden" id="reqBunji1" name="reqBunji1" />
<input type="hidden" id="reqBunji2" name="reqBunji2" />
<input type="hidden" id="reqBjdong" name="reqBjdong" />
<input type="hidden" id="accBunji1" name="accBunji1" />
<input type="hidden" id="accBunji2" name="accBunji2" />
<input type="hidden" id="accBjdong" name="accBjdong" />
<div class="panel panel-info" data-collapsed="0">
	<div class="panel-heading">
		<div class="panel-title">
			<i class="entypo-bag"></i> <strong>신청인 정보</strong>
		</div>
		<div class="panel-options">
			<a href="#" data-rel="collapse"><i class="entypo-down-open"></i></a>
		</div>
	</div>
	<div class="panel-body">
		<%-- <form role="form" class="form-horizontal form-groups-bordered"> --%>
		<div class="form-horizontal form-groups-bordered">
			<div class="form-group">
				<label class="col-sm-3 control-label" style="text-align:left"><span style="color:red">*</span> 이름</label>
				<div class="col-sm-5">
					<div class="input-group">
						<span class="input-group-addon"><i class="entypo-user"></i></span>	
						<input type="text" class="form-control" data-mask="" placeholder="" id="requestNm" name="requestNm"/>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" style="text-align:left">전화번호</label>
					<div class="col-sm-5" style="width:100px; padding-right: 0px">
					<select class="form-control" id="reqTelephone1" name="reqTelephone1">
						<option value="02" <c:if test="${'02' eq reqTelephone }">selected="selected"</c:if>>02</option>
						<option value="031" <c:if test="${'031' eq reqTelephone }">selected="selected"</c:if>>031</option>
						<option value="032" <c:if test="${'032' eq reqTelephone }">selected="selected"</c:if>>032</option>
						<option value="033" <c:if test="${'033' eq reqTelephone }">selected="selected"</c:if>>033</option>
						<option value="041" <c:if test="${'041' eq reqTelephone }">selected="selected"</c:if>>041</option>
						<option value="042" <c:if test="${'042' eq reqTelephone }">selected="selected"</c:if>>042</option>
						<option value="043" <c:if test="${'043' eq reqTelephone }">selected="selected"</c:if>>043</option>
						<option value="051" <c:if test="${'051' eq reqTelephone }">selected="selected"</c:if>>051</option>
						<option value="052" <c:if test="${'052' eq reqTelephone }">selected="selected"</c:if>>052</option>
						<option value="053" <c:if test="${'053' eq reqTelephone }">selected="selected"</c:if>>053</option>
						<option value="054" <c:if test="${'054' eq reqTelephone }">selected="selected"</c:if>>054</option>
						<option value="055" <c:if test="${'055' eq reqTelephone }">selected="selected"</c:if>>055</option>
						<option value="061" <c:if test="${'061' eq reqTelephone }">selected="selected"</c:if>>061</option>
						<option value="062" <c:if test="${'062' eq reqTelephone }">selected="selected"</c:if>>062</option>
						<option value="063" <c:if test="${'063' eq reqTelephone }">selected="selected"</c:if>>063</option>
						<option value="064" <c:if test="${'064' eq reqTelephone }">selected="selected"</c:if>>064</option>
					</select>
					</div>
					<div class="col-sm-5" style="width:5px; padding-top:7px; padding-left:10px; padding-right:15px">-</div>
					<div class="col-sm-5" style="width:120px; padding-left:0px; padding-right:0px"><input type="text" class="form-control" maxlength="4" id="reqTelephone2" name="reqTelephone2" /></div>
					<div class="col-sm-5" style="width:5px; padding-top:7px; padding-left:10px; padding-right:15px">-</div>
					<div class="col-sm-5" style="width:120px; padding-left:0px; padding-right:0px"><input type="text" class="form-control" maxlength="4" id="reqTelephone3" name="reqTelephone3" /></div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" style="text-align:left"><span style="color:red">*</span> 핸드폰번호</label>
				<div class="col-sm-5" style="width:100px; padding-right: 0px">
					<select class="form-control" id="reqMobile1" name="reqMobile1">
						<option value="010" <c:if test="${'010' eq reqTelephone }">selected="selected"</c:if>>010</option>
						<option value="011" <c:if test="${'011' eq reqTelephone }">selected="selected"</c:if>>011</option>
						<option value="016" <c:if test="${'016' eq reqTelephone }">selected="selected"</c:if>>016</option>
						<option value="017" <c:if test="${'017' eq reqTelephone }">selected="selected"</c:if>>017</option>
						<option value="018" <c:if test="${'018' eq reqTelephone }">selected="selected"</c:if>>018</option>
						<option value="019" <c:if test="${'019' eq reqTelephone }">selected="selected"</c:if>>019</option>
					</select>
				</div>
				<div class="col-sm-5" style="width:5px; padding-top:7px; padding-left:10px; padding-right:15px">-</div>
				<div class="col-sm-5" style="width:120px; padding-left:0px; padding-right:0px"><input type="text" class="form-control" data-mask="" maxlength="4" id="reqMobile2" name="reqMobile2" /></div>
				<div class="col-sm-5" style="width:5px; padding-top:7px; padding-left:10px; padding-right:15px">-</div>
				<div class="col-sm-5" style="width:120px; padding-left:0px; padding-right:0px"><input type="text" class="form-control" data-mask="" maxlength="4" id="reqMobile3" name="reqMobile3" /></div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" style="text-align:left">이메일</label>
				<div class="col-sm-5">
					<div class="input-group">
						<span class="input-group-addon"><i class="entypo-mail"></i></span>
						<input type="text" class="form-control" data-mask="" placeholder="" id="reqEmail" name="reqEmail" >
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" style="text-align:left"><span style="color:red">*</span> 우편번호</label>
				<div class="col-sm-5" style="width:100px; padding-right:0px"><input type="text" class="form-control" maxlength="3" id="reqPost1" name="reqPost1" readonly /></div>
				<div class="col-sm-5" style="width:5px; padding-top:7px; padding-left:10px; padding-right:15px">-</div>
				<div class="col-sm-5" style="width:85px; padding-left:0px; padding-right:0px"><input type="text" class="form-control" maxlength="3" id="reqPost2" name="reqPost2" readonly /></div>
				<div class="col-sm-5"><a href="#n" onclick="findJuso('juso1'); return false;" title="새창"><button type="submit" class="btn btn-primary">우편번호 검색</button></a></div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" style="text-align:left"><span style="color:red">*</span> 집주소</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" placeholder="" id="reqAddr" name="reqAddr" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" style="text-align:left">도로명주소</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" placeholder="" id="reqNewAddr1" name="reqNewAddr1" readonly />
					<br />
					<input type="text" class="form-control" placeholder="" id="reqNewAddr2" name="reqNewAddr2" />
				</div>
			</div>
		<%-- </form> --%>
		</div>
	</div>
</div>

<div class="panel panel-info" data-collapsed="0">
	<div class="panel-heading">
		<div class="panel-title">
			<!-- <i class="glyphicon glyphicon-th-list"></i> -->
			<i class="entypo-bag"></i> <strong>배출장소</strong>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="checkbox" id="" onClick="copyCheck(this);">
			주소지와 동일
			<font color="red">(배출지가 해당시청에 속하는 지역이 아니면 수거처리가 되지 않습니다.)</font>
		</div>
		<div class="panel-options">
			<a href="#" data-rel="collapse"><i class="entypo-down-open"></i></a>
		</div>
	</div>
	<div class="panel-body">
		<div class="form-horizontal form-groups-bordered">
			<div class="form-group">
				<label class="col-sm-3 control-label" style="text-align:left"><span style="color:red">*</span> 우편번호</label>
				<div class="col-sm-5" style="width:100px; padding-right:0px"><input type="text" class="form-control" maxlength="3" id="accPost1" name="accPost1" readonly /></div>
				<div class="col-sm-5" style="width:5px; padding-top:7px; padding-left:10px; padding-right:15px">-</div>
				<div class="col-sm-5" style="width:85px; padding-left:0px; padding-right:0px"><input type="text" class="form-control" maxlength="3" id="accPost2" name="accPost2" readonly /></div>
				<div class="col-sm-5"><a href="#n" onclick="findJuso('juso2'); return false;" title="새창"><button type="submit" class="btn btn-primary">우편번호 검색</button></a></div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" style="text-align:left"><span style="color:red">*</span> 주소</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" placeholder="" id="accAddr" name="accAddr" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" style="text-align:left">도로명주소</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" placeholder="" id="accNewAddr1" name="accNewAddr1" readonly />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" style="text-align:left">상세배출장소</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" placeholder="" id="accNewAddr2" name="accNewAddr2" />
				</div>
			</div>
		</div>
	</div>
</div>
<div style="padding-bottom:15px">
	<!-- <font color="red"> -->* 근처 찾기쉬운 건물명을 상세배출장소 뒷부분에 입력해 주세요. 예) 금성슈퍼, 금강빌딩 등<!-- </font> -->
</div>
<!-- <div style="padding-bottom:10px; text-align:right">
	<button type="submit" class="btn btn-blue">폐기물 및 규격</button>
</div> -->
<div class="panel panel-info" data-collapsed="0">
	<div class="panel-heading">
		<div class="panel-title">
			<!-- <i class="glyphicon glyphicon-th-list"></i> -->
			<i class="entypo-bag"></i> <strong>배출내역</strong>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<font color="red">폐기물 및 규격을 누르시면 폐기물 리스트를 볼 수 있습니다.</font>
		</div>
		<div class="panel-options">
			<a href="#" data-rel="collapse"><i class="entypo-down-open"></i></a>			
		</div>
	</div>
	<div class="panel-body">
		<div class="form-horizontal form-groups-bordered">
			<div class="form-group">
				<div class="row" style="margin:0 auto;">
					<div class="col-md-2" style="text-align:center; padding-bottom:10px">
						<strong>폐기물 찾기</strong>
					</div>
					<div class="col-md-3" style="text-align:center; padding-bottom:10px">
						<strong>폐기물 명</strong>
					</div>
					<div class="col-md-3" style="text-align:center; padding-bottom:10px">
						<strong>규격</strong>
					</div>
					<div class="col-md-2" style="text-align:center; padding-bottom:10px">
						<strong>금액</strong>
					</div>
					<div class="col-md-1" style="text-align:center; padding-bottom:10px">
						<strong>수량</strong>
					</div>
					<div class="col-md-1" style="text-align:center; padding-bottom:10px">
						<strong>삭제</strong>
					</div>
				</div>
				<%
				for(int rNum=1; rNum<=10; rNum++) {
				%>
				<div class="row" style="margin:0 auto; padding-bottom:5px">
					<div class="col-md-2" style="text-align:center">
						<a href="#n" onclick="popSpec('<%=rNum %>'); return false;" title="새창"><button type="submit" class="btn btn-primary">폐기물 및 규격</button></a>
					</div>
					<div class="col-md-3">
						<input type="text" class="form-control" placeholder="" id="item<%=rNum%>" name="item<%=rNum%>" readonly>
					</div>
					<div class="col-md-3">
						<input type="text" class="form-control" placeholder="" id="spec<%=rNum%>" name="spec<%=rNum%>" readonly>
					</div>
					<div class="col-md-2">
						<input type="text" class="form-control" placeholder="" id="price<%=rNum%>" name="price<%=rNum%>" readonly style="text-align:right">
					</div>
					<div class="col-md-1">
						<input type="text" class="form-control" placeholder="" id="amount<%=rNum%>" name="amount<%=rNum%>" onchange="javascript:setTotalMoney(<%=rNum%>);">
					</div>
					<div class="col-md-1" style="text-align:center">
						<a href="#n" onclick="deleteBtn('<%=rNum %>'); return false;"><button type="submit" class="btn btn-primary">삭제</button></a>
					</div>
				</div>
				<%
				}
				%>
			</div>
		</div>
	</div>
</div>

<div class="panel panel-info" data-collapsed="0">
	<div class="panel-heading">
		<div class="panel-title">
			<!-- <i class="glyphicon glyphicon-th-list"></i> -->
			<i class="entypo-bag"></i> <strong>수수료</strong>
		</div>
		<div class="panel-options">
			<a href="#" data-rel="collapse"><i class="entypo-down-open"></i></a>
		</div>
	</div>
	<div class="panel-body">
		<div class="form-horizontal form-groups-bordered">
			<div class="form-group">
				<label class="col-sm-3 control-label" style="text-align:left">수수료</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" placeholder="" id="price" name="price" readonly />
				</div>
				<label class="col-sm-3 control-label" style="text-align:left; font-weight:normal; padding-left:0px">원</label>
			</div>
		</div>
	</div>
</div>

<div class="panel panel-info" data-collapsed="0">
	<div class="panel-heading">
		<div class="panel-title">
			<!-- <i class="glyphicon glyphicon-th-list"></i> -->
			<i class="entypo-bag"></i> <strong>배출 예정일</strong>
		</div>
		<div class="panel-options">
			<a href="#" data-rel="collapse"><i class="entypo-down-open"></i></a>
		</div>
	</div>
	<div class="panel-body">
		<div class="form-horizontal form-groups-bordered">
			<div class="form-group">
				<label class="col-sm-3 control-label" style="text-align:left"><span style="color:red">*</span> 배출 예정일</label>
				<div class="col-sm-5" style="width:100px; padding-right: 0px">
					<select class="form-control" id="year" name="year">
					<%
						for(int i=0; yearResult<=yearMax; i++) {
					%>
						<option value=<%=yearResult %> <% if(year==yearResult) { %> selected="selected" <% } %>><%=yearResult %></option>
					<%
						String.valueOf(yearResult++);
						}
					%>
					</select>
				</div>
				<div class="col-sm-5" style="width:5px; padding-top:7px; padding-left:10px; padding-right:15px">년</div>
				<div class="col-sm-5" style="width:100px; padding-right: 0px">
					<select class="form-control" id="month" name="month">
					<%
						for(int i=1; i<=12; i++) {
					%>
					<option value=<%=i %> <% if(i==month) { %> selected="selected" <% } %>><%=i %></option>
					<%
						}
					%>
					</select>
				</div>
				<div class="col-sm-5" style="width:5px; padding-top:7px; padding-left:10px; padding-right:15px">월</div>
				<div class="col-sm-5" style="width:100px; padding-right:0px"><input type="text" class="form-control" maxlength="2" id="date" name="date" value=<%=date %> /></div>
				<div class="col-sm-5" style="width:5px; padding-top:7px; padding-left:10px; padding-right:15px">일</div>
			</div>
		</div>
	</div>
</div>

<div class="panel panel-info" data-collapsed="0">
	<div class="panel-heading">
		<div class="panel-title">
			<!-- <i class="glyphicon glyphicon-th-list"></i> -->
			<i class="entypo-bag"></i> <strong>세부 사항입력</strong>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<font color="red">* 다른 폐기물과 혼돈되지 않도록 특징을 자세히 입력해 주세요. 예: 색상, 제품번호, 회사명 등</font>
		</div>
		<div class="panel-options">
			<a href="#" data-rel="collapse"><i class="entypo-down-open"></i></a>
		</div>
	</div>
	<div class="panel-body">
		<div class="form-horizontal form-groups-bordered">
			<div class="form-group">
				<div class="col-sm-12">
					<textarea class="form-control" id="detail" name="detail" placeholder="" style="height:200px"></textarea>
				</div>
			</div>
		</div>
	</div>
</div>

<div style="padding-bottom:5px">
	* 결제 처리 후 민원인의 요청으로 인한 환불 처리시 결제 수수료를 제외한 금액이 환불 됩니다.
</div>
<div style="padding-bottom:5px">	
	* 환불처리 시 결제페이지 마지막에 표시되는 배출증 번호를 적어두시거나 인쇄하신 후 해당 주민센터에서 환불 요청하시기 바랍니다.
</div>
<div style="padding-bottom:5px">
	* 배출한 품목이 수거된 경우에는 환불되지 않습니다.
</div>

<div style="padding-top:50px; padding-bottom:10px; text-align:center">
	<button type="submit" id="registBtn" name="registBtn" class="btn btn-blue" style="width:80px">등록</button>
	<a href="#n" onclick="cancelBtn(); return false;"><button type="submit" class="btn btn-default" style="width:80px">취소</button></a>
</div>
</form>

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
