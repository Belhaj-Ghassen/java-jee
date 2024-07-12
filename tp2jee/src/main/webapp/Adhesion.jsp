<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajout</title>
<head>
    <meta charset="UTF-8">
    <title>Adhésion</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            text-align: center;
        }

        h1 {
            color: #333;
        }

        form {
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 5px;
            padding: 20px;
            width: 300px;
            margin: 0 auto;
        }

        span {
            display: block;
            text-align: left;
        }

        input[type="hidden"], input[type="text"] {
            width: 200;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"] {
            background-color: #337ab7;
            color: #fff;
            border: none;
            padding: 10px 15px;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #286090;
        }
    </style>
</head>
<body>
    <h1>Adhésion des membres</h1>
    <form  method="post" action="ajouter">
        <span>Groupe <%= request.getParameter("groupe_id") %></span>
        <span for="member_name">Membre:</span>
        <input type="hidden" name="groupe_id" value="<%= request.getParameter("groupe_id")  %>">
        <input type="text" id="member_name" name="name">
        <input type="submit" value="Valider">
    </form>
</body>
</html>



