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
<table>
    <tr>
        <td>id</td>
        <td>firstName</td>
        <td>lastName</td>
        <td>email</td>
    </tr>
    <tr>
        <td><%=us.get("id")%>
        </td>
        <td><%=us.get("firstName")%>
        </td>
        <td><%=us.get("lastName")%>
        </td>
        <td><%=us.get("email")%>
        </td>
        <td></td>
        <td><a href='/users/delete?id=${us.get("id")}'>Удалить пользователя?</a></td>
    </tr>
</table>
</body>
</html>
<!-- END -->