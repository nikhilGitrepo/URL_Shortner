<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<form:form action="home.urlview">
	Long URL : <input type="text" name="longUrl.url" value ="https://www.facebook.com/hrithikroshan" size="50"/>
	<br/>
	Short URL : <input type="text" name="shortUrl.url" value ="https://goo.gl/GNE4v9" size="50"/>
	<br/>
	<input type="submit" value="Quick Short"/>
</form:form>
</body>
</html>