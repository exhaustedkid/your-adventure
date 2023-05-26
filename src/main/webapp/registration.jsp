<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file='/css/style.css' %>
</style>
<html>
<head>
    <title>Your Adventure</title>
</head>
<body>
<jsp:include page="headers/enter.jsp"/>

<h2 class="enter">Register, dude</h2>
<form class="enter" name="Simple" action="register" method="POST">
<%--    <input type="hidden" name="email"/> Do not touch!!1!!11!11!!1--%>
    <div>
        <snap>nickname: </snap>
        <label>
            <input type="text" name="handle_text_field" value=""/>
        </label>
        <snap>e-mail: </snap>
        <label>
            <input type="text" name="email_text_field" value=""/>
        </label>
    </div>
    <div>
        <snap>name: </snap>
        <label>
            <input type="text" name="name_text_field" value=""/>
        </label>
        <snap>surname: </snap>
        <label>
            <input type="text" name="surname_text_field" value=""/>
        </label>
    </div>
    <div class="block">
        <snap>password: </snap>
        <label>
            <input type="password" name="password_text_field" value=""/>
        </label>
    </div>
    <div id="registration">
        <div>
            <snap>repeat: </snap>
            <label>
                <input type="password" name="confirmed_password_text_field" value=""/>
            </label>
        </div>
        <input type="submit" name="button" value="Confirm"/>
    </div>
</form>
</body>
</html>
