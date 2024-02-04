<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./CSS/index.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

<style>
  .username {
    color: green;
  }

  /* Adjustments */
  .search-bar {
    margin-bottom: 20px; /* Add margin to create space between the search bar and the paragraph */
  }

  .form-control {
    width: 100%; /* Make the input field 100% width */
  }

  .center-content {
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
  }

  .center-content .container {
    max-width: 600px; /* Adjust as needed */
  }

  /* Styling for QuestionBank text */
  .question-bank {
    font-size: 2.5rem; /* Adjust font size */
    color: rgba(118, 213, 226, 1.00); /* Set the color */
    text-align: center; /* Align text center */
  }
</style>

<title>Question Bank-Home </title>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container">
    <a class="navbar-brand" href="#">Home</a>
    <ul class="navbar-nav ms-auto">
      <li class="nav-item">
        <a href="userPage.jsp" class="nav-link username"><%= session.getAttribute("username") %></a>
      </li>
    </ul>
  </div>
</nav>

<div class="center-content">
  <div class="container">
    <h1 class="question-bank">QuestionBank</h1> <!-- Use h1 for QuestionBank with custom styling -->
    <form action="searchResults.jsp" method="GET" class="search-bar">
      <div class="input-group">
        <input name="subject" class="form-control me-2" type="search" placeholder="Search subjects..." aria-label="Search">
        <div class="input-group-append">
          <button class="btn btn-outline-success" type="submit">Search</button>
        </div>
      </div>
    </form> 

    <div class="mt-3 text-center">
      <p>see subject? <a href="userSelection.jsp">here:</a></p>
    </div>
  </div>
</div>

</body>
</html>
