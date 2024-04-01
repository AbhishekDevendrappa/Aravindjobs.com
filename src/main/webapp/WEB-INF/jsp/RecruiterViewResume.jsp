<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>

<div class="toolbar">
		<h1>Jobs.Com</h1>
		<a href="rback"><button type="submit">Back</button></a>
		<a href="loglout"><button type="submit">Logout</button></a>
	</div>
	<h2>Resumes Details</h2>
		<table>
			<tr>
				<th>Serial number</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Contact Number</th>
				<th>Date of Birth</th>
				<th>Gender</th>
				<th>Total Experience</th>
				<th>City Applying</th>
				<th>10th Percentage</th>
				<th>12th Percentage</th>
				<th>Highest Qualification</th>
				<th>Year of Highest Qualification</th>
				<th>Current Company</th>
				<th>Current Designation</th>
				<th>Current CTC</th>
			</tr>

			<tr>
				<td>${resume.slno}</td>
				<td>${resume.firstname}</td>
				<td>${resume.lastname}</td>
				<td>${resume.email}</td>
				<td>${resume.contactnumber}</td>
				<td>${resume.dateofbirth}</td>
				<td>${resume.gender}</td>
				<td>${resume.totalexperience}</td>
				<td>${resume.cityapplying}</td>
				<td>${resume.tenthpercentage}</td>
				<td>${resume.twelvethpercentage}</td>
				<td>${resume.highestqualification}</td>
				<td>${resume.yearofhighestqualification}</td>
				<td>${resume.currentCompany}</td>
				<td>${resume.currentDesignation}</td>
				<td>${resume.currentCTC}</td>
			</tr>
		</table>
</body>
</html>