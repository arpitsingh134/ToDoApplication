<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<%@ include file="global_bootstrap.jsp"%>


<title><c:out value="${page }"></c:out></title>
</head>
<body>
	<div class="container">
		<%@ include file="navbar.jsp"%>
		<c:if test="${not empty msg }">

			<div class="alert alert-success text-left">

				<c:out value="${msg}"></c:out>

			</div>

		</c:if>

		<div class="row mt-4">

			<div class="col-md-3 text-center">
				<ul class="list-group">
					<li class="list-group-item active disable">Menu</li>
					<a href='<c:url value='/add'></c:url>'
						class="list-group-item list-group-item-action">Add Work</a>
					<a href='<c:url value='/home'></c:url>'
						class="list-group-item list-group-item-action">View Work</a>
				</ul>


			</div>
			<div class="col-md-9">
				<c:if test="${page=='home' }">
					<h1 class="text-center">All ToDo's</h1>
					<c:forEach items="${todos }" var="t">
						<div class="card">

							<div class="card-body">
								<h3>
									<c:out value="${t.title }"></c:out>
								</h3>
								<p>
									<c:out value="${t.content }"></c:out>
								</p>
								<small><c:out value="${t.addedDate.toString() }"></c:out></small>
								
								<div class="container text-center">
									<a  href="<c:url value='/deleteToDo/${t.id}'></c:url>" class="btn btn-outline-danger" >Delete</a>
								</div>


							</div>

						</div>


					</c:forEach>


				</c:if>
				<c:if test="${page=='add' }">
					<h1 class="text-center">Add ToDo</h1>
					<br>
					<form:form action="saveToDo" method="post" modelAttribute="todo">
						<div class="form-group">
							<form:input path="title" cssClass="form-control"
								placeholder="enter your title	" />

						</div>
						<div class="form-group">
							<form:textarea path="content" cssClass="form-control"
								placeholder="enter your content" cssStyle="height:300px " />

						</div>
						<div class="container text-center">
							<button type="submit" class="btn btn-outline-success">Add</button>
						</div>


					</form:form>


				</c:if>

			</div>

		</div>


	</div>



</body>
</html>