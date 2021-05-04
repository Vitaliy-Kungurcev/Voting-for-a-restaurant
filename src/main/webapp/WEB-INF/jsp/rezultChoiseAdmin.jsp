<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<body>

<h2>Голосование</h2>

<h2>${date}</h2>
<table>

    <tr>
        <th>Название ресторана</th>
        <th>Адрес</th>
        <th>Имя работника</th>

    </tr>


    <c:forEach var="allChoises" items="${allChoiseToday}">

        <tr>
            <td>${allChoises.restName}</td>
            <td>${allChoises.restAdress}</td>
            <td>${allChoises.userName}</td>

        </tr>


    </c:forEach>


</table>
<br><br>
<button onclick="window.history.back()" type="button">Назад</button>


</body>


</html>