<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <c:set var = "salary" scope = "session" value = "${2000*2}"/>
        <c:if test = "${salary > 2000}">
            <p>My salary is:  <c:out value = "${salary}"/><p>
            </c:if>
    </body>
</html>
