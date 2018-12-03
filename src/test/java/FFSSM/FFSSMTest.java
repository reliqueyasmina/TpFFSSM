/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FFSSM;
import java.util.Calendar;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author Yasmina
 */
public class FFSSMTest {
        Plongeur plongeur1, plongeur2;
	Moniteur moniteur1, moniteur2;
        Licence licence1, licence2;
        Embauche embauche1,embauche2;
        Club club1;
        Plongee plongee1,plongee2;
        Site site1;
	
	@Before
	public void setUp() {
                
                Calendar c1 = Calendar.getInstance();
                c1.set(1972,12,12);
		plongeur1 = new Plongeur("001", "Maret", "Loic", "2 Allee Fare", "64500", c1,1);
                
                plongeur2 = new Plongeur("002", "Robert", "Louis", "2 Allee Fare", "64500", c1,1);
                
                
                Calendar c2 = Calendar.getInstance();
                c2.set(1999,9,10);
		moniteur1 = new Moniteur("002", "Payet", "Valérie", "5 chemin ah", "81100", c2,1);
                club1 = new Club(moniteur1, "ASS", "077777777");
                Calendar c3 = Calendar.getInstance();
                c3.set(2018,02,02);
                licence1 = new Licence(plongeur1, "066005522", c3, 1, club1); //licence valide
               // plongeur1.ajouteLicence(licence1);
                Calendar c4 = Calendar.getInstance();
                c4.set(2012,02,02);
                licence2 = new Licence(plongeur2, "065005599", c4, 1, club1); //licence non valide
                embauche1 = new Embauche(c4, moniteur1, club1);
                site1 = new Site("MonSite","details de mon site");
                 Calendar duJour = Calendar.getInstance();
                duJour.set(2018,11,27);
                plongee1 = new Plongee(site1, moniteur1, duJour, 80000, 30);                
                plongee2 = new Plongee(site1, moniteur1, duJour, 80000, 30);

	}
        
        
        @Test
        public void testAjoutLicence(){
            plongeur1.ajouteLicence(licence2);
           assertEquals(plongeur1.myLicences.size(),1);
        }
        
        @Test
        public void testGetEmployeur(){
            assertEquals(embauche1.getEmployeur(),club1);
        }
        
        @Test
        public void testEmbaucheTerminer(){
            Calendar c4 = Calendar.getInstance();
            c4.set(2018,02,02);
            embauche1.terminer(c4);
            assertEquals(embauche1.getFin(),c4);
        }
        
        @Test
        public void testLicenceValide(){
            Calendar d = Calendar.getInstance();
            d.set(2018,11,27);
            assertEquals(licence1.estValide(d),true);
            assertEquals(licence2.estValide(d),false);
        } 
        
        @Test
        public void testAjoutParticipants(){
            plongee1.ajouteParticipant(plongeur1);
            assertEquals(plongee1.myParticipants.size(),1);
        }
        
        @Test
        public void testPlongleesConformes(){
            plongeur1.ajouteLicence(licence1);
            plongeur2.ajouteLicence(licence2);
            //Ajout d'un participant avec licence licence valide
            plongee1.ajouteParticipant(plongeur1);
            assertEquals(plongee1.estConforme(),true);
            //Ajout d'un participant avec licence licence non valide
            plongee1.ajouteParticipant(plongeur2);
            assertEquals(plongee1.estConforme(),false);
        }
        
        @Test
        public void testPlongeeAvecParticipantsSansLicence(){
            try{
                plongee1.ajouteParticipant(plongeur1);
                assertEquals(plongee1.estConforme(),true);
                fail();
            }
            catch(Exception e){
                
            }
        }
        
        @Test
        public void testPlongeeSansParticipants(){
            try{
                assertEquals(plongee1.estConforme(),true);
                fail();
            }
            catch(Exception e){
                
            }
        }
        
        
        @Test
        public void testOrganisePlongee(){
            club1.organisePlongee(plongee1);
           assertEquals(club1.myPlongees.size(),1);
        }
        
        @Test
        public void testListePlongeeNonConforme(){
            plongeur1.ajouteLicence(licence1);
            plongeur2.ajouteLicence(licence2);
            //Ajout d'un participant avec licence licence valide
            plongee1.ajouteParticipant(plongeur1);
            //Ajout d'un participant avec licence licence non valide
            plongee2.ajouteParticipant(plongeur2);
            club1.organisePlongee(plongee1);
            assertEquals(club1.plongeesNonConformes().size(),0);
            club1.organisePlongee(plongee2);
            assertEquals(club1.plongeesNonConformes().size(),1);
        }
        
        @Test
        public void testNouvelEmbauche(){
            Calendar c2 = Calendar.getInstance();
            c2.set(2018,02,02);
            assertEquals(moniteur1.myEmployees.size(),0);
            moniteur1.nouvelEmbauche(club1, c2);
            assertEquals(moniteur1.myEmployees.size(),1);
        }
        
        @Test
        public void testEmployeur(){
            Calendar c2 = Calendar.getInstance();
            c2.set(2018,02,02);
            moniteur1.nouvelEmbauche(club1, c2);
            assertEquals(moniteur1.employeur(),club1);
        }
        
        
}
