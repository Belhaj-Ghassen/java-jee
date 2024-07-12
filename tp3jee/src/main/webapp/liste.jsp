<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Membres</title>
<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            text-align: center;
        }

        h1 {
            color: #333;
        }

        table {
            border-collapse: collapse;
            width: 80%;
            margin: 0 auto;
        }

        table, th, td {
            border: 1px solid #333;
        }

        th, td {
            padding: 8px;
            text-align: center;
        }

        th {
            background-color: #333;
            color: #fff;
        }

        form {
            display: inline; /* Align the form elements horizontally */
        }

        /* Styling for the "Delete" button */
        input[type="submit"] {
            background-color: #d9534f;
            color: #fff;
            border: none;
            padding: 5px 10px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #c9302c;
        }
    </style>
</head>
<%@ page import="Model.Membre" %>
<%@ page import="DAO.GestionClubImp" %>
<%@ page import="java.util.List" %>

<%	
	GestionClubImp gestion = new GestionClubImp();
	int grpid = (int)request.getAttribute("grp_id");
	List<Membre> membres = gestion.getAllMembreByGp(grpid);
	pageContext.setAttribute("allMembers", membres);
%>
<body>
    <h1>Members</h1>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>NOM</th>
                <th>ACTION</th>
            </tr>
        </thead>
        <tbody>
            <c:choose>
                <c:when test="${!allMembers.isEmpty()}">
                    <c:forEach var="m" items="${allMembers}">
                        <tr>
                            <td>${m.idm}</td>
                            <td>${m.nom}</td>
                            <td>
                                <form action="delete" method="post">
                                    <input type="hidden" name="grp_id" value="${grp_id}">
                                    <input type="hidden" name="member_id" value="${m.idm}">
                                    <input type="submit" value="Delete">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:when test="${allMembers.isEmpty()}">
                    <tr>
                        <td colspan="3">There are no members for this group</td>
                    </tr>
                </c:when>
            </c:choose>
        </tbody>
    </table>
</body>
</html>