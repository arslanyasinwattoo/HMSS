<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<t:template>


	<div class="panel-body">

		<form method="post" role="form" id="form_login"
			action="${pageContext.request.contextPath}/hadmin/registerHotel.bnu">

			<div class="form-group">

				<div class="input-group">
					<div class="input-group-addon">
						<i class="entypo-user"></i>
					</div>

					<input type="text" class="form-control" name="name"
						placeholder="name" />
				</div>

			</div>
	</div>

	<div class="input-group">
		<div class="input-group-addon">
			<i class="entypo-user"></i>
		</div>

		<input type="text" class="form-control" name="city" placeholder="City" />
	</div>

	<div class="input-group">
		<div class="input-group-addon">
			<i class="entypo-user"></i>
		</div>

		<input type="text" class="form-control" name="contactNumber"
			placeholder="contactNumber" />
	</div>

	<div class="input-group">
		<div class="input-group-addon">
			<i class="entypo-user"></i>
		</div>

		<input type="text" class="form-control" name="address"
			placeholder="Address" />
	</div>




	<div class="form-group">
		<button type="submit" class="btn btn-primary btn-block btn-login">
			<i class="entypo-login"></i> Register
		</button>
	</div>


	</form>

	</div>


</t:template>