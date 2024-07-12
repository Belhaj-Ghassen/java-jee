package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Gestiondb;
import model.Etudiant;

public class Ajouter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Gestiondb gest =new Gestiondb();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int num=Integer.parseInt(request.getParameter("num"));
		 String nom=request.getParameter("nom");
		 String prenom=request.getParameter("prenom");
		 String numtel=request.getParameter("numtel");
		 Etudiant etd=new Etudiant(num,nom,prenom,numtel);
		 gest.addEtudiant(etd);
		 List<Etudiant> L=gest.getAllEtudiants();
		 request.setAttribute("L", L);
		 request.getRequestDispatcher("Liste.jsp").forward(request, response);

		 

	}

}
