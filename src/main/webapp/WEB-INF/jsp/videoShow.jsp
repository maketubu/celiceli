<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script
			src="<%=request.getContextPath()%>/static/Homepage/js/jquery.min.js"></script>

	<link rel="stylesheet"
		  href="<%=request.getContextPath()%>/static/Homepage/videoPlay/css/fz-video.css">
	<link rel="stylesheet"
		  href="<%=request.getContextPath()%>/static/Homepage/videoPlay/font/iconfont.css">
	<link rel="stylesheet"
		  href="<%=request.getContextPath()%>/static/Homepage/video/css/bootstrap.min.css">
	<link rel="stylesheet"
		  href="<%=request.getContextPath()%>/static/Homepage/video/css/dashboard.css">
	<link rel="stylesheet"
		  href="<%=request.getContextPath()%>/static/Homepage/video/css/fz-video.css">
	<link rel="stylesheet"
		  href="<%=request.getContextPath()%>/static/Homepage/video/css/popuo-box.css">
	<link rel="stylesheet"
		  href="<%=request.getContextPath()%>/static/Homepage/video/css/style.css">


	<style type="text/css">
		body{font:12px/180% Arial, Helvetica, sans-serif, "新宋体";background:#121212;}

		/* slider */
		.wp{position:relative;width:100%;height:600px;overflow:hidden;margin:20px auto;border:1px solid #121212;background:#fff;}

		.slider{position:absolute;width:760px;padding:0 20px;left:0;top:0;}
		.fl{float:left}
		.slider img{display:block;padding:2px;border:1px solid #ccc}
		.slider li{padding:20px 0;border-bottom:1px dashed #ccc;overflow:hidden;width:100%}
		.slider p{font-size:12px;margin:0;padding-left:68px;color:#333;line-height:20px;}
	</style>

	<style>
		body, div, dl, dt, dd, ul, ol, li, h1, h2, h3, h4, h5, h6, pre, code,
		form, fieldset, legend, input, button, textarea, p, blockquote, th, td
		{
			margin: 0;
			padding: 0;
		}

		body {
			background: #fff;
			color: #555;
			font-size: 14px;
			font-family: Verdana, Arial, Helvetica, sans-serif;
		}

		td, th, caption {
			font-size: 14px;
		}

		h1, h2, h3, h4, h5, h6 {
			font-weight: normal;
			font-size: 100%;
		}

		address, caption, cite, code, dfn, em, strong, th, var {
			font-style: normal;
			font-weight: normal;
		}

		a {
			color: #555;
			text-decoration: none;
		}

		a:hover {
			text-decoration: underline;
		}

		img {
			border: none;
		}

		ol, ul, li {
			list-style: none;
		}

		input, textarea, select, button {
			font: 14px Verdana, Helvetica, Arial, sans-serif;
		}

		table {
			border-collapse: collapse;
		}

		html {
			overflow-y: scroll;
		}

		.clearfix:after {
			content: ".";
			display: block;
			height: 0;
			clear: both;
			visibility: hidden;
		}

		.clearfix {
			*zoom: 1;
		}

		/*body{ font-family: "微软雅黑"; background-color: #292929; 	}*/
		#testBox {
			width: 80%;
			height: 537px;
			margin: 0 auto;
		}
	</style>

	<title>cilicili-视频区</title>
</head>
<body>
<div style="width: 100%;height: 40px;" >
	<div style="background-color: #6C89B2;">
		<div style="margin-left: 90%;">
			<%if (request.getSession().getAttribute("userName") == null) {%>
			<button class="btn btn-primary ladda-button" data-style="expand-left" id="login">
				<span class="ladda-label"><a href="/login.action" style="font-size: 10px; color: white; text-decoration: none" >登录</a></span>
			</button>
			<button class="btn btn-primary ladda-button" data-style="expand-left" id="zhuce">
				<span class="ladda-label"><a href="/register.action" style="font-size: 10px; color: white; text-decoration: none" >注册</a></span>
			</button>
			<%} else {%>
			<button class="btn btn-primary ladda-button" data-style="expand-left" id="userxinxi">
			<span class="ladda-label"><a href="/userInformation.action" style="font-size: 10px; color: white; text-decoration: none">
				欢迎你的登录:
				<span style="color: red"><%=request.getSession().getAttribute("userName")%></span>
			</a>
			</span>
			</button>
			<%
				}
			%>
		</div>
		<script type="text/javascript">
            $(document).ready(function(){
                $("#userxinxi").click(function(){
                    location.href="userInformation.action";

                });
                $("#login").click(function(){
                    location.href="login.action";
                });
                $("#zhuce").click(function(){
                    location.href="register.action";
                });
            });
		</script>
	</div>
</div>
<%--  容器区  展示视频--%>
<div id="testBox"></div>
<%--<script src="<%=request.getContextPath()%>/static/Homepage/videoPlay/js/fz-video.js"></script>--%>
<%--<script>--%>
<%--var FZ_VIDEO = new createVideo("testBox", //容器的id--%>
<%--{--%>
<%--url : '<%=request.getAttribute("videoAddr")%>', //视频地址--%>
<%--autoplay : true--%>
<%--//是否自动播放--%>
<%--});--%>
<%--</script>--%>


<div class="text-center ctr" >
	<br>

	<button type="button"  onclick="resumer() ">弹幕开始/继续</button>&nbsp;&nbsp;&nbsp;&nbsp;
	<button type="button"  onclick="pauser()">弹幕暂停</button>  &nbsp;&nbsp;&nbsp;&nbsp;
	显示弹幕:<input type='checkbox' checked='checked' id='ishide' value='is' onchange='changehide()'> &nbsp;&nbsp;&nbsp;&nbsp;
	弹幕透明度:
	<input type="range" name="op" id="op" onchange="op()" value="100"> <br>

	<p><button id="dianzan" class="btn btn-success"
			   onclick="dj()"
			   <%

		Integer praiseRecord=(Integer) request.getSession().getAttribute("praiseRecord");
		if (praiseRecord == 1) {

	%>style="background-color: rgb(79,204,66)">

		<%} else { %>
		style="background-color: rgba(139,181,146,0.22)">
		<% } %>点赞（<%=request.getSession().getAttribute("praiseNum")%>）</button>
	</p>

	当前弹幕运行时间(分秒)：<span id="time"></span>&nbsp;&nbsp;
	设置当前弹幕时间(分秒)： <input type="text" id="set_time" max=20 />
	<button type="button"  onclick="settime()">设置</button>

	<br>



	发弹幕:
	<select  name="color" id="color" >
		<option value="white">白色</option>
		<option value="red">红色</option>
		<option value="green">绿色</option>
		<option value="blue">蓝色</option>
		<option value="yellow">黄色</option>
	</select>
	<select name="size" id="text_size" >
		<option value="1">大文字</option>
		<option value="0">小文字</option>
	</select>
	<select name="position" id="position"   >
		<option value="0">滚动</option>
		<option value="1">顶端</option>
		<option value="2">底端</option>
	</select>
	<input type="textarea" id="danmutext" max=300 />
	<button type="button"  onclick="send()">发送</button>
</div><br>

<!-- 评论区 -->
<div class="all-comments" >
	<div class="all-comments-info">
		<!-- 这里是自定义的js -->
		<script src="<%=request.getContextPath()%>/static/adminjs/videojs.js"></script>
		<div class="box">
			<!-- <form action="messageuser.sf" method="post"> -->
			<!-- 					<input
                                    type="text" placeholder="标题" required="" name="message"> -->
			<input type="text" id="shipingID" style="display: none" name="shipingID" value="<%=request.getAttribute("videoID")%>">
			<textarea  placeholder="请输入留言内容---------内容不超过150字" id="message" required="" name="message" ></textarea>
			<input type="button" id="button" value="发表">
			<div class="clearfix"></div>
			<!-- </form> -->
		</div>
		<!--<div class="all-comments-buttons">
                            <ul>
                                <li><a href="#" class="top">Top Comments</a></li>
                                <li><a href="#" class="top newest">Newest First</a></li>
                                <li><a href="#" class="top my-comment">My Comments</a></li>
                            </ul>
                        </div>-->
	</div>

	<script type="text/javascript">
        <%--  ???   --%>
        function H$(i){
            return document.getElementById(i)
        }
        function H$$(c, p){
            return p.getElementsByTagName(c)
        }

        var slider = function(){
            function init(o){
                this.id = o.id;
                this.at = o.auto ? o.auto : 3;
                this.o = 0;
                this.pos();
            }
            init.prototype = {
                pos : function(){
                    clearInterval(this.__b);
                    this.o = 0;
                    var el = H$(this.id), li = H$$('li', el), l = li.length;
                    var _t = li[l-1].offsetHeight;
                    var cl = li[l-1].cloneNode(true);
                    cl.style.opacity = 0; cl.style.filter = 'alpha(opacity=0)';
                    el.insertBefore(cl, el.firstChild);
                    el.style.top = -_t + 'px';
                    this.anim();
                },
                anim : function(){
                    var _this = this;
                    this.__a = setInterval(function(){_this.animH()}, 20);
                },
                animH : function(){
                    var _t = parseInt(H$(this.id).style.top), _this = this;
                    if(_t >= -1){
                        clearInterval(this.__a);
                        H$(this.id).style.top = 0;
                        var list = H$$('li',H$(this.id));
                        H$(this.id).removeChild(list[list.length-1]);
                        this.__c = setInterval(function(){_this.animO()}, 20);
                        //this.auto();
                    }else {
                        var __t = Math.abs(_t) - Math.ceil(Math.abs(_t)*.07);
                        H$(this.id).style.top = -__t + 'px';
                    }
                },
                animO : function(){
                    this.o += 2;
                    if(this.o == 100){
                        clearInterval(this.__c);
                        H$$('li',H$(this.id))[0].style.opacity = 1;
                        H$$('li',H$(this.id))[0].style.filter = 'alpha(opacity=100)';
                        this.auto();
                    }else{
                        H$$('li',H$(this.id))[0].style.opacity = this.o/100;
                        H$$('li',H$(this.id))[0].style.filter = 'alpha(opacity='+this.o+')';
                    }
                },
                auto : function(){
                    var _this = this;
                    this.__b = setInterval(function(){_this.pos()}, this.at*1000);
                }
            }
            return init;
        }();
	</script>
	<script type="text/javascript">
        /* $(document).ready(function(){
             //alert("测试");//打算在页面加载时 用ajax 根据用户名查询出用户的头像地址
            $.post("userHand",function(test){
                var ht=eval("("+test+")");
                 $.each(ht,function(index,m){

                       });
                     //alert(html);
                 $("#userHand").html(html);
        });
        });  */
	</script>
	<div align="center">
		<button type="button" id="buttonhide">动态留言板</button>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<button type="button" id="buttonhide2">静态留言板</button></div>
	<div class="wp"  style="background-color: #E8E8E8" id="danmu">
		<ul id="slider" class="slider">
			<c:forEach items="${messageList}" var="messagelist">
				<li>
					<a class="fl" href=""><img src="<%=request.getContextPath()%>${messagelist.messageHeadPic}" alt="" width="70px";height="70px" /></a>
					<p>${messagelist.messageContent}</p>
					<br>
					<p style="color: red;">留言者:<a href="" style="color: darkgoldenrod;text-decoration:none;">&nbsp;${messagelist.messageUserName}</a><span style="color: blue;">&nbsp;&nbsp;&nbsp;留言时间:${messagelist.messageTime}</span></p>
				</li>
			</c:forEach>
		</ul>
	</div>

	<script type="text/javascript">
        /* $("#buttonhide").click(function(){
            $("#buttonhide").html("不行 不行! 还是动的弹幕好看!");
            $("#danmu").hide();
        }); */
        $(document).ready(function(){
            $("#danmu").hide();
            $("#texthide").hide();
            $("#buttonhide").click(function(){
                $("#danmu").show();
                $("#texthide").hide();
            });

            $("#buttonhide2").click(function(){
                $("#danmu").hide();
                $("#texthide").show();

            });

            $("#huifu").click(function(){
                //alert("回复未实现!");
                //这里点击之后弹出一个div
                $("#woyaochakan").show();

            });


        });



	</script>
	<style type="text/css">
		*{
			margin:0;padding:0;
			-webkit-touch-callout: none; /* prevent callout to copy image, etc when tap to hold */
			-webkit-text-size-adjust: none; /* prevent webkit from resizing text to fit */
			-webkit-tap-highlight-color: rgba(210,210,210,0.35); /* make transparent link selection, adjust last value opacity 0 to 1.0 */
			-webkit-user-select: none; /* prevent copy paste, to allow, change 'none' to 'text' */
		}
		body{font-family:"微软雅黑";font-size:12px;}
		ul,li{list-style:none;}
		.ylcon{width:100%;min-width:320px;}
		.tit{height:26px;line-height:26px;padding:0px 15px;position:relative;font-size:15px;color:#aaa;border-bottom:1px solid rgba(0, 0, 0, 0.15);}

		.story{border-bottom:1px dashed #cecece;padding:0 15px 3px;position:relative;}
		.story_t{font-size:1.2em;color:rgba(0,0,0,1);padding-top:5px;padding-bottom:2px;}
		.story_m{color:rgba(110,110,110,1);line-height:21px;word-break:break-all;word-wrap:break-word;overflow:hidden;font-size:1.2em;padding:2px 0;}
		.story_time{color:rgba(154,154,154,1);padding:2px 0;}
		.story_hf{background:rgb(245,245,245);font-size:1.2em;border:1px solid rgba(204,204,204,0.2);border-radius:2px;color:rgba(110,110,110,1);padding:4px;margin-bottom:5px;}
		.opbtn{position:absolute;top: 0;right: 0;}
	</style>
	<div class="ylcon" id="texthide">
		<p class="tit">
			所有留言
		</p>
		<div id="messDivId">
			<c:forEach items="${messageList}" var="messagelist">
				<div class="story">
					<div class="opbtn"></div>
					<p class="story_t">${messagelist.messageUserName}<span style="margin-left: 85%;">
							<button type="button" value="查看留言" id="huifu">查看回复</button>   <button type="button" value="查看留言" id="liuyan">我要留言</button></span>
					</p>
					<p class="story_time">${messagelist.messageTime}</p>
					<!--<span style="margin-left: 90%;"><button type="button" value="查看留言">查看留言</button></span>-->
					<p class="story_m">${messagelist.messageContent}</p>
				</div>
				<div id="woyaochakan" style="display: none">这里可以查看</div>
			</c:forEach>
		</div>
		<div align="center" style="color: black">
			<button type="button" id="shou">首页</button>
			&nbsp;
			<button type="button" id="up">上一页</button>&nbsp;
			<button type="button" id="next">下一页</button>&nbsp;<button type="button" id="wei">尾页</button>
			&nbsp;
			<input type="text" id="text" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"
				   onblur="this.v();" style="width: 80px; height: 22px">
			</input> &nbsp;
			<button type="button" id="tiaozhuan">跳转</button>
		</div>

		<script type="text/javascript">
            new slider({id:'slider'})
		</script>


	</div>
</div>
</body>
<script src="<%=request.getContextPath()%>/static/Homepage/videoPlay/js/fz-video.js"></script>
<script>

    var FZ_VIDEO = new createVideo("testBox", //容器的id
        {
            url : '<%=request.getAttribute("videoAddr")%>', //视频地址
            autoplay : true
            //是否自动播放
        });
</script>
<!--
弹幕js代码:
jquery.danmu.js (//github.com/chiruom/danmu/) - Licensed under the MIT license
-->
<script src="static/barrage/js/jquery-1.11.1.min.js"></script>
<script src="static/barrage/js/bootstrap.js"></script>
<script src="static/barrage/js/headroom.min.js"></script>
<script src="static/barrage/js/jQuery.headroom.min.js"></script>
<script src="static/barrage/js/template.js"></script>
<script src="static/barrage/js/highlight/highlight.pack.js"></script>
<script src="static/barrage/js/jquery.danmu.js"></script>
<script>hljs.initHighlightingOnLoad();</script>

<script>



    var state=true;//false表示弹幕处于暂停
    //初始化弹幕函数
    (function(){


        $("#danmuss").danmu({
                // left:$("#danmussarea").offset().left,
                // top:$("#danmussarea").offset().top,
                // height: 445,
                //    width: 800,
                left:0,
                top:0,
                height:"100%",
                width:"100%",
                speed:30000,
                opacity:1,
                font_size_small:16,
                font_size_big:24,
                top_botton_danmu_time:6000
            }


        );
    })(jQuery);


    query();
    timedCount();
    setTimeout(function(){
        $('#danmuss').danmu('danmu_resume');
        var array = new Array();
        //console.info("info");
        <c:forEach items="${barragesList}" var="item" varStatus="status" >
        array.push("${item}");
        var temp = "${item}";
        //获得其下标
        <%--alert("${status.count}");--%>
        <%--//传递过来的是字符串，加引号--%>
        <%--alert("${item.color}");--%>
        <%--alert("${item.text}");--%>
        <%--//传递过来的是int类型，不需要加引号--%>
        <%--alert(${item.size});--%>
        var getBarrage = '{ "text":"${item.text}" , "color":"${item.color}" ,"size":"${item.size}","position":"${item.position}","time":${item.time}}';
        var barrageObj = eval('(' + getBarrage + ')');

        $('#danmuss').danmu("add_danmu", barrageObj);
        </c:forEach>
        <%--<c:forEach items="${barragesList }" var="barrages">--%>
        <%--alert(555)--%>
        <%--alert(${barrages.text})--%>
        <%--alert(barrages.time)--%>
        <%--var videoDanmu = '{ "text":barrages.text , "color":barrages.color ,"size":barrages.size,"position":barrages.position,"time": barrages.time }';--%>
        <%--var danmuObj = eval('(' + videoDanmu + ')');--%>

        <%--$('#danmuss').danmu("add_danmu", danmuObj);--%>
        <%----%>
        <%--</c:forEach>--%>
        <%--var barragesArry=new Array();--%>
        <%--<c:forEach items="${barragesList }" var="barrages">--%>
        <%--barragesArry.push("${barrages}");--%>
        <%--</c:forEach>--%>
        for(var i=0;i<10;i++)
        {
            var time = i * 10;
            var danmutest = '{ "text":"hahahaha" , "color":"red" ,"size":"0","position":"0","time":' + time + '}';
            var new_obj = eval('(' + danmutest + ')');

            $('#danmuss').danmu("add_danmu", new_obj);
        }

    },10)

    var first=true;
    // $('#danmuss').danmu('danmu_resume');//弹幕处于运行

    function timedCount()
    {
        $("#time").text($('#danmuss').data("nowtime"));

        t=setTimeout("timedCount()",50)

    }



    function starter(){

        $('#danmuss').danmu('danmu_start');

    }
    function pauser(){

        $('#danmuss').danmu('danmu_pause');
    }
    $("#percentage").click(function(){
        var t = Math.round(10*dangqiantime/1);
        console.log(t)
        $('#danmuss').data("nowtime",t);
    });
    function settime(){
        var t=document.getElementById("set_time").value;
        t=parseInt(t)
        console.log(t)
        $('#danmuss').data("nowtime",t);
    }
    $("#playOrStop").click(function(){
        state = !state;
        if(state){
            $('#danmu').danmu('danmu_resume');
        }else {
            $('#danmu').danmu('danmu_pause');
        }
    });
    function resumer(){


        state = !state;
        if(state){
            $('#danmu').danmu('danmu_resume');
        }else {
            $('#danmu').danmu('danmu_pause');
        }

    }
    function stoper(){
        $('#danmuss').danmu('danmu_stop');
    }

    function getime(){
        alert($('#danmuss').data("nowtime"));
    }

    function getpaused(){
        alert($('#danmuss').data("paused"));
    }

    function add(){
        var newd=
            { "text":"new2" , "color":"green" ,"size":"1","position":"0","time":60};

        $('#danmuss').danmu("add_danmu",newd);
    }
    function insert(){
        var newd= { "text":"new2" , "color":"green" ,"size":"1","position":"0","time":50};
        str_newd=JSON.stringify(newd);
        $.post("stone.php",{danmu:str_newd},function(data,status){alert(data)});
    }
    function query() {
        $.get("query.php",function(data,status){
            var danmu_from_sql=eval(data);
            for (var i=0;i<danmu_from_sql.length;i++){
                var danmu_ls=eval('('+danmu_from_sql[i]+')');
                $('#danmuss').danmu("add_danmu",danmu_ls);
            }
        });
    }

    function send(){

        var user = "<%=request.getSession().getAttribute("userName")%>";
        if(user=="null"){
            alert("请先登录！");
        }else {
            var videoID="<%=request.getAttribute("videoID")%>";
            var text = document.getElementById('danmutext').value;
            var color = document.getElementById('color').value;
            var position = document.getElementById('position').value;
            var time = $('#danmuss').data("nowtime")+5;
            var size =document.getElementById('text_size').value;
            var text_obj='{ "text":"'+text+'","color":"'+color+'","size":"'+size+'","position":"'+position+'","time":'+time+'}';;
            $.post("barrage.action",{"videoID":videoID,"text":text,"color":color,"position":position,"time":time,"size":size});
            // $.post("stone.php",{danmu:text_obj});
            var text_obj='{ "text":"'+text+'","color":"'+color+'","size":"'+size+'","position":"'+position+'","time":'+time+',"isnew":""}';
            var new_obj=eval('('+text_obj+')');
            $('#danmuss').danmu("add_danmu",new_obj);
            document.getElementById('danmutext').value='';
        }

    }

    function op(){
        var op=document.getElementById('op').value;
        $('#danmuss').data("opacity",op);
    }


    function changehide() {
        var op = document.getElementById('op').value;
        op = op / 100;
        if (document.getElementById("ishide").checked) {
            jQuery('#danmuss').data("opacity", op);
            jQuery(".flying").css({
                "opacity": op
            });
        } else {
            jQuery('#danmuss').data("opacity", 0);
            jQuery(".flying").css({
                "opacity": 0
            });
        }
    }



</script>

<%--点赞的js代码--%>
<script>


    var praiseNum ="<%=request.getSession().getAttribute("praiseNum")%>";
    var user = "<%=request.getSession().getAttribute("userName")%>";
    var videoID="<%=request.getAttribute("videoID")%>";
    var djchange="<%=request.getSession().getAttribute("praiseRecord")%>";
    function dj(){


        if((user!="null")&&(djchange==0)){
            //点赞
            praiseNum++;
            document.getElementById("dianzan").style.backgroundColor = "#2acc38";
            document.getElementById("dianzan").innerText="点赞（"+praiseNum+")";
            djchange=1;
            $.post("praise.action",{"videoID":videoID,"user":user,"praiseNum":praiseNum,"djchange":djchange});


        }else if((user!="null")&&(djchange==1)){
            //取消点赞
            praiseNum--;
            document.getElementById("dianzan").style.backgroundColor = "#8BB592";
            document.getElementById("dianzan").innerText="点赞（"+praiseNum+")";
            djchange=0;
            $.post("praise.action",{"videoID":videoID,"user":user,"praiseNum":praiseNum,"djchange":djchange});


        }
        if(user=="null"){
            alert("请先登录！");
        }




    }


</script>
</html>