<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<style>
    <%@include file='/css/style.css' %>
</style>

<!DOCTYPE html>
<html>
<head>
    <title>Your Adventure</title>
</head>
<body>
<jsp:include page="headers/enter.jsp"/>

<%--<jsp:useBean id="loginForm" class="com.yadv.your_adventure.account.LoginForm"/>--%>
<div>
    <form class="enter" name="Simple" action="sign_in" method="POST">
        <h2 class="enter">Sign in</h2>
        <input type="hidden" name="email" value="${loginForm}"/>
        <div class="block">
            <snap>username: </snap>
            <label>
                <input type="text" name="hande_text_field" value=""/>
            </label>
        </div>
        <div class="block">
            <snap>password: </snap>
            <label>
                <input type="password" name="password_text_field" value=""/>
            </label>
            <input type="submit" name="button" value="Sign in"/>
        </div>
        <snap class="small_words block">Don't have an account?<a href="registration.jsp">Sign up</a></snap>
    </form>
</div>

<h4>${login_status}</h4>

<br/>
</body>
</html>