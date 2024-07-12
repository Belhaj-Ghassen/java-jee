<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion des Etudiants</title>
</head>
<body>
<h1>Entrer votre identité</h1>
<form action="Verification" method="post">
<label for="user">Utilisateur:</label>
<input type="text" name="user" required><br><br>
<label for="pass">Mot de passe:</label>
<input type="password" name="pass" required><br><br>
<input type="submit" value="se connecter">
</form>
</body>
</html>