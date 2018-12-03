/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Moniteur extends Personne {

    public int numeroDiplome;
    public List<Embauche> myEmployees;
    

    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, Calendar naissance, int numeroDiplome) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.numeroDiplome = numeroDiplome;
        myEmployees = new LinkedList();
    }

    public Club employeur() {
         //Si ya pas date de fin alors il a un employeur donc return
         Embauche dernierEmbauche =  myEmployees.get(myEmployees.size()-1);
         if(dernierEmbauche.estTerminee()){
             return null;
         }
         return dernierEmbauche.getEmployeur();
    }
    
    public void nouvelEmbauche(Club employeur, Calendar debutNouvelle) {   
         Embauche e = new Embauche(debutNouvelle, this, employeur);
         myEmployees.add(e);
    }

    public List<Embauche> emplois() {
         return myEmployees;
    }

}
