/**
 * Author: tong
 * 图片上传JS
 */


$(document).ready(function(){
	
});


/**
 * 递增图片上传	从0开始 递增1
 */
var imgItemMap = {};
var upImgItemArray=function(filePicker){
	var fileTypeItem=imgItemMap[filePicker];
	var length = $("[name='add_html']").find("[filepicker='"+filePicker+"']").length;
	if(fileTypeItem == undefined || fileTypeItem == ""){
		if(fileTypeItem==0){
			imgItemMap[filePicker]=parseInt(fileTypeItem)+parseInt(1);
		}else{
			imgItemMap[filePicker]=0;
		}
	}else{
		imgItemMap[filePicker]=parseInt(fileTypeItem)+parseInt(1);
	}
	return imgItemMap;
}

/**
 * 当前图片已经上传到第几张
 */
var upImgItem=function(filePicker){
	var fileTypeItem=imgItemMap[filePicker];
	if(fileTypeItem == undefined||fileTypeItem == ""){
		fileTypeItem=0;
	}
	var length = $("[name='add_html']").find("[filepicker='"+filePicker+"']").length;
	if(length<=0) {
		fileTypeItem=0;
	}else {
		fileTypeItem=parseInt(fileTypeItem)+parseInt(1);
	}
	return fileTypeItem;
}

/**
 * 递减图片上传 递减1
 */
var downImgItemArray=function(filePicker){
	var fileTypeItem=imgItemMap[filePicker];
	if(fileTypeItem== undefined||fileTypeItem == ""){
		imgItemMap[filePicker]=0;
	}else{
		var item = parseInt(fileTypeItem)-parseInt(1);
		if(item < 0) {
			item = 0;
			imgItemMap[filePicker]="";
		}
		imgItemMap[filePicker]=item;
	}
	var length = $("[name='add_html']").find("[filepicker='"+filePicker+"']").length;
	if(length==0) {
		imgItemMap[filePicker]="";
	}
	return imgItemMap;
}



/**
 * 图片显示
 */
function showImg(imgJson,fileList_id,nameList,filePicker){
	var allAddCoverImgHTML="";
	var allAddCoverHTML="";
	imgJson=eval('('+imgJson+')');

	for(var i=0,l=imgJson.length;i<l;i++){
		
		var addImgHTML="<div id='WU_FILE_"+imgJson[i]["item"]+"' class='file-item thumbnail cp_img upload-state-done'>";
	   	addImgHTML+="<img src='"+imgJson[i]["url"]+"'>";
	   	addImgHTML+="<div class='info'>"+imgJson[i]["title"]+"</div>";
	   	addImgHTML+="</div>";
	   	allAddCoverImgHTML+=addImgHTML;
	}
	$("#"+fileList_id).append(allAddCoverImgHTML);
}

/**
 * 初始化Web Uploader
 * @param filePicker 图片选择按钮
 */
var initUploader=function(filePicker){
	// 初始化Web Uploader
	var uploader = WebUploader.create({
	    // 选完文件后，是否自动上传。
	    auto: true,
	    // swf文件路径
	    swf: '/ueditor/third-party/webuploader/Uploader.swf',
	    // 文件接收服务端。
	    server: getRootPath_web()+'/background/utils/upload.html',
	    // 选择文件的按钮。可选。
	    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
	    pick: '#'+filePicker,
	    // 只允许选择图片文件。
	    accept: {
	        title: 'Images',
	        extensions: 'gif,jpg,jpeg,bmp,png',
	        mimeTypes: 'image/*'
	    }
	});
	return uploader;
}

/**
 * 图片上传 初始化
 * @param fileList 图片显示位置
 * @param filePicker 图片选择按钮
 */
