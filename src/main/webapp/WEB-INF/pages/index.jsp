<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
<body>
<h1>The page all USER</h1>
<table border="1px">
  <tr style="background-color: cornflowerblue">
    <td>User ID</td>
    <td>User LOGIN</td>
    <td>Delete User</td>

  </tr>

  <c:forEach var="user" items="${users}">
    <tr>
     <td>  ${user.userId}</td>
      <td>${user.login}</td>
      <td><a href="?deleteid=${user.userId}">DELETE</a> </td>
    </tr>
  </c:forEach>
</table>
<H2>Filtr</H2>
<%--<form>--%>
  <p>Введите число от 1 до ${message}:</p>
  ${log}
  <%--<p>От<input type="number" size="3" name="num1" min="1" max="${max}" value="1"></p>--%>
  <%--<p>До<input type="number" size="3" name="num2" min="1" max="${max}" value="1"></p>--%>
  <%--<input type="submit" value="filtred"/>--%>

<%--</form>--%>

<H2>Add User</H2>
<form method="POST" >

  <input type="text" name="login"/><br/>
  <input type="password" name="password"/><br/>
  <input type="submit" value="add"/>
</form>
</body>
</html>