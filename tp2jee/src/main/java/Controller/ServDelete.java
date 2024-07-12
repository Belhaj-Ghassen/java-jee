package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.GestionClubImp;


@WebServlet("/delete")
public class ServDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int membreId = Integer.parseInt(request.getParameter("member_id")) ;
		GestionClubImp gestion = new GestionClubImp();
		gestion.deleteMembreById(membreId);
		String grp_id = request.getParameter("grp_id");
;		response.sendRedirect("/tp2/liste?id="+grp_id);
	}

}
