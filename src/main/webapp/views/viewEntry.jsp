<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.ayyappa.springmvcdemo1.model.*" %>
<% response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
   DiaryModel diary = (DiaryModel)request.getAttribute("view");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Entry</title>
<style type="text/css">
	body {
		font-family: Arial, sans-serif;
		background-color: #e0f7fa;
		margin: 0;
		display: block;
	}
	.topnav {
	  	background-color: #333;
	  	overflow: hidden;
	}
	.topnav h1 {
	  	text-align: center;
	  	color: #f2f2f2;
	  	padding: 14px 16px;
	  	font-size: 18px;
	}
	.container {
	    border-radius: 8px;
	    width: 30%;
	    margin: 80px auto;
	    padding: 30px;
	    background-color: #ffffff;
	}
	.form-fields {
	    width: 100%;
	}
	.form-fields h2 {
	    font-size: 20px;
	    color: #555;
	    margin-bottom: 10px;
	}
	label {
	    display: block;
	    font-size: 14px;
	    color: #555;
	    margin-bottom: 5px;
	}
	input[type="date"],
	textarea {
	    width: 100%;
	    padding: 8px;
	    margin-bottom: 15px;
	    border: 1px solid #ccc;
	    border-radius: 4px;
	    font-size: 14px;
	    font-family: inherit;
	    color: #333;
	}
	button {
	    background-color: #4CAF50;
	    color: white;
	    padding: 10px 20px;
	    border: none;
	    border-radius: 4px;
	    cursor: pointer;
	    font-size: 16px;
	}
	button:hover {
	    background-color: #45a049;
	}
</style>
</head>
<body>
	<div class="topnav">
	  <h1>MyDiary App</h1>
	</div>
	<div class="container">
            <div class="form-fields">
                <h2>View Entry</h2>
                <label for="date">Date</label>
                <input type="date" id="date" name="date" value="<%=diary.getDate() %>" readonly>
                <label for="description">Description</label>
                <textarea id="description" name="description" rows="5" readonly><%=diary.getDescription() %></textarea>
                <button onclick="window.location.href = 'home';">Home</button>
                <button style="margin-left: 10px;" onclick="window.location.href = 'update?id=<%=diary.getId()%>';">Update</button>
            </div>
        </div>
</body>
</html>

