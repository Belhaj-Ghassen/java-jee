<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
				<% 
					GestionClubImp gestion = new GestionClubImp();
					List<Seance> seances =  (List<Seance>)request.getAttribute("seances");
					System.out.println("fist session" + seances.get(0));
					Groupe grp = (Groupe)request.getAttribute("currentGroup");
					List<Groupe> groupes = (List<Groupe>)request.getAttribute("allGroupes");
					pageContext.setAttribute("allGroupes", groupes); 
					pageContext.setAttribute("seances", seances);
					pageContext.setAttribute("currentGroupe", grp);
				%>
	<form method="get" action="home">
		<select name="id">
		
			<c:forEach var="grp" items="${allGroupes}">
    			<option value="${grp.idgp}">
					${ grp.nom }
				</option>
			</c:forEach>
			
		</select>
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
        <%	
        	
			List<String> weekDays = new ArrayList<String>();
			weekDays.add("Monday");
			weekDays.add("Tuesday");
			weekDays.add("Wednesday");
			weekDays.add("Thursday");
			weekDays.add("Friday");
			weekDays.add("Saturday");
			weekDays.add("Sunday");
			pageContext.setAttribute("weekdays", weekDays);
			String[][] html = new String[7][3];
			for (int i = 0; i < 7; i++) {
			    for (int j = 0; j < 3; j++) {
			        html[i][j] = "<td></td>";
			    }
			}
			pageContext.setAttribute("html", html);
		%>
			
			
		   <c:forEach var="d" items = "${weekdays}">
		   		<c:forEach var="s" items = "${ seances }">
		   			<% 
		   				Seance s = (Seance)pageContext.getAttribute("s"); 
		   				String d = (String)pageContext.getAttribute("d");
		   				System.out.println("id seance"+s.getIds());
		   				System.out.println("day:"+d);
		   			%>
		   			<c:if test = "${s.jour == d}">
		   			<%
		   				int i = weekDays.indexOf(d);
		   				int j = Integer.parseInt(s.getNums())-1;
		   				
		   				String colText = "Entraineur: " + s.getEntraineur().getNom();
		   				colText += "<hr>";
		   				colText += "<a href=liste?id="+s.getGrp().getIdgp()+">Gp"+s.getGrp().getIdgp();
		   				colText += s.getGrp().getNom() + "</a>";
		   				colText += "<hr>";
		   				colText += "<form method=\"get\" action=\"Adhesion.jsp\">";
		   				colText += "<input type=\"hidden\" name=\"groupe_id\" value=\"" + s.getGrp().getIdgp() + "\">";
		   				colText += "<input type=\"submit\" value=\"Adhesion\"></form>";

		   						
		   						
		   				html[i][j] = "<td>"+colText+"</td>";
		   				
		   			%>
		   			
		   			</c:if>
		   		</c:forEach>
		   </c:forEach>	
 		   		
 		   		<%
		 		   	for (int i = 0; i < 7; i++) { %>
		 		   		<%= "<tr><td>Day Name</td>"%>
					    <%for (int j = 0; j < 3; j++) { %>
					    	
					        <%= html[i][j] %> 
					        
					        
					        <%
					    } %>
					    <%= "</tr>"%>
					    <%
					}
 		   		%>
				
 		 

        
   
</table>


       

	
</body>
</html>