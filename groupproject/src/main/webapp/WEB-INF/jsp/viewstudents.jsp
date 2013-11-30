<%-- 
    Document   : viewstudents
    Created on : Nov 24, 2013, 3:19:49 PM
    Author     : Dan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
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
                        <td>Details</td>
                    </tr>
                </thead>

                <c:forEach var="listValue" items="${students}">
                    <tr>
                        <td>${listValue.name}</td>
                        <td>${listValue.departmentName}</td>
                        <td><a href="${pageContext.request.contextPath}/students/${listValue.id}">View</a></td>
                    </tr>    
                </c:forEach>
            </table>
        </c:if>
        
        <p>Total Time: ${totalTime}</p>
        <br/>
        <a href="${pageContext.request.contextPath}/">Home</a>
    </body>
</html>
