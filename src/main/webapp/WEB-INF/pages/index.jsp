<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Start pages</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css'/>" />
</head>

<body>
<h1 align="center">START PAGES</h1>
${cookie}  ${errorMessage}
<div class="bloc3">
   <c:if test="${user.login==null}">
    <form action="/HB/" method="post">
        <input type="text" name="login"/><br/>
        <input type="password" name="password"/><br/>
        <input type="hidden" name="exit" value="0"/>
        <input type="submit" value="Войти"/>
    </form></c:if>
    <c:if test="${user.login!=null}">
    Приветствую ${user.login}<br/>
    <form action="/HB/" method="post">
        <input type="hidden" name="exit" value="1"/>
        <input type="hidden" name="login" value="d"/><br/>
        <input type="hidden" name="password" value="d"/><br/>
        <input type="submit" value="Выход"/>
    </form>
    </c:if>
    <a href="/HB/login/">Авторизация</a><br/>
    <a href="/HB/registration/">Регистрация</a> <br/>
    <a href="/HB/addcontent/">Добавить материал</a><br/>
    <a href="/HB/alluser/">Все пользователи</a>
</div>
${loginMessage}
<div class="bloc1">
    <c:forEach var="content" items="${contents}">
        <div class="bloc2">
            <H2><a href="/HB/content/?id=${content.contentId}">${content.title}</a></H2>
                ${content.contentDescription}
        </div>
    </c:forEach>
</div>

</body>
</html>