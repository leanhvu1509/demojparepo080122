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
			<h1>List Hobbies</h1>
		</div>

		<div class="row">
			<div class="col-lg-3">
				<a href="show-form" class="btn btn-primary btn-sm mb-3"> Add
					Hobby</a>
			</div>
		</div>
		<table class="table table-striped table-bordered">
			<thead class="table-dark">
				<tr>
					<th>Name</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="h" items="${hobbies}">
					<c:url var="updateLink" value="/hobby/update-hobby">
						<c:param name="hid" value="${h.id}" />
					</c:url>

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/hobby/delete-hobby">
						<c:param name="hid" value="${h.id}" />
					</c:url>
					<tr>
						<td>${h.name}</td>
					
						<td><a href="${updateLink}" class="btn btn-primary">Edit</a>
							| <a href="${deleteLink}"
							onclick="if (!(confirm('Ban mun xoa?'))) return false"
							class="btn btn-danger">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>