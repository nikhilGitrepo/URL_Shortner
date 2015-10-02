<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="Main theme for Bootstrap" content="">
    <meta name="author" content="Doug">
    <link rel="icon" href="../../favicon.ico">

    <title>URLator</title>
    <!-- Bootstrap core CSS -->
   	 <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	 <link href="bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="urlator/css/base.css" rel="stylesheet">

 
     </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">URL Shortener</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"></li>
            <li><a href="#URLMaps">URL Maps</a></li>
          </ul>
          <form:form action="home.urlview" class="navbar-form navbar-right">
            <div class="form-group">
              <input type="text" placeholder="Long URL" class="form-control">
            </div>
            <div class="form-group">
              <input type="text" placeholder="Desired Id" class="form-control">
            </div>
            <button type="submit" class="btn btn-success">QuckShorten!</button>
          </form:form>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    
   

    <div class="container">
		<div class ="contentPanel" role="main">
	 		<!-- Main jumbotron for a primary marketing message or call to action -->
      		<div class="jumbotron">
       			 <h1>URL Shortener</h1>
       			 <p>Presenting custom shortened url links</p>
     		</div>
     		
     		<div class="panel panel-primary">
            <div class="panel-heading">
              <h3 class="panel-title">Most popular links</h3>
            </div>
            <div class="panel-body">
               <table class="table table-striped">
            <thead>
              <tr>
                <th>#</th>
                <th>URL</th>
                <th>ID</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>1</td>
                <td>firstURL</td>
                <td>firstID</td>
              </tr>
              <tr>
                <td>2</td>
                <td>next</td>
                <td>etc</td>
              </tr>
         </tbody>
          </table>
            </div>
          </div>
		</div> <!--  content panel -->
    </div><!-- /.container -->
    


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="bootstrap/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
