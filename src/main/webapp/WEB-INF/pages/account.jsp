<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;" %>
<html>
<body>


<div align="center">
<a href="adminPage">Admin page</a>
<br/>
<a href="bookStorage">Go to book storage</a>
<br/>

<table border="1" >
    <tr>
        <th>Book name</th>
        <th>Author name</th>
        <th>Genre</th>
        <th>Value</th>
        <th>Deposit</th>
    </tr>

    <c:if test="${not empty bookList}">
    <c:forEach var="listValue" items="${bookList}">
    <tr>
        <td>${listValue.bookName}</td>
        <td>${listValue.author.authorName}</td>
        <td>${listValue.genre.genreName}</td>
        <td>${listValue.value}</td>
        <td>${listValue.deposit}</td>
    </tr>
    </c:forEach>
    </c:if>
</table>>
</div>
</body>
</html>
