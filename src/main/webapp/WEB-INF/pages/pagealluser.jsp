<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
<style type="text/css">
    .bloc1 {
        border: solid 1px #474369;
        padding: 5px 20px 5px 20px;
        margin-left: 200px
    }

    .bloc2 {
        border: solid 1px burlywood;
        background: gainsboro;
        padding: 5px 20px 5px 20px;
    }

    .bloc3 {
        padding: 0 30px 0 30px;
        width: 230px;
        position: relative;
        top: 60px;
    }
</style>
<body>
<h1 align="center">Все пользователи</h1>

<div class="bloc3">
    <a href="/HB/">Главная</a><br/>
    <a href="/HB/login/">Авторизация</a><br/>
    <a href="/HB/registration/">Регистрация</a> <br/>
    <a href="/HB/addcontent/">Добавить материал</a><br/>
</div>

<div class="bloc1">
    <c:forEach var="user" items="${users}">
        <div class="bloc2">
            Пользователь ${user.login}<br/>
            Id ${user.userId}<br/>
            Зарегестрирован ${user.dateReg}<br/>
            Дата последнего визита ${user.dateLastVisit}

        </div>
    </c:forEach>
</div>

</body>
</html>