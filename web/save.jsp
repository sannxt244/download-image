<%-- 
    Document   : save
    Created on : Mar 13, 2022, 1:54:14 AM
    Author     : sannx
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Save-Imageram</title>
        <style>
            *{
                padding: 0;
                margin: 0;
            }
            h1 {
                margin-top: 140px; 
            }
            .content {
                min-height: 100vh;
            }

            .image--content {
                display: flex;
            }
            
            .image {
                margin: 10px;
                width: 400px;
                height: 400px;
            }

            img {
                width: 100%;
                height: 100%;
                object-fit: cover;
            }
        </style>
    </head>
    <body>
        <jsp:include page="navbar.jsp"></jsp:include>
            <div class="content">
                <h1>${photoid}</h1>
            <div class="image--content">
                <c:forEach items="${savePhoto}" var="photo">
                    <a class="image" href="photo?id=${photo.id}">
                        <img src="${photo.getImagePath()}">
                    </a>
                </c:forEach>
            </div>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
