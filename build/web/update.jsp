<%-- 
    Document   : create
    Created on : Feb 28, 2022, 3:18:36 AM
    Author     : sannx
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!--        private String id;
                private String album_id;
                private String user_id;
                private String title;
                private String description;
                private String privacy;
                private String uploadDate;
                private int view;
                private String imagePath;-->
        <form action="update" method="post">
            <table>
                <tr>
                    <td>id</td>
                    <td><input type="text" name="id" readonly value="${photo==null?"null":photo.id}"/></td>
                </tr>
                <tr>
                    <td>album id</td>
                    <td><input type="text" name="album_id" value="${photo.album_id}"/></td>
                </tr>
                <tr>
                    <td>user id</td>
                    <td><input type="text" name="user_id" value="${photo.user_id}"/></td>
                </tr>
                <tr>
                    <td>title</td>
                    <td><input type="text" name="title" value="${photo.title}"/></td>
                </tr>
                <tr>
                    <td>description</td>
                    <td><input type="text" name="description" value="${photo.description}"/></td>
                </tr>

            </table>
            <c:forEach items="${listTag}" var="tag">
                <input ${tag.checked?"checked":""} class="tags" type="checkbox" name="tags" value="${tag.id}"/>${tag.title}<br/>
            </c:forEach>
            <input type="submit" value="edit"/>
        </form>     
    </body>
</html>
