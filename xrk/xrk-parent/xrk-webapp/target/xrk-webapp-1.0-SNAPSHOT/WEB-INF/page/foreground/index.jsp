<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@include file="../common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">
<meta name="viewport"
	content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">

<title>向日葵摄影网站-专业为您服务的网站</title>
<%@include file="../common/common-css.jsp"%>
<%@include file="../common/common-js.jsp"%>

<link rel="stylesheet" type="text/css"
	href="${pageContext.servletContext.contextPath }/css/fenyecss.css" />

<style type="text/css">
input {
	font-size: 12px
}
</style>
</head>

<body class="index">

	<%@include file="../common/foregroundTop.jsp"%>

	<div class="container projects" style="margin-top: 1%;">

		<div id="myCarousel" class="carousel slide">
			<!-- 轮播（Carousel）指标 -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>
			<!-- 轮播（Carousel）项目 -->
			<div class="carousel-inner">
				<div class="item active">
					<img
						src="${pageContext.servletContext.contextPath }/images/pt_41a05b0ab5524e168e245318ecce3465.jpg-works.g.jpg"
						alt="First slide">
				</div>
				<div class="item">
					<img
						src="${pageContext.servletContext.contextPath }/images/pt_ea73e6e98442406e8f8be65260ff4bc3.jpg-works.g.jpg"
						alt="Second slide">
				</div>
			</div>
			<!-- 轮播（Carousel）导航 -->
			<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
			<a class="carousel-control right" href="#myCarousel"
				data-slide="next">&rsaquo;</a>
		</div>

		<section class="hz-section" style="padding-top: 15px;">
		<div class="row">

			<c:forEach var="key" items="${pageView.records}">
				<div class="col-sm-6 col-lg-3 ">
					<div class="thumbnail">
						<a href="details.html?id=${key.id}" title="Git简易指南" target="_blank"
							onclick="_hmt.push(['_trackEvent', 'tile', 'click', 'git'])">
							<img class="lazy"
							src="http://static.bootcss.com/www/${pageContext.servletContext.contextPath }/images/git-guide.png"
							style="width: 300px; height: 250px;"
							data-src="http://static.bootcss.com/www/${pageContext.servletContext.contextPath }/images/git-guide.png">
						</a>
						<div class="caption">
							<h3>
								<a href="details.html" title="git简易指南" target="_blank"
									onclick="_hmt.push(['_trackEvent', 'tile', 'click', 'git'])">${key.name}
									<br> <small>${key.description}</small>
								</a>
							</h3>
							<div class="course-info">
								<img class="avatar-ss "
									src="http://f1.howzhi.com/avatar/2012/05-12/012238eac2d4588387.jpg">
								<a class="link-light " href="u/7224/">${key.cameramanName}</a>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>



		</div>

		<div style="margin-bottom: 30px;"></div>

		</section>

	</div>

	<%@include file="../common/foregroundBottom.jsp"%>

	<!--top-contain-->
	<%@include file="../common/foregroundContain.jsp"%>
	<!--top-contain-->

</body>

</html>