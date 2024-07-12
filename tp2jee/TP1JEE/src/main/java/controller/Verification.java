package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Gestiondb;
import model.Etudiant;


public class Verification extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Gestiondb gest =new Gestiondb();
    public Verification() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("user");
		String password=request.getParameter("pass");
		if(gest.verif(username, password)) {
			List<Etudiant> LE =gest.getAllEtudiants();
			request.setAttribute("List", LE);
			request.getRequestDispatcher("Liste.jsp").forward(request, response);
		}else {
			response.sendRedirect("Authentification.jsp");
		}
		

	}

}
