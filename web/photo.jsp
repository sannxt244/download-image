<%-- 
    Document   : photo
    Created on : Mar 7, 2022, 1:00:35 AM
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
            *{
                margin: 0;
                padding: 0;
            }
            body {
                background-color: #000000;
                font-family: 'Poppins', sans-serif;
                font-size: 20px;
            }
            .photo--wrapper {
                width: 70%;
                background-color: #ffffff;
                margin: 0 auto;
            }

            .photo {
                width: 500px;
                height: 500px;
                margin: 0 auto;
                padding: 99px 0;
            }

            .info {
                margin: 0 50px;
                padding: 40px 0;
                border-bottom: 1px solid #cacaca;
                border-top: 1px solid #cacaca;
            }

            .info > div {
                margin-bottom: 30px;
            }

            .info--header {
                display: flex;
                justify-content: space-between;
            }
            img {
                width: 100%;
                height: 100%;
                object-fit: cover;
            }

            .relate--photo {
                margin: 5px;
                width: 200px;
                height: 200px;
            }

            .relate--photo__wrapper {
                padding: 40px 0;
                margin: 0 auto;
                width: 70%;
                display: flex;
                justify-content: center;
                flex-wrap: wrap;
            }

            .tag__wrapper {
                display: flex;
                flex-wrap: wrap;
            }

            .tag {
                padding: 10px 25px;
                margin-right: 10px;
                border-radius: 7px;
                background-color: #e7e7e7;
            }

            a {
                text-decoration: none;
                color: #000000;
            }

            a:hover {
                color: #5bb9ff;
                cursor: pointer;
            }

            .saveForm {
                display: none;
            }
            input {
                border: none;
                font-family: 'Poppins', sans-serif;
                font-size: 20px;
            }
        </style>
    </head>
    <body>
        <jsp:include page="navbar.jsp"></jsp:include>
            <div class="photo--wrapper">
                <div class="photo">
                    <img src="${photo.getImagePath()}"/>
            </div>
            <div class="info">
                <div class="info--header">
                    <div style="white-space: nowrap;">
                        ${photo.user_id}
                        <c:if test="${user != null && user.id != photo.user_id}">
                            <c:if test="${isfollow == true}">
                                <a id="follow" onclick="handlefollow('unfollow','${photo.user_id}', '${user.id}')">unfollow</a>
                            </c:if>
                            <c:if test="${isfollow == false}">
                                <a id="follow" onclick="handlefollow('follow','${photo.user_id}', '${user.id}')">follow</a>
                            </c:if>
                        </c:if>
                    </div>
                    <div>View:${photo.view}</div>
                    <div>
                        <c:if test="${userid!=photo.user_id}">
                            <form name="saveForm" action="save">
                                <input id="photoid" type="hidden" value="" name="photoid"/>
                                <button type="button" onclick="save(${photo.id})">
                                    <i class="fa-solid fa-clock"></i>
                                </button>
                            </form>
                        </c:if>
                        <c:if test="${userid==photo.user_id}">
                            <a href="update?id=${photo.id}">Edit</a>
                            <a onclick="confirmMess('${photo.id}')">Delete</a>
                        </c:if>
                    </div>
                </div>
                <div class="info--content">
                    <div>${photo.title}</div>
                    <div>${photo.description}</div>

                </div>

                <div class="tag__wrapper">
                    <c:forEach items="${photo.tags}" var="tag">
                        <input class="tag" onclick="handleCheck('${tag}')" type="button" value="${tag}"/><br/>
                    </c:forEach>
                </div>
                <form style="display: none" action="explore" method="post" name="tagform">  
                    <input type="checkbox" name="tags" id="tagField" />
                </form>   
            </div>
            <div class="relate--photo__wrapper">
                <c:forEach items="${relatePhoto}" var="relate">
                    <a href="photo?id=${relate.id}" class="relate--photo">
                        <img src="${relate.getImagePath()}"/>
                    </a>
                </c:forEach>
            </div>
        </div>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" integrity="sha512-9usAa10IRO0HhonpyAIVpjrylPvoDwiPUiKdWk5t3PyolY1cOd4DSE0Ga+ri4AuTroPR5aQvXU9xC6qOPnzFeg==" crossorigin="anonymous" referrerpolicy="no-referrer" />            
        <script src="assets/js/jquery-3.6.0.min.js"></script>
        <script>
                            function handleCheck(tag) {
                                document.getElementById("tagField").value = tag;
                                document.getElementById("tagField").checked = true;
                                document.tagform.submit();
                            }
                            function confirmMess(id) {
                                var result = confirm("Do u want to delete?");
                                if (result) {
                                    window.location.assign("delete?id=" + id);
                                }
                            }

                            function save(id) {
                                document.getElementById("photoid").value = id;
                                document.saveForm.submit();
                            }
                            function handlefollow(action, userId, followerId) {
                                console.log(action);
                                console.log(userId);
                                console.log(followerId);
                                $.ajax({
                                    url: "/imageram/follow",
                                    type: "get",
                                    data: {
                                        actionRaw: action,
                                        userId: userId,
                                        followerId: followerId
                                    },
                                    success: function (responseData) {
                                        location.reload();
                                    }
                                });
                            }
                            
        </script>
    </body>
</html>
