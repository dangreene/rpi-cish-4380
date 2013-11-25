<%-- 
    Document   : viewstudents
    Created on : Nov 24, 2013, 3:19:49 PM
    Author     : Dan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <body>
        <h2>Registered Students</h2>

        <c:if test="${not empty students}">

            <ul>
                <c:forEach var="listValue" items="${students}">
                    <li>${listValue.firstName} ${listValue.lastName} <a href="${pageContext.request.contextPath}/students/${listValue.id}">View</a></li>
                    </c:forEach>
            </ul>
            
        </c:if>
        
        <a href="${pageContext.request.contextPath}/">Home</a>
    </body>
</html>
