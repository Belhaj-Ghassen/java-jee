package Controller;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.GestionClubImp;
import Model.Membre;


@WebServlet("/liste")
public class ServListe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServListe() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id != null) {
			int grpId = Integer.parseInt(id);
			GestionClubImp gestion = new GestionClubImp();
			List<Membre>  list = gestion.getAllMembreByGp(grpId);
			request.setAttribute("memberList", list);
			request.setAttribute("grp_id", grpId);
			RequestDispatcher rd = request.getRequestDispatcher("/liste.jsp");
			rd.forward(request, response);
		}else {
			response.sendRedirect("/tp2/liste?id=1");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	}

}
