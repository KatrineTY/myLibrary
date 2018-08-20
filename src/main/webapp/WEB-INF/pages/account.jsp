<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>

<a href="adminPage.jsp">Admin page</a>

<tr></tr>

<table>
    <tr>
        <th>Book name</th>
        <th>Author name</th>
        <th>Genre</th>
        <th>Value</th>
        <th>Deposit</th>
    </tr>

    < test="${not empty bookList}">
    <c:forEach var="listValue" items="${bookList}">
    <tr>
        <td>${listValue.bookName}</td>
        <td>${listValue.author.authorName}</td>
        <td>${listValue.genre.genreName}</td>
        <td>${listValue.value}</td>
        <td>${listValue.deposit}</td>
    </tr>
    </c:forEach>
</table>>

</body>
</html>
