package controller;

import java.io.IOException;

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sn.isi.dao.inter.ICompteLocal;
import sn.isi.entities.Compte;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(value = "/Login", name = "Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ICompteLocal ic_dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/login.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String action = request.getParameter("action");
		
		if (action.equals("signup")) {
		 	String username = request.getParameter("username");
		    String password = request.getParameter("password");



		    Compte compte = ic_dao.findByUsernameAndPassword(username, password);


		    if (compte != null){
		        Compte c = ic_dao.findByCompte(compte);
		        HttpSession session = request.getSession();
		        session.setAttribute("c", c);
		        response.sendRedirect(request.getContextPath() +"/index.jsp	");

		    }
		    else{

		        String errorMsg = "Une erreur c'est produit lors de l'inscription" + " | " ;

		        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/login.jsp");
		        dispatcher.forward(request, response);
		    }
		}

		    }
	}


