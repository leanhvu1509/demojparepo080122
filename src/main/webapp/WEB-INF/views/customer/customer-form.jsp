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
				<h1 class="text-center">Create Customer</h1>
				<div class="card-body">
					<c:if test="${mes != null}">
						<div class="alert alert-warning" role="alert">${mes}</div>
					</c:if>

					<form:form action="save-customer" modelAttribute="customer"
						method="POST">
						<form:hidden path="id" />
						<div class="form-group">
							<label for="firstName" class="col-md-3 control-label">FirstName</label>
							<div class="col-md-9">
								<form:input path="firstName" cssClass="form-control" />
								<form:errors path="firstName" cssClass="error" />
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-md-3 control-label">LastName</label>
							<div class="col-md-9">
								<form:input path="lastName" cssClass="form-control" />
								<form:errors path="lastName" cssClass="error" />
							</div>
						</div>
						<div class="form-group">
							<label for="email" class="col-md-3 control-label">Email</label>
							<div class="col-md-9">
								<form:input path="email" cssClass="form-control" />
								<form:errors path="email" cssClass="error" />
							</div>
						</div>
						<div class="form-group">
							<label for="province" class="col-md-3 control-label">Province</label>
							<div class="col-md-9">
								<form:select path="province" cssClass="form-control">
									<form:option value="" label="Select" />
									<c:forEach var="province" items="${provinces}">
										<form:option value="${province.id }" label="${province.name}"
											selected="${province.id==customer.province.id?'selected':''}" />
									</c:forEach>
								</form:select>
							</div>
						</div>
						<div class="form-group">
							<label for="hobbies" class="col-md-3 control-label">Hobbies</label>
							<div class="col-md-9">
								<form:select path="hobbies" multiple="true" itemValue="id"
									itemLabel="name" items="${hobbies}" cssClass="form-control"></form:select>
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