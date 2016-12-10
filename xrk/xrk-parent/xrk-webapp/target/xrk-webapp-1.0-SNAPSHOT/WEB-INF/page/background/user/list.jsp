<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@include file="../../common/taglib.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

</head>

<body>


<div id="wrapper">

    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">你当前的位置：系统管理-用户列表

                <div class="panel-body">
                    <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                        <thead>
                        <tr>
                            <th>用户名</th>
                            <th>所属角色</th>
                            <th>昵称</th>
                            <th>注册时间</th>
                            <th>最后一次登录时间</th>
                            <th>等级</th>
                            <th>基本操作</th>
                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach var="key" items="${pageView}">
                            <tr class="odd gradeX">
                                <td>${key.userName}</td>
                                <td>${key.roleName}</td>
                                <td>${key.userNickname}</td>
                                <td class="center">
                                    <fmt:parseDate value="${key.regTime}" var="date" pattern="yyyy-MM-dd HH:mm:ss"/>
                                    <fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                                <td class="center">
                                    <fmt:parseDate value="${key.lastLogintime}" var="date" pattern="yyyy-MM-dd HH:mm:ss"/>
                                    <fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
                                </td>
                                <td class="center">${key.level}</td>
                                <td class="center">
                                    <a href="javascript:void(0);" onclick="userRole('${key.userId}')">分配角色</a>
                                    <a href="javascript:void(0);" onclick="permissio('${key.userId}')">分配权限</a>
                                    <a onclick="toLoadPage('${ctx }/${adminPath}/background/user/getById.html?userId=${key.userId}&&type=1');">编辑</a>
                                    <a href="javascript:void(0);" onclick="checkClick('${ctx }/${adminPath}/background/user/deleteById?userId=${key.userId}','${ctx}/${adminPath}/background/user/query','删除');">删除</a>
                                </td>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

</div>

</div>

<script type="text/javascript">
    $(document).ready(function () {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
    function userRole(id) {
        top.dialog({
            url: "${ctx }/${adminPath}/background/user/userRole?userId=" + id,
            title: '设置角色',
            width: 400,
            height: 400,
            okValue: '设置',
            cancelValue: '取消',
            ok: function () {
                $("iframe")[0].contentWindow.getNodes();
                return false;
            },
            cancel: function () {
            }
        }).showModal();
        return false;
    }

</script>

</body>
</html>