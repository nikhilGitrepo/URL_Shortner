<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
function setFrameHeight(){
    var mainLayoutFrame = document.getElementById('mainLayoutFrame');
    if(mainLayoutFrame) {
    	mainLayoutFrame.height = "";
    	mainLayoutFrame.height = mainLayoutFrame.contentWindow.document.body.scrollHeight + "px";
    } 
}
</script>

<title>URLShortener</title>
</head>
<body onload="setFrameHeight();">
<div align="center">
<iframe id="mainLayoutFrame" align="middle" id="homePage" src="redirect.urlview" frameborder="0" height="" width="100%"></iframe>
</div>
</body>
</html>