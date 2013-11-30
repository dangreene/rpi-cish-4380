<%-- 
    Document   : viewstudentsummary
    Created on : Nov 30, 2013, 5:31:25 PM
    Author     : Dan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Summary</title>
        <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.3.0/base-min.css">
        <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.3.0/pure-min.css">
    </head>
    <body>
        <h2>Registered Students</h2>

        <c:if test="${not empty students}">
            <table class="pure-table">
                <thead>
                    <tr>
                        <td>Name</td>
                        <td>Department</td>
                        <td>Total Credits</td>
                    </tr>
                </thead>

                <c:forEach var="listValue" items="${students}">
                    <tr>
                        <td>${listValue.value.name}</td>
                        <td>${listValue.value.department}</td>
                        <td>${listValue.value.totalCredits}</td>
                    </tr>    
                </c:forEach>
            </table>
        </c:if>

        <br/>
        <a href="${pageContext.request.contextPath}/">Home</a>
    </body>
</html>
