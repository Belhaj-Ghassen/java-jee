package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.GestionClubImp;
import Model.Groupe;
import Model.Membre;


@WebServlet("/ajouter")
public class ServAjout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServAjout() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int groupId = Integer.parseInt(request.getParameter("groupe_id")) ;
		String name = (String) request.getParameter("name");
		GestionClubImp gestion = new GestionClubImp();
		Groupe grp = gestion.getGbById(groupId);
		Membre m = new Membre(name, grp);
		gestion.addMembre(m);
		response.sendRedirect("/");
	}

}
