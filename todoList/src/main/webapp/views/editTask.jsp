<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Task</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            text-align: center;
        }
        h1 {
            margin-top: 30px;
        }
        form {
            width: 50%;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        label {
            display: block;
            text-align: left;
            margin-bottom: 5px;
        }
        input[type="text"],
        textarea,
        input[type="checkbox"],
        input[type="submit"] {
            width: calc(100% - 20px);
            padding: 10px;
            margin-bottom: 15px;
            border-radius: 3px;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #6a1b9a;
            color: white;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        input[type="submit"]:hover {
            background-color: #9c27b0;
        }
    </style>
</head>
<body>
    <h1>Edit Task</h1>
    
    <form action="/tasks/edit/${task.id}" method="post">
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" value="${task.title}" /><br/><br/>
        
        <label for="description">Description:</label>
        <textarea id="description" name="description">${task.description}</textarea><br/><br/>
        
        <label for="completed">Completed:</label>
        <input type="checkbox" id="completed" name="completed" ${task.completed ? 'checked' : ''} /><br/><br/>
        
        <input type="submit" value="Save Changes" />
    </form>
</body>
</html>
