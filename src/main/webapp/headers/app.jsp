<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.io.PrintWriter"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<div class="header">
  <span class="block">
    <c:if test="${handle == ''}">
      Guest
    </c:if>
    <c:if test="${handle != ''}">
      ${handle}
    </c:if>
  </span>
  <span class="block">Your Adventure</span>
  <div>
    <button onclick="document.location='community.jsp'">community.jsp</button>
    <button onclick="document.location='create.jsp'">create.jsp</button>
  </div>
</div>
</html>
