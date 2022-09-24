<%--
  Created by IntelliJ IDEA.
  User: solomonchow
  Date: 24/9/2022
  Time: 11:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Save Customer</title>
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css ">
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>
</div>

<div id="container">
    <h3>Save Customer</h3>
    <form:form action="saveCustomer" modelAttribute="customer" method="post">
        <table>
            <tbody>
            <tr>
                <tb><label>First name:</label></tb>
                <tb><form:input path="firstName"/></tb>
            </tr>
            <tr>
                <tb><label>Last name:</label></tb>
                <tb><form:input path="lastName"/></tb>
            </tr>
            <tr>
                <tb><label>Email:</label></tb>
                <tb><form:input path="email"/></tb>
            </tr>
            <tr>
                <tb><label></label></tb>
                <tb><input type="submit" value="Submit" class="save"/></tb>
            </tr>
            </tbody>
        </table>
    </form:form>
    <div style="clear: both;"></div>
    <p>
        <a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
    </p>

</div>


</body>
</html>
