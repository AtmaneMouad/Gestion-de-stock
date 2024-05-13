package com.gestion;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.util.List;

@WebServlet("/FournisseurServlet")
public class FournisseurServlet extends HttpServlet {
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
                    addFournisseur(request);
                    break;
                case "delete":
                    deleteFournisseur(request);
                    break;
                case "update":
                    updateFournisseur(request);
                    break;
                default:
                    // Handle other cases
            }
        }

        // Display all fournisseurs after handling the action
        FournisseurDAO fournisseurDAO = new FournisseurDAO();
        List<Fournisseur> fournisseurs = fournisseurDAO.getAllFournisseurs();

        // Add a null check before setting the attribute in the request
        if (fournisseurs != null) {
            request.setAttribute("fournisseurs", fournisseurs);
        }

        request.getRequestDispatcher("fournisseur.jsp").forward(request, response);
    }

    private void addFournisseur(HttpServletRequest request) {
        String libelle = request.getParameter("libelle");
        String contact = request.getParameter("contact");

        FournisseurDAO fournisseurDAO = new FournisseurDAO();
        Fournisseur fournisseur = new Fournisseur(0, libelle, contact);
        fournisseurDAO.addFournisseur(fournisseur);
    }

    private void deleteFournisseur(HttpServletRequest request) {
        int fournisseurId = Integer.parseInt(request.getParameter("id"));

        FournisseurDAO fournisseurDAO = new FournisseurDAO();
        fournisseurDAO.deleteFournisseur(fournisseurId);
    }

    private void updateFournisseur(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String libelle = request.getParameter("libelle");
        String contact = request.getParameter("contact");

        FournisseurDAO fournisseurDAO = new FournisseurDAO();
        Fournisseur fournisseur = new Fournisseur(id, libelle, contact);
        fournisseurDAO.updateFournisseur(fournisseur);
    }
}
