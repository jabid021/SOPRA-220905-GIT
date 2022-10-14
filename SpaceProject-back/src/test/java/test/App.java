package test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import context.Context;
import dao.IDAOCompte;
import dao.IDAOMission;
import dao.IDAOPays;
import dao.IDAOPlanete;
import dao.IDAOVaisseau;
import model.Admin;
import model.Adresse;
import model.Astronaute;
import model.Compte;
import model.Mission;
import model.Pays;
import model.Planete;
import model.Statut;
import model.TypePlanete;
import model.TypeVaisseau;
import model.Vaisseau;

public class App {

	static IDAOPlanete daoPlanete = Context.getSingleton().getDaoPlanete();
	static IDAOPays daoPays =  Context.getSingleton().getDaoPays();
	static IDAOVaisseau daoVaisseau=  Context.getSingleton().getDaoVaisseau();
	static IDAOCompte daoCompte =  Context.getSingleton().getDaoCompte();
	static IDAOMission daoMission =  Context.getSingleton().getDaoMission();

	public static String saisieString(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return  sc.nextLine();
	}

	public static int saisieInt(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return  sc.nextInt();
	}

	public static double saisieDouble(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return  sc.nextDouble();
	}


	public static boolean saisieBoolean(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return  sc.nextBoolean();
	}



	//----------------------------

	public static void menuPrincipal() {

		System.out.println("Menu Principal");
		System.out.println("1- Se connecter");
		System.out.println("2- Inscription");
		System.out.println("3- Stop ");

		int choix=saisieInt("Choisir un menu");

		switch(choix) 
		{
		case 1 : connexion();break;
		case 2 : inscription();break;
		case 3 : System.exit(0);break;
		}

		menuPrincipal();
	}








	public static void connexion() {
		System.out.println("Connexion : ");
		String login=saisieString("Saisir votre login");
		String password=saisieString("Saisir votre password");

		Compte connected = daoCompte.seConnecter(login, password);

		if(connected == null) 
		{
			System.out.println("Identifiants invalides");
		}
		else if(connected instanceof Admin) 
		{
			menuAdmin();
		}
		else if(connected instanceof Astronaute) 
		{
			menuAstronaute();
		}

	}

	public static void menuAstronaute() {
		System.out.println("Menu Astronaute");

	}

	public static void menuAdmin() {
		System.out.println("Menu Admin");
		System.out.println("1- Gestion des Pays");
		System.out.println("2- Gestion des Planetes");
		System.out.println("3- Gestion des Vaisseaux");
		System.out.println("4- Gestion des Comptes");
		System.out.println("5- Gestion des Missions");
		System.out.println("6- Se deconnecter");

		int choix =saisieInt("Choisir menu");

		switch(choix) 
		{
		case 1 : gestionPays();break;
		case 2 : gestionPlanetes();break;
		case 3:  gestionVaisseaux();break;
		case 4 : gestionComptes();break;
		case 5 : gestionMissions();break;
		case 6 : menuPrincipal();break;
		}

		menuAdmin();
	}

	public static void gestionMissions() {
		System.out.println("Menu Gestion Missions");
		System.out.println("1- Afficher toutes les missions");
		System.out.println("2- Ajouter une mission");
		System.out.println("3- Modifier une mission");
		System.out.println("4- Supprimer une mission");
		System.out.println("5- Retour");

		int choix = saisieInt("Choisir menu");

		switch(choix) 
		{
		case 1 : afficherMissions();break;
		case 2 : ajouterMission();break;
		case 3 : modifierMission();break;
		case 4 : supprimerMission();break;
		case 5 : menuAdmin();break;
		}
		gestionMissions();


	}



