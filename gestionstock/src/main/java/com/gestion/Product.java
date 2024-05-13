package com.gestion;
public class Product {
    private int id;
    private String libelle;
    private int prix;
    private int quantite;
    private int idcategorie;
    private int ifournisseur;

    public Product(int id, String libelle, int prix, int quantite, int idcategorie, int ifournisseur) {
        this.id = id;
        this.libelle = libelle;
        this.prix = prix;
        this.quantite = quantite;
        this.idcategorie = idcategorie;
        this.ifournisseur=ifournisseur;
    }

    // Add getters and setters for each field

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

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(int idcategorie) {
        this.idcategorie = idcategorie;
    }

    public int getIfournisseur() {return ifournisseur;}

    public void setIfournisseur(int ifournisseur) {this.ifournisseur = ifournisseur;}
}

