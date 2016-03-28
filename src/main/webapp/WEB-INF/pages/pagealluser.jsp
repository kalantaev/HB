<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title><spring:message code="all_user"/></title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css'/>"/>
</head>

<body>
<div class="all">
<h1 align="center" class="top"><spring:message code="all_user"/></h1>
    <jsp:include page="${request.contextPath}/leftblock"></jsp:include>

    <div class="content">
        <div class="top"><a href="/HB/allsorteduser/">По логину</a>&nbsp;|&nbsp;<a href=""> По дате регистрации</a>&nbsp;|&nbsp;<a href="">По дате последнего визита</a></div><br/><br/>
    <c:forEach var="user" items="${users}">
        <div class="bloc2">
            <spring:message code="user"/> ${user.login}<br/>
            Id ${user.userId}<br/>
            <spring:message code="registration_date"/> ${user.dateReg}<br/>
            <spring:message code="last_vizit"/> ${user.dateLastVisit}

        </div>
    </c:forEach>
</div>
</div>
</body>
</html>