<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<body>

<h2>Рестораны и меню</h2>
<a href="/">На Главную</a>
<br><br>
<form:form action="/choise/create"  >
<table>
    <input type="hidden" name="userName" value="${userName}">

    <tr>
        <th>Голосование</th>
        <th>Название</th>
        <th>Адрес</th>
        <th>Меню дня</th>
    </tr>


    <c:forEach var="allRestarants" items="${allRestarants}">

        <tr>
        <td style="text-align: center;"><input type="radio" name="choiseinput" value=${allRestarants.id}>Голос</td>
        <td>${allRestarants.name}</td>
        <td>${allRestarants.adress}</td>

        <c:forEach var="meals" items="${allRestarants.meals}">
            <tr>
                <td></td>
                <td></td>
                <td></td>

                <td>
                        ${meals.name} : ${meals.price} руб.
                </td>
            </tr>
        </c:forEach>

    </c:forEach>


</table>
<input type="submit" value="Проголосовать">
</form:form>
<br>

</body>


</html>