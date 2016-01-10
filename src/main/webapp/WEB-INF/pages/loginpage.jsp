<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<title>Страница ваторизации</title>
<html>
<body>
<h1>Страница авторизации</h1>
<a href="/HB/">На главную</a>

<div align="center">
    ${errorMessage}
    
    <form action="/HB/login/" method="post">
        <input type="text" name="login"/><br/>
        <input type="password" name="password"/><br/>
        <input type="submit" value="Войти"/>
    </form>
</div>
<div align="center"><a href="/HB/registration/">Зарегестрироваться</a></div>

</body>
</html>