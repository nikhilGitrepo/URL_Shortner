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
          <a class="navbar-brand nav-urlator" id="HOME" href="#">URL Shortener</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"></li>
            <li id="URL_MAPS" class="nav-urlator"><a href="">URL Maps</a></li>
          </ul>
          <form:form action="home.urlview" class="navbar-form navbar-right">
            <div class="form-group">
            
              <input type="text" placeholder="URL" class="form-control" >
            </div>
            <div class="form-group">
            
              <input type="text" placeholder="Desired ID" class="form-control" >
            </div>
            <button type="submit" class="btn btn-success">Shorten!</button>
          </form:form>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    
   

    <div class="container">
    <div id="mainPanel">
		<div class ="contentPanel" role="main">
	 		<!-- Main jumbotron for a primary marketing message or call to action -->
      		<div class="jumbotron">
       			 <h1>URL Shortener</h1>
       			 <p class="lead">Presenting custom shortened url links</p>
     		</div>
     		<div class="row">
     		<div class="col-sm-4">
     		
     		 
              <form:form action="home.urlview">
            <div class="form-group">
            <label for="lurlInput">URL</label>
              <input type="text" placeholder="Long URL" class="form-control" id="lurlInput">
            </div>
            <div class="form-group">
            <label for="idInput">Desired ID</label>
              <input type="text" placeholder="Desired ID" class="form-control" id="idInput">
            </div>
            <button type="submit" class="btn btn-default">Shorten!</button>
          </form:form>
             </div>
     		
     	     		
     		
     		
     		
     		
     		
     		
     		
     		
     	<div class="col-sm-8">	
     		<div class="panel panel-primary">
            <div class="panel-heading">
              <h3 class="panel-title">Most popular links</h3>
            </div>
            <div class="panel-body">
             
              
              
               <table class="table table-striped">
            
            <tbody>
              <tr>
                <td>1</td>
                <td>
                <a href="ushort.com/?=myfile">ushort.com/?=umyfile</a>
                </td>
              </tr>
              <tr>
                <td>2</td>
                   <td>
                   <a href="ushort.com/?=myfile">ushort.com/?u=funnycatvideo</a>
                   </td>
              </tr>
         </tbody>
          
          </table>
         
            </div>
            
          </div>
        </div> <!--  col -->
        </div> <!--  row -->
          
		</div> <!--  content panel -->
		</div>	<!--  main panel -->
		
    </div><!-- /.container -->
    


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="urlator/js/UrlatorClient.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="bootstrap/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
