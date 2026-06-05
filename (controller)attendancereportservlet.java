package controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

import model.Attendance;
import model.AttendanceDAO;

@WebServlet("/AttendanceReportServlet")

public class AttendanceReportServlet extends HttpServlet {

protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {

AttendanceDAO dao = new AttendanceDAO();

List<Attendance> list = dao.getTodayAttendance();

request.setAttribute("attendanceList", list);

RequestDispatcher rd = request.getRequestDispatcher("attendance-report.jsp");

rd.forward(request, response);

}

}