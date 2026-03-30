<!DOCTYPE html>
<html>
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
<head>
    <title>Login</title>
</head>
<body>

<h2>Library Login</h2>

<form action="login" method="post">

    Username: <input type="text" name="username"><br><br>

    Password: <input type="password" name="password"><br><br>

    <button type="submit">Login</button>

</form>

</body>
</html>