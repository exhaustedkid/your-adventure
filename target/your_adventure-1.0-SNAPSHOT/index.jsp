<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Your Adventure</title>
</head>
<body>

<h2><%= "Log in or "%>
    <a href="registration.jsp">sign in</a>
</h2>

<%--<jsp:useBean id="loginForm" class="com.yadv.your_adventure.account.LoginForm"/>--%>
<form name="Simple" action="sign_in" method="POST">
    <input type="hidden" name="email" value="${loginForm}"/>
    <label>
        <input type="text" name="hande_text_field" value="handle"/>
    </label>
    <label>
        <input type="password" name="password_text_field" value="password"/>
    </label>
    <input type="submit" name="button" value="Sign in"/>
</form>

<h4>${login_status}</h4>

<br/>
</body>
</html>