<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header class="header">
<div class="container">
	<div class="edu-header">
		<div class="navbar-header">
			<a href="index.html" class="navbar-brand"> <img
					src="${pageContext.servletContext.contextPath }/images/eslogo.png"
					class="img-responsive"> </a>
		</div>
		<div class="section header-inner clearfix" style="float: right;">
			<ul class="main-nav">

				<li class="active">
					<a href="javascript:;">关于我们</a>
					<ul class="submenu">
						<li>
							<a href="abouts/company">公司介绍</a>
						</li>
						<li>
							<a href="abouts/joinus">加入我们</a>
						</li>
					</ul>
				</li>

				<li>
					<a href="javascript:;">套餐</a>
					<ul class="submenu">
						<li>
							<ul>
								<li>
									<a href="product/system">ES通用版</a>
								</li>
								<li>
									<a href="product/k12">ES校园版</a>
								</li>
							</ul>
						</li>
					</ul>
				</li>

				<li>
					<a href="javascript:;">作品欣赏</a>
					<ul class="submenu">
						<li>
							<ul>
								<li>
									<a href="product/system">5岁以下儿童</a>
								</li>
								<li>
									<a href="product/k12">5-10岁儿童</a>
								</li>
								<li>
									<a href="product/k12">10-15岁儿童</a>
								</li>
								<li>
									<a href="product/k12">15岁以上</a>
								</li>
							</ul>
						</li>
					</ul>
				</li>

				<li>
					<a href="${pageContext.servletContext.contextPath }/foregroundregisterlogin/login.html">登录</a>
				</li>

				<li>
					<a href="${pageContext.servletContext.contextPath }/foregroundregisterlogin/login.html">注册</a>
				</li>

			</ul>
		</div>
	</div>
</div>
</header>