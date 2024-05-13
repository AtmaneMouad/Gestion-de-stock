package com.gestion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String enteredUsername = request.getParameter("login");
        String enteredPassword = request.getParameter("password");

        if (validateUser(enteredUsername, enteredPassword)) {
            HttpSession session = request.getSession();
            session.setAttribute("loggedIn", true);

            response.sendRedirect("index.jsp");
        } else {
            int attemptsLeft = handleIncorrectAttempt(request);

            if (attemptsLeft > 0) {
                request.setAttribute("errorMessage", "Identifiants incorrects. Tentatives restantes : " + attemptsLeft);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                response.sendRedirect("login.jsp");
            }
        }
    }

    private boolean validateUser(String enteredUsername, String enteredPassword) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/gestiostock";
        String dbUsername = "root";
        String dbPassword = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword)) {
                String query = "SELECT * FROM admin WHERE login=? AND password=?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, enteredUsername);
                    preparedStatement.setString(2, enteredPassword);

                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        return resultSet.next(); // true if a matching user is found
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
            return false;
        }
    }

    private int handleIncorrectAttempt(HttpServletRequest request) {
        HttpSession session = request.getSession(true);

        int attemptsLeft;
        if (session.getAttribute("attemptsLeft") == null) {
            attemptsLeft = 2;
        } else {
            attemptsLeft = (int) session.getAttribute("attemptsLeft") - 1;
        }
        session.setAttribute("attemptsLeft", attemptsLeft);
        return attemptsLeft;
    }
}

