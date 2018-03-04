<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://topjava.javawebinar.ru/functions" %>
<html>
<style>
    .normal {
        color: forestgreen;
        font: 20px "Arial";
    }

    .exceeded {
        color: crimson;
        font: 20px "Arial";
    }
</style>
<head>
    <title>Meals</title>
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<h2>Meals</h2>
<table width="100%" cellspacing="1" cellpadding="10" border="0" align="center" bgcolor="black"
       style="font: 20px 'Arial Black'">

    <tr bgcolor="#eaf6ff">
        <th width="33%">Дата/Время</th>
        <th width="34%">Описание</th>
        <th width="33%">Калории</th>
    </tr>
    <tbody>

    <c:forEach items="${allTimeFood}" var="meal">
        <tr bgcolor="#f9f9f9" class="${meal.isExceed() ? 'exceeded' : 'normal'}">

            <th><c:out value="${fn:formatDateTime(meal.dateTime)}"/></th>
            <th><c:out value="${meal.description}"/></th>
            <th><c:out value="${meal.calories}"/></th>


        </tr>
    </c:forEach>
    </tbody>

</table>

</body>
</html>
