package controller;

import java.io.IOException;

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sn.isi.dao.impl.CVImpl;
import sn.isi.dao.inter.IcvLocal;
import sn.isi.entities.CV;

/**
 * Servlet implementation class CreateCVServlet
 */
@WebServlet(value = "/CreateCV", name = "CreateCV")
public class CreateCVServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IcvLocal icv_dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCVServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/registration.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String action = request.getParameter("action");
		
		if (action.equals("Enregistrer")) {
			
			String prenom = request.getParameter("prenom");
	        String nom = request.getParameter("nom");
	        String email = request.getParameter("email");
	        String adresse = request.getParameter("adresse");
	        int age = Integer.parseInt(request.getParameter("age"));
	        int telephone = Integer.parseInt(request.getParameter("telephone"));
	        String niveauetude = request.getParameter("niveauetude");
	        String expeprof = request.getParameter("expeprof");
	        String specialite = request.getParameter("specialite");
	        
	        
	        
	        CV cv = new CV();
			  cv.setPrenom(prenom);
			  cv.setNom(nom);
			  cv.setEmail(email);
			  cv.setAdresse(adresse);
			  cv.setAge(age);
			  cv.setTelephone(telephone);
			  cv.setNiveauetude(niveauetude);
			  cv.setExpeprof(expeprof);
			  cv.setSpecialite(specialite);
			  
			  this.icv_dao.add(cv);
			  
			  request.setAttribute("students", icv_dao.liste());
			  
			  request.getRequestDispatcher("createcompte.jsp").forward(request, response);
			
			
			
		}else  {
        	
        	request.getRequestDispatcher("index.jsp").forward(request, response);
        	
        }
		
		




        
        
	}

}
