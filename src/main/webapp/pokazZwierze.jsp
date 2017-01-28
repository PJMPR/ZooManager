<%@page import="dao.model.Zwierze" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Lista Zwierzat</title>
</head>
<body>
<%
    Zwierze zw = (Zwierze) session.getAttribute("zwierze");

%>
<h1>Zwierze :</h1>
<h2>Id: <%=zw.getId()%>
</h2>
<h2>Nazwa: <%=zw.getNazwa()%>
</h2>
<h2>Poziom najedzenia: <%=zw.getPoziomNajedzenia()%>
</h2>
<h2>Tempo jedzenia: <%=zw.getTempoJedzenia()%>
</h2>
<br/>
<a href="edytujZwierze.jsp">Edytuj</a>
<a href="pokazZwierzeta.jsp">Powrót</a>
<br/>
<form action="UsunZwierzeServlet" method="get">
    <input type="hidden"  name="idZwierze" value="<%=zw.getId()%>">
    <input type="submit" value="Usuń"/>
</form>
<%--<button type="button" onclick="usunZwierze.jsp">Click Me!</button>--%>
</body>
</html>