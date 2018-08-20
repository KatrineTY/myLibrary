<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
<body>

<form method="POST" action="check-reader">

    <label>
        <input type="text" value="Reader Name" name="readerName"/>
    </label>
    <label>
        <input type="password" value="password" name="password"/>
    </label>
    <input type="submit" value="Log in">]

</form>

</body>
</html>