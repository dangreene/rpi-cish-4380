<%-- 
    Document   : index
    Created on : Nov 24, 2013, 9:04:57 PM
    Author     : Dan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.3.0/base-min.css">
        <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.3.0/pure-min.css">
        <title>CISH 4380 Group Project</title>
    </head>
    <body>
        <h2>MongoDB Student Database implementation</h2>
        <ul>
            <li><a href="${pageContext.request.contextPath}/students/">View Students</a></li>
            <li><a href="${pageContext.request.contextPath}/studentsummary/">Student Credit Summary</a></li>
        </ul>
    </body>
</html>
