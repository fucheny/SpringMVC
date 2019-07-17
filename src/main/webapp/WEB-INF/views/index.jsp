
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<label>功能1：查询</label>
	<form action="/cc/search" class="form-inline" role="form">
		<div class="form-group">
			<label class="sr-only" for="name">姓名：</label> <input type="text"
				class="form-control" id="userName" name="userName"
				placeholder="请输入姓名">
		</div>

		<button type="submit" class="btn btn-default">查询</button>

	</form>

	<a href="/cc/add">添加</a>
	<table class="table table-striped table-bordered">
		<tr>
			<th>序号</th>
			<th>姓名</th>
			<th>性别</th>
			<th>电话</th>
			<th>组别</th>
			<th>导师</th>
			<th colspan="3">操作</th>
		</tr>

		<c:forEach items="${lists}" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.name}</td>
				<td>${user.sex }</td>
				<td>${user.phone}</td>
				<td>${user.groupz}</td>
				<td>${user.leader}</td>
				<td><a href="/cc/update?id=${user.id}">更新</a></td>
				<td><a href="/cc/delete?id=${user.id}">删除</a></td>
			</tr>
		</c:forEach>


	</table>



</body>
</html>