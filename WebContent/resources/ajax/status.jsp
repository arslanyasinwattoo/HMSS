<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<c:if test="${status==1}">
	<div class="col-md-12">
		<div class="alert alert-default">

			<strong>Succees</strong>Our Admin will get back to you soon


		</div>
	</div>
</c:if>
<c:if test="${status==0}">

	<div class="col-md-6">
		<div class="alert alert-danger">
			<strong>Oh snap!</strong> try submitting again.
		</div>
	</div>
</c:if>
