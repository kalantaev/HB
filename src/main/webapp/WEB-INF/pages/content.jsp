<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css'/>"/>
    <title>${content.title}</title>
</head>
<body>
<div class="all">
    <h1 class="top">${content.title}</h1>

    <jsp:include page="${request.contextPath}/leftblock"></jsp:include>

    <div class="content">
        <div class="bloc2"> ${content.contentDescription}</div>
        <hr/>
        <c:forEach var="coment" items="${coment}">
            <div class="bloc2">

                <spring:message code="user"/> ${coment.userAutor.login} сказал:<br/>
                    ${coment.description}
                  <span style="float: right">
				<a href="/HB/delete/?id_coment=${coment.commentId}&id=${content.contentId}" ><spring:message code="delete_content"/></a>
			</span>
            </div>
        </c:forEach>
        <div align="center">
            <form action="/HB/content/" method="post">
                <input type="hidden" name="id" value="${content.contentId}"/>
                <textarea name="description" rows="4" cols="50"></textarea><br/>
                <input type="submit" value="<spring:message code="add_coment"/>"/>
            </form>
        </div>
    </div>
</div>
</body>
</html>