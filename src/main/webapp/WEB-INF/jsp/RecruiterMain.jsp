<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Recuiter Main</title>
</head>
<body>
<h1>Hello well come to recruiter main page</h1>
<h2><h2>${Msg}</h2></h2>
<form action="savejob" method="post">
<h1>Post job</h1>
<label>Company</label>
<input type="text" name="company">
<label>Job Title</label>
<input type="text" name=jobtitle>
<label>Job Description</label>
<input type="text" name="jobdescription">
<label>Job Location</label>
<input type="text" name="joblocation">
<label>Job Type</label>
<input type="text" name="jobtype">
<input type="submit">
</form>
</body>
</html>