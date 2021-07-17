<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
<head>
	<title>Customers: </title>
</head>

<body>
<div id="wrapper">
		<div id="header">
			<h2> CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		<!-- add html table here -->
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
				</tr>
				
				<c:forEach var="tempCustomer" items="${customers}">
					<tr>
						<th>${tempCustomer.firstName}</th>
						<th>${tempCustomer.lastName}</th>
						<th>${tempCustomer.email}</th>
					</tr>
				
				</c:forEach>
				
			</table>
		</div>
	</div>
</body>

</html>