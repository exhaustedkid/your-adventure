<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your Adventure</title>
</head>
<body>
<h1>Hey! Here will be some pictures of good maps!</h1>
<h3>You authorised as ${handle}</h3>

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

<form name="save" action="manage_img" method="post" enctype="multipart/form-data">
    <input type="file" name="file">
    <input type="submit" value="Submit">
</form>


</body>
</html>
