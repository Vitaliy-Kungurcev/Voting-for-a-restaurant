<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<body>

<h3>Где сегодня будем обедать?</h3>

<a href="/login">Выбрать пользователя</a>
<br><br>

<security:authorize access="hasRole('ADMIN')">
<input type="button" value="Меню дня"
       onclick="window.location.href = '/restaurants/'">
Редактирование

<br><br>

<input type="button" value="Результат"
       onclick="window.location.href = '/rezult'">
Результаты дня

<br><br>
История голосования:
<br>


<form:form action="history" modelAttribute="dateChoise" method="post">


        Дата:<input type="date" name="localDate"/>

        <input type="submit" value="Показать">

        </form:form>
        </security:authorize>




        <security:authorize access="hasRole('EMPLOYEE')">

        <c:url var="сhoise" value="your_choise"></c:url>

    <td><input type="button" value="Голосование"
               onclick="window.location.href = '${сhoise}'"/>
        Проголосовать за ресторан
        </security:authorize>
</body>


</html>