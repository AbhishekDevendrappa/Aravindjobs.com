<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="UTF-8">
<title>Admin Main</title>
</head>
<body>

	<div class="toolbar">
		<h1>Jobs.Com</h1>
		<a href="Aloglout"><button type="submit">Logout</button></a>
	</div>

	<h2>USer with number offer of letters they have</h2>
	<h2>${message}</h2>
	<table>
		<tr>
			<th>slno</th>
			<th>User name</th>
			<th>offersGained</th>
			<th>Block User for job apply</th>
		</tr>
		<c:forEach items="${offers}" var="user">
			<tr>
				<td>${user.slno}</td>
				<td>${user.user.username}</td>
				<td>${user.offerletterofffered}</td>
				<td><a href="block?no=${user.user.slno}">Block user</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
