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

<script type="text/javascript">
    console.log('here1');
</script>

<script>
    let canvas = document.getElementById("draw");
    let ctx = canvas.getContext("2d");
    ctx.canvas.width = 1000;
    ctx.canvas.height = 1000;
    let image = new Image();
    console.log("here");
    image.src = "map.png";
    ctx.drawImage(image, 0, 0);
</script>

<%--<script language="JavaScript">--%>
<%--<script type="text/javascript">--%>
<%--    --%>
<%--</script>--%>

<h2>${handle1} ${pic1}</h2>
<h2>${handle2} ${pic2}</h2>
<h2>${handle3} ${pic3}</h2>

<form name="load" action="load" method="POST">
    <input type="submit" name="button" value="Next page"/>
    <label>Page number ${page}</label>
    <input type="hidden" name="page" value=${page}>
</form>

<script src="image_loader.js" defer>
    draw_image("map.png");
</script>

<%--<img src=map.png alt="">--%>

</body>
</html>
