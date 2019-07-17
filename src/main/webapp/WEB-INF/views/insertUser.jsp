<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新信息</title>
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
	<h1>更新信息 ${serverTime }</h1>


	<form action="/cc/addMethod" class="form-horizontal" role="form">
		<div class="form-group">
			<label for="firstname" class="col-sm-4 control-label">姓名</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="uesrName"
					name="uesrName" placeholder="请输入姓名">
			</div>
			<div class="col-sm-6"></div>
		</div>
		<div class="form-group">
			<label for="firstname" class="col-sm-4 control-label">性别</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="userSex" name="userSex"
					placeholder="请输入性别">
			</div>
			<div class="col-sm-6"></div>
		</div>
		<div class="form-group">
			<label for="firstname" class="col-sm-4 control-label">电话</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="userPhone"
					name="userPhone" placeholder="请输入电话">
			</div>
			<div class="col-sm-6"></div>
		</div>
		<div class="form-group">
			<label for="firstname" class="col-sm-4 control-label">组别</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="userGroup"
					name="userGroup" placeholder="请输入名字">
			</div>
			<div class="col-sm-6"></div>
		</div>
		<div class="form-group">
			<label for="firstname" class="col-sm-4 control-label">领导</label>
			<div class="col-sm-2">
				<input type="text" class="form-control" id="userLeader"
					name="userLeader" placeholder="请输入领导姓名">
			</div>
			<div class="col-sm-6"></div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-4 col-sm-8">
				<button type="submit" class="btn btn-default">提交</button>
			</div>
		</div>
	</form>
</body>
</html>