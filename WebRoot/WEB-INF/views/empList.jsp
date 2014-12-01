<%@page import="vo.EmpVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="">
		<table>
			<tr>
				<td>员工号</td><td>员工名</td><td>职务</td><td>薪酬</td><td>操作</td>
			</tr>
		</table>
		<%
			List<EmpVO> vos = (List<EmpVO>)request.getAttribute("empList");
			for(EmpVO vo : vos){
		%>
			<tr>
				<td><%=vo.getEmpno()%></td><td><%=vo.getEname()%></td>
				<td><%=vo.getJob()%></td><td><%=vo.getSal()%></td>
				<td><a href="<%=request.getContextPath()%>/emp/<%=vo.getEmpno()%>/edit">编辑</a></td>
			</tr><br>
		<%
			}
		%>
	</form>
</body>

</html>