<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css'/>" />
    <title>${content.title}</title>
</head>
<body>
<h1 align="center">${content.title}</h1>

<div class="bloc3"><a href="/HB/">На главную</a></div>
<div class="bloc1">
    <div>${content.contentDescription}</div>
    <div align="center">
        <c:forEach var="coment" items="${coment}">
            <div class="bloc2">

                Пользователь ${coment.userAutor.login} сказал:<br/>
                    ${coment.description}
            </div>
        </c:forEach>

        <form action="/HB/content/" method="post">
            <input type="hidden" name="id" value="${content.contentId}"/>
            <textarea name="description" rows="4" cols="50"></textarea><br/>
            <input type="submit" value="Добавить комментарий"/>
        </form>
    </div>
</div>
</body>
</html>