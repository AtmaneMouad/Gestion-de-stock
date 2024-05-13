<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.gestion.Fournisseur" %>

<html>
<head>
  <title>Fournisseur List</title>
</head>
<body>
<h2>Fournisseur List</h2>

<table border="1">
  <thead>
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Contact</th>
  </tr>
  </thead>
  <tbody>
  <%
    List<Fournisseur> fournisseurList = (List<Fournisseur>) request.getAttribute("fournisseurList");
    for (Fournisseur fournisseur : fournisseurList) {
  %>
  <tr>
    <td><%= fournisseur.getId() %></td>
    <td><%= fournisseur.getLibelle() %></td>
    <td><%= fournisseur.getContact() %></td>
    <td>
      <a href="FournisseurServlet?action=edit&id=<%= fournisseur.getId() %>">Modifier</a>
      |
      <a href="FournisseurServlet?action=delete&id=<%= fournisseur.getId() %>">Supprimer</a>
    </td>
  </tr>
  <% } %>
  </tbody>
</table>
<a href="FournisseurServlet?action=add">Ajouter</a>
</body>
</html>
