package controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

import model.Student;
import model.StudentDAO;

@WebServlet("/AttendancePageServlet")

public class AttendancePageServlet extends HttpServlet {

protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {

	StudentDAO dao = new StudentDAO();
	List<Student> students = dao.getAllStudents();
request.setAttribute("studentList", students);

RequestDispatcher rd = request.getRequestDispatcher("mark-attendance.jsp");

rd.forward(request, response);

}

}