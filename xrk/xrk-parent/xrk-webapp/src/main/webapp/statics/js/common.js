function serviceOrder(entrance){
	$(".order_mask").show();
	$(".service_order_box").show();
    order_box_entrance = entrance;
}
function closeOrder(){
	//$(".order_mask").hide();
	$(".service_order_box").hide();
	$(".order_warn").text("");
}



$(function() {
	
	//绑定鼠标滚动条事件  
	$(window).bind("scroll", function() {
		var sTop = $(window).scrollTop();
		var sTop = parseInt(sTop);
		if (sTop >= 130) {
			if (!$(".sidetop").is(":visible")) {
				try {
					$(".sidetop").slideDown();
				} catch (e) {
					$(".sidetop").show();
				}
			}
		} else {
			if ($(".sidetop").is(":visible")) {
				try {
					$(".sidetop").slideUp();
				} catch (e) {
					$(".sidetop").hide();
				}
			}
		}
	});
	
	$(".side ul li").hover(function(){
		$(this).find(".sidebox").stop().animate({"width":"124px"},200).css({"opacity":"1","filter":"Alpha(opacity=100)","background":"#ae1c1c"})	
	},function(){
		$(this).find(".sidebox").stop().animate({"width":"54px"},200).css({"opacity":"0.8","filter":"Alpha(opacity=80)","background":"#000"})	
	});
	
});

//页面返回顶部
function goTop(){
	$('html,body').animate({'scrollTop':0},600);
}

//项目根目录
function getRootPath_web() {
    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
    var curWwwPath = window.document.location.href;
    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
    var pathName = window.document.location.pathname;
    var pos = curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8083
    var localhostPaht = curWwwPath.substring(0, pos);
    //获取带"/"的项目名，如：/uimcardprj
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
    return (localhostPaht + projectName);
}


//打开提示框
function tips(text){
	$("#open_tip").slideToggle(300);//300 为展开显示时间
	$("#overlaytip").slideToggle(300);//300 为展开显示时间
	$("[name='tip_text']").text(text);
	return false;
}


function toLoadPage(url) {
	$("#centerTab").load(url, function () {
	});
}

function checkClick(url, backUrl, tip) {
	var d = dialog({
		title: '提示',
		content: "确认"+ tip+"？",
		okValue: '确定',
		cancelValue: '取消',
		ok: function () {
			onSubmit(url, backUrl, tip);
		},
		cancel: function () {
		},
		width: '20em'
	});
	d.showModal();
}

function onSubmit(url, backUrl, tip) {
	$.ajax({
		url: url,
		type: "POST",
		data: $("#formId").serialize(),
		dataType: "json",
		cache: false,
		success: function (message) {
			if (message.msg == "success") {
				msgCenter("提示", tip + "成功", 3000);
				$("#centerTab").load(backUrl, function () {
				});
			} else {
				msgCenter("提示", tip + "失败,请重试!", 3000);
			}
		},
		error: function (response) {
			msgCenter("提示", tip + "失败,请重试!", 3000);
		}
	});
	return false;
}



