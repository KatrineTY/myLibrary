<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <style>
        input {
            padding: 10px;
            background: #9DEE93;
            border-radius: 5px;
            border: 2px solid #73AD21;
        }
    </style>
</head>
<body>
<div align="center">

<h2>Enter book information</h2>
<form:form method="post" modelAttribute="book" action="addBook">
    <table>
        <tr>
            <td><form:label path="bookName" >bookName</form:label></td>
            <td><form:input path="bookName" /></td>
                <%--            <td><form:errors path="bookName"/></td>--%>
        </tr>
        <tr>
            <td><form:label path="author.authorName">author</form:label></td>
            <td><form:input path="author.authorName" /></td>
                <%--            <td><form:errors path="author.authorName"/></td>--%>

        </tr>
        <tr>
            <td><form:label path="genre.genreName">genre</form:label></td>
            <td><form:input path="genre.genreName" /></td>
                <%--            <td><form:errors path="genre.genreName"/></td>--%>

        </tr>
        <tr>
            <td><form:label path="value">value</form:label></td>
            <td><form:input path="value" /></td>
                <%--            <td><form:errors path="value"/></td>--%>

        </tr>
        <tr>
            <td><form:label path="deposit">deposit</form:label></td>
            <td><form:input path="deposit" /></td>
                <%--            <td><form:errors path="deposit"/></td>--%>

        </tr>
        <tr>
            <td><form:label path="count">count</form:label></td>
            <td><form:input path="count" /></td>
                <%--            <td><form:errors path="count"/></td>--%>

        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form:form>
</div>
</body>
</html>