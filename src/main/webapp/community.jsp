<%@ page import="static java.lang.constant.ConstantDescs.NULL" %>
<style>
    <%@include file='/css/style.css' %>
</style>
<html>
<head>
    <title>Your Adventure</title>
</head>
<body>
<jsp:include page="headers/app.jsp"/>
<%
    if (request.getParameter("handle") != NULL) {
      new String("...");
    }
//        request.getParameter("handle")
%>

</body>
</html>
