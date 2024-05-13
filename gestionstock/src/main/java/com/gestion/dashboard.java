package com.gestion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/dashboard")
public class dashboard extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String buttonClicked = request.getParameter("buttonClicked");

        if ("Produit".equals(buttonClicked)) {
            List<Product> productList = getProductData(); // Fetch product data from the database
            request.setAttribute("productList", productList);
            request.getRequestDispatcher("/product.jsp").forward(request, response);
        } else if ("Categorie".equals(buttonClicked)) {
            List<Categorie> categorieList = getCategorieData("SELECT * FROM categorie");
            request.setAttribute("categorieList", categorieList);
            request.getRequestDispatcher("/category.jsp").forward(request, response);
        } else if ("Fournisseur".equals(buttonClicked)) {
            List<Fournisseur> fournisseurList = getFournisseurData("SELECT * FROM fournisseur");
            request.setAttribute("fournisseurList", fournisseurList);
            request.getRequestDispatcher("/fournir.jsp").forward(request, response);
        } else {
            response.sendRedirect("/dashboardjsp.jsp"); // Redirect to the dashboard if the button is not recognized
        }
    }

    private List<Product> getProductData() {
        List<Product> productList = new ArrayList<>();

        String jdbcUrl = "jdbc:mysql://localhost:3306/gestiostock";
        String dbUsername = "root";
        String dbPassword = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword)) {
                String query = "SELECT * FROM produit";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                        ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        int productId = resultSet.getInt("id");
                        String productName = resultSet.getString("libelle");
                        int productPrice = resultSet.getInt("prix");
                        int productQuantity = resultSet.getInt("quantite");
                        int categoryId = resultSet.getInt("idcategorie");
                        int fournisseurId = resultSet.getInt("idfournisseur");

                        Product product = new Product(productId, productName, productPrice, productQuantity, categoryId,fournisseurId);
                        productList.add(product);
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }

        return productList;
    }
    private List<Categorie> getCategorieData(String query) {
        List<Categorie> categorieList = new ArrayList<>();

        String jdbcUrl = "jdbc:mysql://localhost:3306/gestiostock";
        String dbUsername = "root";
        String dbPassword = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);
                 PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    int categoryId = resultSet.getInt("id");
                    String categoryLibelle = resultSet.getString("libelle");

                    // Create Categorie object and add to the list
                    Categorie categorie = new Categorie(categoryId, categoryLibelle);
                    categorieList.add(categorie);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }

        return categorieList;
    }

    // Method to fetch fournisseur data
    private List<Fournisseur> getFournisseurData(String query) {
        List<Fournisseur> fournisseurList = new ArrayList<>();

        String jdbcUrl = "jdbc:mysql://localhost:3306/gestiostock";
        String dbUsername = "root";
        String dbPassword = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);
                 PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    int fournisseurId = resultSet.getInt("id");
                    String fournisseurLibelle = resultSet.getString("libelle");
                    String fournisseurContact = resultSet.getString("contact");

                    // Create Fournisseur object and add to the list
                    Fournisseur fournisseur = new Fournisseur(fournisseurId, fournisseurLibelle, fournisseurContact);
                    fournisseurList.add(fournisseur);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }

        return fournisseurList;
    }
}