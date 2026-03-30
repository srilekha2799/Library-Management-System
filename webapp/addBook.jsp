<form action="<%= request.getContextPath() %>/addBook" method="post">

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
    Book ID: <input type="text" name="bookID"><br>
    Title: <input type="text" name="title"><br>
    Author: <input type="text" name="author"><br>
    Category: <input type="text" name="category"><br>
    Quantity: <input type="text" name="quantity"><br>

    <button type="submit">Add Book</button>
</form>