	public static void ajouterMission() 
	{
		String debut = saisieString("Saisir date debut");
		String fin = saisieString("Saisir date fin");
		String obj = saisieString("Saisir objectif");
		String description = saisieString("Saisir description");
		String statut = saisieString("Saisir statut "+Arrays.toString(Statut.values()));

		afficherVaisseau();

		int idVaisseau = saisieInt("Saisir l'id du vaisseau");
		Vaisseau vaisseau = daoVaisseau.findById(idVaisseau);

		afficherPlanete();
		int idPlanete = saisieInt("Saisir l'id de la planete");
		Planete planete = daoPlanete.findById(idPlanete);


		afficherPays();
		int idPays = saisieInt("Saisir l'id du pays");
		Pays pays = daoPays.findById(idPays);

		Mission mission = new Mission(LocalDate.parse(debut),LocalDate.parse(fin),obj,description,pays,Statut.valueOf(statut),planete,vaisseau);

		daoMission.save(mission);


	}

	public static void modifierMission() 
	{

		afficherMissions();
		int idMission = saisieInt("Quelle mission modifier ?");


		String debut = saisieString("Saisir date debut");
		String fin = saisieString("Saisir date fin");
		String obj = saisieString("Saisir objectif");
		String description = saisieString("Saisir description");
		String statut = saisieString("Saisir statut "+Arrays.toString(Statut.values()));

		afficherVaisseau();

		int idVaisseau = saisieInt("Saisir l'id du vaisseau");
		Vaisseau vaisseau = daoVaisseau.findById(idVaisseau);

		afficherPlanete();
		int idPlanete = saisieInt("Saisir l'id de la planete");
		Planete planete = daoPlanete.findById(idPlanete);


		afficherPays();
		int idPays = saisieInt("Saisir l'id du pays");
		Pays pays = daoPays.findById(idPays);

		Mission mission = new Mission(idMission,LocalDate.parse(debut),LocalDate.parse(fin),obj,description,pays,Statut.valueOf(statut),planete,vaisseau);

		daoMission.save(mission);
	}

	public static void supprimerMission() 
	{
		afficherMissions();
		int idMission = saisieInt("Quelle mission supprimer ?");
		daoMission.delete(idMission);

	}



	public static void afficherMissions() 
	{

		List<Mission> missions = daoMission.findAll();

		for(Mission m : missions) 
		{
			System.out.println(m);
		}

	}



	//--------Groupe 3--------------------


	public static void inscription() 
	{
		afficherCompte();
		//boolean isAdmin = saisieBoolean("Creer un compte Admin ?  True/False");

		String login = saisieString("Saisir le login: ");
		String password = saisieString("Saisir le mot de passe: ");

		//if(isAdmin)
		//{

		//Compte compte = new Admin(login,password,null);
		//daoCompte.insert(compte);
		//}
		//else  
		//{
		String numero = saisieString("Saisir numero de voie: ");
		String voie = saisieString("Saisir la voie: ");
		String ville = saisieString("Saisir la ville: ");
		String cp = saisieString("Saisir le code postal: ");
		afficherPays();
		int idPays = saisieInt("Saisir l'id du pays: ");
		Pays pays = daoPays.findById(idPays);
		Adresse adresse = new Adresse(numero, voie, ville, cp, pays);
		String nom = saisieString("Saisir votre nom: ");
		String prenom = saisieString("Saisir votre prenom: ");
		String debutCarriere = saisieString("Saisir date debut carriere: ");
		boolean isActif = saisieBoolean("Etes vous actif? True/False");


		Compte compte = new Astronaute(password, login, adresse, nom, prenom,LocalDate.parse(debutCarriere), isActif);
		daoCompte.save(compte);
		//}

	}

