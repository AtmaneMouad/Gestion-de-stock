package com.gestion;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.util.List;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "add":
                    addProduct(request);
                    break;
                case "delete":
                    deleteProduct(request);
                    break;
                case "update":
                    updateProduct(request);
                    break;
                default:
                    // Handle any other cases if needed
                    break;
            }
        }

        ProductDAO productDAO = new ProductDAO();
        List<Product> products = productDAO.getAllProducts();

        if (products != null) {
            request.setAttribute("products", products);
        }

        request.getRequestDispatcher("productor.jsp").forward(request, response);
    }

    private void addProduct(HttpServletRequest request) {
        String libelle = request.getParameter("libelle");
        int prix = Integer.parseInt(request.getParameter("prix"));
        int quantite = Integer.parseInt(request.getParameter("quantite"));
        int idcategorie = Integer.parseInt(request.getParameter("idcategorie"));
        int idfournisseur = Integer.parseInt(request.getParameter("idfournisseur"));

        ProductDAO productDAO = new ProductDAO();
        Product product = new Product(0, libelle, prix, quantite, idcategorie, idfournisseur);
        productDAO.addProduct(product);
    }

    private void deleteProduct(HttpServletRequest request) {
        int productId = Integer.parseInt(request.getParameter("id"));

        ProductDAO productDAO = new ProductDAO();
        productDAO.deleteProduct(productId);
    }

    private void updateProduct(HttpServletRequest request) {

        int id = Integer.parseInt(request.getParameter("id"));
        String libelle = request.getParameter("libelle");
        int prix = Integer.parseInt(request.getParameter("prix"));
        int quantite = Integer.parseInt(request.getParameter("quantite"));
        int idcategorie = Integer.parseInt(request.getParameter("idcategorie"));
        int idfournisseur = Integer.parseInt(request.getParameter("idfournisseur"));




        ProductDAO productDAO = new ProductDAO();
        Product product = new Product(id, libelle, prix, quantite, idcategorie, idfournisseur);
        productDAO.updateProduct(product);
    }
}
