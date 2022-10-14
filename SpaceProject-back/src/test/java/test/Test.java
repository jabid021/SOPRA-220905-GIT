package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

public class Test {

	
	static List<Compte> comptes=new ArrayList(); // => comptes.txt
	static List<Vaisseau> vaisseaux = new ArrayList();
	static List<Mission> missions = new ArrayList();
	static List<Planete> planetes = new ArrayList();
	
	
	public static void ecrirePlanete() 
    {
        File f = new File("planetes.txt");

        try(FileOutputStream fos = new FileOutputStream(f); ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(planetes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void lirePlanete() 
    {
        File f = new File("planetes.txt");
        List<Planete> planetes = null;
        try(FileInputStream fis = new FileInputStream(f); ObjectInputStream ois = new ObjectInputStream(fis);) {
            planetes = (List<Planete>)ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	
    public static void ecrireVaisseau() 
    {
        File f = new File("vaisseaux.txt");

        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(vaisseaux);
            oos.close();
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void lireVaisseau() 
    {
        File f = new File("vaisseaux.txt");
        List<Vaisseau> vaisseaux = null;
        try(
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);
                )
        {
            vaisseaux=(List<Vaisseau>) ois.readObject();
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
    }
	
    
    
    public static void ecrireCompte()
    {
        


        File c = new File("compte.txt");
        try (
                FileOutputStream cos = new FileOutputStream(c);
                ObjectOutputStream  oos = new ObjectOutputStream(cos);
            )
        {

            oos.writeObject(comptes);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void lireCompte()
    {
        File c = new File("compte.txt");
        List <Compte> comptes = null;

        try (
                FileInputStream cis = new FileInputStream(c);
                ObjectInputStream  ois = new ObjectInputStream(cis);
            )
        {
            comptes = (List<Compte>)ois.readObject();
        }

        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
	
    
    public static void ecrireMissions()
	{        
		
		
		File f = new File("mission.txt");


		FileOutputStream fos;
		try {
			fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(missions);

			oos.close();
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void lireMissions()
	{		
		File f = new File("mission.txt");
	List<Mission> missions = null;
	try(
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			)
	{
		missions=(List<Mission>) ois.readObject();	
	}
	catch(Exception e) 
	{
		e.printStackTrace();
	}

	
	}
	
	public static void main(String[] args) {
		
		

		Pays p1 = new Pays ("France");
	    Pays p2 = new Pays ("Chine");
	    
	    
		Adresse adresse0 = new Adresse("3","rue de la Paix","Paris","75002", p1);
        Adresse adresse1 = new Adresse("17 bis", "rue encelade", "Rennes", "35000", p1);
        Adresse adresse2 = new Adresse("9", "rue Mario Nikis", "Paris", "75015", p2);
        
        Admin admin0 = new Admin("Bob", "Lennon", null);
        
        Astronaute astronaute0 = new Astronaute("toto","zero",adresse2,"Pesquet","Thomas",LocalDate.parse("2002-08-11"),true );
        Astronaute astronaute1 = new Astronaute("TintinAstronaute","Milou",adresse0,"Tintin","Lune",LocalDate.parse("1953-12-29"),false);
		
        Collections.addAll(comptes, admin0,astronaute0,astronaute1);
        
        
        
        Vaisseau fusee = new Vaisseau("Faucon Millenium",12,LocalDate.parse("2012-05-25"), true, TypeVaisseau.valueOf("Fusee"));
        Vaisseau navette = new Vaisseau("Enterprise",7,LocalDate.parse("2021-06-01"), true, TypeVaisseau.Navette);
        Vaisseau sonde = new Vaisseau("Star Destroyer",0,LocalDate.parse("1956-11-07"), false, TypeVaisseau.valueOf("Sonde"));

        
        Collections.addAll(vaisseaux, fusee, navette, sonde);
        
        
	    Planete pl1 = new Planete ("Mars",6779,0,78,TypePlanete.Tellurique);
	    Planete pl2 = new Planete ("Jupiter",139822,80,600,TypePlanete.Gazeux);
	    
	    
	  //Mission n°1
	    Statut statut1=Statut.EnCours;
        
	    List<Astronaute> astronautes = new ArrayList();
        Collections.addAll(astronautes, astronaute0, astronaute1);

        Mission m1 = new Mission(LocalDate.parse("2022-02-02"),LocalDate.parse("2022-12-02"),"Jupiter GetH3","jupiter pour aller chercher de l'helium 3 en masse",p1,statut1,pl1,fusee);
        m1.setAstronautes(astronautes);

        System.out.println(m1);

        System.out.println("\n\n");
        
        
        //Mission n°2
        LocalDate d3=LocalDate.parse("2022-02-02");
        LocalDate d4=LocalDate.parse("2022-12-02");
        String obj2="Jupiter GetH3";
        String desc2="jupiter pour aller chercher de l'helium 3 en masse";
        Statut statut2=Statut.EnCours;

        List<Astronaute> astronautes2 = new ArrayList();
  
        Collections.addAll(astronautes2, astronaute0);

        Mission m2 = new Mission(d3,d4,obj2,desc2,p2,statut2,pl2,navette);
        m1.setAstronautes(astronautes2);

        System.out.println(m2);
	    
        
        Collections.addAll(missions, m1,m2);
        
        
        ecrirePlanete();
        ecrireCompte();
        ecrireVaisseau();
        ecrireMissions();
        
        
	}

}
