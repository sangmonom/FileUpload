<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link href="./resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="./resources/js/jquery.min.js"></script>
<script type="text/javascript" src="./resources/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<h4>All Users</h4>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Email</th>
					<th>Phone</th>
					<th>Photo</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="u">
					<tr>
						<td>${u.id }</td>
						<td>${u.name }</td>
						<td>${u.email }</td>
						<td>${u.phone }</td>
						<td>
							<img src="/FileUpload/imgUploads/${u.photo}" alt="" width="100" height="100"/>
						</td>
						
					</tr>
					</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>