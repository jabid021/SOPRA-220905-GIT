package test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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

public class TestBdd {


	static String urlBdd = "jdbc:mysql://localhost:3306/space_project";
	// static String urlBdd = "jdbc:mysql://localhost:8889/space_project";
	static String loginBdd = "root";

	static String passwordBdd=""; 
	//static String passwordBdd="root" 

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


	//-------------------------------------------------JDBC-------------------------------------------------


	///------------PARTIE JORDAN----------------
	
	

	///------------PARTIE GROUPE 1 PLANETE----------------

	public static List<Planete> findAllPlanete()
	{
		List<Planete> planetes = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(urlBdd, loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from planete");

			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				//Planete planete = findByIdPlanete(rs.getInt("planetes"));
				Planete planete = new Planete(rs.getInt("id"),rs.getString("nom"), rs.getDouble("diametre"), rs.getInt("satellites"),rs.getInt("distance"),TypePlanete.valueOf(rs.getString("type_planete")));
				planetes.add(planete);
			}

			rs.close();
			ps.close();
			conn.close();
		} 
		catch (Exception e) {

			e.printStackTrace();
		}

		return planetes;
	}
	public static Planete findByIdPlanete(Integer id) 
	{
		Planete planete = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(urlBdd, loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from planete WHERE id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{

				planete = new Planete(id, rs.getString("nom"), rs.getDouble("diametre"), rs.getInt("satellites"),rs.getInt("distance"),TypePlanete.valueOf(rs.getString("type_planete")));

			}

			rs.close();
			ps.close();
			conn.close();
		} 
		catch (Exception e) {

			e.printStackTrace();
		}

		return planete;
	}
	public static void insertPlanete(Planete p) 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(urlBdd, loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("INSERT INTO planete (nom,diametre,satellites,distance,type_planete) VALUES(?,?,?,?,?)");
			ps.setString(1, p.getNom().toString());
			ps.setDouble(2, p.getDiametre());
			ps.setInt(3, p.getSatellites());
			ps.setInt(4, p.getDistance());
			ps.setString(5, p.getTypePlanete().toString());



			ps.executeUpdate();

			ps.close();
			conn.close();
		} 
		catch (Exception e) {

			e.printStackTrace();
		}


	}
	public static void updatePlanete(Planete p) 
	{

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(urlBdd, loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("UPDATE planete set nom=?,diametre=?,satellites=?,distance=?,type_planete=? where id=?");
			ps.setString(1, p.getNom());
			ps.setDouble(2, p.getDiametre());
			ps.setInt(3, p.getSatellites());
			ps.setInt(4, p.getDistance());
			ps.setString(5, p.getTypePlanete().toString());
			ps.setInt(6, p.getId());
			ps.executeUpdate();

			ps.close();
			conn.close();
		} 
		catch (Exception e) {

			e.printStackTrace();
		}
	}
	public static void deletePlanete(Integer id) 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(urlBdd, loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("DELETE FROM planete where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();

			ps.close();
			conn.close();
		} 
		catch (Exception e) {

			e.printStackTrace();
		}
	}


	///------------PARTIE GROUPE 2 Pays----------------
	public static List<Pays> findAllPays()
	{

		List<Pays> pays = new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(urlBdd, loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from pays");


			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				Pays p = new Pays(rs.getInt("id"), rs.getString("nom"));
				pays.add(p);
			}

			rs.close();
			ps.close();
			conn.close();
		} 
		catch (Exception e) {

			e.printStackTrace();
		}

		return pays;


	}

	public static Pays findByIdPays(Integer id) 
	{
		Pays p = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(urlBdd, loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from pays where id=?");
			ps.setInt(1, id);


			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{

				p = new Pays(rs.getInt("id"), rs.getString("nom"));
			}

			rs.close();
			ps.close();
			conn.close();
		} 
		catch (Exception e) {

			e.printStackTrace();
		}
		return p;	
	}


	public static void insertPays(Pays p) 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(urlBdd, loginBdd,passwordBdd);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO pays (id, nom) VALUES (?,?)");
			ps.setInt(1, p.getId());
			ps.setString(2, p.getNom());		

			ps.executeUpdate();

			ps.close();
			conn.close();
		} 
		catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void updatePays(Pays p) 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(urlBdd, loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("UPDATE pays set nom=? where id=?");
			ps.setString(1, p.getNom());
			ps.setInt(2, p.getId());
			ps.executeUpdate();

			ps.close();
			conn.close();
		} 
		catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void deletePays(Integer id) 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(urlBdd, loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("DELETE FROM pays where id=?");
			ps.setInt(1, id);

			ps.executeUpdate();

			ps.close();
			conn.close();
		} 
		catch (Exception e) {

			e.printStackTrace();
		}
	}





	///------------PARTIE GROUPE 3 Comptes----------------
	public static List<Compte> findAllCompte() //Mohamed K
	{
		List<Compte> comptes = new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(urlBdd, loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from compte");

			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				if(rs.getString("type_compte").equals("Admin")) 
				{
					Compte compte = new Admin(rs.getInt("id"),rs.getString("password"),rs.getString("login"));
					comptes.add(compte);
				}
				else if(rs.getString("type_compte").equals("Astronaute")) 
				{
					Pays pays = findByIdPays(rs.getInt("pays"));
					Adresse a = new Adresse(rs.getString("numero"),rs.getString("voie"),rs.getString("ville"),rs.getString("cp"),pays);
					Compte compte = new Astronaute(rs.getInt("id"),rs.getString("password"),rs.getString("login"),a,rs.getString("nom"),rs.getString("prenom"),LocalDate.parse(rs.getString("debut")), rs.getBoolean("actif"));
					comptes.add(compte);
				}
			}
			rs.close();
			ps.close();
			conn.close();
		}
		catch (Exception e) {

			e.printStackTrace();
		}

		return comptes;
	}
	//Anastasia
	public static Compte findByIdCompte(Integer id) 
	{
		Compte compte = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(urlBdd, loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from compte where id=?");
			ps.setInt(1, id);


			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				if(rs.getString("type_compte").equals("Admin")) 
				{
					compte = new Admin(rs.getInt("id"),rs.getString("password"),rs.getString("login"));
				}
				else if(rs.getString("type_compte").equals("Astronaute")) 
				{

					Pays pays = findByIdPays(rs.getInt("pays"));
					Adresse adresse = new Adresse(rs.getString("numero"),rs.getString("voie"),rs.getString("ville"),rs.getString("cp"),pays);
					compte = new Astronaute(rs.getInt("id"), rs.getString("password"), rs.getString("login"),adresse,rs.getString("nom"),rs.getString("prenom"),LocalDate.parse(rs.getString("debut")),rs.getBoolean("actif"));

				}
			}

			rs.close();
			ps.close();
			conn.close();
		} 
		catch (Exception e) {

			e.printStackTrace();
		}
		return compte;


	}

	//Matthieu
	//ne travailler qu'avec les astronautes
	public static void insertCompte(Compte c) 
	{
		Astronaute a = (Astronaute) c;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(urlBdd, loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("INSERT INTO compte (login,password,nom,prenom,debut,actif,numero,voie,ville,cp,pays,type_compte) VALUES(?,?,?,?,?,?,?,?,?,?,?,Astronaute)");
			ps.setString(1, a.getLogin());
			ps.setString(2, a.getPassword());
			ps.setString(3, a.getNom());
			ps.setString(4, a.getPrenom());
			ps.setString(5, a.getDebutCarriere().toString());
			ps.setBoolean(6, a.isActif());
			ps.setString(7, a.getAdresse().getNumero());
			ps.setString(8, a.getAdresse().getVoie());
			ps.setString(9, a.getAdresse().getVille());
			ps.setString(10, a.getAdresse().getCp());
			ps.setInt(11, a.getAdresse().getPays().getId());


			ps.executeUpdate();

			ps.close();
			conn.close();
		} 
		catch (Exception e) {

			e.printStackTrace();
		}

	}

	// mohamed_A
	//ne travailler qu'avec les astronautes
	public static void updateCompte(Compte c) 
	{
		Astronaute a = (Astronaute) c;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(urlBdd, loginBdd,passwordBdd);


			PreparedStatement ps = conn.prepareStatement("UPDATE compte set password=?,login=?,numero=?,voie=?,ville=?,cp=?,pays=? where id=?");
			ps.setString(1, a.getLogin());
			ps.setString(2, a.getPassword());
			ps.setString(3, a.getNom());
			ps.setString(4, a.getPrenom());
			ps.setString(5, a.getDebutCarriere().toString());
			ps.setBoolean(6, a.isActif());
			ps.setString(7, a.getAdresse().getNumero());
			ps.setString(8, a.getAdresse().getVoie());
			ps.setString(9, a.getAdresse().getVille());
			ps.setString(10, a.getAdresse().getCp());
			ps.setInt(11, a.getAdresse().getPays().getId());
			ps.setInt(12,c.getId());




			ps.executeUpdate();

			ps.close();
			conn.close();
		} 
		catch (Exception e) {

			e.printStackTrace();
		}
	}


	// mohamed_A
	public static void deleteCompte(Integer id) 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(urlBdd, loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("DELETE FROM compte where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();

			ps.close();
			conn.close();
		} 
		catch (Exception e) {

			e.printStackTrace();
		}
	}
	public static Compte seConnecter(String login,String password) 
	{

		Compte compte = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(urlBdd, loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("SELECT * from compte where login=? and password=?");
			ps.setString(1, login);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) 
			{
				if(rs.getString("type_compte").equals("Admin")) 
				{
					compte = new Admin(rs.getInt("id"),password,login);
				}
				else if(rs.getString("type_compte").equals("Astronaute")) 
				{
					Pays pays = findByIdPays(rs.getInt("pays"));
					Adresse a = new Adresse(rs.getString("numero"),rs.getString("voie"),rs.getString("ville"),rs.getString("cp"),pays);
					compte = new Astronaute(rs.getInt("id"),password,login,a,rs.getString("nom"),rs.getString("prenom"),LocalDate.parse(rs.getString("debut")), rs.getBoolean("actif"));
				}

			}

			rs.close();
			ps.close();
			conn.close();
		} 
		catch (Exception e) {

			e.printStackTrace();
		}
		return compte;

	}





	///------------PARTIE GROUPE 4 Vaisseaux----------------

	public static List<Vaisseau> findAllVaisseau()
	{List<Vaisseau> vaisseaux = new ArrayList();
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection(urlBdd, loginBdd,passwordBdd);

		PreparedStatement ps = conn.prepareStatement("SELECT * from vaisseau");


		ResultSet rs = ps.executeQuery();

		while(rs.next()) 
		{

			Vaisseau vaisseau = new Vaisseau(rs.getInt("id"),rs.getString("nom"), rs.getInt("capacite"), LocalDate.parse(rs.getString("date_service")),rs.getBoolean("fonctionnel"), TypeVaisseau.valueOf(rs.getString("type_vaisseau")));

			vaisseaux.add(vaisseau);
		}

		rs.close();
		ps.close();
		conn.close();
	} 
	catch (Exception e) {

		e.printStackTrace();
	}

	return vaisseaux;
	}

	public static Vaisseau findByIdVaisseau(Integer id) 
	{Vaisseau vaisseau=null;
	try {

		Class.forName("com.mysql.jdbc.Driver");

		Connection conn=DriverManager.getConnection(urlBdd, loginBdd,passwordBdd); 


		PreparedStatement ps = conn.prepareStatement("SELECT * from vaisseau where id=?");
		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		while(rs.next()) {
			//(Integer id,String nom, int capacite, LocalDate miseEnService, boolean fonctionnel,TypeVaisseau typeVaisseau) //pour le boolÃ©ean j'ai pas vu comment il faisait ?!
			vaisseau = new Vaisseau(id,rs.getString("nom"),rs.getInt("capacite"),LocalDate.parse(rs.getString("date_service")),rs.getBoolean("fonctionnel"), TypeVaisseau.valueOf(rs.getString("type_vaisseau")));
			System.out.println(vaisseau);

		}

		rs.close();
		ps.close();
		conn.close();

	} catch (Exception e) {
		e.printStackTrace();
	}
	return vaisseau;
	}

	public static void insertVaisseau(Vaisseau v) 
	{  try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection(urlBdd, loginBdd,passwordBdd);

		PreparedStatement ps = conn.prepareStatement("INSERT INTO vaisseau (nom,capacite,date_service,fonctionnel,type_vaisseau) values(?,?,?,?,?)");
		ps.setString(1,v.getNom());
		ps.setInt(2, v.getCapacite());
		ps.setString(3, v.getMiseEnService().toString());
		ps.setBoolean(4, v.isFonctionnel());
		ps.setString(5,v.getTypeVaisseau().toString());


		ps.executeUpdate();

		ps.close();
		conn.close();
	} 
	catch (Exception e) {

		e.printStackTrace();
	}

	}

	public static void updateVaisseau(Vaisseau v) 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(urlBdd, loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("UPDATE vaisseau set nom=?,capacite=?,date_service=?,fonctionnel=?,type_vaisseau=? where id=?");
			ps.setString(1, v.getNom());
			ps.setInt(2, v.getCapacite());
			ps.setString(3,v.getMiseEnService().toString());
			ps.setBoolean(4, v.isFonctionnel());
			ps.setString(5, v.getTypeVaisseau().toString());
			ps.setInt(6, v.getId());
			ps.executeUpdate();

			ps.close();
			conn.close();
		} 
		catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void deleteVaisseau(Integer id) 
	{
		findAllVaisseau();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(urlBdd, loginBdd,passwordBdd);

			PreparedStatement ps = conn.prepareStatement("DELETE FROM vaisseau where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();

			ps.close();
			conn.close();
		} 
		catch (Exception e) {

			e.printStackTrace();
		}
	}

	//-------------------------------------------------TEST-------------------------------------------------



	public static void ajouterPlanete(){

		String nom = saisieString("Saisir nom");
		double diametre = saisieDouble("Saisir diametre");
		int satellites = saisieInt("Saisir satellite");
		int distance = saisieInt("Saisir distance");
		String typePlanete = saisieString ("Saisir type de planete" +Arrays.toString(TypePlanete.values()));

		Planete planete = new Planete(nom, diametre, satellites, distance, TypePlanete.valueOf(typePlanete));

		insertPlanete(planete);

	}

	public static void modifierPlanete(){
		afficherPlanetes();

		int idPlanete = saisieInt("Quelle planete modifier ?");
		String nom = saisieString("Saisir nom");
		double diametre = saisieDouble("Saisir diametre");
		int satellites = saisieInt("Saisir nombre de satellite");
		int distance = saisieInt("Saisir distance");
		String typePlanete = saisieString ("Saisir type de planete" +Arrays.toString(TypePlanete.values()));

		Planete p = new Planete(idPlanete,nom,diametre,satellites,distance,TypePlanete.valueOf(typePlanete));

		updatePlanete(p);

	}

	public static void supprimerPlanete(){

		afficherPlanetes();
		int idPlanete = saisieInt("Quelle planète supprimer ?");
		deletePlanete(idPlanete);

	}

	public static void afficherPlanetes(){
		List<Planete> planetes = findAllPlanete();

		for(Planete p : planetes) 
		{
			System.out.println(p);
		}
	}


	public static void ajouterPays() 
	{
		int id = saisieInt("Saisir id");
		String nom = saisieString("Saisir nom");

		Pays pays = new Pays(id, nom);


		insertPays(pays);


	}

	public static void modifierPays() 
	{

		afficherPays();
		int idPays = saisieInt("Quelle pays modifier ?");


		String nom = saisieString("Saisir nom");


		Pays pays = new Pays(idPays, nom);

		updatePays(pays);
	}

	public static void supprimerPays() 
	{
		afficherPays();
		int idPays = saisieInt("Quel pays supprimer ?");
		deletePays(idPays);

	}



	public static void afficherPays() 
	{

		List<Pays> pays = findAllPays();

		for(Pays p : pays) 
		{
			System.out.println(p);
		}

	}

	public static void afficherVaisseaux() 
	{

		List<Vaisseau> vaisseaux = findAllVaisseau();

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

		insertVaisseau(vaisseau);
	}

	public static void modifierVaisseau() 
	{
		afficherVaisseaux();
		int idVaisseau = saisieInt("Quel vaisseau modifier ?");

		String nom = saisieString("Saisir nom");
		int capacite = saisieInt("Saisir capacite");
		LocalDate miseEnService = LocalDate.parse(saisieString("Saisir date mise en service"));
		Boolean fonctionnel = saisieBoolean("Saisir fonctionnel (false/true)");
		TypeVaisseau typeVaisseau = TypeVaisseau.valueOf(saisieString("Saisir Type "+Arrays.toString(TypeVaisseau.values())));




		Vaisseau vaisseau = new Vaisseau(idVaisseau,nom,capacite,miseEnService,fonctionnel,typeVaisseau);

		updateVaisseau(vaisseau);
	}

	public static void supprimerVaisseaux(){
		afficherVaisseaux();
		int idVaisseau = saisieInt("Quel vaisseau supprimer ?");


		deleteVaisseau(idVaisseau);
	} 

	public static void main(String[] args) {

		//System.out.println(seConnecter("toto", "zero"));


		//ajouterMission();

		//modifierMission();

		//supprimerMission();

		//System.out.println(findByIdMission(1));

		//afficherMissions();


		//---------


		//ajouterX();

		//modifierX();

		//supprimerX();

		//System.out.println(findByIdX(2));

		//afficherX();


	}

}
