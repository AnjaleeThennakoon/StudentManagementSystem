/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsbm.dao;

import com.nsbm.model.Student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anjal
 */
public class studentdao {
    private final  String jdbcURL = "jdbc:mysql://localhost:3307/studentdb";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "";

    public void insertStudent(Student student) throws SQLException, ClassNotFoundException {
        String insertQuery = "INSERT INTO students (name, email, course) VALUES (?, ?, ?)";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (
            
             Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setString(3, student.getCourse());

            int rowInserted = preparedStatement.executeUpdate();
            if (rowInserted > 0) {
                System.out.println("Student successfully added.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Student> listStudents() {
        List<Student> students = new ArrayList<>();
        String selectQuery = "SELECT * FROM Students";

        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id")); // Assuming 'id' is a column in your table
                student.setName(resultSet.getString("name"));
                student.setEmail(resultSet.getString("email"));
                student.setCourse(resultSet.getString("course"));
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }
    }
 
