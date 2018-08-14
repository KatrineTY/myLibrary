<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>

<h2>Enter book information</h2>
<form:form method="post" action="addBook">
    <table>
        <tr>
            <td><form:label path="bookName">bookName</form:label></td>
            <td><form:input path="bookName" /></td>
        </tr>
        <tr>
            <td><form:label path="authorName">authorName</form:label></td>
            <td><form:input path="authorName" /></td>
        </tr>
        <tr>
            <td><form:label path="genre">genre</form:label></td>
            <td><form:input path="genre" /></td>
        </tr>
        <tr>
            <td><form:label path="value">value</form:label></td>
            <td><form:input path="value" /></td>
        </tr>
        <tr>
            <td><form:label path="deposit">deposit</form:label></td>
            <td><form:input path="deposit" /></td>
        </tr>
        <tr>
            <td><form:label path="count">count</form:label></td>
            <td><form:input path="count" /></td>
        </tr>
        <tr>
            <td><form:label path="id">id</form:label></td>
            <td><form:input path="id" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>