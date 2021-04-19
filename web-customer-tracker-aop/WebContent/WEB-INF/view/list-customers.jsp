<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<title>the customers list</title>
<link type="text/css" 
	  rel = "stylesheet"
	  href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>

<body>

	<div id="wrapper">
		<div id="header">
				<h1>CRM-customer relationship manager</h1>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
		
		<input type="button" , value="add customer" onclick="window.location.href='showFormForAdd'; return false ;" class="add-button"/>
		
			<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Action</th>
			</tr>	
			
			<c:forEach var="tempCustomers" items="${customers}">
			
			<c:url var="updateLink" value="/customer/showFormForUpdate">
			<c:param name="customerId" value="${tempCustomers.id}"/>
			</c:url>
			
			<c:url var="deleteLink" value="/customer/deleteCustomer">
			<c:param name="customerId" value="${tempCustomers.id}"/>			
			</c:url>
			
				<tr>
					<td>${tempCustomers.firstName}</td>
					<td>${tempCustomers.lastName}</td>
					<td>${tempCustomers.email}</td>
					<td>
						<a href="${updateLink}">Update</a>
						<a href="${deleteLink}" onclick="if(!(confirm('are you sure you want to proceed ?'))) return false">Delete</a>
					</td>
				</tr>
			
			</c:forEach>		
			</table>
		</div>
	
	</div>


</body>

</html>