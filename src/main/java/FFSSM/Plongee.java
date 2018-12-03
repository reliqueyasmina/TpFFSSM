/**
 * @(#) Plongee.java
 */
package FFSSM;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.LinkedList;



public class Plongee {

    public Site lieu;

    public Moniteur chefDePalanquee;

    public Calendar date;

    public int profondeur;

    public int duree;
    
    public List<Plongeur> myParticipants;

    public Plongee(Site lieu, Moniteur chefDePalanquee, Calendar date, int profondeur, int duree) {
        this.lieu = lieu;
        this.chefDePalanquee = chefDePalanquee;
        this.date = date;
        this.profondeur = profondeur;
        this.duree = duree;
        this.myParticipants = new LinkedList();
    }

    public void ajouteParticipant(Plongeur participant) {
         myParticipants.add(participant);
    }

    public Calendar getDate() {
        return date;
    }

    public boolean estConforme() {
       if(myParticipants.isEmpty() ){
           throw new IllegalArgumentException("Il n'y a pas de participants à cette plongée");
       }
        for (Plongeur pl : myParticipants){
            if(pl.myLicences.isEmpty()){
           throw new IllegalArgumentException("Un ou plusieurs des participants a(ont) une licence non valide");
       }
            for(Licence l : pl.myLicences){
                //Si une des licences pas valide
                if(!l.estValide(date)){
                    return false;
                }
            }
        }
        return true;
    }

}
