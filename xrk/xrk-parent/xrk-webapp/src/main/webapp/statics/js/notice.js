function msgCenter(title,msg,mil){
    var d = dialog({
        content: msg,
        title:title,
        fixed: true
    });
    d.show();
    if(mil!=null){
        setTimeout(function () {
            d.close().remove();
        }, mil);
    }
}
//确认弹窗(模式)
function confirm(content,url){
    var d = dialog({
        title: '提示',
        content: content,
        okValue:'确定',
        cancelValue:'取消',
        ok: function () {window.location.href=url;},
        cancel:function(){},
        width:'20em'
    });
    d.showModal();
}

function multiDel(tip,url){
    if($('input[name="ids"]:checked').length<1){
        var d = dialog({
            id: 'delDialog',
            align: 'bottom left',
            quickClose: true,
            content: '请选中需要删除的'+tip
        });
        d.show(document.getElementById('multiDel'));
        return;
    }else{
        var ids="";
        var len=$('input[name="ids"]:checked').length;
        $('input[name="ids"]:checked').each(function(i){
            if(i!=(len-1)){
                ids+=$(this).val()+",";
            }else{
                ids+=$(this).val();
            }
        });
        confirm('共'+$('input[name="ids"]:checked').length+'条,确定删除选中的'+tip+'?',url+"?ids="+ids);
    }
}
function loading(){
    var d = dialog({
        onclose: function () {
        },
        height:80,
        okValue:"",
        ok: null
    });
    d.show();
    return d;
}