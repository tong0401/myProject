<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<%@include file="../../common/common-css.jsp"%>
<%@include file="../../common/common-js.jsp"%>

<script type="text/javascript">
	$(document).ready(
	
	});
</script>

</head>

<body>
	<div style="height: 100%; overflow-y: auto;">
		<br /> <br />

		<form action="${ctx }/background/productstock/update.html"
			class="form-horizontal" role="form" method="post">
			
			<input type="hidden" name="id" value="${webProductStock.id }"/>
			
			<div class="form-group">
				<label class="col-sm-2 control-label" for="inputEmail">名称</label>
				<div class="col-sm-4">
					<input name="name" class="form-control" class="form-control"
						placeholder="*" required value="${webProductStock.name}" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="inputEmail">规格</label>
				<div class="col-sm-4">
					<input name="spec" class="form-control" class="form-control"
						placeholder="*" required value="${webProductStock.spec}" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="inputEmail">数量</label>
				<div class="col-sm-4">
					<input name="number" class="form-control" class="form-control"
						placeholder="*" required value="${webProductStock.number}" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="inputEmail">价格</label>
				<div class="col-sm-4">
					<input name="price" class="form-control" class="form-control"
						placeholder="*" required value="${webProductStock.price}" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label"></label>
				<div class="col-sm-4">
					<button type="submit" class="btn btn-success">提交</button>
					<button type="button" class="btn"
						onclick="javascript:window.location.href='javascript:history.go(-1)'">返回</button>
				</div>
			</div>

			<!-- 存放图片路径隐藏域 -->
			<div name="add_html"></div>
			<!-- 存放图片路径隐藏域 -->

			<!-- 需要删除的图片 -->
			<input type="hidden" name="deleteImg" />
			<!-- 需要删除的图片 -->

		</form>

	</div>
</body>
</html>
