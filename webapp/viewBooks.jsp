<%@ page import="java.util.*, model.Book" %>

<html>
<head>
<title>View Books</title>

<style>
body {
    font-family: Arial;
    background-color: #f5f5f5;
    text-align: center;
}

table {
    margin: auto;
    border-collapse: collapse;
    width: 70%;
}

th, td {
    padding: 10px;
    border: 1px solid black;
}

th {
    background-color: #4CAF50;
    color: white;
}
</style>

</head>

<body>

<h2> Book List</h2>

<table>
<tr>
    <th>ID</th>
    <th>Title</th>
    <th>Author</th>
    <th>Category</th>
    <th>Quantity</th>
</tr>

<%
List<Book> list = (List<Book>) request.getAttribute("books");

if(list != null && !list.isEmpty()){
    for(Book b : list){
%>

<tr>
    <td><%= b.getBookID() %></td>
    <td><%= b.getTitle() %></td>
    <td><%= b.getAuthor() %></td>
    <td><%= b.getCategory() %></td>
    <td><%= b.getQuantity() %></td>
</tr>

<%
    }
} else {
%>

<tr>
    <td colspan="5">No books found </td>
</tr>

<%
}
%>

</table>

</body>
</html>