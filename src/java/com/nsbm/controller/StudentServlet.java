/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsbm.controller;

import com.nsbm.dao.studentdao;
import com.nsbm.model.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author anjal
 */
@WebServlet(name = "StudentServlet", urlPatterns = {"/StudentServlet"})
public class StudentServlet extends HttpServlet {

   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
    }

    
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    String name = request.getParameter("name"); 
    String email = request.getParameter("email");
    String course = request.getParameter("course");
         System.out.println(name+email+course);
       

   
    // Initialize DAO object
    studentdao studentDAO = new studentdao();
    Student student = new Student();
    student.setName(name);
    student.setEmail(email);
    student.setCourse(course);

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/studentdb", "root", "");
            String sql = "INSERT INTO students (name, email, course) VALUES (?, ?, ?)";
            if(connection != null){
                System.out.println("connection not null");
            }else{
                System.out.println("conenction null");
            }
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2,email);
            statement.setString(3, course);
            int rowsInserted = statement.executeUpdate();
            
            System.out.println("row effected" +  rowsInserted);
            connection.close();

    } catch (Exception e) {
        e.printStackTrace();
        request.setAttribute("message", "Error adding student.");
    }
    List<Student> students = getStudent();
request.setAttribute("studentMap", students);
    
    // Forward to JSP
    request.getRequestDispatcher("StudentList.jsp").forward(request, response);
}

public List<Student> getStudent(){
      List<Student> students = new ArrayList<>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/studentdb", "root", "");
               String sql = "SELECT * FROM students";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
 
 while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setCourse(rs.getString("course"));
                student.setEmail(rs.getString("email"));

                students.add(student);
            }
            
 

            
        } catch (Exception e) {
            System.out.println("error"+e.getMessage());
        }
      return students; 
}

}
