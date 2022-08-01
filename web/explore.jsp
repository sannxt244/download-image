<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Explore-Imageram</title>
        <link rel="stylesheet" href="assets/css/explore.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" integrity="sha512-9usAa10IRO0HhonpyAIVpjrylPvoDwiPUiKdWk5t3PyolY1cOd4DSE0Ga+ri4AuTroPR5aQvXU9xC6qOPnzFeg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <script src="assets/js/explore.js"></script>
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        <div class="header--banner">
            <div class="searchform">
                <input class="searchform--input" id="searchField__raw" name="search" value="${search}"/>
                <button class="searchform--button" onclick="submitForms()">
                    <i class="fa-solid fa-magnifying-glass"></i>
                </button>
            </div>
            <div class="container">
                <div class="tag-container">
                </div>

            </div>
        </div>
        <div class="main--content">
            <div class="sidebar">
                <form id="category" action="explore" method="post" name="form">
                    <input type="hidden" name="order" id="orderField"/>
                    <input type="hidden" name="page" id="pageField"/>
                    <input type="hidden" name="search" id="searchField"/>
                    <c:forEach items="${listTag}" begin = "0" end = "${listTag.size()}" var="tag">
                        <input ${tag.checked?"checked":""} onclick="handleCheck('${tag.title}')" type="checkbox" name="tags" value="${tag.title}" id="${tag.title}" />${tag.title}<br/>
                    </c:forEach>
                    <input class="btn" type="submit" value="Find" onclick="submitForms()"/>
                </form>
            </div>
            <div class="content">
                <div class="container--bar">
                    <div>
                        Gallery
                    </div>
                    <select id="mySelect" onchange="submitForms()">
                        <option value="MostView" ${order == "MostView"?"selected":""}>Most View</option>
                        <option value="Newest" ${order == "Newest"?"selected":""}>Newest</option>
                    </select>
                </div>
                <div>
                    <div class="container--images">
                        <c:forEach var="i" items="${listPhoto}">
                            <a href="photo?id=${i.id}" class="image">
                                <img src="${i.imagePath}"/>
                            </a>
                        </c:forEach>
                    </div>
                    <div class="page">
                        <c:if test="${pageid!=null && pageid!=1}">
                            <button onclick="paging(${pageid-1})" class="page__numbers"><</button>
                        </c:if>
                        <c:forEach var="page" items="${pageList}">
                            <button onclick="paging(this.innerHTML)" class="page__numbers ${pageid==page?"page__numbers--active":""}">${page}</button>
                        </c:forEach>
                        <c:if test="${pageid!=null && pageid!=pageList.size()}">
                            <button onclick="paging(${pageid+1})" class="page__numbers">></button>
                        </c:if>
                    </div>   
                </div> 
            </div>   
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
        
            <script>
            <c:forEach items="${listTag}" begin = "0" end = "${listTag.size()}" var="tag">
                                if (${tag.checked}) {
                                    handleCheck('${tag.title}');
                                }
            </c:forEach>
        </script>
    </body>
</html>
