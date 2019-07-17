<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Bootstrap 实例 - 基本的表格</title>
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<a href="cc/">添加信息</a>
	<h1>实习生信息</h1>
	<table class="table table-striped table-bordered">

		<tr>
			<th>序号</th>
			<th>姓名</th>
			<th>性别</th>
			<th>电话</th>
			<th>组别</th>
			<th>导师</th>
			<th colspan="2">操作</th>
		</tr>

		<c:forEach items="${lists}" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.name}</td>
				<c:choose>
					<c:when test="${user.sex==\"2\" }">
						<td>女</td>
					</c:when>
					<c:otherwise>
						<td>男</td>
					</c:otherwise>
				</c:choose>
				<td>${user.phone}</td>
				<td>${user.groupz}</td>
				<td>${user.leader}</td>
				<td><a href="#">更新</a></td>
				<td><a href="#">删除</a></td>
			</tr>
		</c:forEach>


	</table>

</body>
</html>
