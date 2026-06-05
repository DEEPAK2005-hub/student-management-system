package controller;

import java.io.IOException;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.DBConnection;

@WebServlet("/LoginServlet")

public class LoginServlet extends HttpServlet {

protected void doPost(HttpServletRequest request,HttpServletResponse response)
throws ServletException,IOException{

String username=request.getParameter("username");
String password=request.getParameter("password");

try{

Connection conn=DBConnection.getConnection();

PreparedStatement ps=conn.prepareStatement(
"select * from faculty where username=? and password=?");

ps.setString(1,username);
ps.setString(2,password);

ResultSet rs=ps.executeQuery();

if(rs.next()){

response.sendRedirect("index.html");

}else{

response.getWriter().println("Invalid Login");

}

}catch(Exception e){

e.printStackTrace();

}

}

}