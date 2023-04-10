package controller;

import java.io.IOException;

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sn.isi.dao.inter.ICompteLocal;
import sn.isi.entities.Compte;

/**
 * Servlet implementation class CreateCompteServlet
 */
@WebServlet(value = "/CreateCompte", name = "CreateCompte")
public class CreateCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ICompteLocal ic_dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCompteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/createcompte.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
String action = request.getParameter("action");
		
		if (action.equals("Enregistrer")) {
			
			String username = request.getParameter("username");
	        String password = request.getParameter("password");
	
	        
	        
	        Compte compte = new Compte();
	        compte.setUsername(username);
			  compte.setPassword(password);
			  
			  this.ic_dao.add(compte);
			  
			  request.setAttribute("students", ic_dao.liste());
			  
			  request.getRequestDispatcher("/login.jsp").forward(request, response);
			
			
			
		}else  {
        	
        	request.getRequestDispatcher("index.jsp").forward(request, response);
        	
        }
		
	}

}
