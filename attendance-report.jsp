<%@ page import="java.sql.*,model.DBConnection" %>

<!DOCTYPE html>
<html>
<head>

<title>Attendance Report</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

<style>

body{
background:#f4f6f9;
}

.card{
border-radius:12px;
}

</style>

</head>

<body class="container mt-5">

<h2 class="text-center mb-4">Attendance Report (Today)</h2>

<%

Connection conn = DBConnection.getConnection();

PreparedStatement ps = conn.prepareStatement(
"SELECT * FROM attendance WHERE date = CURDATE() ORDER BY time DESC");

ResultSet rs = ps.executeQuery();

String lastTime = "";

while(rs.next()){

String currentTime = rs.getTimestamp("time").toString();

if(!currentTime.equals(lastTime)){
%>

<div class="card shadow mb-4">

<div class="card-header bg-dark text-white">

Attendance Session: <%=currentTime%>

</div>

<table class="table table-bordered m-0">

<tr class="table-secondary">

<th>Student ID</th>
<th>Status</th>
<th>Date</th>

</tr>

<%
}

%>

<tr>

<td><%=rs.getInt("student_id")%></td>
<td>

<%
String status = rs.getString("status");

if(status.equals("Present")){
%>

<span class="badge bg-success">Present</span>

<%
}else{
%>

<span class="badge bg-danger">Absent</span>

<%
}
%>

</td>

<td><%=rs.getDate("date")%></td>

</tr>

<%

lastTime = currentTime;

}

%>

</table>

</div>

<a href="index.html" class="btn btn-primary mt-3">Back to Dashboard</a>

</body>
</html>