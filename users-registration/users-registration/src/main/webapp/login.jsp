<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

<title> Login </title>


<style>
.container {

  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  height: 500px;
  background-color: #e0e6ee; 
  padding: 50px;
  padding-bottom: 20px;
  margin: 35px 7%;
  margin-top: 100px;
  
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
  background-color: #0062cc; /* Dark blue */
  color: white; /* White text for contrast */
  border: none; /* Remove default border */
  padding: 10px 20px; /* Adjust padding as needed */
  font-size: 16px; /* Set a readable font size */
  border-radius: 5px; /* Optional: Add rounded corners */
  cursor: pointer; /* Indicate interactivity */
}

/* Optional hover effect: */
button[type="submit"]:hover {
  background-color: #007bff ; /* Slightly darker blue on hover */
}

</style>

</head>
<body>

<input type="hidden" id="status" 
value = "<%= request.getAttribute("status") %>">
<h1> QuestionBank</h1>

  <div class="container">
  
       <div class="image">
      <img src="image4.jpg" alt="Welcome Image" id="image">
    </div>
  

    <div class="form">
      <div id="login-form">
        <h2>LOGIN TO YOUR ACCOUNT </h2>
        <form action="login" method="post" onsubmit="">
          <label for="username">Username:</label>
          <input type="text" id="username" name="username" required><br>
          <label for="password">Password:</label>
          <input type="password" id="password" name="password" required><br>
          <button type="submit">Login</button>
        </form>
        <p>Don't have an account? <a href="signUp.jsp">Sign Up</a></p>
      </div>
    </div>
    

    

  </div>

  
  	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">
	
	<script type = "text/javascript">
	
	var status = document.getElementById("status").value;
	if(status == "failed"){
		swal("Sorry", "Wrong username or password", "failed")
	}
	</script>
</body>
</html>