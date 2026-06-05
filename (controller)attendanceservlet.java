package controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

import model.AttendanceDAO;

@WebServlet("/AttendanceServlet")

public class AttendanceServlet extends HttpServlet {

protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {

try{

String[] studentIds = request.getParameterValues("studentId");

for(String id : studentIds){

String status = request.getParameter("status_" + id);

AttendanceDAO.saveAttendance(Integer.parseInt(id), status);

}

response.sendRedirect("index.html");

}catch(Exception e){

e.printStackTrace();

}

}

}