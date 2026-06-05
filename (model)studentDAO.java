package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.*;

public class StudentDAO {

    public static boolean addStudent(Student student) {

        boolean status = false;

        try {

            Connection conn = DBConnection.getConnection();

            String query = "INSERT INTO student(name,email,course,phone) VALUES (?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getCourse());
            ps.setString(4, student.getPhone());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
    public List<Student> getAllStudents() {

        List<Student> students = new ArrayList<>();

        try {

            Connection conn = DBConnection.getConnection();

            String query = "SELECT * FROM student";

            PreparedStatement ps = conn.prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            System.out.println("Fetching students...");
            while(rs.next()) {
                System.out.println("Student Found: " + rs.getString("name"));

                Student s = new Student();

                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setCourse(rs.getString("course"));
                s.setPhone(rs.getString("phone"));

                students.add(s);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return students;
    }
    public boolean deleteStudent(int id) {

        boolean status = false;

        try {

            Connection conn = DBConnection.getConnection();

            String query = "DELETE FROM student WHERE id=?";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, id);

            status = ps.executeUpdate() > 0;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}