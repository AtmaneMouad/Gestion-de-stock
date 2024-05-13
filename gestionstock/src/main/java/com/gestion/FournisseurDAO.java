package com.gestion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FournisseurDAO {

    private Connection connection;

    // Update these variables with your database connection details
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/gestiostock";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Error loading MySQL JDBC driver");
        }
    }

    public FournisseurDAO() {
        // Initialize database connection here
        this.connection = getConnection();
    }

    private Connection getConnection() {
        try {
            return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error connecting to the database");
        }
    }

    public List<Fournisseur> getAllFournisseurs() {
        List<Fournisseur> fournisseurs = new ArrayList<>();
        try {
            String query = "SELECT * FROM fournisseur";
            try (PreparedStatement pst = connection.prepareStatement(query)) {
                try (ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String libelle = rs.getString("libelle");
                        String contact = rs.getString("contact");
                        Fournisseur fournisseur = new Fournisseur(id, libelle, contact);
                        fournisseurs.add(fournisseur);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately in your application
        }
        return fournisseurs;
    }

    public void addFournisseur(Fournisseur fournisseur) {
        try {
            String query = "INSERT INTO fournisseur (libelle, contact) VALUES (?, ?)";
            try (PreparedStatement pst = connection.prepareStatement(query)) {
                pst.setString(1, fournisseur.getLibelle());
                pst.setString(2, fournisseur.getContact());
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately in your application
        }
    }

    public void deleteFournisseur(int fournisseurId) {
        try {
            String query = "DELETE FROM fournisseur WHERE id=?";
            try (PreparedStatement pst = connection.prepareStatement(query)) {
                pst.setInt(1, fournisseurId);
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately in your application
        }
    }
    public int getFournisseurCount() {
        int count = 0;
        try {
            String query = "SELECT COUNT(*) AS count FROM fournisseur";
            try (PreparedStatement pst = connection.prepareStatement(query)) {
                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        count = rs.getInt("count");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately in your application
        }
        return count;
    }

    public void updateFournisseur(Fournisseur fournisseur) {
        try {
            String query = "UPDATE fournisseur SET libelle=?, contact=? WHERE id=?";
            try (PreparedStatement pst = connection.prepareStatement(query)) {
                pst.setString(1, fournisseur.getLibelle());
                pst.setString(2, fournisseur.getContact());
                pst.setInt(3, fournisseur.getId());
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately in your application
        }
    }
}
