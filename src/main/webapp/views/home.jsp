<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@page import="com.ayyappa.springmvcdemo1.model.*" %>
    <%@page import="com.ayyappa.springmvcdemo1.service.*" %>
    <%@page import="java.util.*" %>
    <%	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
    UserModel userModel = (UserModel)request.getAttribute("user");
    
    List<DiaryModel> diaryEntries = (List<DiaryModel>)request.getAttribute("diary-list"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MyDiary Home</title>
<style>
		body {
			font-family: Arial, sans-serif;
			background-color: #e0f7fa;
			display: block;
			justify-content: center;
			align-items: center;
			height: 100vh;
			margin: 0;
		}
		.topnav {
		  background-color: #333;
		  overflow: hidden;
		}
		.topnav h1 {
		  float: center;
		  color: #f2f2f2;
		  text-align: center;
		  padding: 14px 16px;
		  text-decoration: none;
		  font-size: 18px;
		}
		.container {
		    max-width: 800px;
		    margin: 20px auto;
		    padding: 20px;
		    background-color: #f5f5f5;
		    border-radius: 8px;
		}
		
		h2 {
		    text-align: center;
		}
		
		.user-info {
		    display: flex;
		    justify-content: space-between;
		}
		
		.entries {
		    border-collapse: collapse;
		    width: 100%;
		}
		
		th, td {
		    border: 1px solid #ccc;
		    padding: 8px;
		    text-align: center;
		}
		
		button {
		    background-color: #4caf50;
		    color: white;
		    padding: 8px 12px;
		    border: none;
		    border-radius: 4px;
		    cursor: pointer;
		}
		
		button:hover {
		    background-color: #3e8e41;
		}
</style>
</head>
<body>
	<div class="topnav">
	  <h1>MyDiary App</h1>
	</div>
	<div class="container">
        <div class="user-info">
            <p>Welcome, <span style="color: red; font-family: sans-serif; font-size: 25px; text-decoration: none;"><%=userModel.getUserName() %></span></p>
            <button style="height: 42px;" onclick="window.location.href = 'sign-out';">Sign Out</button>
        </div>
        <h2>List of Past Entries</h2>
        <table class="entries">
            <thead>
                <tr>
                    <th>Date</th>
                    <th colspan="3">Actions</th>
                </tr>
            </thead>
            <tbody>
            <% if( diaryEntries != null && !diaryEntries.isEmpty()) {
            	for(DiaryModel dm: diaryEntries){%>
            		 <tr>
	                    <td><%=dm.getDate() %></td>
	                    <td><button onclick="window.location.href = 'view?id=<%=dm.getId()%>';">View</button></td>
	                    <td><button onclick="window.location.href = 'update?id=<%=dm.getId()%>';">Update</button> </td>
	                    <td><button onclick="window.location.href = 'delete?id=<%=dm.getId()%>';">Delete</button></td>
	                </tr>
            	<%}
            }else{%>
            	<tr><td>no entries</td></tr>
            <%}
            %>
               
            </tbody>
        </table>
        <button onclick="window.location.href = 'add';" style="margin-top: 25px;">Add Entry</button>
    </div>
</body>
</html>