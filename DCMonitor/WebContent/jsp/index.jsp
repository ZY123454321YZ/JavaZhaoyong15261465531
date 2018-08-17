<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*" pageEncoding="UTF8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>京东网上商城</title>
<style type="text/css">
ul {
	display: inline;
	white-space: nowrap;
}

ul li {
	padding: 10px 20px;
	display: inline-block;
	background-color: hsl(200, 65%, 75%);
	white-space: nowrap;
}
</style>
</head>
<body>
	<div>
		<ul class="fr">
			<li class="fore1 dorpdown" id="ttbar-login"
				clstag="h|keycount|head|topbar_02"><a target="_blank"
				href="login.jsp" class="link-login">你好，请登录</a>&nbsp;&nbsp;<a
				href="regst.jsp" class="link-regist style-red">免费注册</a></li>
			<li class="spacer"></li>
			<li class="fore2" clstag="h|keycount|head|topbar_03">
				<div class="dt">
					<a target="_blank" href="//order.jd.com/center/list.action">我的订单</a>
				</div>
			</li>
			<li class="spacer"></li>
			<li class="fore3 dorpdown" id="ttbar-myjd"
				clstag="h|keycount|head|topbar_04">
				<div class="dt cw-icon">
					<a target="_blank" href="//home.jd.com/">我的京东</a><i
						class="iconfont">&#xe605;</i><i class="ci-right"><s>◇</s></i>
				</div>
				<div class="dd dorpdown-layer"></div>
			</li>
			<li class="spacer"></li>
			<li class="fore4" clstag="h|keycount|head|topbar_05">
				<div class="dt">
					<a target="_blank" href="//vip.jd.com/">京东会员</a>
				</div>
			</li>
			<li class="spacer"></li>
			<li class="fore5" clstag="h|keycount|head|topbar_06">
				<div class="dt">
					<a target="_blank" href="//b.jd.com/">企业采购</a>
				</div>
			</li>
			<li class="spacer"></li>
			<li class="fore8 dorpdown" id="ttbar-serv"
				clstag="h|keycount|head|topbar_07">
				<div class="dt cw-icon">
					客户服务<i class="iconfont">&#xe605;</i><i class="ci-right"><s>◇</s></i>
				</div>
				<div class="dd dorpdown-layer"></div>
			</li>
			<li class="spacer"></li>
			<li class="fore9 dorpdown" id="ttbar-navs"
				clstag="h|keycount|head|topbar_08">
				<div class="dt cw-icon">
					网站导航<i class="iconfont">&#xe605;</i><i class="ci-right"><s>◇</s></i>
				</div>
				<div class="dd dorpdown-layer"></div>
			</li>
			<li class="spacer"></li>
			<li class="fore10 mobile" id="J_mobile"
				clstag="h|keycount|head|topbar_09">
				<div class="dt mobile_txt">手机京东</div>
				<div class="mobile_static">
					<div class="mobile_static_qrcode"></div>
				</div>
				<div id='J_mobile_pop' class='mod_loading mobile_pop'></div>
			</li>
		</ul>
	</div>
	<div>
		<table border="1" width="100%" height="50">
			<tr>
				<th><a
					href="miaosha.jsp">秒杀</a></th>
				<th><a href="role.jsp">优惠劵</a></th>
				<th><a href="">闪购</a></th>
				<th><a href="../controller/Operationdata">拍卖</a></th>
			</tr>
		</table>
	</div>
	<div style="background-color: #FF4000; height: 60px">
		<p align="center">
			<a href="jsp/role.jsp" style="">备案和审计</a>
		</p>
		<p align="center">
			<a href="help.jsp">帮助中心</a>
		</p>
	</div>
	<div style="background-color: yellow;">
		<table border="1" width="100%" height="400">
			<tr>
				<th><a href="Clothes.jsp">京东服饰</a></th>
				<th><a href="role.jsp">京东超市</a></th>
			</tr>
			<tr>
				<td align="center"><a href="role.jsp">生鲜</a></td>
				<td align="center"><a href="role.jsp">全球购</a></td>
			</tr>
			<tr>
				<td align="center"><a href="role.jsp">京东金融</a></td>
				<td align="center"><a href="role.jsp">家用电器</a></td>
			</tr>
			<tr>
				<td align="center"><a href="role.jsp">食品/酒类</a></td>
				<td align="center"><a href="role.jsp">图书/音像</a></td>
			</tr>
			<tr>
				<td align="center"><a href="role.jsp">房产/汽车</a></td>
				<td align="center"><a href="role.jsp">男装/女装</a></td>
			</tr>
		</table>
	</div>
</body>
</html>