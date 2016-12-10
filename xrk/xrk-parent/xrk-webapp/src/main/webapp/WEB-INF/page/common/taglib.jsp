<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">

<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<c:set var="adminPath" value="admin"/>

<%--

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<c:set var="ctx" value="<%=basePath %>"/>
--%>


<script type="text/javascript" src="${ctx }/statics/js/jquery-2.1.1.min.js"></script>
<link href="${ctx}/statics/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
<script type="text/javascript" src="${ctx }/statics/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/statics/tip-plug/css/xcConfirm.css"/>
<script src="${ctx}/statics/tip-plug/js/xcConfirm.js" type="text/javascript" charset="utf-8"></script>

<link rel="stylesheet" type="text/css" href="${ctx}/statics/css/style.css"/>

<script type="text/javascript" src="${ctx }/statics/js/common.js"></script>

<!--前端框架-->
<!-- MetisMenu CSS -->
<link href="${ctx }/statics/framework/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="${ctx }/statics/framework/dist/css/sb-admin-2.css" rel="stylesheet">
<!-- Morris Charts CSS -->
<link href="${ctx }/statics/framework/vendor/morrisjs/morris.css" rel="stylesheet">
<!-- Custom Fonts -->
<link href="${ctx }/statics/framework/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<!-- Metis Menu Plugin JavaScript -->
<script src="${ctx }/statics/framework/vendor/metisMenu/metisMenu.min.js"></script>
<!-- Morris Charts JavaScript -->
<script src="${ctx }/statics/framework/vendor/raphael/raphael.min.js"></script>
<!-- Custom Theme JavaScript -->
<script src="${ctx }/statics/framework/dist/js/sb-admin-2.js"></script>
<!-- DataTables JavaScript -->
<script src="${ctx }/statics/framework/vendor/datatables/js/jquery.dataTables.min.js"></script>
<script src="${ctx }/statics/framework/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
<script src="${ctx }/statics/framework/vendor/datatables-responsive/dataTables.responsive.js"></script>
<!-- DataTables CSS -->
<link href="${ctx }/statics/framework/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">
<!-- DataTables Responsive CSS -->
<link href="${ctx }/statics/framework/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">

<!---->
<script src="${ctx }/statics/artDialog/js/dialog.js"></script>
<script src="${ctx }/statics/artDialog/js/dialog-min.js"></script>
<script src="${ctx }/statics/artDialog/js/dialog-plus.js"></script>
<script src="${ctx }/statics/artDialog/js/dialog-plus-min.js"></script>
<link href="${ctx }/statics/artDialog/css/ui-dialog.css" rel="stylesheet">
<!---->

<!---->
<script src="${ctx }/statics/validator/js/bootstrapValidator.min.js"></script>
<script src="${ctx }/statics/validator/js/bootstrapValidator_zh_CN.js"></script>
<link href="${ctx }/statics/validator/css/bootstrapValidator.min.css" rel="stylesheet">
<!---->

<script src="${ctx }/statics/js/notice.js"></script>

<script src="${ctx }/statics/ueditor/ueditor.all.min.js"></script>
<script src="${ctx }/statics/ueditor/ueditor.config.js"></script>
<script src="${ctx }/statics/ueditor/ueditor.parse.min.js"></script>

<!--前端框架-->

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

</head>

<script>

    if ("${msg}" != "") {
        msgCenter("提示", "${msg}", 3000);
    }

</script>

</html>