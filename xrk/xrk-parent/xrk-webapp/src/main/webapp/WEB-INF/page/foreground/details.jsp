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

<script src="${pageContext.servletContext.contextPath }/js/plugins.min.js"></script>
<script src="${pageContext.servletContext.contextPath }/js/main.min.js"></script>

<script src="${pageContext.servletContext.contextPath }/js/photo_order_box.js"></script>

<link rel="stylesheet" type="text/css"
	href="${pageContext.servletContext.contextPath }/css/Introduction-menu.css">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath }/css/details.css">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath }/css/order_box.css">

<script type="text/javascript">
	
	$(document).ready(function() {
		
		//详情图片
		var album = '${webProduct.album}';
		var imgJson=eval('('+album+')');
		console.log("album=="+album);
		var html = "";
		for(var i=0,l=imgJson.length;i<l;i++){
			var url = imgJson[i]["url"];
			var item = imgJson[i]["item"];
			var title = imgJson[i]["title"];
			var content = imgJson[i]["content"];
			console.log("url="+url);
			html += "<div class='post-masonry col-md-4 col-sm-6'>";
			html += "<div class='post-thumb'>";
			html += "<img src='"+url+"'>";
			html += "<div class='title-over'>";
			html += "<h4> <a href='#'>"+title+"</a></h4>";
			html += "</div>";
			html += "<div class='post-hover text-center'>";
			html += "<div class='inside'>";
			html += "<h4><a href='#'>"+title+"</a></h4>";
			html += "<p>"+content+"</p>";
			html += "</div>";
			html += "</div>";
			html += "</div>";
			html += "</div>";
		}
		$("#img_details").html(html);
		
	});
	/* 
	//提交预约
	function submitOrder() {
		var userName = $("[name='userName']").val();
		var orderTel = $("[name='orderTel']").val();
	}
	 */
</script>

<style type="text/css">
.ul-li {
	height: 210px;
	border: 1px solid #EEE;
	border-radius: 5px;
	margin-right: 30px;
	padding: 10px;
}

.ul-li img {
	width: 100%;
	height: 100%;
}

.ul-li a {
	height: 70%;
	border: 1px solid #E0E0E0;
}

.ul-li-span-1 {
	font-size: 15px;
	color: #E0E0E0;
}

