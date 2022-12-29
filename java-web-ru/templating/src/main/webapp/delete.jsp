<%@ page import="org.apache.tomcat.jni.User" %>
<%@ page import="java.util.Map" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- BEGIN -->
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
</head>
<body>
<%
    Map<String, String> us = (Map<String, String>) request.getAttribute("us");
%>
<a>
    Выдействительно хотите удалить пользователя
</a>
<table>
    <tr>
        <td>ID: <%=us.get("id")%>
        </td>
    </tr>
    <tr>
        <td>firstName: <%=us.get("firstName")%>
        </td>
    </tr>
    <tr>
        <td>lastName: <%=us.get("lastName")%>
        </td>
    </tr>
</table>
<form method="post" action="/users/delete?id=<%=us.get("id")%>">
    <input type="submit" value="Удалить"/>
</form>
</body>
</html>
<!-- END -->
