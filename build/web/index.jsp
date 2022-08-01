<%@page import="dal.PhotoDAO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Home - Imageram</title>
        <link rel="stylesheet" href="assets/css/main.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" integrity="sha512-9usAa10IRO0HhonpyAIVpjrylPvoDwiPUiKdWk5t3PyolY1cOd4DSE0Ga+ri4AuTroPR5aQvXU9xC6qOPnzFeg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <style>
            th {
                padding: 5px 15px;
            }
            th:hover {
                cursor: pointer;
            }
        </style>
    </head>
    <body>

        <div class="header">
            <%@include file="navbar.jsp"%>
            <div class="header--banner">
                <div class="searchform">
                    The best free stock photos, royalty <br/> free images shared by creators.

                </div>

            </div>
        </div>

        <%--<div id="photo--wrapper" class="photo--wrapper"></div>    --%>

        <div class="container">
            <div class="container--bar">
                <table>
                    <tr>
                        <th style="background-color: white">Trending:</th>
                        <th class="tags" id="all" onclick="loadByTag('all')">All</th>
                            <c:forEach items="${listTrendingTags}" var="tag">
                            <th class="tags" id="${tag.title}" onclick="loadByTag('${tag.title}')">${tag.title}</th>
                            </c:forEach>
                    </tr>
                </table>
                <div style="font-weight: bold" class="tags" id="follow" class="tags" onclick="loadByTag('follow')">My Follow</div>
            </div>
            <div class="container--images" id="container--images">
                <c:forEach items="${listPhoto}" var="photo">
                    <a class="image" href="photo?id=${photo.id}">
                        <img src="${photo.getImagePath()}">
                    </a>
                </c:forEach>

            </div>
        </div>   
        <div>view:${view}</div>
        <div style="display: none" id="pageTitle">${pageTitle}</div>
        <%@include file="footer.jsp"%>
        <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
        <script>
                                pageId = 1;
                                tagTitle = 'all';
                                $(window).scroll(function () {
                                    if ($(window).scrollTop() === $(document).height() - $(window).height()) {
                                        load();
                                    }
                                });
                                function load() {
                                    pageId++;
                                    console.log(pageId);
                                    console.log(tagTitle);
                                    $.ajax({
                                        url: "/imageram/list",
                                        type: "get",
                                        data: {
                                            page: pageId,
                                            tagTitle: tagTitle
                                        },
                                        success: function (responseData) {
                                            document.getElementById("container--images").innerHTML += responseData;
                                        }
                                    });
                                }
                                function loadByTag(id) {
                                    changeColor(id);
                                    pageId = 1;
                                    tagTitle = id;
                                    $.ajax({
                                        url: "/imageram/list",
                                        type: "get",
                                        data: {
                                            page: pageId,
                                            tagTitle: tagTitle
                                        },
                                        success: function (responseData) {
                                            document.getElementById("container--images").innerHTML = responseData;
                                        }
                                    });
                                }
                                changeColor('all');
                                function changeColor(id) {
                                    const collection = document.getElementsByClassName("tags");
                                    for (let i = 0; i < collection.length; i++) {
                                        collection[i].style.border = "none";
                                    }
                                    document.getElementById(id).style.borderBottom = "2px solid black";
                                    return false;
                                }

                                function loadImg(id) {
                                    document.getElementById("photo--wrapper").scrollIntoView();
                                    document.getElementById("photo--wrapper").style.display = 'block';
                                    pageId++;
                                    console.log(pageId);
                                    $.ajax({
                                        url: "/imageram/photo",
                                        type: "get",
                                        data: {
                                            id: id
                                        },
                                        success: function (responseData) {
                                            document.getElementById("photo--wrapper").innerHTML = responseData;
                                        }
                                    });
                                }
        </script>
    </body>
</html>
