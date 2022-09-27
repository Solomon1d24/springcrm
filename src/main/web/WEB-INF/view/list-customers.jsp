<%--
  Created by IntelliJ IDEA.
  User: solomonchow
  Date: 19/9/2022
  Time: 8:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>CRM - Customer Relationship Manager</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relationship Manager</h2>
    </div>
</div>

<div id="container">
    <div id="content">
        <!--Add a new button here -->
        <input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'; return false;"
               class="add-button"/>

        <!--Add HTML Table here -->
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Action</th>
            </tr>
            <!-- loop over the customers and print them out -->
            <c:forEach var="tempCustomer" items="${customers}">
                <!--Construct an update link for each Customer id-->
                <c:url var="updateLink" value="/customer/showFormForUpdate">
                    <c:param name="customerId" value="${tempCustomer.id}"/>
                </c:url>
                <c:url var="deleteLink" value="/customer/showFormForDelete">
                    <c:param name="customerId" value="${tempCustomer.id}"/>
                </c:url>
                <tr>
                    <td>${tempCustomer.firstName}</td>
                    <td>${tempCustomer.lastName}</td>
                    <td> ${tempCustomer.email}</td>
                    <td>
                        <!--display the update link-->
                        <a href="${updateLink}">Update</a>
                        |
                        <!--display the delete link-->
                        <a href="${deleteLink}"
                           onclick="if(!(confirm('Are you sure you want to delete the customer ?'))) return false">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

</body>
</html>
