<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<body>

<h2>История голосования за ${date}: </h2>



<table>

    <tr>
        <th>Название ресторана</th>
        <th>Адрес</th>
        <th>Имя работника</th>

    </tr>


    <c:forEach var="historyChoise" items="${historyChoise}">

        <tr>
            <td>${historyChoise.restName}</td>
            <td>${historyChoise.restAdress}</td>
            <td>${historyChoise.userName}</td>

        </tr>


    </c:forEach>


</table>
<br><br>

<h3>Список ресторанов и меню в этот день:</h3>


<table>

    <tr>
        <th>Название</th>
        <th>Адрес</th>
        <th>Меню дня</th>
    </tr>


    <c:forEach var="historyRestaurantsAndMenu" items="${historyRestaurantsAndMenu}">

        <tr>

        <td>${historyRestaurantsAndMenu.name}</td>
        <td>${historyRestaurantsAndMenu.adress}</td>

        <c:forEach var="meals" items="${historyRestaurantsAndMenu.meals}">
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
</body>
<br>

<button onclick="window.history.back()" type="button">На главную</button>
<br><br>


</html>