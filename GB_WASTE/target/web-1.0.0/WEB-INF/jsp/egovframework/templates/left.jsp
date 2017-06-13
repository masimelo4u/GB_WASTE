<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<ul id="main-menu" class="main-menu">
				<!-- add class "multiple-expanded" to allow multiple submenus to open -->
				<!-- class "auto-inherit-active-class" will automatically add "active" class for parent elements who are marked already with class "active" -->
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
			