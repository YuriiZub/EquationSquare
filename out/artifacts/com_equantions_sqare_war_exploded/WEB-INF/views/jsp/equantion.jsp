<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
</head>
<body>
<h3>Welcome, Enter The Employee Details</h3>
<form:form method="POST"
           action="/equation" modelAttribute="equantion">
    <table>
        <tr>
            <td><form:label path="paramA">Name</form:label></td>
            <td><form:input path="paramA" value="1" required="true" type="number"/></td>
        </tr>
        <tr>
            <td><form:label path="paramB">Id</form:label></td>
            <td><form:input path="paramB" value="1" required="true" type="number"/></td>
        </tr>
        <tr>
            <td><form:label path="paramC">Id</form:label></td>
            <td><form:input path="paramC" value="1" required="true" type="number"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="doEquation"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>