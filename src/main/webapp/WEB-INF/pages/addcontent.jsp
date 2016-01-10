<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<title>Страница добавления материала</title>
<html>
<body>
<h1>Страница добавления материал</h1>
<a href="/HB/">На главную</a>

<div align="center">
    ${errorMessage}

    <form action="/HB/addcontent/" method="post">
        <input type="text" name="title" placeholder="Введите название материала" /><br/>
        <input type="text"  name="description" placeholder="Введите содержимое материала" /><br/>
        <input type="submit" value="Добавить иатериал"/>
    </form>
</div>

</body>
</html>