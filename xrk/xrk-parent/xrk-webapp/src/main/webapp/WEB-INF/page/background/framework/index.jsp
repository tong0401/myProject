<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="../../common/taglib.jsp" %>
<%@taglib prefix="myShiro" tagdir="/WEB-INF/tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>向日葵官网后台管理系统</title>

</head>

<body>

<div id="wrapper">

    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
        <!--顶头部分-->
        <jsp:include page="top.jsp"/>
        <!--顶头部分-->
        <!--左侧菜单栏部分-->
        <jsp:include page="left.jsp"/>
        <!--左侧菜单栏部分-->
    </nav>

    <!--中部内容部分-->
    <jsp:include page="right.jsp"/>
    <!--中部内容部分-->

</div>

</body>

</html>
