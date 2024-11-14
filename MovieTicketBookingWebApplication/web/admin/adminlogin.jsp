<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>JSP Page</title>
        
            <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

        <style>
            #adminlogin{
                position: absolute;
                width: 550px;
                height: 500px;
                padding: 20px;
                top: 50%;
                left: 70%;
                transform: translate(-50%,-50%);
            }
            .form{
                padding: 20px; 
            }
            .pt-1{
                padding-top: 1rem;
            }
        </style>
    </head>
    
    <body class="#263238 blue-grey darken-4">  
        <section id="adminlogin">
            <div class="card z-depth-3 #37474f blue-grey darken-3">
                <div class="card-panel center #ef5350 red lighten-1">
                    <span class="card-title white-text">Admin LOgin</span>
                </div>
                <form class="form">
                    <div class="input-firld">
                        <input type="email" class="validate">
                        <label>Email</label>
                    </div>
                    <div class="input-field">
                        <input type="password" class="validate">
                        <lable>Password</lable>
                    </div>
                    <div class="center">
                        <button type="submit" class="btn-large #ef5350 red lighten-1">
                            Sign In
                        </button>
                    </div>
                    <div class="center pt-1">
                        <a href="#">Forget Password??</a>
                    </div>
                </form>
            </div>
        <!--<h1>Hello World!</h1>-->
        <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    </body>
</html>
