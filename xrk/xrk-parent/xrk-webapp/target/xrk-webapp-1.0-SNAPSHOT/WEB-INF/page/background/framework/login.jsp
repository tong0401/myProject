<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/page/common/taglib.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>login</title>

    <script type="text/javascript">
        function checkUserForm() {
            var userName = $("#userName").val();
            var userPassword = $("#userPassword").val();
            if (userName == "" || userPassword == "") {
                window.wxc.xcConfirm("用户名或密码不能为空", window.wxc.xcConfirm.typeEnum.error);
                return false;
            }
            document.loginForm.submit();
        }
        //按回车键
        document.onkeydown = function () {
            if (event.keyCode == 13) {
                checkUserForm();
            }
        };

        $(function () {
            if (${message != null}) {
                window.wxc.xcConfirm('${message}', window.wxc.xcConfirm.typeEnum.error);
            }
        });

    </script>

</head>

<body>

    <div class="container" style="margin-top:10%;">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Please Sign In</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form" name="loginForm" method="post" action="${ctx }/${adminPath }/background/loginCheck.html" onsubmit="return false;">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="用户名" id="userName" name="userName" type="userName" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="密码" id="userPassword" name="userPassword" type="userPassword" value="">
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                    </label>
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
                                <button onclick="checkUserForm()" class="btn btn-lg btn-success btn-block">Login</button>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>

</html>
