package ajc.sopra.eshop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ajc.sopra.eshop.config.JpaConfig;
import ajc.sopra.eshop.model.Produit;
import ajc.sopra.eshop.service.ProduitService;

/**
 * Servlet implementation class ProduitContrioller
 */
@WebServlet("/produit")
public class ProduitController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AnnotationConfigApplicationContext ctx;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProduitController() {
		super();
	}

	@Override
	public void init() throws ServletException {
		ctx = (AnnotationConfigApplicationContext) this.getServletContext().getAttribute("springCtx");

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String query = request.getParameter("query");
		RequestDispatcher rd = null;
		if (query == null || query.isBlank()) {
			// on veut lister les produits
			rd = list(request, response);
		} else if (query.equals("delete")) {
			// on veut supprimer un produit
			rd = delete(request, response);
		} else if (query.equals("edit")) {
			rd = edit(request, response);
		} else if (query.equals("save")) {
			rd = save(request, response);
		} else if (query.equals("add")) {
			rd = add(request, response);
		}
		rd.forward(request, response);
	}

	private RequestDispatcher add(HttpServletRequest request, HttpServletResponse response) {
		return request.getRequestDispatcher("/WEB-INF/produit/edit.jsp");
	}

	private RequestDispatcher save(HttpServletRequest request, HttpServletResponse response) {
		ProduitService produitService = ctx.getBean(ProduitService.class);
		String libelle = request.getParameter("libelle");
		double prix = Double.parseDouble(request.getParameter("prix"));

		if (request.getParameter("id") == null || request.getParameter("id").isBlank()) {
			produitService.create(new Produit(libelle, prix));
		} else {

			produitService.update(new Produit((Integer.parseInt(request.getParameter("id"))), libelle, prix));
		}
		return list(request, response);
	}

	private RequestDispatcher list(HttpServletRequest request, HttpServletResponse response) {
		ProduitService produitService = ctx.getBean(ProduitService.class);
		request.setAttribute("produits", produitService.findAll());
		return request.getRequestDispatcher("/WEB-INF/produit/produits.jsp");
	}

	private RequestDispatcher delete(HttpServletRequest request, HttpServletResponse response) {
		ProduitService produitService = ctx.getBean(ProduitService.class);
		produitService.deleteId(Integer.parseInt(request.getParameter("id")));
		return list(request, response);
	}

	private RequestDispatcher edit(HttpServletRequest request, HttpServletResponse response) {
		ProduitService produitService = ctx.getBean(ProduitService.class);
		request.setAttribute("produit", produitService.findById(Integer.parseInt(request.getParameter("id"))));
		return request.getRequestDispatcher("/WEB-INF/produit/edit.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
