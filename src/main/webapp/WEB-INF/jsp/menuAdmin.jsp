<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<body>

<h2>Меню ресторана ${nameRest}</h2>
<br>
<h3><a href="/restaurants/">Страница с ресторанами</a></h3>
<br>

<br>

<table>
    <tr>
        <th>Действие с меню</th>
        <th><p style="margin-left: 40px">Название</p></th>
        <th><p style="margin-left: 40px">Цена</p></th>
    </tr>
    <c:url var="createMeals" value="/restaurants/menu/create">
        <c:param name="restId" value="${restId}"/></c:url>


    <input type="button" value="Добавить блюдо" onclick="window.location.href = '${createMeals}'"/>
    <br><br>
    <c:forEach var="meals" items="${mealsAll}">

        <c:url var="updateMeals" value="/restaurants/menu/update">
            <c:param name="mealId" value="${meals.id}"/>
            <c:param name="restId" value="${restId}"/>
        </c:url>

        <c:url var="deleteMeals" value="/restaurants/menu/delete">
            <c:param name="mealId" value="${meals.id}"/>
            <c:param name="restId" value="${restId}"/>
        </c:url>

        <tr>
            <td>
                <input type="button" value="Изменить" onclick="window.location.href = '${updateMeals}'"/>

                <input type="button" value="Удалить"
                       onclick="window.location.href = '${deleteMeals}'"/>

            </td>
            <td><p style="margin-left: 40px"><span style="font-weight:bold;">${meals.name}</span></p></td>
            <td><p style="margin-left: 100px">${meals.price}</td>
            <td>

            </td>


        </tr>
    </c:forEach>


</table>


</body>


</html>