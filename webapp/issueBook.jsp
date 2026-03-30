<%@ page import="java.util.*,model.Book,model.User,service.LibraryService" %>
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
<h2>Issue Book</h2>

<form action="<%= request.getContextPath() %>/issueBook" method="post">

Issue ID: <input type="text" name="issueID"><br><br>

Book:
<select name="bookID">
<%
LibraryService service = new LibraryService();
List<Book> books = service.getAllBooks();

for(Book b : books){
%>
<option value="<%= b.getBookID() %>">
    <%= b.getTitle() %>
</option>
<% } %>
</select><br><br>

User:
<select name="userID">
<%
List<User> users = service.getAllUsers();

for(User u : users){
%>
<option value="<%= u.getUserID() %>">
    <%= u.getName() %>
</option>
<% } %>
</select><br><br>

<button type="submit">Issue Book</button>

</form>