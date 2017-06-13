<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<ul id="main-menu" class="main-menu">
				<!-- add class "multiple-expanded" to allow multiple submenus to open -->
				<!-- class "auto-inherit-active-class" will automatically add "active" class for parent elements who are marked already with class "active" -->
				<c:choose>
				    <c:when test="${menu eq 'selectHjdongList' || menu eq 'selectMngList' || menu eq 'updatePwdView'}">
				        <li class="opened active has-sub">	
				    </c:when>
				    <c:otherwise>
				        <li class="has-sub">
				    </c:otherwise>
				</c:choose>
					<a href="#">
						<i class="entypo-gauge"></i>
						<span class="title">통합 관리</span>
					</a>
					<c:choose>
					    <c:when test="${menu eq 'selectHjdongList' || menu eq 'selectMngList' || menu eq 'updatePwdView'}">
					        <ul class="visible">
					    </c:when>
					    <c:otherwise>
					        <ul>
					    </c:otherwise>
					</c:choose>
						<c:choose>
						    <c:when test="${menu eq 'selectHjdongList'}">
						        <li class="active">
						    </c:when>
						    <c:otherwise>
						        <li>
						    </c:otherwise>
						</c:choose>
							<a href="/hjd/selectHjdongList.do">
								<span class="title">행정동 관리</span>
							</a>
						</li>
						<c:choose>
						    <c:when test="${menu eq 'selectMngList'}">
						        <li class="active">
						    </c:when>
						    <c:otherwise>
						        <li>
						    </c:otherwise>
						</c:choose>
							<a href="/mng/selectMngList.do">
								<span class="title">관리자 관리</span>
							</a>
						</li>
						<c:choose>
						    <c:when test="${menu eq 'updatePwdView'}">
						        <li class="active">
						    </c:when>
						    <c:otherwise>
						        <li>
						    </c:otherwise>
						</c:choose>
							<a href="/mng/updatePwdView.do">
								<span class="title">비밀번호 변경</span>
							</a>
						</li>
					</ul>
				</li>
				<c:choose>
				    <c:when test="${menu eq 'selectWasteList'}">
				        <li class="opened active has-sub">	
				    </c:when>
				    <c:otherwise>
				        <li class="has-sub">
				    </c:otherwise>
				</c:choose>
					<a href="#">
						<i class="entypo-bag"></i>
						<span class="title">수거신청 관리</span>
					</a>
					<c:choose>
					    <c:when test="${menu eq 'selectWasteList'}">
					        <ul class="visible">
					    </c:when>
					    <c:otherwise>
					        <ul>
					    </c:otherwise>
					</c:choose>
						<c:choose>
						    <c:when test="${menu eq 'selectWasteList'}">
						        <li class="active">
						    </c:when>
						    <c:otherwise>
						        <li>
						    </c:otherwise>
						</c:choose>
							<a href="/wst/selectWasteList.do">
								<span class="title">수거신청 관리</span>
							</a>
						</li>
						<li>
							<a href="#">
								<span class="title">수거일 등록</span>
							</a>
						</li>
					</ul>
				</li>
				<c:choose>
				    <c:when test="${menu eq 'selectSpecList'}">
				        <li class="opened active has-sub">	
				    </c:when>
				    <c:otherwise>
				        <li class="has-sub">
				    </c:otherwise>
				</c:choose>
					<a href="#">
						<i class="entypo-newspaper"></i>
						<span class="title">폐기물 및 규격 관리</span>
					</a>
					<c:choose>
					    <c:when test="${menu eq 'selectSpecList'}">
					        <ul class="visible">
					    </c:when>
					    <c:otherwise>
					        <ul>
					    </c:otherwise>
					</c:choose>
						<c:choose>
						    <c:when test="${menu eq 'selectSpecList'}">
						        <li class="active">
						    </c:when>
						    <c:otherwise>
						        <li>
						    </c:otherwise>
						</c:choose>
							<a href="/spc/selectSpecList.do">
								<span class="title">폐기물 및 규격 관리</span>
							</a>
						</li>
					</ul>
				</li>
				<li class="has-sub">
					<a href="#">
						<i class="entypo-doc-text"></i>
						<span class="title">통계</span>
					</a>
					<ul>
						<li>
							<a href="#">
								<span class="title">통계</span>
							</a>
						</li>
						<li>
							<a href="#">
								<span class="title">품목별 통계</span>
							</a>
						</li>
					</ul>
				</li>
			</ul>    
			