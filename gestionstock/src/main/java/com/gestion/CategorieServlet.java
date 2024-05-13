package com.gestion;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.util.List;

@WebServlet("/CategorieServlet")
public class CategorieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Redirect to doPost to handle the form submissions
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "add":
                    addCategorie(request);
                    break;
                case "delete":
                    deleteCategorie(request);
                    break;
                case "update":
                    updateCategorie(request);
                    break;
                default:
                    // Handle other cases
            }
        }

        // Display all categories after handling the action
        CategorieDAO categorieDAO = new CategorieDAO();
        List<Categorie> categories = categorieDAO.getAllCategories();

        // Add a null check before setting the attribute in the request
        if (categories != null) {
            request.setAttribute("categories", categories);
        }

        request.getRequestDispatcher("categorie.jsp").forward(request, response);
    }

    private void addCategorie(HttpServletRequest request) {
        String libelle = request.getParameter("libelle");

        CategorieDAO categorieDAO = new CategorieDAO();
        Categorie categorie = new Categorie(0, libelle);
        categorieDAO.addCategorie(categorie);
    }

    private void deleteCategorie(HttpServletRequest request) {
        int categorieId = Integer.parseInt(request.getParameter("id"));

        CategorieDAO categorieDAO = new CategorieDAO();
        categorieDAO.deleteCategorie(categorieId);
    }

    private void updateCategorie(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String libelle = request.getParameter("libelle");

        CategorieDAO categorieDAO = new CategorieDAO();
        Categorie categorie = new Categorie(id, libelle);
        categorieDAO.updateCategorie(categorie);
    }
}
