<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@page contentType="text/html; charset=UTF-8" %>


<html>
<head>
    <title>Meal</title>
</head>
<body>

<h2>${namePage == 'create' ? 'Добавление блюда' : 'Изменение блюда'}</h2>


<form:form action="save" modelAttribute="meal" method="post">

<tr>
    <td>
            <form:hidden path="id"/>
            <form:hidden path="restaurant_id"/>
        Название:
            <form:input path="name"/>
            <form:errors path="name"/>
        <br><br>
        Цена:
            <form:input path="price"/>
            <form:errors path="price"/>
        <br><br>
        <input type="submit" value="Сохранить">
        <button onclick="window.history.back()" type="button">Cancel</button>
        </form:form>


</body>
</html>