function uploadImg(fileList,filePicker,content,input_name){
	//图片上传
	var $ = jQuery,
    $list = $('#'+fileList),
    // 优化retina, 在retina下这个值是2
    ratio = window.devicePixelRatio || 1,
    // 缩略图大小
    thumbnailWidth = 100 * ratio,
    thumbnailHeight = 100 * ratio,
    // Web Uploader实例
    uploader;
	// 初始化Web Uploader
	uploader = initUploader(filePicker);
	// 当有文件添加进来的时候
	uploader.on( 'fileQueued', function( file) {

		//图片上传到第几张
		var img_item=upImgItem(filePicker);
		
		var file_sum = 0;
		$("[name='add_html']").find("input[filepicker='"+filePicker+"']").each(function(){
			var file_name = $(this).attr("file_name");
			if(file_name==file.name) {
				file_sum = parseInt(file_sum) + parseInt(1);
			}
		});
		if(file_sum > 0) {
			tips("请勿上传相同的图片!");
			return;
		}
		
	    var $li = $(
	            '<div id="' + file.id + '" class="file-item thumbnail cp_img">' +
	            	'<span filePicker="'+filePicker+'" class="file_del cp_img_del" name="delete_file" file_name="'+file.name+'" title="删除" item="'+img_item+'"></span>' +
	                '<img>' +
	                '<div name="add_textarea"></div>' +
	            '</div>'
	            ),
	        $img = $li.find('img');
	    // $list为容器jQuery实例
	    $list.append( $li );
	    // 创建缩略图
	    // 如果为非图片文件，可以不用调用此方法。
	    // thumbnailWidth x thumbnailHeight 为 100 x 100
	    uploader.makeThumb( file, function( error, src ) {
	        if ( error ) {
	            $img.replaceWith('<span>不能预览</span>');
	            return;
	        }
	        $img.attr( 'src', src );
	    }, thumbnailWidth, thumbnailHeight );
	});
	// 文件上传过程中创建进度条实时显示。
	uploader.on( 'uploadProgress', function( file, percentage ) {
	    var $li = $( '#'+file.id ),
	        $percent = $li.find('.progress span');
	    // 避免重复创建
	    if ( !$percent.length ) {
	        $percent = $('<p class="progress"><span></span></p>')
	                .appendTo( $li )
	                .find('span');
	    }
	    $percent.css( 'width', percentage * 100 + '%' );
	});
	// 文件上传成功，给item添加成功class, 用样式标记上传成功。
	uploader.on( 'uploadSuccess', function( file,data) {
		uploadImgresponseText(data,filePicker,content,input_name);//图片上传返回值 生成存放 路径值 元素
	    $( '#'+file.id ).addClass('upload-state-done');
	});
	// 文件上传失败，显示上传出错。
	uploader.on( 'uploadError', function( file ) {
	    var $li = $( '#'+file.id ),
	        $error = $li.find('div.error');
	    // 避免重复创建
	    if ( !$error.length ) {
	        $error = $('<div class="error"></div>').appendTo( $li );
	    }
	    $error.text('上传失败');
	});
	// 完成上传完了，成功或者失败，先删除进度条。
	uploader.on( 'uploadComplete', function( file ) {
	    $( '#'+file.id ).find('.progress').remove();
	});
	//执行删除方法
	$list.on("click", "[name='delete_file']", function () {
		var id = $(this).parent().attr("id");
		uploader.removeFile(uploader.getFile(id,true));
		$(this).parent().remove();
		deleteImgItem(this);
	});
	//执行删除方法
	$list.on("click", "[name='del_file']", function () {
		var id = $(this).parent().attr("id");
		$(this).parent().remove();
		deleteImgItem(this);
	});
	
	//图片上传
	
}

/**
 * 文件上传
 */
function uploadFile(){
	//文件上传
	var $ = jQuery,
    $list = $('#thelist'),
    // 优化retina, 在retina下这个值是2
    ratio = window.devicePixelRatio || 1,
    // 缩略图大小
    thumbnailWidth = 100 * ratio,
    thumbnailHeight = 100 * ratio,
    // Web Uploader实例
    uploader;
	// 初始化Web Uploader
	var uploader = WebUploader.create({

	    // swf文件路径
	    swf: '/ueditor/third-party/webuploader/Uploader.swf',

	    // 文件接收服务端。
	    server: getRootPath_web()+'/background/utils/upload.html',

	    // 选择文件的按钮。可选。
	    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
	    pick: '#picker',

	    // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
	    resize: false
	});
	// 当有文件被添加进队列的时候
	uploader.on( 'fileQueued', function( file ) {
	    $list.append( '<div id="' + file.id + '" class="item">' +
	        '<h4 class="info">' + file.name + '</h4>' +
	        '<p class="state">等待上传...</p>' +
	    '</div>' );
	});
	
	// 文件上传过程中创建进度条实时显示。
	uploader.on( 'uploadProgress', function( file, percentage ) {
	    var $li = $( '#'+file.id ),
	        $percent = $li.find('.progress .progress-bar');

	    // 避免重复创建
	    if ( !$percent.length ) {
	        $percent = $('<div class="progress progress-striped active">' +
	          '<div class="progress-bar" role="progressbar" style="width: 0%">' +
	          '</div>' +
	        '</div>').appendTo( $li ).find('.progress-bar');
	    }

	    $li.find('p.state').text('上传中');

	    $percent.css( 'width', percentage * 100 + '%' );
	});
	
	uploader.on( 'uploadSuccess', function( file ) {
	    $( '#'+file.id ).find('p.state').text('已上传');
	});

	uploader.on( 'uploadError', function( file ) {
	    $( '#'+file.id ).find('p.state').text('上传出错');
	});

	uploader.on( 'uploadComplete', function( file ) {
	    $( '#'+file.id ).find('.progress').fadeOut();
	});
	
	//文件上传
}

