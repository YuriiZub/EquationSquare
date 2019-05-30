<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Getting Started: Handing Form Submission</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<h3 style="color:blue;">Results:</h3>
<div>

    <table>
        <tr>
            <td>a :</td>
            <td>${equation.paramA}</td>
        </tr>
        <tr>
            <td>b :</td>
            <td>${equation.paramB}</td>
        </tr>
        <tr>
            <td>c :</td>
            <td>${equation.paramC}</td>
        </tr>
        <tr>
            <td>D :</td>
            <td>${equation.discriminant}</td>
        </tr>

        <c:choose>
            <c:when test="${equation.successResult == 1}">
                <tr style="color:blue;">
                    <td>X1 :</td>
                    <td>${equation.firstResult}</td>
                </tr>
            </c:when>
            <c:when test="${equation.successResult == 2}">
                <tr style="color:blue;">
                    <td>X1 :</td>
                    <td>${equation.firstResult}</td>
                </tr>
                <tr style="color:blue;">
                    <td>X2 :</td>
                    <td>${equation.secondResult}</td>
                </tr>

            </c:when>
            <c:otherwise><h3 style="color:red;">Error3! Uknown results!</h3></c:otherwise>
        </c:choose>

    </table>

</div>
<div>
    <h3 th:text="${saved}"></h3>
</div>
<div>
    <a href="/equation">new calculation</a>
</div>


</body>
</html>