	public static void modifierCompte() 
	{

		afficherCompte();
		int idCompte = saisieInt("Quel compte modifier ?");
		//boolean isAdmin = saisieBoolean("Avez-vous un compte Admin ?  True/False");

		String login = saisieString("Saisir le login: ");
		String password = saisieString("Saisir le mot de passe: ");

		//if(isAdmin)
		//{

		//	Compte compte = new Admin(idCompte, password, login);
		//daoCompte.update(compte);
		//}
		//else  
		//{
		String numero = saisieString("Saisir numero de voie: ");
		String voie = saisieString("Saisir la voie: ");
		String ville = saisieString("Saisir la ville: ");
		String cp = saisieString("Saisir le code postal: ");
		afficherPays();
		int idPays = saisieInt("Saisir l'id du pays: ");
		Pays pays = daoPays.findById(idPays);
		Adresse adresse = new Adresse(numero, voie, ville, cp, pays);
		String nom = saisieString("Saisir votre nom: ");
		String prenom = saisieString("Saisir votre prenom: ");
		String debutCarriere = saisieString("Saisir date debut carriere: ");
		boolean isActif = saisieBoolean("Etes vous actif? True/False");


		Compte compte = new Astronaute(idCompte, password, login, adresse, nom, prenom,LocalDate.parse(debutCarriere), isActif);
		daoCompte.save(compte);
		//}

	}

	public static void supprimerCompte() 
	{
		afficherCompte();
		int idCompte = saisieInt("Quel compte supprimer ?");
		daoCompte.delete(idCompte);

	}

	public static void afficherCompte() 
	{

		List<Compte> comptes = daoCompte.findAll();

		for(Compte c : comptes) 
		{
			System.out.println(c);
		}

	}

	public static void gestionComptes() {

		System.out.println("Menu Gestion Comptes");
		System.out.println("1- Afficher tous les comptes");
		System.out.println("2- Ajouter un compte");
		System.out.println("3- Modifier un compte");
		System.out.println("4- Supprimer un compte");
		System.out.println("5- Retour");

		int choix = saisieInt("Choisir menu");

		switch(choix) 
		{
		case 1 : afficherCompte();break;
		case 2 : inscription();break;
		case 3 : modifierCompte ();break;
		case 4 : supprimerCompte ();break;
		case 5 : menuAdmin();break;
		}
		gestionComptes();
	}




	//--------Groupe 4--------------------
	public static void gestionVaisseaux() {
		System.out.println("Menu Gestion vaisseaux");
		System.out.println("1- Afficher toutes les Vaisseaux");
		System.out.println("2- Ajouter un vaisseau");
		System.out.println("3- Modifier un vaisseau");
		System.out.println("4- Supprimer un vaisseau");
		System.out.println("5- Retour");

		int choix = saisieInt("Choisir menu");

		switch(choix) 
		{
		case 1 : afficherVaisseau();break;
		case 2 : ajouterVaisseau();break;
		case 3 : modifierVaisseau();break;
		case 4 : supprimerVaisseau();break;
		case 5 : menuAdmin();break;
		}
		gestionVaisseaux();

	}
	public static void afficherVaisseau() 
	{

		List<Vaisseau> vaisseaux = daoVaisseau.findAll();

		for(Vaisseau v : vaisseaux) 
		{

			System.out.println(v);
		}

	}
	public static void ajouterVaisseau() 
	{

		String nom = saisieString("Saisir nom");
		int capacite = saisieInt("Saisir capacite");
		LocalDate miseEnService = LocalDate.parse(saisieString("Saisir date mise en service"));
		Boolean fonctionnel = saisieBoolean("Saisir fonctionnel (false/true)");
		TypeVaisseau typeVaisseau = TypeVaisseau.valueOf(saisieString("Saisir Type "+Arrays.toString(TypeVaisseau.values())));


		Vaisseau vaisseau = new Vaisseau(nom,capacite,miseEnService,fonctionnel,typeVaisseau);

		daoVaisseau.save(vaisseau);
	}

	public static void modifierVaisseau() 
	{
		afficherVaisseau();
		int idVaisseau = saisieInt("Quel vaisseau modifier ?");

		String nom = saisieString("Saisir nom");
		int capacite = saisieInt("Saisir capacite");
		LocalDate miseEnService = LocalDate.parse(saisieString("Saisir date mise en service"));
		Boolean fonctionnel = saisieBoolean("Saisir fonctionnel (false/true)");
		TypeVaisseau typeVaisseau = TypeVaisseau.valueOf(saisieString("Saisir Type "+Arrays.toString(TypeVaisseau.values())));




		Vaisseau vaisseau = new Vaisseau(idVaisseau,nom,capacite,miseEnService,fonctionnel,typeVaisseau);

		daoVaisseau.save (vaisseau);
	}

