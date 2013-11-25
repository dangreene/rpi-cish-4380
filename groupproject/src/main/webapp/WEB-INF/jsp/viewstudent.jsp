<%-- 
    Document   : viewstudent
    Created on : Nov 24, 2013, 8:53:25 PM
    Author     : Dan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <h2>Student Information</h2>
        <div>${student.id} ${student.firstName} ${student.lastName}</div>
        <a href="${pageContext.request.contextPath}/students">Back to registered students</a>
    </body>
</html>
