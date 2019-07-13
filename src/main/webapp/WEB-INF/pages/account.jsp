<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;" %>
<html>
<head>
    <style>
        table, td {
            border: 2px solid #73AD21;
        }

        td {
            padding: 10px;
        }

        table {
            border-collapse: collapse;
            margin-top: 10px;
        }

        a {
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
    </style>
</head>
<body>
<div align="center">
    <a href="adminPage">Admin page</a>
    <br/>
    <a href="bookStorage">Book storage</a>
    <br/>

    <table>
        <tr>
            <td>Book name</td>
            <td>Author name</td>
            <td>Genre</td>
            <td>Value</td>
            <td>Deposit</td>
        </tr>
        <c:if test="${not empty bookList}">
            <c:forEach var="listValue" items="${bookList}">
                <tr>
                    <td>${listValue.bookName}</td>
                    <td>${listValue.autdor.autdorName}</td>
                    <td>${listValue.genre.genreName}</td>
                    <td>${listValue.value}</td>
                    <td>${listValue.deposit}</td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
</div>
</body>
</html>
