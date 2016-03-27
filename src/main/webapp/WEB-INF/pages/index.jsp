<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title><spring:message code="start"/></title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css'/>"/>
</head>

<body>
<div class="all">
    <h1 class="top" align="center"><spring:message code="start"/></h1>

    <div class="menu">
        ${errorMessage}
        <c:if test="${user.login==null}">

            <%--<form:form method="POST" modelAttribute="user"  action="/HB/"  >--%>

            <%--<form:label path="login"></form:label>--%>
            <%--<form:input path="login" />--%>
            <%--<form:errors path="login" />--%>

            <%--<form:label path="password">Password:</form:label>--%>
            <%--<form:password path="password" />--%>
            <%--<form:errors path="password" cssClass="error"/>--%>
            <%--<input type="submit" value="Login" >--%>
            <%--</form:form>--%>


            <form action="/HB/" method="post">
                <input type="text" name="login"/><br/>
                <input type="password" name="password"/><br/>
                <input type="submit" value="<spring:message code="enter"/>"/>
            </form>
            <a href="/HB/registration/"><spring:message code="registration"/></a> <br/>
        </c:if>
        <c:if test="${user.login!=null}">
            <spring:message code="hello"/>  ${user.login}<br/>

            <form action="/HB/exit" method="post">

                <input type="submit" value="<spring:message code="exit"/>"/>
            </form>
        </c:if>


        <a href="/HB/addcontent/"><spring:message code="add_content"/></a><br/>
        <a href="/HB/alluser/"><spring:message code="all_user"/></a>
    <span style="float: right">
				<a href="?lang=en">en</a>
				<a href="?lang=ru">ru</a>
			</span>
    </div>

    <div class="content">
        ${loginMessage}
        <c:forEach var="content" items="${contents}">
            <div class="bloc2">
               <H2><a href="/HB/content/?id=${content.contentId}">${content.title}</a></H2>


                    ${content.contentDescription}
                 <span style="float: right">
				<a href="/HB/delete/?id_content=${content.contentId}"><spring:message code="delete_content"/></a>
			</span>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>