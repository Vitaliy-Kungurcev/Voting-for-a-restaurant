<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Restaurant</title>
</head>
<body>

<h2>${namePage == 'create' ? 'Добавление ресторана' : 'Изменение ресторана'}</h2>





<form:form action="save" modelAttribute="restaurant">
    <input type="hidden" name="restautant" value="${restaurant}">
    <form:hidden path="id" />
    <form:hidden path="date" />
    Название: <form:input path="name"/>
    <form:errors path="name"/>
    <br><br>
    Адрес: <form:input path="adress"/>
    <form:errors path="adress"/>
    <br><br>

    <input type="submit" value="Сохранить">
    <button onclick="window.history.back()" type="button">Cancel</button>
</form:form>

</body>
</html>