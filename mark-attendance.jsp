<%@ page import="java.util.*,model.Student" %>

<!DOCTYPE html>

<html>

<head>

<title>Mark Attendance</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

<style>

body{
background:#f4f6f9;
}

.card{
border-radius:12px;
}

.table{
background:white;
border-radius:10px;
overflow:hidden;
}

.btn-present{
width:90px;
}

.btn-absent{
width:90px;
}

</style>

</head>

<body class="container mt-5">

<div class="card shadow p-4">

<h2 class="text-center mb-4">Mark Attendance</h2>

<form action="AttendanceServlet" method="post">

<table class="table table-bordered text-center align-middle">

<tr class="table-dark">

<th>ID</th>
<th>Name</th>
<th>Attendance</th>

</tr>

<%

List<Student> students=(List<Student>)request.getAttribute("studentList");

for(Student s:students){

%>

<tr>

<td><%=s.getId()%></td>

<td><%=s.getName()%></td>

<td>

<input type="hidden" name="status_<%=s.getId()%>" id="status_<%=s.getId()%>" value="Present">

<input type="hidden" name="studentId" value="<%=s.getId()%>">

<button type="button"
class="btn btn-success btn-sm btn-present"
onclick="setStatus(<%=s.getId()%>,'Present',this)">

Present

</button>

<button type="button"
class="btn btn-danger btn-sm btn-absent"
onclick="setStatus(<%=s.getId()%>,'Absent',this)">

Absent

</button>

</td>

</tr>

<%

}

%>

</table>

<div class="text-center">

<button class="btn btn-primary px-4">Submit Attendance</button>

</div>

</form>

</div>

<script>

function setStatus(id,status,btn){

document.getElementById("status_"+id).value=status;

var row=btn.parentElement;

var buttons=row.querySelectorAll("button");

buttons.forEach(b=>b.classList.remove("btn-warning"));

btn.classList.add("btn-warning");

}

</script>

</body>

</html> 