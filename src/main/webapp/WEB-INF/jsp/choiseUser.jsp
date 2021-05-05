<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html; charset=UTF-8" %>
<html>

<body>
<a href="/">Главная</a>
<br><br>
<a href="/login">Сменить пользователя</a>
<br><br>
<form>
    Вы  проголосовали за ${choise.restName}. Адрес: ${choise.restAdress}.
    <br>  <br>
    Свой выбор можно изменить до 11:00.
    <br>  <br>



    <c:url var="choiseUpdate" value="/choise">
        <c:param name="userName" value="${choise.userName}"/></c:url>
    <input type="button" value="Изменить выбор"
               onclick="window.location.href = '${choiseUpdate}'"/>


</form>
</body>
</html>
