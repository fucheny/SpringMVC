<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/cc/param" role="form">
		姓名：<input type="text" name="userName"><br /> <input
			type="submit" value="查询">
	</form>
	<table>
		<tr>
			<th>序号</th>
			<th>姓名</th>
			<th>性别</th>
			<th>电话</th>
			<th>组别</th>
			<th>导师</th>
		</tr>
		<c:forEach items="${lists}" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.name}</td>
				<c:choose>
					<c:when test="user.sex == '1'">
						<td>男</td>
					</c:when>
					<c:otherwise>
						<td>女</td>
					</c:otherwise>
				</c:choose>
				<td>${user.phone}</td>
				<td>${user.groupz}</td>
				<td>${user.leader}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>