/**
 * 移除图片
 * @param add_html 存放添加图片存放动态生成的input元素
 * @param file_name 图片原名称
 */
function deleteImgItem(obj){
	var file_name=$(obj).attr("file_name");//图片名称
	var img_src=$(obj).next("img").attr("src");//图片路径
	var del_item=$(obj).attr("item");//图片顺序号
	//记录需要删除的图片路径
	var deleteImg=$("[name='deleteImg']").val();
	var all_deleteImg="";
	if(deleteImg==null || deleteImg==""){
		all_deleteImg=img_src;
	}else{
		all_deleteImg=deleteImg+","+img_src;
	}
	$("[name='deleteImg']").val(all_deleteImg);
	//记录需要删除的图片路径
	var filePicker = $(obj).attr("filePicker");
	
	$("[name='add_html']").find("input").each(function () {
		var file_name_1=$(this).attr("file_name");//图片名称
		var item=$(this).attr("item");//图片顺序号
		var img_type=$(this).attr("img_type");//图片顺序号
		var input_type=$(this).attr("input_type");//图片顺序号
		if(item > del_item) {
			var item_value = parseInt(item)-parseInt(1);
			if(item_value<0) {
				item_value = 0;
			}
			if(input_type=="item") {
				$(this).attr("value",item_value);
				
				$("[name='delete_file'],[name='del_file']").each(function () {
					var file_name_2 = $(this).attr("file_name");
					if(file_name_1==file_name_2) {
						$(this).attr("item",item_value);
						$(this).parent().find("[textarea_type='title']").attr("name",img_type+"["+item_value+"].title");
						$(this).parent().find("[textarea_type='content']").attr("name",img_type+"["+item_value+"].content");
					}
				});
				
			}
			$(this).attr("item",item_value);
			$(this).attr("name",img_type+"["+item_value+"]."+input_type);
		}
		if(file_name_1==file_name){
			$(this).remove();
		}
	});
	
	var imgItemMap=downImgItemArray(filePicker);
	
}

/**
 * 图片上传返回值 生成存放 路径值 元素
 * @param responseText 返回值
 * @param filePicker 图片选择按钮
 * @param content 是否需要图片文字描述
 * @param input_name 隐藏域名称
 */
var uploadImgresponseText=function(responseText,filePicker,content,input_name){
	var file_url=responseText.result.file_url;
	var file_name=responseText.result.file_name;
	
	//图片上传到第几张
	var img_item=0;
	var imgItemMap=upImgItemArray(filePicker);
	for(key in imgItemMap){
		if(filePicker==key){
			img_item=imgItemMap[key];
		}
	}
	//图片上传到第几张
	
	var add_name=input_name+'['+img_item+']';
	var add_html='<input type="hidden" filePicker="'+filePicker+'" img_type="'+input_name+'" input_type="url" name="'+add_name+'.url" file_name="'+file_name+'" value="'+file_url+'" item="'+img_item+'"/>';
	add_html+='<input type="hidden" filePicker="'+filePicker+'" img_type="'+input_name+'" input_type="item" name="'+add_name+'.item" file_name="'+file_name+'" value="'+img_item+'" item="'+img_item+'"/>';
	add_html+='<input type="hidden" filePicker="'+filePicker+'" img_type="'+input_name+'" input_type="fileName" name="'+add_name+'.fileName" file_name="'+file_name+'" value="'+file_name+'" item="'+img_item+'"/>';
	img_item++;
	$("[name='add_html']").append(add_html);
	if(content=="content-yes"){//是否需要图片文字描述
		$("[name='delete_file']").each(function(){
			var file_name1=$(this).attr("file_name");
			if(file_name==file_name1){
				$(this).parent().find("[name='add_textarea']").append('<div>标题：<textarea name="'+add_name+'.title" textarea_type="title"></textarea></div><div>描述：<textarea name="'+add_name+'.content" textarea_type="content"></textarea></div>');
			}
		});
	}
	return "";
}

/**
 * 修改数据 回显图片（无图片内容）
 */
