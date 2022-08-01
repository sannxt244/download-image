<%-- 
    Document   : manager
    Created on : Mar 15, 2022, 2:39:20 PM
    Author     : sannx
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            * {
                margin: 0;
                padding: 0;
            }
            table   {
                margin-left: 40px;
                border-collapse: collapse;
                border: 1px solid black;
            } 
            table  th {
                border: 1px solid black;
                padding: 15px;
                background-color: #afc4ea;
            }
            table  td {
                border: 1px solid black;
                padding: 15px;
            }
            h1 {
                margin-top: 140px;  
                margin-left: 40px;
            }
        </style>
    </head>
    <body>
        <jsp:include page="navbar.jsp"></jsp:include>
        <h1>Manager User</h1>
        <table>
            <tr>
                <th>User ID</th>
                <th>User name</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${data}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td><a onclick="confirmDelete('${user.id}')">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
        <form name="myForm" action="manager" method="post">
            <input name="id" type="hidden" value="" id="idField"/>
        </form>
        <script>
            function confirmDelete(id) {
                var c = confirm("Are you sure to delete user have id = " + id);
                if(c) {
                    document.getElementById("idField").value = id;
                    document.myForm.submit();
                }
            }
        </script>
    </body>
</html>
