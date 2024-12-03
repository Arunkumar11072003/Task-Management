<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Task Manager</title>
</head>
<body>
    <h1>Welcome to the Task Manager</h1>
    <form action="TaskServlet" method="POST">
        <input type="text" name="name" placeholder="Task Name" required><br>
        <textarea name="description" placeholder="Task Description" required></textarea><br>
        <select name="status">
            <option value="pending">Pending</option>
            <option value="completed">Completed</option>
        </select><br>
        <input type="submit" value="Add Task">
    </form>
    <br><br>
    <a href="tasks.jsp">View All Tasks</a>
</body>
</html>


