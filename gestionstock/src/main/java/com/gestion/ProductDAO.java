package com.gestion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class ProductDAO {

    private Connection connection;

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

    public ProductDAO() {
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

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try {
            String query = "SELECT * FROM produit";  // Assuming your table name is "produit"
            try (PreparedStatement pst = connection.prepareStatement(query)) {
                try (ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String libelle = rs.getString("libelle");
                        int prix = rs.getInt("prix");
                        int quantite = rs.getInt("quantite");
                        int idcategorie = rs.getInt("idcategorie");
                        int idfournisseur = rs.getInt("idfournisseur");

                        Product product = new Product(id, libelle, prix, quantite, idcategorie, idfournisseur);
                        products.add(product);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately in your application
        }
        return products;
    }


    public void addProduct(Product product) {
        try {
            String query = "INSERT INTO produit(libelle, prix, quantite, idcategorie, idfournisseur) VALUES (?,?,?,?,?)";
            try (PreparedStatement pst = connection.prepareStatement(query)) {
                pst.setString(1, product.getLibelle());
                pst.setInt(2, product.getPrix());
                pst.setInt(3, product.getQuantite());
                pst.setInt(4, product.getIdcategorie());
                pst.setInt(5, product.getIfournisseur());
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(int productId) {
        try {
            String query = "DELETE FROM produit WHERE id=?";
            try (PreparedStatement pst = connection.prepareStatement(query)) {
                pst.setInt(1, productId);
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProduct(Product product) {
        try {

            String query = "UPDATE produit SET libelle=?, prix=?, quantite=?,idcategorie=? ,idfournisseur=? WHERE id=?";
            try (PreparedStatement pst = connection.prepareStatement(query)) {
                pst.setString(1, product.getLibelle());
                pst.setInt(2,product.getPrix());
                pst.setInt(3,product.getQuantite());
                pst.setInt(4,product.getIdcategorie());
                pst.setInt(5,product.getIfournisseur());
                pst.setInt(6, product.getId());
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int getProductCount() {
        int count = 0;
        try {
            String query = "SELECT COUNT(*) AS count FROM produit";
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
