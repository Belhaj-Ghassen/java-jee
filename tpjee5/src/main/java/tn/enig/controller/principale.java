package tn.enig.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.enig.dao.GestionDaoImpl;
import tn.enig.model.hotel;

/**
 * Servlet implementation class principale
 */
public class principale extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public principale() {
        super();
        // TODO Auto-generated constructor stub
    }
GestionDaoImpl gest=new GestionDaoImpl();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<hotel>h=gest.GetAllhotel();
		request.setAttribute("h", h);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
