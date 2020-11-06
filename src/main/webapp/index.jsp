<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link href="./resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="./resources/js/jquery.min.js"></script>
<script type="text/javascript" src="./resources/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
	<div class="card">
		<div class="card-header">
			<h4>Add New User</h4>
		</div>
		<div class="card-body">
			<c:url value="/user-create" var="save"></c:url>
			<form action="${save}" class="form col-6" method="post" enctype="multipart/form-data">
				<div class="form-group">
					<label for="" >Name</label>
					<input type="text" name="name" class="form-control">
				</div>
				<div class="form-group">
					<label for="" >Email</label>
					<input type="text" name="email" class="form-control">
				</div>
				<div class="form-group">
					<label for="" >Phone</label>
					<input type="text" name="phone" class="form-control">
				</div>
				<div class="form-group">
					<label for="" >Photo</label>
					<input type="file" name="photo" class="form-control">
				</div>
				<button type="submit" class="btn btn-success">Save</button>
				<button type="reset" class="btn btn-danger">Clear</button>
			</form>
		</div>
	</div>
	</div>
</body>
</html>