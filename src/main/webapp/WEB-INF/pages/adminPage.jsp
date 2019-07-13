<%@ page contentType="text/html;" %>
<html>
<head>
    <style>
        button, a {
            padding: 10px;
            background: #9DEE93;
            width: 150px;
            border-radius: 5px;
            border: 2px solid #73AD21;
            text-decoration: none;
            color: black;
        }

        div {
            text-align: center;
        }
    </style>
</head>
<body>

<%--<c:if test="isAdmin">--%>
<div>
    <form action="addBookPage" method="get">
        <button type="submit">Add book</button>
    </form>
    <form action="deleteBookPage" method="get">
        <button type="submit">Delete book</button>
    </form>
    <br>
    <a href="booksTable">Book storage</a>
</div>
<%--</c:if>--%>
</body>
</html>
