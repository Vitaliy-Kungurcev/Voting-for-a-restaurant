<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<body>

<h2>Рестораны и меню</h2>

<a href="/">Главная</a>
<br><br>

<a href="create">Добавить ресторан</a>
<br>
<table>

    <tr>
        <th>Действие с рестораном</th>
        <th>Название</th>
        <th>Адрес</th>
        <th>Меню на ${dateToday} </th>


    </tr>



    <c:forEach var="rest" items="${allRestarants}">
        <tr>
        <c:url var="updateRestarant" value="/restaurants/update">
            <c:param name="restId" value="${rest.id}"/></c:url>

        <c:url var="deleteRestarant" value="/restaurants/delete">
            <c:param name="restId" value="${rest.id}"/></c:url>


        <c:url var="editMenu" value="/restaurants/menu">
            <c:param name="restId" value="${rest.id}"/></c:url>


            <td><input type="button" value="Изменить"
                       onclick="window.location.href = '${updateRestarant}'"/>

                <input type="button" value="Удалить"
                       onclick="window.location.href = '${deleteRestarant}'"/>


            <td>${rest.name}</td>
            <td>${rest.adress}</td>

        <c:forEach var="meals" items="${rest.meals}">
            <tr>
            <td></td>
                <td></td>
                <td></td>

                <td>
                    ${meals.name} : ${meals.price}
            </td>

            </c:forEach>
        <tr>
            <td></td>
            <td></td>
            <td></td>
        <td><input type="button" value="Редактировать меню  ${rest.name}"
                   onclick="window.location.href = '${editMenu}'"/></td>

    </tr>


    </c:forEach>


</table>


</body>


</html>