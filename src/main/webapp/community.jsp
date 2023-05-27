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

<h2>
    <a href="editor.jsp">Create new map</a>
</h2>

<h2>${handle1} ${pic1}</h2>
<h2>${handle2} ${pic2}</h2>
<h2>${handle3} ${pic3}</h2>

<form name="load" action="load" method="POST">
    <input type="submit" name="button" value="Next page"/>
    <label>Page number ${page}</label>
    <input type="hidden" name="page" value=${page}>
</form>

<div class="canvas-container">
    <canvas id="draw"></canvas>
</div>


</body>
</html>
