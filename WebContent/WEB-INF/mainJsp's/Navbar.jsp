<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<sec:authorize
	access="hasAnyRole('ROLE_USER','ROLE_HADMIN','ROLE_SYSADMIN')">
	<div class="sidebar-menu">


		<header class="logo-env">

			<!-- logo -->
			<div class="logo">
				<a href="index.html"> <img
					src="${pageContext.request.contextPath}/resources/images/logo%402x.png"
					width="120" alt="" />
				</a>
			</div>

			<!-- logo collapse icon -->

			<div class="sidebar-collapse">
				<a href="#" class="sidebar-collapse-icon with-animation"> <!-- add class "with-animation" if you want sidebar to have animation during expanding/collapsing transition -->
					<i class="entypo-menu"></i>
				</a>
			</div>



			<!-- open/close menu icon (do not remove if you want to enable menu on mobile devices) -->
			<div class="sidebar-mobile-menu visible-xs">
				<a href="#" class="with-animation"> <!-- add class "with-animation" to support animation -->
					<i class="entypo-menu"></i>
				</a>
			</div>

		</header>





		<ul id="main-menu" class="">
			<li id="search">
				<form method="get" action="#">
					<input type="text" name="q" class="search-input"
						placeholder="Search something..." />
					<button type="submit">
						<i class="entypo-search"></i>
					</button>
				</form>
			</li>
			<sec:authorize access="hasAnyRole('ROLE_SYSADMIN')">
				<li class="active opened active"><a href=""><i
						class="entypo-gauge"></i><span>Manage users</span></a>


					<ul>
						<li class="active"><a
							href="${pageContext.request.contextPath}/sysadmin/pendingUsers.bnu"><span>pending
									users </span></a></li>

						<li><a
							href="${pageContext.request.contextPath}/sysadmin/ListUsers.bnu"><span>List
									of users</span></a></li>


					</ul></li>

				<li class="active opened active"><a href=""><i
						class="entypo-gauge"></i><span>Manage Hotels</span></a>


					<ul>

						<li><a
							href="${pageContext.request.contextPath}/sysadmin/ListHotel.bnu"><span>List
									of hotels</span></a></li>


					</ul></li>
		</ul>
</sec:authorize>
<sec:authorize access="hasAnyRole('ROLE_USER')">
	<li class="active opened active"><a href=""><i
			class="entypo-gauge"></i><span>Manage users</span></a>


		<ul>
			<li class="active"><a
				href="${pageContext.request.contextPath}/user/customer.bnu"><span>Customer</span></a></li>

			<li><a
				href="${pageContext.request.contextPath}/user/ListUsers.bnu"><span>List
						of customer</span></a></li>


		</ul></li>

	</ul>
</sec:authorize>
<sec:authorize access="hasAnyRole('ROLE_HADMIN')">
	<li class="active opened active"><a href=""><i
			class="entypo-gauge"></i><span>Manage Hotels</span></a>


		<ul>
			<li class="active"><a
				href="${pageContext.request.contextPath}/hadmin/ManageHotel.bnu"><span>Hotel</span></a></li>

			<li><a
				href="${pageContext.request.contextPath}/hadmin/ListHotels.bnu"><span>List
						of Hotels</span></a></li>


		</ul></li>

	<li class="active opened active"><a href=""><i
			class="entypo-gauge"></i><span>Manage Employee</span></a>


		<ul>
			<li class="active"><a
				href="${pageContext.request.contextPath}/hadmin/ManageEmployee.bnu""><span>Employee
				</span></a></li>

			<li><a
				href="${pageContext.request.contextPath}/hadmin/ListEmployee.bnu"><span>List
						of Employee</span></a></li>


		</ul></li>
	</ul>
</sec:authorize>
</sec:authorize>