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
<form method="post" action="register-new-reader" style="text-align: center;">
    <label>
        <input type="text" value="Reader Name" name="readerName"/>
    </label>
    <label>
        <input type="text" value="Reader Phone" name="readerPhone"/>
    </label>
    <input type="submit" value="Register">
</form>
</body>
</html>
