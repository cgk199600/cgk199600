layui.use(['form','layer','jquery'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer
        $ = layui.jquery;

    $(".loginBody .seraph").click(function(){
        layer.msg("这只是做个样式，至于功能，你见过哪个后台能这样登录的？还是老老实实的找管理员去注册吧",{
            time:5000
        });
    })
    $("#img").click(function(){//点击验证码图片换//每次传入不同的连接刷新验证码
    	$("#img").attr("src","/ssm/code.do?v="+Math.random());
    })

    //登录按钮
    form.on("submit(login)",function(data){
        $(this).text("登录中...").attr("disabled","disabled").addClass("layui-disabled");
        $.ajax({
        	type:"post",
        	url:"/ssm/login.do",
        	data:{"username":$("#username").val(),"password":hex_md5($("#password").val()),"code":$("#code").val()},
        	dataType:"json",
        	success:function(data){
        	if(data.code==0){
        	setTimeout(function(){
                window.location.href = "/ssm/layuicms/index.jsp";
            },1000);
        }else{
        	$("button").text("登录中...").removeAttr("disabled","disabled").removeClass("layui-disabled");
        	layer.msg(data.msg,{
        		time:1500
        	})  
        	/*
        	 * Ajax中的success:function是在当所有的ajax中其他方法都执行完了，success才单独执行
Ajax不管执行成功不举续往下执行，asnc:false是设置异步请求设置success同步执行
在success后获取button标签设置样式，不能用this应为是单独运行，不在ajax中获取不到this的对象
        	 */
        	
        }
        }
        })
        
        return false;
    })

    //表单输入效果
    $(".loginBody .input-item").click(function(e){
        e.stopPropagation();
        $(this).addClass("layui-input-focus").find(".layui-input").focus();
    })
    $(".loginBody .layui-form-item .layui-input").focus(function(){
        $(this).parent().addClass("layui-input-focus");
    })
    $(".loginBody .layui-form-item .layui-input").blur(function(){
        $(this).parent().removeClass("layui-input-focus");
        if($(this).val() != ''){
            $(this).parent().addClass("layui-input-active");
        }else{
            $(this).parent().removeClass("layui-input-active");
        }
    })
})
