/**
 * @(#) Club.java
 */
package FFSSM;

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.LinkedList;


public class Club {

 
    public Moniteur president;

    public String nom;

    public String adresse;

    public String telephone;
    
    public List<Plongee> myPlongees;

    public Club(Moniteur président, String nom, String telephone) {
        this.president = président;
        this.nom = nom;
        this.telephone = telephone;
        myPlongees = new LinkedList();
    }

    public Set<Plongee> plongeesNonConformes() {
         Set<Plongee> plongeesNonConformes = new HashSet<>();
        for( Plongee p: myPlongees){
            if(p.estConforme()==false){
                plongeesNonConformes.add(p);
            }
        }
        
        return plongeesNonConformes;
    }

    public void organisePlongee(Plongee p) {
         myPlongees.add(p);
    }
    
    
    public Moniteur getPresident() {
        return president;
    }

    public void setPresident(Moniteur président) {
        this.president = président;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Club{" + "président=" + president + ", nom=" + nom + ", adresse=" + adresse + ", telephone=" + telephone + '}';
    }

}
