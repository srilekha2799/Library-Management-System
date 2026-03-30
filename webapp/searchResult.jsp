<%@ page import="java.util.*,model.Book" %>
<style>
body {
    font-family: Arial;
    background-color: #f5f5f5;
    text-align: center;
}

form {
    margin-top: 20px;
}

input, select {
    padding: 8px;
    margin: 5px;
}

button {
    padding: 10px 15px;
    background-color: #4CAF50;
    color: white;
    border: none;
    border-radius: 5px;
}
</style>

<h2>Search Results</h2>

<table border="1">
<tr>
    <th>ID</th>
    <th>Title</th>
    <th>Author</th>
</tr>

<%
List<Book> list = (List<Book>) request.getAttribute("books");

for(Book b : list){
%>
<tr>
    <td><%= b.getBookID() %></td>
    <td><%= b.getTitle() %></td>
    <td><%= b.getAuthor() %></td>
</tr>
<% } %>
</table>