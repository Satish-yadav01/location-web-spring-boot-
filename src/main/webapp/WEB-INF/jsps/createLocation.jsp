<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Location</title>
</head>
<body>
    <pre>
        <form action="saveLocation" method="post">
            Id : <input type="text" name="id"/>
            Code: <input type="text" name="code"/>
            Name: <input type="text" name="name"/>
            Type: Urban <input type="radio" name="type" value="urban"/> Rural <input type="radio" name="type"/ value="rural">
            <input type="submit" value="save"/>
        </form>
        ${msg}
        <a href="displayLocation">Display all</a>
    </pre>
</body>
</html>