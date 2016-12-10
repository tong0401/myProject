<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@include file="../../common/taglib.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

</head>

<body>
<div style="height: 100%;overflow-y: auto;">
    <br/> <br/>

    <div class="panel-body">

        <form class="form-horizontal" id="formId">

            <div class="form-group">
                <label class="col-md-1 control-label ui-sortable" for="userName">用户名</label>
                <div class="col-md-5 ui-sortable">
                    <input class="form-control" type="text" name="userName" id="userName">
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-1 control-label ui-sortable" for="userPassword">密码</label>
                <div class="col-md-5 ui-sortable">
                    <input class="form-control" type="text" name="userPassword" id="userPassword" type="password">
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-1 control-label ui-sortable" for="userNickname">昵称</label>
                <div class="col-md-5 ui-sortable">
                    <input class="form-control" type="text" name="userNickname" id="userNickname">
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-1 control-label ui-sortable" for="userRealname">真实姓名</label>
                <div class="col-md-5 ui-sortable">
                    <input class="form-control" type="text" name="userRealname" id="userRealname">
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-1 control-label ui-sortable" for="province">开户所在省</label>
                <div class="col-md-5 ui-sortable">
                    <input class="form-control" type="text" name="province" id="province">
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-1 control-label ui-sortable" for="city">开户所在市</label>
                <div class="col-md-5 ui-sortable">
                    <input class="form-control" type="text" name="city" id="city">
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-1 control-label ui-sortable" for="userAge">年龄</label>
                <div class="col-md-5 ui-sortable">
                    <input class="form-control" type="text" name="userAge" id="userAge">
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-1 control-label ui-sortable" for="userSex">性别</label>
                <div class="col-md-5 ui-sortable">
                    <input class="form-control" type="text" name="userSex" id="userSex">
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-1 control-label ui-sortable" for="userAddress">地址</label>
                <div class="col-md-5 ui-sortable">
                    <input class="form-control" type="text" name="userAddress" id="userAddress">
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-1 control-label ui-sortable" for="userAddress">账号类型</label>
                <div class="col-md-5 ui-sortable">
                    <input type="radio" name="accountType" value="个人账号" checked="checked"/>：个人账号
                    <input type="radio" name="accountType" value="企业账号"/>：企业账号
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-1 control-label ui-sortable" for="userPhone">电话</label>
                <div class="col-md-5 ui-sortable">
                    <input class="form-control" type="text" name="userPhone" id="userPhone">
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-1 control-label ui-sortable" for="userMail">邮箱</label>
                <div class="col-md-5 ui-sortable">
                    <input class="form-control" type="text" name="userMail" id="userMail">
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-1 control-label ui-sortable" for="mark">备注</label>
                <div class="col-md-5 ui-sortable">
                    <input class="form-control" type="text" name="mark" id="mark">
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-1 control-label ui-sortable" for="mark">QQ</label>
                <div class="col-md-5 ui-sortable">
                    <input class="form-control" type="text" name="userQQ" id="userQQ">
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-1 control-label ui-sortable" for="mark">用户状态</label>
                <div class="col-md-5 ui-sortable">
                    <input type="radio" name="status" value="待审核" checked="checked"/>：待审核
                    <input type="radio" name="status" value="审核通过"/>：审核通过
                </div>
            </div>

            <div class="button-type-box">
                <button id="submitSave" onclick="onSubmit('${ctx}/${adminPath}/background/user/add','${ctx}/${adminPath}/background/user/query','新增');" class="btn btn-danger m-r-5 m-b-5">提 交</button>
            </div>

        </form>

    </div>
</div>


<script type="application/javascript">

    $(document).ready(function () {
        $('#formId').bootstrapValidator({
            message: '请输入正确信息',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            verbose: false,
            excluded: [':disabled'],
            fields: {
                userName: {
                    validators: {
                        stringLength: {max: 20},
                        notEmpty: {}
                    }
                },
                userPassword: {
                    validators: {
                        stringLength: {max: 20},
                        notEmpty: {}
                    }
                },
                userNickname: {
                    validators: {
                        stringLength: {max: 20},
                        notEmpty: {}
                    }
                },
                userRealname: {
                    validators: {
                        stringLength: {max: 20},
                        notEmpty: {}
                    }
                }
            }
        });
    });


</script>


</body>
</html>
