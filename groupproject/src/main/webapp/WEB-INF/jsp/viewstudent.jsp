<%-- 
    Document   : viewstudent
    Created on : Nov 24, 2013, 8:53:25 PM
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
        <h2>Student Information</h2>
        <table class="pure-table">
            <thead>
                <tr>
                    <td>ID</td>
                    <td>Name</td>
                </tr>
            </thead>
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
            </tr>
        </table>

        <c:if test="${not empty student.courses}">
            <h2>Courses</h2>
            <table class="pure-table">
                <thead>
                    <tr>
                        <td>Course</td>
                        <td>Section</td>
                        <td>Semester</td>
                        <td>Year</td>
                        <td>Grade</td>
                        <td>Credits</td>
                    </tr>
                </thead>

                <c:forEach var="listValue" items="${student.courses}">
                    <tr>
                        <td>${listValue.courseId}</td>
                        <td>${listValue.sectionId}</td>
                        <td>${listValue.semester}</td>
                        <td>${listValue.year}</td>
                        <td>${listValue.grade}</td>
                        <td>${listValue.credits}</td>
                    </tr>    
                </c:forEach>
            </table>
        </c:if>
        <p>Total Time: ${totalTime}</p>
        <br/>

        <a href="${pageContext.request.contextPath}/students">Back to registered students</a><br/>
        <a href="${pageContext.request.contextPath}/">Home</a>
    </body>
</html>
