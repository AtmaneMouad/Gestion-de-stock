<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.gestion.Product" %>

<html>
<head>
    <title>Product List</title>
</head>
<body>
    <h2>Product List</h2>

    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Category ID</th>
                <th>Fournisseur ID</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Product> productList = (List<Product>) request.getAttribute("products");
                for (Product product : productList) {
            %>
                <tr>
                    <td><%= product.getId() %></td>
                    <td><%= product.getLibelle() %></td>
                    <td><%= product.getPrix() %></td>
                    <td><%= product.getQuantite() %></td>
                    <td><%= product.getIdcategorie() %></td>
                    <td><%= product.getIfournisseur() %></td>
                    <td>
                        <a href="ProduitServlet?action=edit&id=<%= product.getId() %>">Modifier</a>
                        |
                        <a href="ProduitServlet?action=delete&id=<%= product.getId() %>">Supprimer</a>
                    </td>
                </tr>
            <% } %>
        </tbody>
    </table>
    <a href="ProduitServlet?action=add">Ajouter</a>
</body>
</html>
