<%@ page import="java.util.*, model.Student" %>

<!DOCTYPE html>
<html>
<head>
<title>Student Management</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body class="container mt-5" style="background-image: linear-gradient(to right, #2e3192, #1bffff);">

<h1 class="text-center mb-4" style="color:yellow;">Student Management System</h1>
<h2 class="text-center mb-4" style="color:white;">Registered Students Lists</h2>

<div class="text-end mb-3">
<a href="add-student.html" class="btn btn-success">Add Student</a>
</div>

<table class="table table-bordered table-striped">

<tr class="table-dark">
<th>ID</th>
<th>Name</th>
<th>Email</th>
<th>Course</th>
<th>Phone</th>
<th>Action</th>
</tr>

<%
List<Student> list = (List<Student>) request.getAttribute("studentList");

if(list != null){
for(Student s : list){
%>

<tr>
<td><%= s.getId() %></td>
<td><%= s.getName() %></td>
<td><%= s.getEmail() %></td>
<td><%= s.getCourse() %></td>
<td><%= s.getPhone() %></td>

<td>
<a class="btn btn-danger btn-sm"
href="StudentServlet?action=delete&id=<%= s.getId() %>">
Delete
</a>
</td>
</tr>

<%
}
}
%>

</table>
<a href="index.html" class="btn btn-danger">Back to Home</a>

</body>
</html>