.ul-li-span-2 {
	font-size: 30px;
	color: #999;
}
</style>
<body class="index">

	<%@include file="../common/foregroundTop.jsp"%>

	<div class="container projects" style="margin-top: 1%;">
		<section class="hz-section">
		<div class="row">
			<div class="main-posts">
				<div class="container">
					<div class="row">
						<div class="blog-masonry masonry-true" id="img_details">

							<%-- 
							<div class="post-masonry col-md-4 col-sm-6">
								<div class="post-thumb">
									<img
										src="${pageContext.servletContext.contextPath }/images/1.jpg"
										alt="">
									<div class="title-over">
										<h4>
											<a href="#">Title one goes here</a>
										</h4>
									</div>
									<div class="post-hover text-center">
										<div class="inside">
											<h4>
												<a href="#">Title one goes here</a>
											</h4>
											<p>Cum sociis natoque penatibus et magnis dis parturient
											</p>
										</div>
									</div>
								</div>
							</div>

							<div class="post-masonry col-md-4 col-sm-6">
								<div class="post-thumb">
									<img
										src="${pageContext.servletContext.contextPath }/images/2.jpg"
										alt="">
									<div class="title-over">
										<h4>
											<a href="#">Second Image Title</a>
										</h4>
									</div>
									<div class="post-hover text-center">
										<div class="inside">
											<h4>
												<a href="#">Second Image Title</a>
											</h4>
											<p>Donec venenatis libero sapien, eu condimentum lacus</p>
										</div>
									</div>
								</div>
							</div>

							<div class="post-masonry col-md-4 col-sm-6">
								<div class="post-thumb">
									<img
										src="${pageContext.servletContext.contextPath }/images/3.jpg"
										alt="">
									<div class="title-over">
										<h4>
											<a href="#">Image Number Three</a>
										</h4>
									</div>
									<div class="post-hover text-center">
										<div class="inside">
											<h4>
												<a href="#">Image Number Three</a>
											</h4>
											<p>Sed vitae lacus eget ipsum scelerisque condimentum</p>
										</div>
									</div>
								</div>
							</div>

							<div class="post-masonry col-md-4 col-sm-6">
								<div class="post-thumb">
									<img
										src="${pageContext.servletContext.contextPath }/images/4.jpg"
										alt="">
									<div class="title-over">
										<h4>
											<a href="#">Aliquam sed magna risus</a>
										</h4>
									</div>
									<div class="post-hover text-center">
										<div class="inside">
											<h4>
												<a href="#">Aliquam sed magna risus</a>
											</h4>
											<p>Praesent pharetra blandit ex sed imperdiet</p>
										</div>
									</div>
								</div>
							</div>

							<div class="post-masonry col-md-4 col-sm-6">
								<div class="post-thumb">
									<img
										src="${pageContext.servletContext.contextPath }/images/5.jpg"
										alt="">
									<div class="title-over">
										<h4>
											<a href="#">Lorem ipsum dolor sit</a>
										</h4>
									</div>
									<div class="post-hover text-center">
										<div class="inside">
											<h4>
												<a href="#">Lorem ipsum dolor sit</a>
											</h4>
											<p>Vestibulum faucibus lacus ac risus efficitur</p>
										</div>
									</div>
								</div>
							</div>

							<div class="post-masonry col-md-4 col-sm-6">
								<div class="post-thumb">
									<img
										src="${pageContext.servletContext.contextPath }/images/6.jpg"
										alt="">
									<div class="title-over">
										<h4>
											<a href="#">Praesent eget lectus mauris</a>
										</h4>
									</div>
									<div class="post-hover text-center">
										<div class="inside">
											<h4>
												<a href="#">Praesent eget lectus mauris</a>
											</h4>
											<p>Morbi placerat pellentesque tortor, sed auctor dolor</p>
										</div>
									</div>
								</div>
							</div>
							 --%>

						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="jumbotron"
			style="border-radius: 0px; background-color: #fff;">
			<div id="main" class="main">
				<div class="container">
					<div class="row">
						<div class="col-xs-12 col-sm-12">
							<div class="contain">
								<nav id="product-menu" class="naver">
								<ul>

									<li class="ul-li"><a> <img
											src="${pageContext.servletContext.contextPath }/images/eslogo.png"
											alt="">
									</a> <span class="ul-li-span-1">摄影师</span> <span
										class="ul-li-span-2">${webProduct.cameramanPrice}</span></li>

									<li class="ul-li"><a> <img
											src="${pageContext.servletContext.contextPath }/images/eslogo.png"
											alt="">
									</a> <span class="ul-li-span-1">服装</span> <span
										class="ul-li-span-2">${webProduct.clothingPrice}</span></li>

									<li class="ul-li"><a> <img
											src="${pageContext.servletContext.contextPath }/images/eslogo.png"
											alt="">
									</a> <span class="ul-li-span-1">拍摄景点</span> <span
										class="ul-li-span-2">${webProduct.shootingPlacePrice}</span></li>

									<li class="ul-li"><a> <img
											src="${pageContext.servletContext.contextPath }/images/eslogo.png"
											alt="">
									</a> <span class="ul-li-span-1">包装设计</span> <span
										class="ul-li-span-2">${webProduct.productStockPrice}</span></li>

								</ul>
								</nav>
							</div>

							<nav id="product-menu" class="naver">
							<ul>
								<li class="ul-li" onclick="serviceOrder('作品-立即预约')">
									<a class="btn btn-primary btn-lg" style="height: 100%; background-color: #ff6699; border-color: #ff6699;">
										<span style="margin-top: 60%;"> 立刻预约
											<i class="glyphicon glyphicon-chevron-right" style="font-size: 40"></i>
										</span>
									</a>
								</li>
							</ul>
							</nav>

						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="introduction-menu ">
			<div class="introduction-menu introduction-menu-tabs">
				<div class="introduction-menu-container">
					<div class="row">
						<div class="col-xs-12">
							<ul class="nav nav-tabs" role="tablist">
								<li role="presentation"
									class="active introduction-menu-tab-item"><a
									href="#private" role="tab" data-toggle="tab">
										<h2>套餐概览</h2>
								</a></li>
								<li role="presentation" class="introduction-menu-tab-item">
									<a href="#community" role="tab" data-toggle="tab">
										<h2>服务细节</h2>
								</a>
								</li>
								<li role="presentation" class="introduction-menu-tab-item">
									<a href="#community" role="tab" data-toggle="tab">
										<h2>用户评价</h2>
								</a>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane active" id="private">
					<div class="background-gray2 introduction-menu-section-border">
						<div
							class="introduction-menu-section introduction-menu-section-left">
							<div class="introduction-menu-img">
								<img alt="Crane"
									src="https://d340syr2dan8gj.cloudfront.net/assets/landing/crane-a216b503318e4984264c74978d3b768d.png" />
							</div>
						</div>
					</div>
				</div>
				<div role="tabpanel" class="tab-pane" id="community">
					<div class="background-gray2 introduction-menu-section-border">
						<div
							class="introduction-menu-section introduction-menu-section-left">
							<div class="introduction-menu-img">
								<img alt="Yelp"
									src="https://d340syr2dan8gj.cloudfront.net/assets/landing/community/yelp-377c1a437d33ec54354114973f1aef44.png" />
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		</section>

	</div>

	<!-- 预约弹出框 -->
	<div class="order_mask"></div>
	<div class="order_box">
		<div class="order_section">
			<div class="order_title">预约向日葵儿童摄影</div>
			<div class="highlight">
				<p class="text_order_dec">
					<span class="tag">巨优惠</span><span class="dis">部分摄影师超值抢购活动进行中</span>
				</p>
				<p class="text_order_dec">
					<span class="tag">到店礼</span><span class="dis">凭首次预约短信到店即可领取萌萌哒小黄人玩偶一个</span>
				</p>
				<p class="text_order_dec">
					<span class="tag">放心拍</span><span class="dis">预付500元，不满意随时重拍</span>
				</p>
			</div>
			<form action="${ctx }/foreground/order/add.html" class="form-horizontal" role="form" method="post">
				<input type="hidden" name="productId" value="${webProduct.id}"></input>
				<div class="tip_order_dec">
					感谢您选择婚礼猫婚纱摄影服务。提交手机号码成功后，顾问将在24小时内（节假日顺延）向您致电，与您沟通拍摄细节。本次服务内容详情仅做预约使用，实际服务以下单为准
					<br />
					<div class="input_section">
						<input class="order_input" type="text" name="userName" value="" placeholder="您的姓名"></input>
						<span style="float: right; height: 100%; line-height: 35px; border-radius: 5px; background-color: rgba(216, 216, 216, 0.63); cursor: pointer;">姓名</span>
					</div>
					<div class="input_section">
						<input class="order_input" type="text" name="orderTel" value="" placeholder="您的手机号码 "></input>
						<span style="float: right; height: 100%; line-height: 35px; border-radius: 5px; background-color: rgba(216, 216, 216, 0.63); cursor: pointer;">免费验证码</span>
					</div>
					<div class="input_section">
						<input class="order_input" type="text" value="" placeholder="验证码">
					</div>
				</div>
				
				<!-- <div class="order_btn">立即预约</div> -->
				<button type="submit" class="order_btn">立即预约</button>
				
				<div class="order_close" onclick="closeOrder()"></div>
			</form>
		</div>
	</div>
	<!-- 预约弹出框 -->


	<%@include file="../common/foregroundBottom.jsp"%>

	<!--top-contain-->
	<%@include file="../common/foregroundContain.jsp"%>
	<!--top-contain-->


</body>

</html>