<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>REGISTRATION PAGE</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css'/>"/>
</head>
<body>
<h1>Страница регистрации</h1>
<a href="/HB/">На главную</a>

<div align="center">
    ${errorMessage}

    <form action="/HB/registration/" method="post">
        <input type="text" name="login" placeholder="MyLogin"/><br/>
        <input type="password" name="password" placeholder="password"/><br/>
        <input type="submit" value="Зарегестрироваться"/>
    </form>
</div>


</body>
</html>