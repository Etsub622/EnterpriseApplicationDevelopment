<%
	if(session.getAttribute("username") ==null){
		response.sendRedirect("login.jsp");
	}

%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./CSS/index.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

<title> Your Profile </title>

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

<input type="hidden" id="editStatus" 
value = "<%= session.getAttribute("editStatus") %>">

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="subject.jsp">AdminPanel</a>
  </div>
</nav>

<h3> Welcome, <%= session.getAttribute("username") %>!</h3>

  <div class="container">
  
       <div class="image">
      <img src="image1.jpg" alt="Welcome Image" id="image">
    </div>
  

	<div class="form">
	
      <div id="edit-profile-form">
        <h2>EDIT YOUR PROFILE</h2>
     <form action="AdminEdit" method="post" onsubmit="">
      <label for="name">Change Your Name: </label>
      <input type="text" id="name" name="name" value="<%= session.getAttribute("name") %>"><br>
      <label for="username">Change Your Username:</label>
      <input type="text" id="username" name="username" value="<%= session.getAttribute("username") %>"> <br>
      <button type="submit">Submit</button>
    </form>
    
    <br>
    <br>
    <br>
    <br>
    <br>
	
	<a href="changePassword.jsp"> Change Your Password </a> <br>
	<a href="logout" onclick="return confirm('Are you sure you want to log out?')">Logout</a> <br>
	<a href="deleteaccount" onclick="return confirm('Are you sure you want to delete your account? This action cannot be undone.')">Delete Your Profile</a>

      </div>
    </div>
    
  </div>
	
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">
	
	<script type = "text/javascript">	
	var status = document.getElementById("editStatus").value;
	console.log(status);
	if(status == "success"){
		swal("Username changed successfully.", "Success")
	} else if(status == "taken"){
		swal("Username already taken", "Try a different name.")
	} else if(status == "failed"){
		swal("Something went wrong. Try again.", "Taken")
	}
	setTimeout(function() {
        swal.close();
    }, 2000);
	</script>

</body>
</html>