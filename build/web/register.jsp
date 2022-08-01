<!DOCTYPE html>
<html lang="en" >
    <head>
        <meta charset="UTF-8">
        <title>Log in-Imageram</title>
        <link rel='stylesheet' href='https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&amp;display=swap'>
        <link rel="stylesheet" href="./assets/css/login.css">
        <script src="https://kit.fontawesome.com/ce672ea6c4.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="login--wrapper">
            <div class="login--logo">
                <img class="logo" src="assets/img/logo.png"/>
            </div>
            <form class="login--form" action="register" method="post">
                <div class="username">
                    <label for="username">Username</label>
                    <input type="text" name="username"/>
                </div>
                <div class="password">
                    <label for="password">Password</label>
                    <input type="password" name="password"/>
                </div>
                <div class="password">
                    <label for="password">Confirm password</label>
                    <input type="password" name="confirm"/>
                </div>
                <p style="color: red;">${error}</p>
                <button class="login" type="submit">Register </button>
                <div>
                    <a href="login">Login</a>or
                    <a>Forgot Password?</a>
                </div>
            </form>
        </div>
    </body>
</html>
