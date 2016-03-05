<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<title>The page for adding material</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css'/>" />

<html>
<body>
<h1>The page for adding material</h1>
<a href="/HB/">to Home Page</a>

<div align="center">
    ${errorMessage}

    <form action="/HB/addcontent/" method="post">
        <input type="text" name="title" placeholder="Enter the name of the content" /><br/>
        <input type="text"  name="description" placeholder="Enter contents" /><br/>
        <input type="submit" value="Add content"/>
    </form>
</div>

</body>
</html>