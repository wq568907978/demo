<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/emp/3" method="post">
		<input type="hidden" name="_method" value="put">
		员工号：<input type="text" name="empno"><br>
		员工名：<input type="text" name="ename"><br>
		职务：<input type="text" name="job"><br>
		薪酬：<input type="text" name="sal"><br>
		<input type="text" name="xiao">
		<input type="submit" value="保存">
	</form>
</body>
</html>