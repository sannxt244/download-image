<%-- 
    Document   : post
    Created on : Feb 28, 2022, 12:03:57 PM
    Author     : sannx
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
        <link rel="stylesheet" href="assets/css/post.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" integrity="sha512-9usAa10IRO0HhonpyAIVpjrylPvoDwiPUiKdWk5t3PyolY1cOd4DSE0Ga+ri4AuTroPR5aQvXU9xC6qOPnzFeg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    </head>
    <style>
        .container {
            position: relative;
            width: 50%;
        }

        .image {
            display: block;
            width: 100%;
            height: auto;
        }

        .overlay {
            border-radius: 50%;
            position: absolute;
            top: 0;
            bottom: 0;
            left: 0;
            right: 0;
            height: 100%;
            width: 100%;
            opacity: 0;
            transition: .5s ease;
            background-color: #bebebe;
        }

        .container:hover .overlay {
            opacity: 0.6;
        }

        .text {
            color: white;
            font-size: 20px;
            position: absolute;
            top: 50%;
            left: 50%;
            -webkit-transform: translate(-50%, -50%);
            -ms-transform: translate(-50%, -50%);
            transform: translate(-50%, -50%);
            text-align: center;
            
        }
    </style>
    <body>
        <%@include file="navbar.jsp" %>
        <div class="info">
            <div class="info--avatar">
                <label for="image" class="">
                    <form class="container" style="width: 100%;height: 100%;" action="changeavatar" method="post" name="myForm" enctype="multipart/form-data">
                        <input onchange="loadFile(event)" type="file" name="image" id="image" style="display:none;"/>
                        <img class="image" id="output" src="${avatar}" alt="">
                        <div class="overlay">
                            <div class="text">Upload image</div>
                        </div>
                        <input style="display: none" id="save--btn" type="submit" value="save"/>
                    </form>
                </label>
            </div>
            <div>
                <div class="info--header">
                    <div class="info--header__avatar">${username}</div>
                    <a class="create--btn" href="create">+</a>
                </div>
                <div class="info--stat">
                    <div class="info--stat__post"><b>${list.size()}</b> post</div>
                    <div class="info--stat__follower"><b>${amountFollower}</b> followers</div>
                </div>
            </div>
        </div>
        <div class="image--wrapper">
            <c:forEach items="${list}" var="photo">
                <a class="image--info" href="photo?id=${photo.id}">
                    <img src="${photo.getImagePath()}">
                </a>

            </c:forEach>
        </div> 

        <%@include file="footer.jsp" %>
        <script>
            var loadFile = function (event) {
                var output = document.getElementById('output');
                output.src = URL.createObjectURL(event.target.files[0]);
                document.getElementById("save--btn").style.display = "block";
            };
        </script>
    </body>
</html>
