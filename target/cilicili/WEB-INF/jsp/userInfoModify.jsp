<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- jstl标签 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/User_Data_Update/css/jiazaitoubu.css"
	type="text/css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/User_Data_Update/css/css.css"
	type="text/css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/User_Data_Update/css/center.css"
	type="text/css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/User_Data_Update/city/city.css"
	type="text/css" />

<!-- <script src="<%=request.getContextPath()%>/static/User_Data_Update/"></script> -->
<script
	src="<%=request.getContextPath()%>/static/User_Data_Update/js/jquery-1.8.3.min.js"></script>
<script
	src="<%=request.getContextPath()%>/static/User_Data_Update/js/index2.js"></script>
<script
	src="<%=request.getContextPath()%>/static/User_Data_Update/js/index2.js"></script>



<title>cilicili-全部信息修改</title>
</head>
<body>
	<div class="top" id="wyqtb">
		<!--热门搜索-->

		<!--导航-->
		<div class="dao_hang" style="background-color: #6C89B2;">
			<!--结束-->
			<div class="dao_list">
				<a href="/login.action">首页</a> <a href="javascript:return false;">视频收藏</a> <a href="javascript:return false;">周边</a>
				<a href="javascript:return false;">小黑屋</a>
			</div>
		</div>
	</div>
<!-- 	<script>
window.onload=function(){
	$(".aside").css({display:"none"})
	$(".important").mouseenter(function(){
		$(".aside").css({display:"block"})
		}).mouseleave(function(){
			$(".aside").css({display:"none"})
			})
	}
</script> -->
	<!--当前位置-->
	<div class="now_positionm">
		<span>当前位置：</span><a href="/index.action">首页></a><a
			href="/userInformation.action">个人中心</a>
	</div>
	<!--centers-->
	<div class="centers_m">
		<!--清除浮动-->
		<div class="clear_sm"></div>
		<!--左边信息栏-->
		<div class="centers_ml">
			<!--头像-->
			<div class="center_header">
				<a href="/userInformation.action"><img
					src="<%=request.getContextPath()%><%=request.getSession().getAttribute("userHeadPic")%>" /></a>
				<em>您好，<font><%=request.getSession().getAttribute("userName")%></font></em> <font
					style="color: red; font-size: 11px;">(下方可修改资料~喵)</font>
			</div>
			<!--左侧边栏列表-->
			<div class="centers_listm">
				<div class="centers_listm_one">
					<img
						src="<%=request.getContextPath()%>/static/User_Data_Update/images/zshy.png" />
					<em>会员中心</em>
				</div>
				<!-- 资料管理标题-->
				<div class="centers_listm_one_in">
					<img src="<%=request.getContextPath()%>/static/User_Data_Update/images/shezhi.png" />
					<em>资料管理</em> <b></b>
				</div>
				<%-- 资料管理--%>
				<span class="gjszmdm">
					<a href="/userInformation.action" class="center_in_self">
						<font>信息资料</font></a>
					<a href="/userInformation.action" class="center_in_self">
						<font>银行卡管理ont</font></a>
					<a href="/userInformation.action" class="center_in_self">
						<font>收货地址管理</font></a>
				</span>
				<!-- 订单管理标题-->
				<div class="centers_listm_one_in">
					<img src="<%=request.getContextPath()%>/static/User_Data_Update/images/ddgl.png" />
					<em>订单管理</em> <b></b>
				</div>
				<%-- 订单管理--%>
				<span class="gjszmdm">
					<a href="/userInformation.action" class="center_in_self">
						<font>我的订单</font></a>
					<a href="/userInformation.action" class="center_in_self">
						<font>已删除订单</font></a> <a
					href="javascript:return false;" class="center_in_self">
					<font>订单投诉</font></a>
				</span>
			</div>
			<script type="text/javascript">
		$(function(){//第一步都得写这个
			$(".centers_listm_one_in").click(function(){
			$(this).next(".gjszmdm").slideToggle().siblings("gjszmdm").slideUp()
			});
		})
		</script>
		</div>
		<!-- 中部用户信息展示栏 -->
		<div class="public_m1">
			<div class="public_m2">用户全部信息资料</div>
			<!--提示信息-->
			<div class="tip_notem">
				<ul>
					<li>1.请牢记支付密码</li>
					<li>2.如果丢失密码，可以通过绑定的手机或邮箱找到</li>
				</ul>
			</div>
			<div class="public_m4">
				<p>
					<em>用户真实姓名</em>
					<input type="text" style="height: 23px; border: 1px solid #eaeaea; width: 140px" value="${user.userName}" onfocus=this.blur()>
				</p>
				<p>
					<em>用户地址：</em>
					<input type="text" style="height: 23px; border: 1px solid #eaeaea; width: 140px" value="${user.userAddress}" onfocus=this.blur()>
				</p>
				<p>
					<em>用户手机号：</em>
					<input type="text" style="height: 23px; border: 1px solid #eaeaea; width: 140px" value="${user.userPhone}" onfocus=this.blur()>
				</p>
				<p>
					<em>用户QQ号：</em> <input type="text" style="height: 23px; border: 1px solid #eaeaea; width: 140px"
						value="${user.userQQ}" onfocus=this.blur()>
				</p>
				<p>
					<em>用户邮箱：</em> <input type="text"
						style="height: 23px; border: 1px solid #eaeaea; width: 140px"
						value="${user.userEmial}" onfocus=this.blur()>
				</p>
				<p>
					<em>最后一次登录时间：</em> <input type="text"
						style="height: 23px; border: 1px solid #eaeaea; width: 140px"
						value="${user.userLoginTime}" onfocus=this.blur()>
				</p>
				<p>
					<em>用户状态：</em> <input type="text"
						style="height: 23px; border: 1px solid #eaeaea; width: 140px"
						value="${user.userState}" onfocus=this.blur()>
				</p>

				<a href="/userInformation.action" class="public_m3">返回主信息</a>
			</div>
		</div>
	</div>
</body>
</html>