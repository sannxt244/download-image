<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="assets/css/navbar.css">
        <script src="https://kit.fontawesome.com/ce672ea6c4.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <nav>
            <a class="nav--logo" href="home">
                <img src="assets/img/logo.png"/>
            </a>
            <div class="nav__right">
                <a href="save">Save</a>
                <a href="explore">Explore</a>
                <c:if test = "${sessionScope.user==null}">
                    <a class="nav--login btn" href="login">
                        Login
                    </a>
                </c:if>
                <c:if test = "${sessionScope.user!=null}">
                    <div class="nav--login btn">
                        ${sessionScope.user.id}
                        <div class="nav--login__user">
                            <a href="post">Profile</a><br/>
                            <a href="settings">Setting</a><br/>
                            <a href="logout">Log out</a>
                        </div>
                    </div>
                </c:if>
            </div>
        </nav>
    </body>
</html>