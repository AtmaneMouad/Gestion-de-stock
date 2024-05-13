package com.gestion;

public class Fournisseur {
    private int id;
    private String libelle;
    private String contact;

    public Fournisseur(int id, String libelle, String contact) {
        this.id = id;
        this.libelle = libelle;
        this.contact = contact;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
