<h2>Return Book</h2>

<form action="<%= request.getContextPath() %>/returnBook" method="post">
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
    Issue ID: <input type="text" name="issueID"><br><br>

    <button type="submit">Return Book</button>

</form>