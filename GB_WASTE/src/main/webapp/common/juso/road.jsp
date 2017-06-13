<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	request.setCharacterEncoding("UTF-8");

	String gubun = (String)request.getParameter("gubun");
	if( gubun == null ) gubun = "";
	String transaction = (String)request.getParameter("transaction");
	if( transaction == null ) transaction = "";
	
	String inputYn = request.getParameter("inputYn");
	String roadFullAddr = request.getParameter("roadFullAddr"); 
	String roadAddrPart1 = request.getParameter("roadAddrPart1"); 
	String roadAddrPart2 = request.getParameter("roadAddrPart2"); 
	String engAddr = request.getParameter("engAddr"); 
	String jibunAddr = request.getParameter("jibunAddr"); 
	String zipNo = request.getParameter("zipNo");
	
	String siNm = request.getParameter("siNm");	
	String sggNm = request.getParameter("sggNm");
	String emdNm = request.getParameter("emdNm");
	String lnbrMnnm = request.getParameter("lnbrMnnm");
	String lnbrSlno = request.getParameter("lnbrSlno");
	
	String zipNo1 = "";
	String zipNo2 = "";
	
	if ( zipNo != null) {
		zipNo1 = zipNo.substring(0, 3);
		zipNo2 = zipNo.substring(3, 5);
		zipNo = zipNo.replaceAll("-", "");	
	}
	String addrDetail = request.getParameter("addrDetail"); 
	String admCd    = request.getParameter("admCd");
	String rnMgtSn = request.getParameter("rnMgtSn");
	String bdMgtSn  = request.getParameter("bdMgtSn");
	

%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
<title>::도로명주소검색::</title>
<link type="text/css" href="/common/juso/style.css" rel="stylesheet" />
<script src="/common/juso/common.js"></script>
<script type="text/javascript"> 
function init() {	
	var url = location.href;
	var confmKey = "bnVsbDIwMTQxMDI5MTc1OTUw";
	var inputYn= "<%=inputYn%>";
	if(inputYn != "Y") {
		document.form.confmKey.value = confmKey;
		document.form.returnUrl.value = url;
		document.form.action="http://www.juso.go.kr/addrlink/addrLinkUrl.do"; //인터넷망
		//document.form.action="http://10.182.60.22/addrlink/addrLinkUrl.do"; //내부행망
		document.form.submit();
	} else {

<%
		String post1 = "reqPost1";
		String post2 = "reqPost2";
		
		String newAddr = "";
		if("u".equals(transaction)) {
			newAddr = "reqNewAddr";
		}  
		String newAddr1 = "reqNewAddr1";
		String newAddr2 = "reqNewAddr2";	
		
		String addr = "reqAddr";
		String bunji1 = "reqBunji1";
		String bunji2 = "reqBunji2";
		String bjdongNm = "reqBjdong";
		
		if( "juso1".equals(gubun) ) {
			
		} else if( "juso2".equals(gubun) ) {
			post1 = "accPost1";
			post2 = "accPost2";
			
			if("u".equals(transaction)) {
				newAddr = "accNewAddr";	
			}
			newAddr1 = "accNewAddr1";
			newAddr2 = "accNewAddr2";	
			addr = "accAddr";
			bunji1 = "accBunji1";
			bunji2 = "accBunji2";
			bjdongNm = "accBjdong";
		} 
		
%>
		window.opener.document.getElementById("<%= bunji1 %>").value = '<%=lnbrMnnm%>';
		window.opener.document.getElementById("<%= bunji2 %>").value = '<%=lnbrSlno%>';
		
		window.opener.document.getElementById("<%= post1 %>").value = '<%=zipNo1%>';
		window.opener.document.getElementById("<%= post2 %>").value = '<%=zipNo2%>';
		
<%
	if("u".equals(transaction)) {
%>
		window.opener.document.getElementById("<%= newAddr %>").value = '<%=roadAddrPart1%> <%=addrDetail%> <%=roadAddrPart2%>';
<%
	} else {
%>
		window.opener.document.getElementById("<%= newAddr1 %>").value = '<%=roadAddrPart1%>';
		window.opener.document.getElementById("<%= newAddr2 %>").value = '<%=addrDetail%> <%=roadAddrPart2%>';
<%
	}
%>
		<%-- window.opener.document.getElementById("<%= addr1 %>").value = '<%=siNm%> <%=sggNm%> <%=emdNm%> <%=lnbrMnnm%>-<%=lnbrSlno%>';
		window.opener.document.getElementById("<%= addr2 %>").value = '<%=addrDetail%>'; --%>
		
		window.opener.document.getElementById("<%= addr %>").value =  '<%=jibunAddr%>';
		window.opener.document.getElementById("<%= bjdongNm %>").value =  '<%=emdNm%>';
        window.close();
	}
}
</script>
</head>
<body onload="init();">
<form id="form" name="form" method="post">
	<input type="hidden" id="confmKey" name="confmKey" value=""/>
	<input type="hidden" id="returnUrl" name="returnUrl" value=""/>
</form>
</body>
</html>
