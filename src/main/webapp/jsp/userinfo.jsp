<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<title></title>
</head>
<body>
Hello,${user.userid }!
<p><input type="button" onclick="quit();" value="退出"/></p>
</br>
<button onclick="abv();">今天是星期几？</button>
<p id="demo"></p>


<select id="sel" name="sel" >
	<option value="">--选择</option>
	<c:forEach items="${stulist}" var ="student">
		<option value="${student.sId }">${student.sName }</option>
	</c:forEach>
</select>
<table id="tab1" hidden="true" border="1">
	<thead>
		<tr>
			<td>学生id</td>
			<td>姓名</td>
			<td>学科</td>
			<td>分数</td>
		</tr>
	</thead>
	<tbody>
	</tbody>
</table>
</body>

<script type="text/javascript">
function quit(){
	window.location.href = "/quit";
}

function abv(){
	var showdata;
	var day = new Date().getDay();
	switch(day){
		case 0:	showdata = "星期天";
			break;
		case 1:	showdata = "星期1";
			break;
		case 2:	showdata = "星期2";
			break;				
		case 3:	showdata = "星期3";  
			break;			
		case 4:	showdata = "星期4";
			break;
		case 5:	showdata = "星期5";
			break;				
		case 6:	showdata = "星期6"; 
		break;
	}
	document.getElementById("demo").innerHTML=showdata;
}
$("#sel").change(function(){
	$.ajax({
		type: "post",
		url: "/getuser",
		data: {
			userid:$("#sel").val()
		},
		dataType: "json",
		success:function(data){
			$("#tab1").show();
			var jsonobj = jQuery.parseJSON(data.data);
			console.log(jsonobj.length);
			var str = "";
			for(var i = 0; i < jsonobj.length;i ++){
				str = str + '<tr><td>'+jsonobj[i].s_id+'</td><td>'+jsonobj[i].s_name+'</td><td>'+jsonobj[i].c_name+'</td><td>'+jsonobj[i].s_score+'</td></tr>';
			}
			$("tbody").html(str);
		}
		
	});
});
</script>
</html>

