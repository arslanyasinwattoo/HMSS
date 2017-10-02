<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<t:template>
	<div class="col-sm-8">

		<div class="panel panel-primary">
			<div class="panel-heading">
				<div class="panel-title">List of Hotels</div>


			</div>

			<div class="panel-body with-table">
				<table class="table table-bordered table-responsive">
					<thead>
						<tr>

							<th>Id</th>
							<th>userName</th>
							<th>Hotel Name</th>
							<th>city</th>
							<th>ContactNumber</th>
							<th>Address</th>


						</tr>
					</thead>

					<tbody>

						<c:forEach items="${ListOfInstitute}" var="user">
							<tr>
								<td>${user.hotelId}</td>
								<td>${user.users.username}</td>
								<td>${user.name}</td>
								<td>${user.city}</td>
								<td>${user.contactNumber}</td>
								<td>${user.address}</td>

							</tr>
						</c:forEach>



					</tbody>
				</table>
			</div>
		</div>

	</div>


</t:template>