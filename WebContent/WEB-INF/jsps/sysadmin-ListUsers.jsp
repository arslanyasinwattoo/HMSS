<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<t:template>
	<div class="col-sm-8">

		<div class="panel panel-primary">
			<div class="panel-heading">
				<div class="panel-title">List of Users</div>


			</div>

			<div class="panel-body with-table">
				<table class="table table-bordered table-responsive">
					<thead>
						<tr>

							<th>Username</th>
							<th>Status</th>

						</tr>
					</thead>

					<tbody>

						<c:forEach items="${ListOfUsers}" var="user">
							<tr>

								<td>${user.username}</td>

								<td><c:if test="${user.enabled==1}">Active</c:if> <c:if
										test="${user.enabled==0}">Pending</c:if></td>
								<td>
								<td class=" "><a
									href="${pageContext.request.contextPath}/sysadmin/updateUsersStatus.bnu?username=${user.username}&amp;enabled=0&amp;check=3"
									"
									class="btn btn-default btn-sm btn-icon icon-left">
										<i class="entypo-pencil"></i> Block
								</a></td>
							</tr>
						</c:forEach>



					</tbody>
				</table>
			</div>
		</div>

	</div>


</t:template>