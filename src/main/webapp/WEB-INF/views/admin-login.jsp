<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Admin Login</title></head>
<body>
    <h2>Admin Login</h2>
    <form method="post" action="/admin/login">
        <label>Username:</label><input type="text" name="username" required /><br/>
        <label>Password:</label><input type="password" name="password" required /><br/>
        <button type="submit">Login</button>
    </form>
</body>
</html>
