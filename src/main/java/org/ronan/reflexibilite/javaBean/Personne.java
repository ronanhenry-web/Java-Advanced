package org.ronan.reflexibilite.javaBean;

import org.ronan.reflexibilite.annotation.ToCsv;

import java.io.Serializable;

public class Personne implements Serializable {
    @ToCsv("LASTNAME")
    private String nom;
    @ToCsv("FIRSTNAME")
    private String prenom;
    @ToCsv("YEAR")
    private int AnneeNaissance;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAnneeNaissance() {
        return AnneeNaissance;
    }

    public void setAnneeNaissance(int anneeNaissance) {
        AnneeNaissance = anneeNaissance;
    }
}
