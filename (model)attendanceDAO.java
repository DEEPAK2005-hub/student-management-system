package model;

import java.sql.*;
import java.time.LocalDate;

public class AttendanceDAO {

public static void saveAttendance(int studentId, String status){

try{

Connection conn = DBConnection.getConnection();

PreparedStatement ps = conn.prepareStatement(
"insert into attendance(student_id,date,status) values(?,?,?)");

ps.setInt(1, studentId);

ps.setDate(2, Date.valueOf(LocalDate.now()));

ps.setString(3, status);

ps.executeUpdate();

}catch(Exception e){

e.printStackTrace();

}

}

}