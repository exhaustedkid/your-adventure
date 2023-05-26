<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your Adventure</title>
</head>
<body>
<h1>Register, dude</h1>
<form name="Simple" action="register" method="POST">
    <input type="hidden" name="email"/>
    <label>
        <input type="text" name="handle_text_field" value="handle"/>
    </label>
    <label>
        <input type="text" name="name_text_field" value="name"/>
    </label>
    <label>
        <input type="text" name="surname_text_field" value="surname"/>
    </label>
    <label>
        <input type="text" name="email_text_field" value="email"/>
    </label>
    <label>
        <input type="password" name="password_text_field" value="password"/>
    </label>
    <label>
        <input type="password" name="confirmed_password_text_field" value="confirmed_password"/>
    </label>
    <input type="submit" name="button" value="Confirm"/>
</form>

<h4>${register_status}</h4>

</body>
</html>
