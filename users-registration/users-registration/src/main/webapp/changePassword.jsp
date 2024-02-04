<%
	if(session.getAttribute("username") ==null){
		response.sendRedirect("login.jsp");
	}

%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Change Password</title>
    
    <style>
    h3{
	text-align: center;
	margin-top: 20px;
}
.container {

  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  min-height: 650px;
  background-color: #e0e6ee; 
  padding: 50px;
  margin: 35px 7%;
  
}


.image {
  flex: 1;
  max-width: 80%;
  justify-content: center;
  margin-right: 7%;
  
}

form {
  display: flex;
  justify-content: space-between;
  flex-direction: column;
  flex: 6; 
  padding-right: 170px;
}

#image{
	max-width: 100%;
	border-radius: 50px;
  border-top-right-radius: 50px; 
  border-top-left-radius: 50px; 
}

label {
  font-weight: bold; 
  font-size: 18px;   
}

/* Style for inputs */
input[type="text"],
input[type="password"] {
  width: 100%;       
  padding: 7px;     
  margin-bottom: 10px; 
}

button[type="submit"] {
  background-color: #0062cc; 
  color: white; 
  border: none; 
  padding: 10px 20px; 
  font-size: 16px; 
  border-radius: 5px; 
  cursor: pointer; 
}

/* Optional hover effect: */
button[type="submit"]:hover {
  background-color: #007bff ; 
}
    </style>
</head>
<body>


	<input type="hidden" id="editPwdStatus" 
value = "<%= session.getAttribute("editPwdStatus") %>">

  <div class="container">
  
       <div class="image">
      <img src="image1.jpg" alt="Welcome Image" id="image">
    </div>
  

	<div class="form">
	
      <div id="edit-profile-form">
        <h2>Change Your Password</h2>
		<form action="changePassword" method="post">
        <label for="oldPassword">Old Password:</label>
        <input type="password" id="oldPassword" name="oldPassword" required><br><br>
        
        <label for="newPassword">New Password:</label>
        <input type="password" id="newPassword" name="newPassword" required><br><br>
        
        <button type="submit">Submit</button>
    </form>
    
    <br>
    <br>
    <br>
    <br>
    <br>
	
	<a href="userPage.jsp"> Back to User Page </a> <br>
	

      </div>
    </div>
    

    

  </div>
    
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">
	
	<script type = "text/javascript">
	
	var status = document.getElementById("editPwdStatus").value;
	console.log(status);
	if(status == "success"){
		swal("Password changed successfully!")
	} else if(status == "same password"){
		swal("Old and new password can not be similar.")
	} else if(status == "failure"){
		swal("Something went wrong. Try again.", "Taken")
	} else if(status == "incorrect"){
		swal("Incorrect old password. Try again.")
	}
	</script>
</body>
</html>
