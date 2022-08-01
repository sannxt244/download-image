<%-- 
    Document   : setting
    Created on : Mar 8, 2022, 4:45:21 PM
    Author     : sannx
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Setting-Imageram</title>
        <link rel="stylesheet" href="assets/css/setting.css">

    </head>
    <body>
        <jsp:include page="navbar.jsp"></jsp:include>
            <div class="content--wrapper">
                <div class="sidebar">
                    <h1>Setting</h1>
                    <ul>
                        <li class="button" onclick="load('general')">
                            General
                        </li>
                    </ul>
                    <ul>
                        <li class="button" onclick="load('security')">
                            Security
                        </li>
                    </ul>
                </div>
                <div id="content">
                    <h3>General setting</h3>
                    <table>
                        <tr>
                            <td>Name</td>
                            <td id="name">
                                <div>
                                ${user.name}
                            </div>
                            <div>
                                <a onclick="makeInput('name')">Edit</a>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>Phone</td>
                        <td id="phone">
                            <div>
                                ${user.phone}
                            </div>
                            <div>
                                <a onclick="makeInput('phone')">Edit</a>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>Contact</td>
                        <td id="email">
                            <div>
                                ${user.email}
                            </div>
                            <div>
                                <a onclick="makeInput('email')">Edit</a>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>Address</td>
                        <td id="address">
                            <div>
                                ${user.address}
                            </div>
                            <div>
                                <a onclick="makeInput('address')">Edit</a>
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
        <script>
                                    function load(tabType) {
                                        $.ajax({
                                            url: "/imageram/settings",
                                            type: "post",
                                            data: {
                                                tab: tabType
                                            },
                                            success: function (responseData) {
                                                document.getElementById("content").innerHTML = responseData;
                                            }
                                        });
                                    }

                                    function makeInput(field) {
                                        $.ajax({
                                            url: "/imageram/edit",
                                            type: "get",
                                            data: {
                                                field: field
                                            },
                                            success: function (responseData) {
                                                document.getElementById(field).innerHTML = responseData;
                                            }
                                        });
                                    }

        </script>
    </body>
</html>
