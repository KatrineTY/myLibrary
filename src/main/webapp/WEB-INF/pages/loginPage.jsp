<%@ page contentType="text/html;"
         pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
<head>
    <style>
        input {
            padding: 10px;
            width: 200px;
            margin-top: 10px;
            border-radius: 5px;
            border: 2px solid #73AD21;
        }

        input[type=submit] {
            text-decoration: none;
            background: #9DEE93;
            padding: 10px;
            display: inline-block;
            width: 150px;
            margin: 10px auto;
            color: black;
            border-radius: 25px;
            border: 2px solid #73AD21;
        }

        .box {
            text-align: center;
            border: 2px solid #73AD21;
            width: 300px;
            margin: auto
        }

    </style>
</head>
<body>

<form:form method="POST" modelAttribute="reader" action="check-reader" style="text-align: center;">
    <div class="box">
        <form:label path="readerName">
            <form:input path="readerName" type="text" value="Katrine" name="readerName"/>
        </form:label>
        <br/>
        <form:label path="password">
            <form:input path="password" type="password" value="xxxxxxxxxx" name="password"/>
        </form:label>
        <br/>

        <input type="submit" value="Log in">
    </div>

</form:form>

</body>
</html>