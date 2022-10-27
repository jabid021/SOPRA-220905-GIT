package ajc.sopra.formationweb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
//permet de definir l'url d'appel de la servlet
@WebServlet({"/FirstServlet","/firstServlet","/firstservlet"})
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public FirstServlet() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response=>l'objet pour aller du serveur au client
		// getWriter()=>recuperation d'un flux de type caractere pour envoyer des
		// données
		// append()=>ajout de données dans le flux
		// request=>l'objet pour aller du client au serveur
		// getContextPath()=>le nom de deploiment du projet (pour l'instant c'est
		// formation-web)

		
		String prenom=request.getParameter("prenom");
		// @formatter:off
		response.getWriter()
					.append("<!DOCTYPE html>")
					.append("<html>")
					.append("<head><title>servlet</title></head>")
					.append("<body>")
					.append("<h1>hello "+prenom+"</h1>")
					.append("</body>")
					.append("</html>");
		// @formatter:on

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
