package ajc.sopra.eshop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ajc.sopra.eshop.exception.FournisseurException;
import ajc.sopra.eshop.model.Adresse;
import ajc.sopra.eshop.model.Fournisseur;
import ajc.sopra.eshop.service.FournisseurService;

@WebServlet("/fournisseur")
public class FournisseurController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private FournisseurService fournisseurSrv;

	@Override
	public void init() throws ServletException {
		fournisseurSrv = ((AnnotationConfigApplicationContext) getServletContext().getAttribute("springCtx"))
				.getBean(FournisseurService.class);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String q = request.getParameter("q");
		RequestDispatcher rd = null;
		if (q == null || q.isBlank()) {
			rd = list(request, response);
		} else if (q.equals("edit")) {
			rd=edit(request, response);
		} else if (q.equals("delete")) {
			rd=delete(request, response);
		} else if (q.equals("add")) {
			rd=add(request, response);
		} else if (q.equals("save")) {
			rd=save(request, response);
		}
		rd.forward(request, response);
	}

	private RequestDispatcher list(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("fournisseurs", fournisseurSrv.findAll());
		return request.getRequestDispatcher("/WEB-INF/fournisseur/list.jsp");
	}

	private RequestDispatcher delete(HttpServletRequest request, HttpServletResponse response) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		fournisseurSrv.deleteById(id);
		return list(request, response);
	}

	private RequestDispatcher goFormEdit(Fournisseur fournisseur, HttpServletRequest request,
			HttpServletResponse response) {
		request.setAttribute("fournisseur", fournisseur);
		return request.getRequestDispatcher("/WEB-INF/fournisseur/edit.jsp");
	}

	private RequestDispatcher edit(HttpServletRequest request, HttpServletResponse response) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		return goFormEdit(fournisseurSrv.findById(id), request, response);
	}

	private RequestDispatcher add(HttpServletRequest request, HttpServletResponse response) {
		return goFormEdit(new Fournisseur(), request, response);
	}

	private RequestDispatcher save(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("save");
		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		Adresse adresse = new Adresse(request.getParameter("numero"), request.getParameter("voie"),
				request.getParameter("ville"), request.getParameter("cp"));
		Integer id = (request.getParameter("id") != null && !request.getParameter("id").isBlank())
				? Integer.parseInt(request.getParameter("id"))
				: null;
		String societe = request.getParameter("societe");
		Fournisseur fournisseur = new Fournisseur(id, nom, prenom, adresse, societe);
		try {
			fournisseurSrv.save(fournisseur);
			System.out.println("apres ");
		} catch (FournisseurException e) {
			request.setAttribute("erreur", "données incorrectes");
			return goFormEdit(fournisseur, request, response);
		}
		return list(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
