<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/tablib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
	<%@include file="/common/nav.jsp"%>
	<div class="container">
		<div class="row">
			<h1>List Customers</h1>
		</div>

		<div class="row">
			<div class="col-lg-3">
				<a href="show-form" class="btn btn-primary btn-sm mb-3"> Add
					Customer</a>
			</div>
		</div>
		<table class="table table-striped table-bordered">
			<thead class="table-dark">
				<tr>
					<th>FirstName</th>
					<th>LastName</th>
					<th>Email</th>
					<th>Province</th>
					<th>Hobbies</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<!-- loop over and print our customers -->
				<c:forEach var="tempCustomer" items="${customers}">

					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/customer/update-customer">
						<c:param name="cid" value="${tempCustomer.id}" />
					</c:url>

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/customer/delete-customer">
						<c:param name="cid" value="${tempCustomer.id}" />
					</c:url>

					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
						<td>${tempCustomer.province.name}</td>
						<td><c:forEach var="hobby" items="${tempCustomer.hobbies}">
								<span class="btn-sm">${hobby.name}</span>
							</c:forEach></td>

						<td>
							<!-- display the update link --> <a href="${updateLink}">Update</a>
							| <a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
						</td>

					</tr>

				</c:forEach>

			</tbody>
		</table>
	</div>
</body>
</html>