package FFSSM;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;


    
public class Plongeur extends Personne{
    private final int niveau; 
    public final List<Licence> myLicences;
        
    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, Calendar naissance,int niveau){
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.myLicences = new LinkedList();
        this.niveau=niveau;
    }
    
    public void ajouteLicence(Licence licence){
        myLicences.add(licence);
    }
    
    
}
