<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Task Manager</title>
</head>
<body>
    <h2>Task List</h2>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Status</th>
            </tr>
        </thead>
        <tbody>
            <!-- Use JSTL to loop through tasks -->
            <c:forEach var="task" items="${tasks}">
                <tr>
                    <td>${task.id}</td>
                    <td>${task.name}</td>
                    <td>${task.description}</td>
                    <td>${task.status}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
