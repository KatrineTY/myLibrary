<%@ page contentType="text/html;" %>
<html>
<head>

</head>
<body>

<%--<c:if test="isAdmin">--%>
<div align="center">
<form action="addBookPage" method="get">
    <button type="submit">Add book</button>
</form>
<form action="deleteBookPage" method="get">
<button type="submit">Delete book</button>
</form>
<a href="booksTable">Go to table</a>
</div>
<%--</c:if>--%>
</body>
</html>
