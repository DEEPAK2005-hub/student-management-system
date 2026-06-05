package controller;

import model.Student;
import model.StudentDAO;
import java.util.*;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");
        String phone = request.getParameter("phone");

        Student student = new Student();

        student.setName(name);
        student.setEmail(email);
        student.setCourse(course);
        student.setPhone(phone);

        boolean result = StudentDAO.addStudent(student);

        if (result) {
        	response.sendRedirect("StudentServlet");
        	} else {
            response.getWriter().println("Error Adding Student");
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        StudentDAO dao = new StudentDAO();

        if ("delete".equals(action)) {

            int id = Integer.parseInt(request.getParameter("id"));

            dao.deleteStudent(id);

            response.sendRedirect("StudentServlet");

        } else {

            List<Student> students = dao.getAllStudents();

            request.setAttribute("studentList", students);

            RequestDispatcher rd = request.getRequestDispatcher("view-students.jsp");

            rd.forward(request, response);
        }
    }
}