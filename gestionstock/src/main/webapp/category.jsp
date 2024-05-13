<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.gestion.Categorie" %>

<html>
<head>
  <title>Categorie List</title>
</head>
<body>
<h2>Categorie List</h2>

<table border="1">
  <thead>
  <tr>
    <th>ID</th>
    <th>Name</th>
  </tr>
  </thead>
  <tbody>
  <%
    List<Categorie> categorieList = (List<Categorie>) request.getAttribute("categorieList");
    for (Categorie categorie : categorieList) {
  %>
  <tr>
    <td><%= categorie.getId() %></td>
    <td><%= categorie.getLibelle() %></td>
    <td>
      <a href="CategorieServlet?action=edit&id=<%= categorie.getId() %>">Modifier</a>
      |
      <a href="CategorieServlet?action=delete&id=<%= categorie.getId() %>">Supprimer</a>
    </td>
  </tr>
  <% } %>
  </tbody>
</table>
<a href="CategorieServlet?action=add">Ajouter</a>


</body>
</html>
