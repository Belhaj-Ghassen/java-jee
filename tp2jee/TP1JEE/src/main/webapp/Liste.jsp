<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
<%@ page import ="model.Etudiant" %>
    
<!DOCTYPE html>
<html>
<head>
    <title>Liste des �tudiants</title>
</head>
<body>
    <h1>Liste des �tudiants</h1>

    <table border="1" style="border-color: red;">
        <tr>
            <th>Nom</th>
            <th>Pr�nom</th>
            <th>T�l�phone</th>
            <th>Action</th>
        </tr>
        <% ArrayList<Etudiant> le= (ArrayList<Etudiant>) request.getAttribute("List"); %>
        <%
            for (Etudiant etd : le) {
        %>
            <tr>
                <td><%= etd.getNom() %></td>
                <td><%= etd.getPrenom() %></td>
                <td><%= etd.getNumerotelephone() %></td>
               <td><a href="Supprimer?id=<%=etd.getNumero()%>">Supprimer</a></td>
            </tr>
        <%
            }
        %>
    </table>

    <h2>Ajouter un �tudiant :</h2>
    <form action="Ajouter" method="post">
        <label for="num">Num�ro:</label>
        <input type="text" id="numero" name="num" required><br>

        <label for="nom">Nom:</label>
        <input type="text" id="nom" name="nom" required><br>

        <label for="prenom">Pr�nom:</label>
        <input type="text" id="prenom" name="prenom" required><br>

        <label for="numtel">T�l�phone:</label>
        <input type="text" id="tel" name="numtel" required><br>

        <input type="submit" value="Enregistrer">
    </form>
</body>
</html>