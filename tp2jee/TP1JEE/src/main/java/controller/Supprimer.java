package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Gestiondb;
import model.Etudiant;


public class Supprimer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Gestiondb gest =new Gestiondb();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num=Integer.parseInt(request.getParameter("id"));
		gest.deleteEtudiant(num);
		List<Etudiant> Ls=gest.getAllEtudiants();
		request.setAttribute("List", Ls);
		request.getRequestDispatcher("Liste.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
