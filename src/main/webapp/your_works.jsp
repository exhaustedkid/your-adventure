<%@ page import="static java.lang.constant.ConstantDescs.NULL" %>
<style>
    <%@include file='/css/style.css' %>
</style>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Adventure</title>
    <script type="text/javascript">
        let image = '${pic1}';
    </script>
    <script src="image_loader.js" defer></script>
</head>
<body>

<jsp:include page="headers/app.jsp"/>
<%
    if (request.getParameter("handle") != NULL) {
        new String("...");
    }
//        request.getParameter("handle")
%>


<h2>You are ${handle}</h2>
<h2>You have ${pictures_count} works</h2>

<form name="drawer" action="drawer" method="POST">
    <input type="submit" name="button" value="Create new map"/>
    <input type="hidden" name="handle" value="${handle}">
</form>


<img src="${pic1}" alt="blod" width="1200" height="1000" />
<img src="${pic2}" alt="blod" width="1200" height="1000" />
<img src="${pic3}" alt="blod" width="1200" height="1000" />


<form name="profile" action="profile" method="POST">
    <input type="submit" name="button" value="Next page"/>
    <label>Page number ${page}</label>
    <input type="hidden" name="page" value=${page}>
    <input type="hidden" name="handle" value=${handle}>
</form>


</body>
</html>
