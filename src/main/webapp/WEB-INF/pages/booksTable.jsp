<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;" %>
<html>
<head>
    <script type="text/javascript" src="resources/js/book.js"></script>
    <script type="text/javascript" src="resources/js/author.js"></script>
    <script type="text/javascript" src="resources/js/table.js"></script>
    <script type="text/javascript" src="resources/js/filter.js"></script>
    <style>
        table, td {
            border: 2px solid #73AD21;
        }

        td {
            padding: 10px;
        }

        table {
            border-collapse: collapse;
            width: 100%;
        }

        form {
            width: 60%;
            margin-left: 20px;
            vertical-align: top;
            display: inline-block;
        }

        .filters {
            display: inline-block;
        }

        form button {
            margin-top: 10px;
            padding: 10px;
            background: #9DEE93;
            width: 150px;
            border-radius: 5px;
            border: 2px solid #73AD21;
            float: right;
        }

        input, fieldset {
            border: 2px solid #73AD21;
        }
    </style>
</head>
<body>
<div class="filters">
    <div class="search">
        <input type="text" id="inputBook" onkeyup="findBooksName()" placeholder="Search for names..">
        <br/>
        <br/>
        <input type="text" id="inputAuthor" onkeyup="author()" placeholder="Search for authors..">
    </div>
    <br/>
    <fieldset>
        <legend>Genres</legend>
        <c:forEach var="genre" items="${sessionScope.listOfGenres}">
            <div>
                <label>
                    <input type="checkbox" onclick="filterBooks()" id="${genre.getId()}" name="genre"
                           value="${genre.getGenreName()}">
                        ${genre.getGenreName()}
                </label>
            </div>
        </c:forEach>
    </fieldset>
</div>

<form action="changeCountOfBook" method="post">
    <table id="bookTable">
        <tr>
            <td width="40%">Book name</td>
            <td width="25%">Author name</td>
            <td width="15%">Genre</td>
            <td width="5%">Value</td>
            <td width="5%">Deposit</td>
            <td width="5%">Count</td>
            <td>Take</td>
        </tr>
        <c:if test="${not empty bookList}">
            <c:forEach var="listValue" items="${bookList}">
                <tr>
                    <td>${listValue.bookName}</td>
                    <td>${listValue.author.authorName}</td>
                    <td>${listValue.genre.genreName}</td>
                    <td>${listValue.value}</td>
                    <td>${listValue.deposit}</td>
                    <td>${listValue.count}</td>
                    <td><label>
                        <input type="checkbox" name="bookId" value="${listValue.id}">
                    </label></td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
    <button type="submit">Confirm</button>
</form>

</body>
</html>
