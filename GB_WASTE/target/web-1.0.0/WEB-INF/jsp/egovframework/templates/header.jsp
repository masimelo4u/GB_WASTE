<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- Header -->
			<!-- logo -->
			<div class="navbar-brand">
				<font color="white"><strong>대형폐기물 처리</strong></font>
				<!-- <a href="index.html">
					<img src="assets/images/logo@2x.png" width="88" alt="" />
				</a> -->
			</div>
			
			<!-- main menu -->
			<ul class="navbar-nav">
				<li class="has-sub">
					<a href="#">
						<i class="entypo-gauge"></i>
						<span class="title">통합 관리</span>
					</a>
					<ul>
						<li>
							<a href="#">
								<span class="title">행정동 관리</span>
							</a>
						</li>
						<li>
							<a href="#">
								<span class="title">관리자 관리</span>
							</a>
						</li>
						<li>
							<a href="#">
								<span class="title">비밀번호 변경</span>
							</a>
						</li>
					</ul>
				</li>
				<li class="opened active has-sub">
					<a href="#">
						<i class="entypo-bag"></i>
						<span class="title">수거신청 관리</span>
					</a>
					<ul class="visible">
						<li>
							<a href="/wst/wasteList.do">
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
				<li class="has-sub">
					<a href="#">
						<i class="entypo-newspaper"></i>
						<span class="title">폐기물 및 규격 관리</span>
					</a>
					<ul>
						<li>
							<a href="#">
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
			
			<!-- notifications and other links -->
			<ul class="nav navbar-right pull-right">
				<!-- raw links -->
				<!-- <li class="dropdown">
										<li>
						<a href="#">Live Site</a>
					</li>
									</li>
				
				<li class="sep"></li> -->
				
				<li>
					<a href="extra-login.html">
						Log Out <i class="entypo-logout right"></i>
					</a>
				</li>
				
				
				<!-- mobile only -->
				<li class="visible-xs">	
				
					<!-- open/close menu icon (do not remove if you want to enable menu on mobile devices) -->
					<div class="horizontal-mobile-menu visible-xs">
						<a href="#" class="with-animation"><!-- add class "with-animation" to support animation -->
							<i class="entypo-menu"></i>
						</a>
					</div>
					
				</li>
				
			</ul>
			
