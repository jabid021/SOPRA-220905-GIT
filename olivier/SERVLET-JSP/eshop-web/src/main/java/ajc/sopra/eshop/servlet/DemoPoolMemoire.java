package ajc.sopra.eshop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DemoPoolMemoire
 */
@WebServlet("/demo")
public class DemoPoolMemoire extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoPoolMemoire() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//donnee qui n'existe que le temps de la requete
		request.setAttribute("infoDansLaRequete", "info dans la requete");
		
		//session espace memoire propre à chaque utilisateur
		HttpSession session=request.getSession();
		session.setAttribute("infoDansLaSession", "info dans la session");
		
		//espace commun sur le serveur
		request.getServletContext().setAttribute("infoSurLeServeur", "info commune");
		
		request.getRequestDispatcher("/WEB-INF/demo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
		doGet(request, response);
	}

}
