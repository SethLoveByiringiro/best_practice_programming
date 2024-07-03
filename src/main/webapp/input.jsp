<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Input Data</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f2f2f2; }
        h1 { color: #333; }
        form { background: #fff; padding: 20px; border-radius: 5px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }
        input[type="text"] { padding: 10px; margin: 10px 0; width: 100%; }
        input[type="submit"] { padding: 10px 20px; background: #1a73e8; border: none; color: #fff; border-radius: 5px; cursor: pointer; }
        input[type="submit"]:hover { background: #0c5cba; }
    </style>
</head>
<body>
<h1>Enter Data</h1>
<% if (request.getAttribute("error") != null) { %>
<p style="color: red;"><%= request.getAttribute("error") %></p>
<% } %>
<form method="POST" action="myservlet">
    Enter ID: <input type="text" name="id"><br>
    Enter Name: <input type="text" name="name"><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>