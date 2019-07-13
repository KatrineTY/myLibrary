<%@ page contentType="text/html;" %>
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

<form action="deleteBook" method="post" style="text-align: center;" >
    <label>
        Book id:
        <input type="text" name="bookId" value="bookId">
    </label>
    <br>
    <br>
    <input type="submit" value="Submit">
</form>
</body>
</html>

