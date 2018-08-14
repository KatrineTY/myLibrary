<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="<c:url value="resources/css/table.css" />" rel="stylesheet">
    <script type="text/javascript" src="resources/js/book.js"></script>
    <script type="text/javascript" src="resources/js/author.js"></script>
    <script type="text/javascript" src="resources/js/table.js"></script>
</head>
<body>
<form style="display: inline-block;  margin-left: 20%;" action="getCheckBoxResult" method="post">
    <form style="display: none">
        <fieldset>
            <legend>Genre</legend>
            <c:forEach var="genre" items="${listOfGenres}">
                <div>
                    <input type="checkbox" id="${genre}" name="genre" value="${genre}">
                    <label for="${genre}">${genre}</label>
                </div>
            </c:forEach>
        </fieldset>
        <div>
            <button type="submit">Submit</button>
        </div>

    </form>
    <form action="changeCountOfBook" method="post" style="display: inline-block">
        <div id="tableContainer" class="tableContainer" style="display: inline-block">
            <table border="0" cellpadding="0" cellspacing="0" width="100%" class="scrollTable" id="bookTable">
                <thead class="fixedHeader">
                <tr>
                    <th><input type="text" id="inputName" onkeyup="findBooksName()" placeholder="Search for names..">
                    </th>
                    <th><input type="text" id="inputAuthor" onkeyup="author()" placeholder="Search for authors.."></th>
                    <th></th>
                    <th></th>
                    <th></th>
                    <th></th>
                    <th>
                        <button type="submit">Take Books</button>
                    </th>

                </tr>
                <tr>
                    <th width="25%">Book name</th>
                    <th width="25%">Author name</th>
                    <th width="15%">Genre</th>
                    <th width="5%">Value</th>
                    <th width="5%">Deposit</th>
                    <th width="5%">Count</th>
                    <th width="20%">Take</th>
                </tr>
                </thead>
                <tbody class="scrollContent">
                <c:if test="${not empty bookList}">
                    <c:forEach var="listValue" items="${bookList}">
                        <tr>
                            <td width="25%">${listValue.bookName}</td>
                            <td width="25%">${listValue.authorName}</td>
                            <td width="15%">${listValue.genre}</td>
                            <td width="5%">${listValue.value}</td>
                            <td width="5%">${listValue.deposit}</td>
                            <td width="5%">${listValue.count}</td>
                            <td width="18%"><label>
                                <input type="checkbox" name="bookId" value="${listValue.id}">
                            </label></td>
                        </tr>
                    </c:forEach>
                </c:if>
                </tbody>
            </table>
        </div>

    </form>
</form>


</body>
</html>
