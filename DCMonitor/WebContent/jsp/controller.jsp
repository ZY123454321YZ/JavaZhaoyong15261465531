<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*" pageEncoding="UTF8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>控制平台</title>
</head>
<body>
	<table border='1' style="width: 100%;">
		<tr>
			<td>日期</td>
			<td>在线时长</td>
			<td>在线人数</td>
			<td>开始时间</td>
			<td>结束时间</td>
		</tr>
		<c:forEach items="${list}" var="li" varStatus="s">
			<tr>
				<td>${li.date}</td>
				<td>${li.countDate}</td>
				<td>${li.countUser}</td>
				<td>${li.startDate}</td>
				<td>${li.endDate}</td>
			</tr>
		</c:forEach>
	</table>

	<form action='../controller/exportData' method="post">
		导出数据：<br /> 导出数据文件：<input type="text" name="file"><br /> <input
			type="submit" value="提交">
	</form>
	</div>
</body>
</html>