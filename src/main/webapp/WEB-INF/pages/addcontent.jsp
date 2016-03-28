<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title><spring:message code="pageAddCont"/></title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css'/>"/>
</head>

<body>
<div class="all">
    <h1 align="center" class="top"><spring:message code="pageAddCont"/></h1>
    <jsp:include page="${request.contextPath}/leftblock"></jsp:include>

    <div class="content" align="center">
        ${message}

        <form action="/HB/addcontent/" method="post">
            <input type="text" name="title" placeholder="<spring:message code="enter_cont_name"/>"/><br/>
            <textarea name="contentDescription" placeholder="<spring:message code="contentDescription"/>" rows="4" cols="50"></textarea><br/>
            <input type="submit" value="<spring:message code="add_content"/>"/>
        </form>
    </div>
</div>
</body>
</html>