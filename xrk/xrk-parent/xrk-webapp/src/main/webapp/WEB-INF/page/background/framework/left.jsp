<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="../../common/taglib.jsp" %>
<%@taglib prefix="myShiro" tagdir="/WEB-INF/tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>left</title>

    <script type="application/javascript">

        $(document).ready(function () {

        });

    </script>

</head>
<body>
<div class="navbar-default sidebar" role="navigation">
    <div class="sidebar-nav navbar-collapse">
        <ul class="nav" id="side-menu">

            <li class="sidebar-search">
                <div class="input-group custom-search-form">
                    <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                </div>
            </li>

            <myShiro:hasAnyPermissions name="sys_user,sys_user_find,sys_user_addUI">
                <li>
                    <a href="#"><i class="fa fa-files-o fa-fw"></i>用户管理<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <shiro:hasPermission name="sys_user_find">
                            <li>
                                <a onclick="toLoadPage('${ctx }/${adminPath}/background/user/query.html');">查询用户</a>
                            </li>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="sys_user_addUI">
                            <li>
                                <a onclick="toLoadPage('${ctx }/${adminPath}/background/user/addUI.html');">新增用户</a>
                            </li>
                        </shiro:hasPermission>
                    </ul>
                </li>
            </myShiro:hasAnyPermissions>

            <myShiro:hasAnyPermissions name="sys_role,sys_role_find,sys_role_add">
                <li>
                    <a href="#"><i class="fa fa-files-o fa-fw"></i>角色管理<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <shiro:hasPermission name="sys_role_find">
                            <li>
                                <a href="/background/role/query.html">角色列表</a>
                            </li>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="sys_role_add">
                            <li>
                                <a href="/background/role/addUI.html">新增角色</a>
                            </li>
                        </shiro:hasPermission>
                    </ul>
                </li>
            </myShiro:hasAnyPermissions>

            <myShiro:hasAnyPermissions name="sys_resc,sys_resc_find,sys_resc_addUI">
                <li>
                    <a href="#"><i class="fa fa-files-o fa-fw"></i>资源管理<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <shiro:hasPermission name="sys_resc_find">
                            <li>
                                <a href="/background/resources/query.html">资源列表</a>
                            </li>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="sys_resc_addUI">
                            <li>
                                <a href="/background/resources/addUI.html">添加资源</a>
                            </li>
                        </shiro:hasPermission>
                    </ul>
                </li>
            </myShiro:hasAnyPermissions>

            <myShiro:hasAnyPermissions name="login,log_list">
                <li>
                    <a href="#"><i class="fa fa-files-o fa-fw"></i>登陆信息管理<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <shiro:hasPermission name="log_list">
                            <li>
                                <a href="/background/userLoginList/query.html">用户登录记录</a>
                            </li>
                        </shiro:hasPermission>
                    </ul>
                </li>
            </myShiro:hasAnyPermissions>

            <myShiro:hasAnyPermissions name="log,log_find">
                <li>
                    <a href="#"><i class="fa fa-files-o fa-fw"></i>操作日志管理<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <shiro:hasPermission name="log_find">
                            <li>
                                <a href="/background/log/query.html">日志查询</a>
                            </li>
                        </shiro:hasPermission>
                    </ul>
                </li>
            </myShiro:hasAnyPermissions>

            <myShiro:hasAnyPermissions name="web_cameraman,web_cameraman_find,web_cameraman_addUI">
                <li>
                    <a href="#"><i class="fa fa-files-o fa-fw"></i>摄影师管理<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <shiro:hasPermission name="web_cameraman_find">
                            <li>
                                <a href="/background/cameraman/query.html">摄影师列表</a>
                            </li>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="web_cameraman_addUI">
                            <li>
                                <a href="/background/cameraman/addUI.html">添加摄影师</a>
                            </li>
                        </shiro:hasPermission>
                    </ul>
                </li>
            </myShiro:hasAnyPermissions>

            <myShiro:hasAnyPermissions name="web_clothing,web_clothing_find,web_clothing_addUI">
                <li>
                    <a href="#"><i class="fa fa-files-o fa-fw"></i>服装管理<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <shiro:hasPermission name="web_clothing_find">
                            <li>
                                <a href="/background/clothing/query.html">服装列表</a>
                            </li>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="web_clothing_addUI">
                            <li>
                                <a href="/background/clothing/addUI.html">服装添加</a>
                            </li>
                        </shiro:hasPermission>
                    </ul>
                </li>
            </myShiro:hasAnyPermissions>

            <myShiro:hasAnyPermissions name="web_shooting_place,web_shooting_place_find,web_shooting_place_addUI">
                <li>
                    <a href="#"><i class="fa fa-files-o fa-fw"></i>拍摄地点管理<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <shiro:hasPermission name="web_shooting_place_find">
                            <li>
                                <a href="/background/shootingplace/query.html">拍摄地点列表</a>
                            </li>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="web_shooting_place_addUI">
                            <li>
                                <a href="/background/shootingplace/addUI.html">拍摄地点添加</a>
                            </li>
                        </shiro:hasPermission>
                    </ul>
                </li>
            </myShiro:hasAnyPermissions>

            <myShiro:hasAnyPermissions name="web_shooting_theme,web_shooting_theme_find,web_shooting_theme_addUI">
                <li>
                    <a href="#"><i class="fa fa-files-o fa-fw"></i>拍摄主题管理<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <shiro:hasPermission name="web_shooting_theme_find">
                            <li>
                                <a href="/background/shootingtheme/query.html">拍摄主题列表</a>
                            </li>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="web_shooting_theme_addUI">
                            <li>
                                <a href="/background/shootingtheme/addUI.html">拍摄主题添加</a>
                            </li>
                        </shiro:hasPermission>
                    </ul>
                </li>
            </myShiro:hasAnyPermissions>

            <myShiro:hasAnyPermissions name="web_product,web_product_find,web_product_addUI">
                <li>
                    <a href="#"><i class="fa fa-files-o fa-fw"></i>套餐管理<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <shiro:hasPermission name="web_product_find">
                            <li>
                                <a href="/background/product/query.html">套餐列表</a>
                            </li>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="web_product_addUI">
                            <li>
                                <a href="/background/product/addUI.html">套餐添加</a>
                            </li>
                        </shiro:hasPermission>
                    </ul>
                </li>
            </myShiro:hasAnyPermissions>

            <myShiro:hasAnyPermissions name="web_product_stock,web_product_stock_addUI,web_product_stock_find">
                <li>
                    <a href="#"><i class="fa fa-files-o fa-fw"></i>包装材料管理<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <shiro:hasPermission name="web_product_stock_find">
                            <li>
                                <a href="/background/productstock/query.html">包装材料列表</a>
                            </li>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="web_product_stock_addUI">
                            <li>
                                <a href="/background/productstock/addUI.html">添加包装材料</a>
                            </li>
                        </shiro:hasPermission>
                    </ul>
                </li>
            </myShiro:hasAnyPermissions>

        </ul>
    </div>
</div>
</body>
</html>
