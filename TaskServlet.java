package Project;



import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.sql.*;
import java.util.*;

public class TaskServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        List<Task> taskList = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM tasks";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // Collect tasks in a list
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String status = rs.getString("status");

                Task task = new Task(id, name, description, status);
                taskList.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("<h2>Error fetching tasks:</h2>");
        }

        // Set the tasks as a request attribute to be accessed in JSP
        request.setAttribute("tasks", taskList);

        // Forward to the JSP page to display tasks
        RequestDispatcher dispatcher = request.getRequestDispatcher("tasks.jsp");
        dispatcher.forward(request, response);
    }
}