function updateShowImg(imgJson,fileList_id,nameList,filePicker){
	var allAddCoverImgHTML="";
	var allAddCoverHTML="";
	imgJson=eval('('+imgJson+')');

	for(var i=0,l=imgJson.length;i<l;i++){
		
		imgItemMap=upImgItemArray(filePicker);
		
		var addImgHTML="<div id='WU_FILE_"+imgJson[i]["item"]+"' class='file-item thumbnail cp_img upload-state-done'>";
	   	addImgHTML+="<span filePicker='"+filePicker+"' class='file_del cp_img_del' name='del_file' file_name='"+imgJson[i]["fileName"]+"' item='"+imgJson[i]["item"]+"' title='删除'></span><img src='"+imgJson[i]["url"]+"'>";
	   	addImgHTML+="<div class='info'>"+imgJson[i]["title"]+"</div>";
	   	addImgHTML+="<div name='add_textarea'></div>";
	   	addImgHTML+="</div>";
	   	allAddCoverImgHTML+=addImgHTML;
	   	for(var key in imgJson[i]){
	       if(key=="url"){
	    	   var addUrlHTML='<input type="hidden" filePicker="'+filePicker+'" img_type="'+nameList+'" input_type="url" name="'+nameList+'['+imgJson[i]["item"]+'].url" file_name="'+imgJson[i]["fileName"]+'" value="'+imgJson[i][key]+'" item="'+imgJson[i]["item"]+'"/>';
	    	   allAddCoverHTML+=addUrlHTML;
	       }else if(key=="item"){
	    	   var addItemHTML='<input type="hidden" filePicker="'+filePicker+'" img_type="'+nameList+'" input_type="item" name="'+nameList+'['+imgJson[i]["item"]+'].item" file_name="'+imgJson[i]["fileName"]+'" value="'+imgJson[i][key]+'" item="'+imgJson[i]["item"]+'"/>';
	    	   allAddCoverHTML+=addItemHTML;
	       }else if(key=="fileName"){
	    	   var addFileNameHTML='<input type="hidden" filePicker="'+filePicker+'" img_type="'+nameList+'" input_type="fileName" name="'+nameList+'['+imgJson[i]["item"]+'].fileName" file_name="'+imgJson[i]["fileName"]+'" value="'+imgJson[i][key]+'" item="'+imgJson[i]["item"]+'"/>';
	    	   allAddCoverHTML+=addFileNameHTML;
	       }
	   }
	}
	$("[name='add_html']").append(allAddCoverHTML);
	$("#"+fileList_id).append(allAddCoverImgHTML);
}


/**
 * 修改数据 回显图片（有图片内容）
 */
function updateShowImg_1(imgJson,fileList_id,nameList,filePicker){
	var allAddAlbumImgHTML="";
	var allAddAlbumHTML="";
	imgJson=eval('('+imgJson+')');
	for(var i=0,l=imgJson.length;i<l;i++){

		imgItemMap=upImgItemArray(filePicker);
		
		var addImgHTML="<div id='WU_FILE_"+imgJson[i]["item"]+"' class='file-item thumbnail cp_img upload-state-done'>";
		addImgHTML+="<span filePicker='"+filePicker+"' class='file_del cp_img_del' name='del_file' file_name='"+imgJson[i]["fileName"]+"' item='"+imgJson[i]["item"]+"' title='删除'></span><img src='"+imgJson[i]["url"]+"'>";
		addImgHTML+="<div name='add_textarea'><div>标题：<textarea name='"+nameList+"["+imgJson[i]["item"]+"].title' value='"+imgJson[i]["title"]+"' textarea_type='title'>"+imgJson[i]["title"]+"</textarea></div><div>描述：<textarea name='"+nameList+"["+imgJson[i]["item"]+"].content' value='"+imgJson[i]["content"]+"' textarea_type='content'>"+imgJson[i]["content"]+"</textarea></div></div>";
		addImgHTML+="</div>";
	   	allAddAlbumImgHTML+=addImgHTML;
	   	for(var key in imgJson[i]){
	       if(key=="url"){
	    	   var addUrlHTML='<input type="hidden" filePicker="'+filePicker+'" img_type="'+nameList+'" input_type="url" name="'+nameList+'['+imgJson[i]["item"]+'].url" file_name="'+imgJson[i]["fileName"]+'" value="'+imgJson[i][key]+'" item="'+imgJson[i]["item"]+'"/>';
	    	   allAddAlbumHTML+=addUrlHTML;
	       }else if(key=="item"){
	    	   var addItemHTML='<input type="hidden" filePicker="'+filePicker+'" img_type="'+nameList+'" input_type="item" name="'+nameList+'['+imgJson[i]["item"]+'].item" file_name="'+imgJson[i]["fileName"]+'" value="'+imgJson[i][key]+'" item="'+imgJson[i]["item"]+'"/>';
	    	   allAddAlbumHTML+=addItemHTML;
	       }else if(key=="fileName"){
	    	   var addFileNameHTML='<input type="hidden" filePicker="'+filePicker+'" img_type="'+nameList+'" input_type="fileName" name="'+nameList+'['+imgJson[i]["item"]+'].fileName" file_name="'+imgJson[i]["fileName"]+'" value="'+imgJson[i][key]+'" item="'+imgJson[i]["item"]+'"/>';
	    	   allAddAlbumHTML+=addFileNameHTML;
	       }
	   	}
	}
	$("[name='add_html']").append(allAddAlbumHTML);
	$("#"+fileList_id).append(allAddAlbumImgHTML);
}
