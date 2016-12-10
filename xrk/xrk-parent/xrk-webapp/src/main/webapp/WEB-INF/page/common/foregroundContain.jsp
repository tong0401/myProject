<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="side">
	<ul>
		<li class="hz-weixin">
			<a href="#">
				<div class="weixin">
					<p class="text-center">
						扫一扫关注向日葵微信
					</p>
					<img
						src="${pageContext.servletContext.contextPath }/images/2code.png"
						class="img-responsive" style="width: 100%; padding: 5%;"
						alt="向日葵微信">
				</div>
				<div class="sidebox">
					<img
						src="${pageContext.servletContext.contextPath }/images/top-contain/side_icon01.png">
					<span style="float: right; margin-right: 9%;">微信</span>
				</div> </a>
			<div class="weixin">
				<p
					style="color: #ff6699; text-align: center; margin: 0 0 0px; font-size: 13px;">
					扫一扫关注向日葵微信
				</p>
				<img
					src="${pageContext.servletContext.contextPath }/images/2code.png"
					class="img-responsive" style="width: 100%; padding: 5%;"
					alt="向日葵微信">
			</div>
		</li>
		<li>
			<a href="javascript:void(0);">
				<div class="sidebox">
					<img
						src="${pageContext.servletContext.contextPath }/images/top-contain/side_icon04.png">
					QQ客服
				</div> </a>
		</li>
		<li>
			<a href="javascript:void(0);">
				<div class="sidebox">
					<img
						src="${pageContext.servletContext.contextPath }/images/top-contain/side_icon03.png">
					新浪微博
				</div> </a>
		</li>
		<li style="border: none;">
			<a href="javascript:goTop();" class="sidetop" style="display: none;">
				<img
					src="${pageContext.servletContext.contextPath }/images/top-contain/side_icon05.png">
			</a>
		</li>
	</ul>
</div>