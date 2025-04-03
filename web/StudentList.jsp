
<%@page import="com.nsbm.model.Student"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student List</title>
</head>
<body>
    <h2>Student List</h2>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Course</th>
            <th>Email</th>
        </tr>

        <%
            // Retrieve the list of students from the request attribute
            List<Student> students = (List<Student>) request.getAttribute("studentMap");

            // Check if the list is not null and not empty
            if (students != null && !students.isEmpty()) {
                // Loop through the list of students
                for (Student student : students) {
        %>
        <tr>
            <td><%= student.getId() %></td>
            <td><%= student.getName() %></td>
            <td><%= student.getCourse() %></td>
            <td><%= student.getEmail() %></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="4">No students found</td>
        </tr>
        <%
            }
        %>
    </table>

</body>
</html>
