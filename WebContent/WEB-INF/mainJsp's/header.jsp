<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<div class="row">

	<!-- Profile Info and Notifications -->
	<div class="col-md-6 col-sm-8 clearfix">

		<ul class="user-info pull-left pull-none-xsm">

			<!-- Profile Info -->
			<li class="profile-info dropdown">
				<!-- add class "pull-right" if you want to place this from right -->
				<sec:authorize access="isAuthenticated()">
					<font size="8"><sec:authentication
							property="principal.username" /></font>
				</sec:authorize>

			</li>

		</ul>


	</div>



	<!-- Raw Links -->
	<div class="col-md-6 col-sm-4 clearfix hidden-xs">

		<ul class="list-inline links-list pull-right">

			<sec:authorize access="isAuthenticated()">
				<li><a href="${pageContext.request.contextPath}/logout.bnu">
						Log Out <i class="entypo-logout right"></i>
			</sec:authorize>
			</a>
			</li>
		</ul>
	</div>

</div>

<hr />
