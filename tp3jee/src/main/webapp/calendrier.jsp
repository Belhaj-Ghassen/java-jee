<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Weekly Calendar</title>
	<%@ page import="java.util.List" %>
	<%@ page import="java.util.ArrayList" %>
	<%@ page import="Model.Groupe" %>
	<%@ page import="Model.Seance" %>
	<%@ page import="DAO.GestionClubImp" %>
	<%@ page import="java.time.DayOfWeek" %>
	<%@ page import="java.util.ArrayList" %>
 <%
	 List<DayOfWeek> daysOfWeek = new ArrayList<>();
	
	 daysOfWeek.add(DayOfWeek.MONDAY);
	 daysOfWeek.add(DayOfWeek.TUESDAY);
	 daysOfWeek.add(DayOfWeek.WEDNESDAY);
	 daysOfWeek.add(DayOfWeek.THURSDAY);
	 daysOfWeek.add(DayOfWeek.FRIDAY);
	 daysOfWeek.add(DayOfWeek.SATURDAY);
	 daysOfWeek.add(DayOfWeek.SUNDAY);
	 pageContext.setAttribute("weekDays", daysOfWeek);
 %>
<style>
  form {
        display: flex;
        align-items: center; 
    }
      div {
        display: flex;
        align-items: center; 
    }

    h4 {
        margin-right: 25px; 
    }
        table {
            border-collapse: collapse;
            width: 80%;
            margin: 0 auto;
        }

        th, td {
            border: 1px solid #ddd;
            text-align: center;
            padding: 8px;
        }

        th {
            background-color: #f2f2f2;
        }

        th.day {
            text-align: left;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
    </style>

</head>

<body>
	
	<form method="ServPrincipale" action="Get">
	<div>
	<h4>Groupes:</h4>
		<select name="id">
			<c:forEach var="gg" items="${allGroupes}">
    			<option value="${gg.idgp}">
					${ gg.nom }
				</option>
			</c:forEach>
			
		</select>
	</div>
		<input type="submit" value="search">
	</form>
	


    <h1>Weekly Calendar</h1>
    <table>
        <tr>
            <th></th>
            <th>Seance 1: 17:00 - 18:00</th>
            <th>Seance 2: 18:30 - 19:30</th>
            <th>Seance 3: 20:00 - 21:00</th>
        </tr>
       
    <c:forEach var="d" items="${weekdays}">
    <tr>
        <td><c:out value="${d}" /></td>
        
        <c:forEach var="s" items="${seances}">
            <td><c:out value="${seances.size()}" /></td>
            <c:choose>
                <c:when test="${s.jour == d.toString()}">
                    <c:set var="groupID" value="${s.grp.idgp}" />
                    <c:set var="capacity" value="${s.grp.capacite}" />
                    <c:set var="entraineur" value="${s.entraineur.nom}" />
                    <c:set var="tdContent">
                        Entraineur: ${entraineur}
                        <form method="get" action="/ajouter">
                            <input type="hidden" name="groupId" value="${groupID}">
                            <input type="submit" value="Adhesion">
                        </form>
                        Place Libre: <c:out value="${capacity}" />
                    </c:set>
                    <c:set var="i" value="${weekDays.indexOf(d)}" />
                    <c:set var="j" value="${seances.indexOf(s)}" />
                    <c:set target="${html[i]}" property="${j}" value="<td><c:out value='${tdContent}' /></td>" />
                </c:when>
                <c:when test="${ (s.jour != d) }">
                    <c:set var="i" value="${weekDays.indexOf(d)}" />
                    <c:set var="j" value="${seances.indexOf(s)}" />
                    <c:set target="${html[i]}" property="${j}" value="<td></td>" />
                </c:when>
            </c:choose>
        </c:forEach>
    </tr>
</c:forEach>




        
   
</table>


       
	
</body>
</html>