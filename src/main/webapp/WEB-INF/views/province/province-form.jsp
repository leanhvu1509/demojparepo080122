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
<style>
.error {
	color: red
}
</style>
</head>
<body>
	<%@include file="/common/nav.jsp"%>
	<br>
	<div class="container">
		<div class="row">
			<div
				class="col-lg-6 col-md-6 col-sm-6 container justify-content-center card">
				<h1 class="text-center">Create Province</h1>
				<div class="card-body">
					<c:if test="${mes != null}">
						<div class="alert alert-warning" role="alert">${mes}</div>
					</c:if>
					<form:form action="save-province" modelAttribute="province"
						method="POST">
						<form:hidden path="id" />
						<div class="form-group">
							<label for="name" class="col-md-3 control-label">Name</label>
							<div class="col-md-9">
								<form:input path="name" cssClass="form-control" />
								<form:errors path="name" cssClass="error" />
							</div>
						</div>
						<div class="box-footer">
							<button type="submit" class="btn btn-primary">Submit</button>
						</div>
					</form:form>

				</div>
			</div>
		</div>
	</div>
</body>
</html>