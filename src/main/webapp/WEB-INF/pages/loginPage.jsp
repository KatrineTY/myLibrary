<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
<body>

<form:form method="POST" modelAttribute="reader" action="check-reader">

    <form:label path="readerName"/>
    <form:input path="readerName"/>

    <form:label path="password"/>
    <form:password path="password"/>

    <input type="submit" value="Log in">]


</form:form>

</body>
</html>