	public static void supprimerVaisseau(){
		afficherVaisseau();
		int idVaisseau = saisieInt("Quel vaisseau supprimer ?");


		daoVaisseau.delete(idVaisseau);
	} 














	//--------Groupe 1--------------------
	public static void gestionPlanetes() {
		System.out.println("Menu Gestion Planetes");
		System.out.println("1- Afficher toutes les planetes");
		System.out.println("2- Ajouter une planete");
		System.out.println("3- Modifier une planete");
		System.out.println("4- Supprimer une planete");
		System.out.println("5- Retour");

		int choix = saisieInt("Choisir menu");

		switch(choix) 
		{
		case 1 : afficherPlanete();break;
		case 2 : ajouterPlanete();break;
		case 3 : modifierPlanete();break;
		case 4 : supprimerPlanete();break;
		case 5 : menuAdmin(); break;
		}
		gestionPlanetes();
	}


	public static void afficherPlanete() {
		List<Planete>planetes = daoPlanete.findAll();

		for(Planete p : planetes) 
		{
			System.out.println(p);
		}
	}


	public static void ajouterPlanete() {
		afficherPlanete();

		String nom = saisieString("Saisir nom");
		double diametre = saisieDouble("Saisir diametre");
		int satellite = saisieInt("Saisir satellites");
		int distance = saisieInt("Saisir distance");
		String typePlanete = saisieString("Saisir type planete "+Arrays.toString(TypePlanete.values()));

		Planete planete = new Planete(nom,diametre,satellite,distance,TypePlanete.valueOf(typePlanete));

		daoPlanete.save(planete);
	}



	public static void modifierPlanete() {
		afficherPlanete();
		int idPlanete = saisieInt("Quelle planète modifier ?");

		String nom = saisieString("Saisir nom");
		double diametre = saisieDouble("Saisir diametre");
		int satellite = saisieInt("Saisir satellites");
		int distance = saisieInt("Saisir distance");
		String typePlanete = saisieString("Saisir type planete "+Arrays.toString(TypePlanete.values()));

		Planete planete = new Planete(idPlanete, nom,diametre,satellite,distance,TypePlanete.valueOf(typePlanete));

		daoPlanete.save(planete);	
	}

	public static void supprimerPlanete() {
		afficherPlanete();
		int idPlanete = saisieInt("Quelle planete supprimer ?");
		daoPlanete.delete(idPlanete);
	}















	//--------Groupe 2--------------------
	public static void gestionPays() {

		System.out.println("Menu Gestion Pays");
		System.out.println("1- Afficher tous les pays");
		System.out.println("2- Ajouter un pays");
		System.out.println("3- Modifier un pays");
		System.out.println("4- Supprimer un pays");
		System.out.println("5- Retour");

		int choix = saisieInt("Choisir menu");

		switch(choix) 
		{
		case 1 : afficherPays();break;
		case 2 : ajouterPays();break;
		case 3 : modifierPays();break;
		case 4 : supprimerPays();break;
		case 5 : menuAdmin();break;
		}
		gestionPays();

	}

	public static void afficherPays() 
	{

		List<Pays> pays = daoPays.findAll();

		for(Pays p : pays) 
		{
			System.out.println(p);
		}

	}

	public static void ajouterPays() 
	{
		String nom = saisieString("Saisir nom Pays");

		Pays p = new Pays(nom);

		daoPays.save(p);

	}

	public static void modifierPays() 
	{
		afficherPays();
		int idPays = saisieInt("Quelle pays modifier ?");

		String nom = saisieString("Saisir nom Pays");

		Pays p = new Pays(idPays, nom);

		daoPays.save(p);
	}

	public static void supprimerPays() 
	{
		afficherPays();
		int idPays = saisieInt("Quel pays supprimer ?");
		daoPays.delete(idPays);

	}











	public static void main(String[] args) {

		menuPrincipal();
	}



}
