<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*"
    pageEncoding="UTF8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../jquery/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="../jquery/jquery-2.1.0.js"></script>
<script type="text/javascript" src="../jquery/jquery.min.js"></script>
<script>
function doCompare(){
    $.ajax({
    async : false,
    cache : false,
    type : 'post',
    url : "http://localhost:8080/GoShoping/QueryUser.do",
    error : function() {
        alert('smx失败 ');
    },
    success : function(data) {
    	 alert('smx成功 ');
    	 alert(data);
    	 var jsonData = JSON.parse(data); 
         for (var i = 0; i < jsonData.length; i++) {
             alert(jsonData[i].id);
             alert(jsonData[i].name);                    
         }
    } 
}); 
        
	     }

</script>
<title>管理界面</title>
</head>
<body>
<div>
<table border="1" width="100%">
<tr><th>ID</th><th>姓名</th><th>年龄</th>
<th><input type="button" value="删除" class="del" onclick="doCompare();"/>
   <input type="button" value="修改" class="update"/>
</th></tr>
</table>
</div>

</body>
</html>