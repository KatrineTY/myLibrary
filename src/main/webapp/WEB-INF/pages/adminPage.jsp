<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>

</head>
<body>

<%--<c:if test="isAdmin">--%>

<form action="addBookPage" method="get">
    <button type="submit">Add book</button>
</form>
<form action="deleteBookPage" method="get">
<button type="submit">Delete book</button>
</form>
<a href="booksTable">Go to table</a>

<%--</c:if>--%>
</body>
</html>
