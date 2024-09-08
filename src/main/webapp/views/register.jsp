<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Form</title>
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
			text-align: center;
			padding-top: 83px;
		}
		
		
		.login-box {
			background-color: #ffffff;
			padding: 30px;
			border-radius: 10px;
			box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
			width: 300px;
			margin: 0 auto;
		}
		
		.book-icon {
			width: 100px;
			height:75px;
			margin-bottom: 20px;
		}
		
		h2 {
			color: #6a1b9a;
			margin-bottom: 20px;
		}
		
		.textbox {
			margin-bottom: 20px;
		}
		
		.textbox input {
			width: 100%;
			padding: 10px;
			margin: 8px 0;
			border: none;
			border-bottom: 2px solid #6a1b9a;
			outline: none;
			font-size: 16px;
		}
		
		.btn {
			width: 100%;
			padding: 10px;
			background-color: #6a1b9a;
			color: #fff;
			border: none;
			border-radius: 5px;
			cursor: pointer;
			font-size: 16px;
		}
		
		.btn:hover {
			background-color: #4a148c;
		}
		
		.register-link {
			margin-top: 20px;
		}
		
		.register-link a {
			color: #6a1b9a;
			text-decoration: none;
		}
		
		.register-link a:hover {
			text-decoration: underline;
		}
	</style>
</head>
<body>
	<div class="topnav">
	  <h1>MyDiary App</h1>
	</div>
	<div class="container">
        <div class="login-box">
            <img src="https://t4.ftcdn.net/jpg/05/67/71/83/360_F_567718354_Q3O9bskoH41fsfm4hsDlGKwJ7F5AB3x2.jpg" alt="Book Icon" class="book-icon">
            <h2>Registration Form</h2>
            <form action="registration" method="post">
                <div class="textbox">
                    <input type="text" placeholder="Enter your Username" name="name" required>
                </div>
                <div class="textbox">
                    <input type="password" placeholder="Enter your Password" name="password" required>
                </div>
                <button type="submit" class="btn">Register</button>
            </form>
            <div class="register-link">
                <a href="login">Existing user. Login Now</a>
            </div>
        </div>
    </div>
	</body>
</html>