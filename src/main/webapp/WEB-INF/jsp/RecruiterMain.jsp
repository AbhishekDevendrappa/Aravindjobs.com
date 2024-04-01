<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Job Management System</title>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <style type="text/css">
    body {
    font-family: Arial, sans-serif;
}

h1, h2 {
    color: #333;
}

button {
    background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}

#postJobForm, #viewJobApplications {
    margin-top: 20px;
}

table {
    width: 100%;
    border-collapse: collapse;
}

table, th, td {
    border: 1px solid black;
    padding: 15px;
    text-align: left;
}

th {
    background-color: #4CAF50;
    color: white;
}
    
    </style>
</head>
<body>
<div class="toolbar">
		<h1>Jobs.Com</h1>
		<a href="loglout"><button type="submit">Logout</button></a>
	</div>
   
    

    <button id="postJobButton">Post a Job</button>
    <a href="/viewJobApplications" id="viewApplicationsButton"><button>View Job Applications</button></a>
	<h2>${offer}</h2>

    <div id="postJobForm" style="display: none;">
        <h2>Post a Job</h2>
        <form action="savejob" method="post">
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
    </div>

    <div id="viewJobApplications">
        <h2>View Job Applications</h2>
        <table>
            <tr>
                <th>slno</th>
                <th>user name</th>
                <th>user email</th>
                <th>user number</th>
                <th>Position appied</th>
                <th>company</th>
                <th>Job Type</th>
                <th>View Resume</th>
                <th>Schedual Intervie</th>
                <th>release offer letter</th>
                <th>Reject</th>
            </tr>
            <c:forEach items="${aplliedjobs}" var="j">
                <tr>
                    <td>${j.slno}</td>
                    <td>${j.user.username}</td>
                    <td>${j.user.email}</td>
                    <td>${j.user.number}</td>
                    <td>${j.jobs.jobtitle}</td>
                    <td>${j.jobs.company}</td>
                    <td>${j.jobs.jobtype}</td>
                    <td><a href="showresume?no=${j.user.slno}">View Resume</a></td>
                    <td><a href="intervie?no=${j.user.username}">Schedual Intervie</a></td>
                    <td><a href="offerletter?no=${j.user.username}">release offer letter</a></td>
                    <td><a href="reject?no=${j.slno}">Reject</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <script>
        $(document).ready(function() {
            $("#postJobButton").click(function() {
                // Hide the view job applications section
                $("#viewJobApplications").hide();
                // Show the post job form
                $("#postJobForm").show();
            });

            $("#viewApplicationsButton").click(function() {
                // Hide the post job form
                $("#postJobForm").hide();
                // Show the view job applications section
                $("#viewJobApplications").show();
            });
        });
    </script>
</body>
</html>
