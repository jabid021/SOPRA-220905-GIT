package ajc.sopra.eshop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//l'objet qui permet de charger une page
		RequestDispatcher rd=null;
		if(request.getParameter("login")==null||request.getParameter("login").isEmpty()) {
			//probleme renvoyer vers formulaire
			rd=request.getRequestDispatcher("/WEB-INF/login.jsp");
			request.setAttribute("erreur", true);
		}else {
			//ok renvoyer vers la page qui nous dit bonjour
			rd=request.getRequestDispatcher("/WEB-INF/bonjour.jsp");
			request.setAttribute("monLogin", request.getParameter("login"));
		}
		//partir vers la bonne vue
		rd.forward(request, response);
	}

}
