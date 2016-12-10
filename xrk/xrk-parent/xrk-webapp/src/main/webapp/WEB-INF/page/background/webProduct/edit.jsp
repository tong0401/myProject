<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../common/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<%@include file="../../common/common-css.jsp"%>
<%@include file="../../common/common-js.jsp"%>

<!-- web uploader 图片上传-->
<script type="text/javascript" charset="utf-8" src="${ctx }/statics/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="${ctx }/statics/ueditor/ueditor.all.min.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx }/statics/ueditor/third-party/webuploader/webuploader.css">
<script type="text/javascript" src="${ctx }/statics/ueditor/third-party/webuploader/webuploader.js"></script>
<script type="text/javascript" src="${ctx }/statics/js/uploadImg.js"></script>
<!-- web uploader 图片上传-->


<script type="text/javascript">
	$(document).ready(function() {
			
    	var coverJson = '${webProduct.cover}';//回显封面图片
    	if(coverJson!="" && coverJson!=null && coverJson!="null"){
    		updateShowImg(coverJson,"fileList-cover","coverList","filePicker-cover");
    	}
    	
    	//回显详情图片
    	var albumJson = '${webProduct.album}';
    	if(albumJson!="" && albumJson!=null && albumJson!="null"){
    		updateShowImg_1(albumJson,"fileList-album","albumList","filePicker-album");
    	}
    	//回显详情图片
    	
		//图片
		uploadImg("fileList-album", "filePicker-album", "content-yes", "albumList");//上传图片 初始化 /详情图片
		uploadImg("fileList-cover", "filePicker-cover", "content-no", "coverList");//上传图片 初始化 /封面图片
		//图片
		
	});

	function changeCameramanId(obj) {
		var c_text = $(obj).find("option:selected").text();
		$("[name='cameramanName']").val(c_text);
	}

	function changeClothingId(obj) {
		var c_text = $(obj).find("option:selected").text();
		$("[name='clothingName']").val(c_text);
	}

	function changeShootingPlaceId(obj) {
		var c_text = $(obj).find("option:selected").text();
		$("[name='shootingPlaceName']").val(c_text);
	}

	function changeProductStockId(obj) {
		var c_text = $(obj).find("option:selected").text();
		$("[name='productStockName']").val(c_text);
	}
	
</script>

</head>

<body>
	<div style="height: 100%; overflow-y: auto;">
		<br /> <br />

		<form action="${ctx }/background/product/update.html"
			class="form-horizontal" role="form" method="post">
			
			<input type="hidden" name="id" value="${webProduct.id }"/>
			
			<div class="form-group">
				<label class="col-sm-2 control-label" for="inputEmail">名称</label>
				<div class="col-sm-4">
					<input name="name" class="form-control" class="form-control"
						placeholder="*" required value="${webProduct.name}" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="inputEmail">价格</label>
				<div class="col-sm-4">
					<input name="price" class="form-control" class="form-control"
						placeholder="*" required value="${webProduct.price}" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="inputEmail">描述</label>
				<div class="col-sm-4">
					<input name="description" class="form-control" class="form-control"
						placeholder="*" required value="${webProduct.description}" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label" for="inputEmail">摄影师</label>
				<div class="col-sm-4">
					<select name="cameramanId" class="form-control" onchange="changeCameramanId(this)">
						<c:forEach var="cameramanItem" items="${webCameraman}"
							varStatus="st">
							<option value="${cameramanItem.id }" <c:if test="${cameramanItem.id==webProduct.cameramanId}">selected="true"</c:if>>${cameramanItem.name }</option>
						</c:forEach>
					</select>
					
					<c:forEach var="cameramanItem" items="${webCameraman}" varStatus="st">
						<c:if test="${cameramanItem.id==webProduct.cameramanId}">
							<input type="hidden" name="cameramanName" value="${cameramanItem.name }">
						</c:if>
					</c:forEach>
					
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label" for="inputEmail">服装</label>
				<div class="col-sm-4">
					<select name="clothingId" class="form-control" onchange="changeClothingId(this)">
						<c:forEach var="clothingItem" items="${webClothing}"
							varStatus="st">
							<option value="${clothingItem.id }" <c:if test="${clothingItem.id==webProduct.clothingId}">selected="true"</c:if>>${clothingItem.name }</option>
						</c:forEach>
					</select>

					<c:forEach var="clothingItem" items="${webClothing}" varStatus="st">
						<c:if test="${clothingItem.id==webProduct.clothingId}">
							<input type="hidden" name="clothingName"
								value="${clothingItem.name }">
						</c:if>
					</c:forEach>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label" for="inputEmail">拍摄地点</label>
				<div class="col-sm-4">
					<select name="shootingPlaceId" class="form-control" onchange="changeShootingPlaceId(this)">
						<c:forEach var="shootingPlaceItem" items="${webShootingPlace}"
							varStatus="st">
							<option value="${shootingPlaceItem.id }" <c:if test="${shootingPlaceItem.id==webProduct.shootingPlaceId}">selected="true"</c:if>>${shootingPlaceItem.name }</option>
						</c:forEach>
					</select>

					<c:forEach var="shootingPlaceItem" items="${webShootingPlace}"
						varStatus="st">
						<c:if test="${shootingPlaceItem.id==webProduct.shootingPlaceId}">
							<input type="hidden" name="shootingPlaceName"
								value="${shootingPlaceItem.name }">
						</c:if>
					</c:forEach>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label" for="inputEmail">包装材料</label>
				<div class="col-sm-4">
					<select name="productStockId" class="form-control" onchange="changeProductStockId(this)">
						<c:forEach var="productStockItem" items="${webProductStock}"
							varStatus="st">
							<option value="${productStockItem.id }" <c:if test="${productStockItem.id==webProduct.shootingPlaceId}">selected="true"</c:if>>${productStockItem.name }</option>
						</c:forEach>
					</select>

					<c:choose>
						<c:when test="${webProduct.productStockId==null or webProduct.productStockId=='' }">
							<c:if test="${st.index=='0'}">
								<input type="hidden" name="productStockName" value="${productStockItem.name }">
							</c:if>
						</c:when>
						<c:otherwise>
							<c:forEach var="productStockItem" items="${webProductStock}" varStatus="st">
								<c:if test="${productStockItem.id==webProduct.productStockId}">
									<input type="hidden" name="productStockName" value="${productStockItem.name }">
								</c:if>
							</c:forEach>
						</c:otherwise>
					</c:choose>
					
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label">封面图片</label>

				<!--图片上传-->
				<div class="col-sm-4">
					<div id="fileList-cover" class="uploader-list"></div>
					<div id="filePicker-cover">选择图片</div>
				</div>
				<!--图片上传-->

			</div>
			<div class="form-group" id="ALBUM">
				<label class="col-sm-2 control-label">图文相册</label>
				<!--图片上传-->
				<div class="col-sm-4 below">
					<div id="fileList-album" class="uploader-list"></div>
					<div id="filePicker-album">选择图片</div>
				</div>
				<!--图片上传-->
				
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
