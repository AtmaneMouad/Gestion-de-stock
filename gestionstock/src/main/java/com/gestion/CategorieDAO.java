package com.gestion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategorieDAO {

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

    public CategorieDAO() {
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

    public List<Categorie> getAllCategories() {
        List<Categorie> categories = new ArrayList<>();
        try {
            String query = "SELECT * FROM categorie";
            try (PreparedStatement pst = connection.prepareStatement(query)) {
                try (ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String libelle = rs.getString("libelle");
                        Categorie categorie = new Categorie(id, libelle);
                        categories.add(categorie);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately in your application
        }
        return categories;
    }

    public void addCategorie(Categorie categorie) {
        try {
            String query = "INSERT INTO categorie (libelle) VALUES (?)";
            try (PreparedStatement pst = connection.prepareStatement(query)) {
                pst.setString(1, categorie.getLibelle());
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately in your application
        }
    }

    public void deleteCategorie(int categorieId) {
        try {
            String query = "DELETE FROM categorie WHERE id=?";
            try (PreparedStatement pst = connection.prepareStatement(query)) {
                pst.setInt(1, categorieId);
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately in your application
        }
    }


    public void updateCategorie(Categorie categorie) {
        try {
            String query = "UPDATE categorie SET libelle=? WHERE id=?";
            try (PreparedStatement pst = connection.prepareStatement(query)) {
                pst.setString(1, categorie.getLibelle());
                pst.setInt(2, categorie.getId());
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately in your application
        }
    }

    public int getCategoryCount() {
        int count = 0;
        try {
            String query = "SELECT COUNT(*) AS count FROM categorie";
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



}
