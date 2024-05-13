package com.gestion;

public class Categorie {
    private int id;
    private String libelle;
    public Categorie(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}

