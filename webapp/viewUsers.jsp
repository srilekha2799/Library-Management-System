<%@ page import="java.util.*,model.User,service.LibraryService" %>

<h2>User List</h2>

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
<table border="1">
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Department</th>
    <th>Phone</th>
</tr>

<%
LibraryService service = new LibraryService();
ArrayList<User> list = service.getAllUsers();

for(User u : list){
%>
<tr>
    <td><%= u.getUserID() %></td>
    <td><%= u.getName() %></td>
    <td><%= u.getDepartment() %></td>
    <td><%= u.getPhone() %></td>
</tr>
<% } %>
</table>