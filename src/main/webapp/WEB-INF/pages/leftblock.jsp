<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<div class="menu">
    ${errorMessage}
    <c:if test="${user.login==null}">

        <form action="/HB/leftblock" method="post">
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

    <a href="/HB/"><spring:message code="on_start_page"/></a><br/>
    <a href="/HB/addcontent/"><spring:message code="add_content"/></a><br/>
    <a href="/HB/alluser/"><spring:message code="all_user"/></a>
    <span style="float: right">
				<a href="${url}lang=en">en</a>
				<a href="${url}lang=ru">ru</a>
			</span>
</div>