<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<t:template>
	<div class="col-sm-8">

		<div class="panel panel-primary">
			<div class="panel-heading">
				<div class="panel-title">List of Employee</div>


			</div>

			<div class="panel-body with-table">
				<table class="table table-bordered table-responsive">
					<thead>
						<tr>

							<th>Id</th>
							<th>Name</th>
							<th>Address</th>
							<th>city</th>
							<th>CNIC</th>
							<th>ContactNumber</th>

							<th>Designation</th>


						</tr>
					</thead>

					<tbody>

						<c:forEach items="${ListOfEmp}" var="user">
							<tr>
								<td>${user.empId}</td>
								<td>${user.empName}</td>
								<td>${user.empAddress}</td>
								<td>${user.empCity}</td>
								<td>${user.empCnic}</td>
								<td>${user.empContactNo}</td>

								<td>${user.employeeDesignationId}</td>

							</tr>
						</c:forEach>



					</tbody>
				</table>
			</div>
		</div>

	</div>


</t:template>