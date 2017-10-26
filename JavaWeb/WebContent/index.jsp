<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>L.I-TERRITORIES</title>
    
    <link href="bootstrap-3.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
   <link href="bootstrap-3.3.1/sign/signin//signin.css" rel="stylesheet"> 
  </head>

  <body>

    <div class="container">
		<h4 class="text-center text-danger"><s:actionerror /></h4>
      <form class="form-signin" name="form1" method="post" action="login.action">
        <h3 class="form-signin-heading">Long Island territories</h3>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input name="username" type="text" id="myusername"  class="form-control" placeholder="Username" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input name="password" id="mypassword" type="password" class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" name="Submit" type="submit">Sign in</button>
      </form>

    </div> <!-- /container -->

    <script src="bootstrap-3.3.1/dist/js/bootstrap.min.js"></script>
  </body>
</html>


