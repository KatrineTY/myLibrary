<%@ page contentType="text/html;"
         pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
<body>

<form:form method="POST" modelAttribute="reader" action="check-reader" style="text-align: center;">

    <form:label path="readerName">
        <form:input path="readerName" type="text" value="Reader Name" name="readerName"/>
        <form:errors path="readerName"/>
    </form:label>
    <br/>
    <form:label path="password">
        <form:input path="password" type="password" value="password" name="password"/>
        <form:errors path="password"/>
    </form:label>
    <br>

    <input type="submit" value="Log in">]

</form:form>

</body>
</html>