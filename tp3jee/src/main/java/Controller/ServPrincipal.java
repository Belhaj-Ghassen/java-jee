package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Groupe;
import DAO.GestionClubImp;
import Model.Seance;


@WebServlet("/home")
public class ServPrincipal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServPrincipal() {
        super();
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int grpId = 3;
		if(request.getParameter("id") != null) {
				grpId = Integer.parseInt(request.getParameter("id"));
		}
		System.out.println(grpId);
		GestionClubImp gestion = new GestionClubImp();
		Groupe grp = gestion.getGbById(grpId);
		List<Seance>  list = gestion.getSeanceById(grpId);
		System.out.print("size="+list.size());
		List<Groupe>  allGroupes = gestion.getAllGroupe();
		
		request.setAttribute("seances", list);
		request.setAttribute("currentGroup", grp);
		request.setAttribute("allGroupes", allGroupes);
		RequestDispatcher rd = request.getRequestDispatcher("calendrier.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
