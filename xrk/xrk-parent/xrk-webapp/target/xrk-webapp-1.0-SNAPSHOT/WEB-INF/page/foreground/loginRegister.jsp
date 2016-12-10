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

		<title>登录 - 向日葵摄影网</title>
		<%@include file="../common/common-css.jsp"%>
		<%@include file="../common/common-js.jsp"%>

		<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath }/css/login.css">
		
		<script type="text/javascript">
			$(document).ready(function(){
				
				$("[name='to_register']").click(function(){
					$("[name='login_div']").removeClass("login-box");
					$("[name='login_div']").addClass("login-box active");
					
					$("[name='register_div']").removeClass("login-box register");
					$("[name='register_div']").addClass("login-box register active");
				});
				
				$("[name='to_login']").click(function(){
					$("[name='login_div']").removeClass("login-box active");
					$("[name='login_div']").addClass("login-box login-delay");
					
					$("[name='register_div']").removeClass("login-box register active");
					$("[name='register_div']").addClass("login-box register");
				});
				
			});
		</script>
		
		<body class="index">
		
		
		<header class="header">
			<div class="container">
				<div class="edu-header">
					<div class="navbar-header">
						<a href="index.html" class="navbar-brand">
							<img src="${pageContext.servletContext.contextPath }/images/eslogo.png" class="img-responsive">
						</a>
					</div>
					<div class="section header-inner clearfix" style="float: right;">
						<ul class="main-nav">
						</ul>
					</div>
				</div>
			</div>
		</header>
		
		
		<div class="login">
			
			<!-- login -->
			<div class="login-box" name="login_div">
				<h1>登录向日葵
					<a name="to_register" show_class="login-box login-delay" hide_class="login-box register" class="pull-right js-trun">注册
						<i class="fa fa-arrow-circle-o-right"></i>
					</a>
				</h1>
				<form id="login-form" class="form-vertical" method="post" action="login_check">
					<div class="form-group">
						<label class="control-label" for="login_username">帐号</label>
						<div class="controls">
							<label class="fa-label">
								<i class="fa fa-user glyphicon glyphicon-user"></i>
							</label>
							<input class="form-control" id="login_username" type="text" name="_username" value="" required placeholder='邮箱/手机/用户名' />
							<div class="help-block"></div>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label" for="login_password">密码</label>
						<div class="controls">
							<label class="fa-label">
								<i class="fa fa-unlock-alt glyphicon glyphicon-lock"></i>
							</label>
							<input class="form-control" id="login_password" type="password" name="_password" required placeholder='密码'>
						</div>
					</div>
	
					<div class="form-group">
						<div class="controls">
							<span class="checkbox mtm ">
								<label>
									<input type="checkbox" name="_remember_me" checked="checked">记住密码
								</label>
								<a class="pull-right active" href="resetPass.html">忘记密码</a>
							</span>
						</div>
						<input class="login-btn btn-primary btn" type="submit" value="登录" />
						<div class="social">
							快捷登录
							<a href="login/bind/weibo?_target_path=%2F" class="social-login-btn">
								<i class="hz-icon icon-weibo"></i>
							</a>
							<a href="login/bind/qq?_target_path=%2F" class="social-login-btn">
								<i class="hz-icon icon-qq"></i>
							</a>
						</div>
					</div>
					<input type="hidden" name="_target_path" value="">
					<input type="hidden" name="_csrf_token" value="2a4601f0edb10184900a53b6a90c8108270ea2cc">
				</form>
			</div>
			<!-- login -->
			
			<!-- register -->
			<div class="login-box register" name="register_div">
				<h1>注册向日葵账号
					<a name="to_login" show_class="login-box register active" hide_class="login-box active" class="pull-right js-trun">登录
						<i class="fa fa-arrow-circle-o-right"></i>
					</a>
				</h1>
				<form id="register-form" class="form-vertical" method="post" action="register">
					<div class="form-group mb40">
						<label class="control-label required" for="register_emailOrMobile">常用手机号或邮箱</label>
						<div class="controls">
							<label class="fa-label">
								<i class="hz-icon icon-demo25 glyphicon glyphicon-envelope"></i>
							</label>
							<input type="text" id="register_emailOrMobile" name="emailOrMobile" required="required" class="form-control" data-url="register/email_or_mobile/check" placeholder="常用手机号或邮箱">
							<p class="help-block"></p>
						</div>
					</div>
	
					<div class="form-group mb40">
						<label class="control-label required" for="register_nickname">昵称</label>
						<div class="controls">
							<label class="fa-label">
								<i class="hz-icon icon-person glyphicon glyphicon-user"></i>
							</label>
							<input type="text" id="register_nickname" name="nickname" required="required" class="form-control" data-url="register/nickname/check" placeholder="请输入昵称">
						</div>
					</div>
					<div class="form-group mb40">
						<label class="control-label required" for="register_password">密码</label>
						<div class="controls">
							<label class="fa-label">
								<i class="hz-icon icon-lock glyphicon glyphicon-lock"></i>
							</label>
							<input type="password" id="register_password" name="password" required="required" class="form-control" placeholder="密码">
						</div>
					</div>
					<div class="form-group mb40 hidden email_mobile_msg">
						<label class="control-label required" for="sms_code">短信验证码</label>
						<div class="controls row">
							<div class="col-xs-6">
								<input type="text" class="form-control ident" id="sms_code" name="sms_code" placeholder="短信验证码" required="required" data-url="edu_cloud/sms_check/sms_registration">
							</div>
							<div class="col-xs-6">
								<a href="#modal" data-toggle="modal" class="btn ident btn-primary btn-lg  form-control  js-sms-send disabled" data-url="register/captcha/modal" data-sms-url="edu_cloud/sms_send">
									<span id="js-time-left"></span>
									<span id="js-fetch-btn-text">获取短信验证码</span>
								</a>
							</div>
						</div>
					</div>
					<div class="form-group mb40 agren">
						<div class="controls">
							<label>
								<input type="checkbox" id="user_terms" checked="checked"> 我已阅读并同意
								<a href="userterms" target="_blank">《服务协议》</a>
							</label>
						</div>
					</div>
					<div class="form-group">
						<div class="controls">
							<button type="submit" id="register-btn " data-submiting-text="正在提交" class="login-btn btn-primary btn">注册 </button>
						</div>
					</div>
					<input type="hidden" name="captcha_enabled" value="0">
					<input type="hidden" name="_csrf_token" value="2a4601f0edb10184900a53b6a90c8108270ea2cc">
				</form>
			</div>
			<!-- register -->
			
		</div>
		
		<%@include file="../common/foregroundBottom.jsp"%>
		
	</body>

</html>