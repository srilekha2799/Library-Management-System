<h2>Add User</h2>

<form action="<%= request.getContextPath() %>/addUser" method="post">
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
    User ID: <input type="text" name="userID"><br><br>
    Name: <input type="text" name="name"><br><br>
    Department: <input type="text" name="department"><br><br>
    Phone: <input type="text" name="phone"><br><br>

    <button type="submit">Add User</button>

</form>