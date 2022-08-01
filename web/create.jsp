<%-- 
    Document   : create
    Created on : Feb 28, 2022, 3:18:36 AM
    Author     : sannx
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200&display=swap');
            *{
                margin: 0;
                padding: 0;
                box-sizing: border-box;
                font-size: 20px;
                font-family: 'Poppins', sans-serif;
            }
            form {
                background-color: #dee6f3;
                padding: 250px 200px;
                width: 60%;
                margin: 0 auto;
                margin-top: 140px;
                display: flex;
                justify-content: center;
            }
            tbody > * {
                padding: 20px 40px;
            }
            
            #output {
                width: 400px;
                height: 400px;
                border: 1px solid #000;
                object-fit: cover;
            }
            input {
                height: 50px;
                border-radius: 7px;
                width: 350px;
            }
        </style>
    </head>
    <body>
        <jsp:include page="navbar.jsp"></jsp:include>
            <form action="create" method="post" enctype="multipart/form-data">
                <table>
                    <tr>
                        <td>Album id</td>
                        <td><input type="text" name="albumId"/></td>
                    </tr>
                <tr>
                    <td>Title</td>
                    <td><input type="text" name="title"/></td>
                </tr>
                <tr>
                    <td>Description</td>
                    <td><input style="height: 100px" type="text" name="description"/></td>
                </tr>
                <tr>
                    <td>Image</td>
                    <td>
                        <input id="image--link" type="file" name="image" onchange="loadFile(event)"/>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="submit" value="create"/>
                    </td>
                </tr>
            </table>
            <img id="output"/>
        </form>
        <jsp:include page="footer.jsp"></jsp:include>
        <script>
            function seeImg() {
                var path = document.getElementById('image--link').value;
                console.log(path);
                document.getElementById("myImg").src = path;
            }

            var loadFile = function (event) {
                var output = document.getElementById('output');
                output.src = URL.createObjectURL(event.target.files[0]);
                output.onload = function () {
                    URL.revokeObjectURL(output.src) // free memory
                }
            };
        </script>
    </body>
</html>
