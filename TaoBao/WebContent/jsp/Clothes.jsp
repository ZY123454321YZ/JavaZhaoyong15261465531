<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*" pageEncoding="UTF8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>京东服饰</title>
</head>
<body>
<div>
<table border='1'  style="width: 100%;">
 <c:forEach items="${list}" var="li" varStatus="s">
     <tr>
      <td>
       ${li.date}
      </td>
      <td>
       ${li.countDate}
      </td>
      <td>
       ${li.countUser}
      </td>
      <td>
       ${li.startDate}
      </td>
      <td>
       ${li.endDate}
      </td>
     </tr>
    </c:forEach>


</table>


</div>


</body>
</html>