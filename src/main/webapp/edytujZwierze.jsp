<%--
  Created by IntelliJ IDEA.
  User: TKK
  Date: 2017-01-27
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@page import="dao.model.Zwierze"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edytuj Zwierze</title>
</head>
<body>
<%
    Zwierze zw = (Zwierze) session.getAttribute("zwierze");
%>

<form action="/EdytujZwierzeServlet" method="get">
    Nazwa:<br />
    <input name="nazwa" value="<%=zw.getNazwa()%>" /><br />

    Poziom Najedzenia:<br />

    <input name="poziomnajedzenia" value="<%=zw.getPoziomNajedzenia()%>" /><br />

    Tempo jedzenie:
    <input name="tempojedzenia" value="<%=zw.getTempoJedzenia()%>" /><br />
    <input type="submit" value="Zapisz"/>
</form>


</body>
</html>
